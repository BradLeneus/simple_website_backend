package com.example.labo1.Controller;

import com.example.labo1.Model.Episode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EpisodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private int createEpisodeAndGetId(String title) throws Exception {
        String json = """
            {"title":"%s","episodeNumber":1,"series":{"id":1}}
        """.formatted(title);

        mockMvc.perform(post("/episodes/newEpisode")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        String body = mockMvc.perform(get("/episodes/search/" + title))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        var arr = objectMapper.readTree(body);
        return arr.get(arr.size() - 1).get("id").asInt(); // retourne le dernier épisode créé
    }

    @Test
    void createEpisodeStatusOk() throws Exception {
        int episodeId = createEpisodeAndGetId("TestEpisode1");
        // On vérifie qu'il a bien été créé
        mockMvc.perform(get("/episodes/Id/" + episodeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("TestEpisode1"));
    }

    @Test
    void searchEpisodeStatusOk() throws Exception {
        createEpisodeAndGetId("TestEpisode2");
        mockMvc.perform(get("/episodes/search/TestEpisode2"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }


}
