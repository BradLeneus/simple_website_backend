package com.example.labo1.Controller;

import com.example.labo1.Controller.PersonController;
import com.example.labo1.Service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {




    @Autowired
    private MockMvc mockMvc;

    @Test
    void GetAllReturnStatusOk() throws Exception{
        mockMvc.perform(get("/person/getAll"))
                .andExpect(status().isOk());
    }
    @Test
    void searchNameStatusOk() throws Exception{
        mockMvc.perform(get("/person/search/ssam"))
                .andExpect(status().isOk());
    }
    @Test
    void dgetByIdStatusOk() throws Exception{
        mockMvc.perform(get("/person/getById/1"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteByIdStatusOk() throws Exception {
        String json = """
                {"name":"Temp","lastName":"User","email":"temp@example.com","gender":"F"}
                """;

        mockMvc.perform(post("/person/newPerson")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        String body = mockMvc.perform(get("/person/search/Temp"))
                .andReturn().getResponse().getContentAsString();

        int id = new com.fasterxml.jackson.databind.ObjectMapper()
                .readTree(body).get("id").asInt();

        mockMvc.perform(delete("/person/deleteById/" + id))
                .andExpect(status().isOk());

    }


    @Test
    void createPersonStatusOk() throws Exception{

        String json = """
        {"name":"Bob","lastName":"Durand","email":"bob@example.com","gender":"M"}
    """;

        mockMvc.perform(post("/person/newPerson")
                .contentType("application/json").content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void updatePersonStatusOk() throws Exception{

        String json = """
        {"name":"Temp","lastName":"User","email":"temp@example.com","gender":"F"}
    """;

        mockMvc.perform(post("/person/newPerson")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        String body = mockMvc.perform(get("/person/search/Temp"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();


        int id = new com.fasterxml.jackson.databind.ObjectMapper()
                .readTree(body).get("id").asInt();

        mockMvc.perform(put("/person/modifyName/" + id + "/Alice"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }


    @Test
    void modifyLastNameStatusOk() throws Exception {
        String json = """
        {"name":"Jean","lastName":"Test","email":"jean@example.com","gender":"M"}
    """;

        mockMvc.perform(post("/person/newPerson")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        String body = mockMvc.perform(get("/person/search/Jean"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        int id = new com.fasterxml.jackson.databind.ObjectMapper()
                .readTree(body).get("id").asInt();

        mockMvc.perform(put("/person/modifyLastName/" + id + "/Tremblay"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }


    @Test
    void modifyGenderStatusOk() throws Exception {
        String json = """
        {"name":"Marc","lastName":"Lavoie","email":"marc@example.com","gender":"M"}
    """;

        mockMvc.perform(post("/person/newPerson")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        String body = mockMvc.perform(get("/person/search/Marc"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        int id = new com.fasterxml.jackson.databind.ObjectMapper()
                .readTree(body).get("id").asInt();

        mockMvc.perform(put("/person/modifyGender/" + id + "/F"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }


    @Test
    void modifyEmailStatusOk() throws Exception {
        String json = """
        {"name":"Luc","lastName":"Petit","email":"luc@example.com","gender":"M"}
    """;

        mockMvc.perform(post("/person/newPerson")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk());

        String body = mockMvc.perform(get("/person/search/Luc"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        int id = new com.fasterxml.jackson.databind.ObjectMapper()
                .readTree(body).get("id").asInt();

        mockMvc.perform(put("/person/modifyEmail/" + id + "/newmail@example.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }




}
