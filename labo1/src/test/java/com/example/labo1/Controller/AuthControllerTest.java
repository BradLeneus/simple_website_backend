package com.example.labo1.Controller;

import com.example.labo1.Model.Person;
import com.example.labo1.Repositories.RepositoryPerson;
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
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RepositoryPerson repositoryPerson;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private void deleteUserByEmail(String email) {
        repositoryPerson.findByEmail(email).ifPresent(repositoryPerson::delete);
    }

    @Test
    void registerAndLoginStatusOk() throws Exception {
        String email = "testuser@example.com";
        deleteUserByEmail(email);

        String registerJson = """
            {
                "username":"TestUser",
                "lastName":"Tester",
                "email":"%s",
                "gender":"M",
                "password":"1234"
            }
        """.formatted(email);

        // Test registration
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(registerJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());

        String loginJson = """
            {
                "email":"%s",
                "password":"1234"
            }
        """.formatted(email);

        // Test login
        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())
                .andExpect(jsonPath("$.email").value(email));
    }

    @Test
    void loginWithWrongPasswordUnauthorized() throws Exception {
        String email = "wrongpass@example.com";
        deleteUserByEmail(email);

        // Créer l'utilisateur
        Person user = Person.builder()
                .email(email)
                .name("WrongPass")
                .password("$2a$10$7w3e5EHe6uQpHszqjH4Isez3RMRt6rE6fV8yQ5tIYp/4vZ8/Q5zWy") // bcrypt 1234
                .gender("M")
                .lastName("Test")
                .build();
        repositoryPerson.save(user);

        String loginJson = """
            {
                "email":"%s",
                "password":"wrongpassword"
            }
        """.formatted(email);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(loginJson))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Mot de passe invalide"));
    }
}
