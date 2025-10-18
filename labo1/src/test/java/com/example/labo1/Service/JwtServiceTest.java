package com.example.labo1.Service;

import com.example.labo1.Model.Person;
import com.example.labo1.security.JwtService;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {

    private final JwtService jwtService = new JwtService();

    @Test
    void generateTokenShouldReturnNonNullToken() {
        Person user = new Person();
        user.setId(42);
        user.setEmail("test@example.com");

        String token = jwtService.generateToken(user);

        assertNotNull(token);
        assertFalse(token.isEmpty());
    }

    @Test
    void validateTokenShouldReturnClaims() {
        Person user = new Person();
        user.setId(99);
        user.setEmail("user@example.com");

        String token = jwtService.generateToken(user);

        Claims claims = jwtService.validateToken(token);

        assertEquals("user@example.com", claims.getSubject());
        assertEquals(99, claims.get("id", Integer.class));
        assertNotNull(claims.getIssuedAt());
        assertNotNull(claims.getExpiration());
    }

    @Test
    void validateTokenShouldThrowForInvalidToken() {
        String invalidToken = "invalid.token.value";

        assertThrows(Exception.class, () -> {
            jwtService.validateToken(invalidToken);
        });
    }
}
