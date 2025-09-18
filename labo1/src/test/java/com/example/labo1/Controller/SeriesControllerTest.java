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
public class SeriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private int createSerieAndGetId(String title, String genre) throws Exception {
        String json = """
        {"title":"%s","genre":"%s","episodesNumber":10,"rating":4.5}
    """.formatted(title, genre);

        mockMvc.perform(post("/series/newSerie")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        String body = mockMvc.perform(get("/series/search/" + genre))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        var arr = new com.fasterxml.jackson.databind.ObjectMapper().readTree(body);
        return arr.get(arr.size() - 1).get("id").asInt(); // ✅ last one created
    }


    @Test
    void getAllSeriesStatusOk() throws Exception {
        mockMvc.perform(get("/series/getAll"))
                .andExpect(status().isOk());
    }

    @Test
    void getSerieByIdStatusOk() throws Exception {
        int id = createSerieAndGetId("TestShow", "Drama");

        mockMvc.perform(get("/series/getById/" + id))
                .andExpect(status().isOk());
    }

    @Test
    void searchSeriesByGenreStatusOk() throws Exception {
        createSerieAndGetId("ShowX", "Comedy");

        mockMvc.perform(get("/series/search/Comedy"))
                .andExpect(status().isOk());
    }

    @Test
    void modifyTitleStatusOk() throws Exception {
        int id = createSerieAndGetId("OldTitle", "Action");

        mockMvc.perform(put("/series/modifyTitle/" + id + "/NewTitle"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void modifyGenreStatusOk() throws Exception {
        int id = createSerieAndGetId("GenreTest", "OldGenre");

        mockMvc.perform(put("/series/modifyGenre/" + id + "/NewGenre"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void modifyEpisodesNumberStatusOk() throws Exception {
        int id = createSerieAndGetId("EpisodeTest", "Drama");

        mockMvc.perform(put("/series/modifyEpisodesNumber/" + id + "/20"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void modifyRatingStatusOk() throws Exception {
        int id = createSerieAndGetId("RatingTest", "SciFi");

        mockMvc.perform(put("/series/modifyRating/" + id + "/9.2"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void deleteSerieStatusOk() throws Exception {
        int id = createSerieAndGetId("DeleteTest", "Horror");

        mockMvc.perform(delete("/series/deleteById/" + id))
                .andExpect(status().isOk());
    }
}
