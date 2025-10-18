package com.example.labo1.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private int createPersonAndGetId(String name) throws Exception {
        String json = """
            {"name":"%s","lastName":"Tester","email":"%s@example.com","gender":"M", "password":"1234"}
        """.formatted(name, name.toLowerCase());

        mockMvc.perform(post("/person/signUp")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        String body = mockMvc.perform(get("/person/search/" + name))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        return new ObjectMapper().readTree(body).get("id").asInt();
    }

    private int createSerieAndGetId(String title) throws Exception {
        String json = """
            {"title":"%s","genre":"Drama","episodesNumber":5,"rating":3.5}
        """.formatted(title);

        mockMvc.perform(post("/series/newSerie")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        String body = mockMvc.perform(get("/series/search/Drama"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        var arr = new ObjectMapper().readTree(body);
        return arr.get(arr.size() - 1).get("id").asInt(); // last created
    }

    @Test
    void addSerieToHistoryStatusOk() throws Exception {
        int userId = createPersonAndGetId("HistoryUser");
        int serieId = createSerieAndGetId("HistoryShow");

        mockMvc.perform(post("/history/" + userId + "/" + serieId))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void findAllByUserIdStatusOk() throws Exception {
        int userId = createPersonAndGetId("UserX");
        int serieId = createSerieAndGetId("ShowX");

        mockMvc.perform(post("/history/" + userId + "/" + serieId))
                .andExpect(status().isOk());

        mockMvc.perform(get("/history/" + userId))
                .andExpect(status().isOk());
    }

    @Test
    void findAllWatchedSerieStatusOk() throws Exception {
        mockMvc.perform(get("/history/allWatchedSerie"))
                .andExpect(status().isOk());
    }
}
