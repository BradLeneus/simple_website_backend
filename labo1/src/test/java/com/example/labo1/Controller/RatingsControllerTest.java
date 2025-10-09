package com.example.labo1.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RatingsControllerTest {


    @Autowired
    private MockMvc mockMvc;

    private int createPersonAndGetId(String name) throws Exception {
        String json = """
            {"name":"%s","lastName":"Tester","email":"%s@example.com","gender":"M","password":"abc123"}
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


    private int createEpisodeAndGetId(String title) throws Exception {
        String json = """
            {"title":"%s","description":"Test episode","duration":45}
        """.formatted(title);

        mockMvc.perform(post("/episodes/newEpisode")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        String body = mockMvc.perform(get("/episodes/search/" + title))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        var arr = new ObjectMapper().readTree(body);
        return arr.get(arr.size() - 1).get("id").asInt(); // last created
    }


    @Test
    void ratingSeriesStatusOk() throws Exception {
        int personId = createPersonAndGetId("person1");
        int seriesId = createSerieAndGetId("serie1");
        double rating = 5.0;

        mockMvc.perform(post("/ratings/series/" + seriesId + "?personId=" + personId + "&rating=" + rating))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }


    @Test
    void getRatingAvgStatusOk()throws Exception{
        int serieId = createSerieAndGetId("serie2");


        mockMvc.perform(get("/ratings/series/" + serieId))
                .andExpect(status().isOk());
    }

    @Test
    //testRating
    void ratingEpisodeStatusOk() throws Exception {
        int personId = createPersonAndGetId("person2");
        int episodeId = createEpisodeAndGetId("episode1");
        double rating = 5.0;

        mockMvc.perform(post("/ratings/episodes/" + episodeId + "?personId=" + personId + "&rating=" + rating))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }


    @Test
    void getEpisodeRatingAvgStatusOk()throws Exception{
        int episodeId = createEpisodeAndGetId("episode1");


        mockMvc.perform(get("/ratings/episodes/" + episodeId))
                .andExpect(status().isOk());
    }
}
