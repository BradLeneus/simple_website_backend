package com.example.labo1.security;

import com.example.labo1.Model.Person;
import com.example.labo1.Repositories.RepositoryPerson;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class JwtFilterTest {

    private JwtService jwtService;
    private RepositoryPerson userRepository;
    private JwtFilter jwtFilter;

    private HttpServletRequest request;
    private HttpServletResponse response;
    private FilterChain filterChain;

    @BeforeEach
    void setUp() {
        jwtService = mock(JwtService.class);
        userRepository = mock(RepositoryPerson.class);
        jwtFilter = new JwtFilter(jwtService, userRepository);

        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        filterChain = mock(FilterChain.class);
    }

    @Test
    void doFilterInternal_shouldSetUserAttributeIfTokenValid() throws Exception {
        // Arrange
        String token = "valid.token";
        String email = "test@example.com";

        Person user = new Person();
        user.setEmail(email);

        Claims claims = mock(Claims.class);
        when(claims.getSubject()).thenReturn(email);
        when(jwtService.validateToken(token)).thenReturn(claims);
        when(userRepository.findByEmail(email)).thenReturn(java.util.Optional.of(user));
        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);

        // Act
        jwtFilter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(request).setAttribute("user", user);
        verify(filterChain).doFilter(request, response);
    }

    @Test
    void doFilterInternal_shouldNotFailIfNoAuthorizationHeader() throws Exception {
        when(request.getHeader("Authorization")).thenReturn(null);

        jwtFilter.doFilterInternal(request, response, filterChain);

        verify(request, never()).setAttribute(eq("user"), any());
        verify(filterChain).doFilter(request, response);
    }

    @Test
    void doFilterInternal_shouldNotFailIfTokenInvalid() throws Exception {
        String token = "invalid.token";
        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);
        when(jwtService.validateToken(token)).thenThrow(new RuntimeException("Invalid token"));

        jwtFilter.doFilterInternal(request, response, filterChain);

        verify(request, never()).setAttribute(eq("user"), any());
        verify(filterChain).doFilter(request, response);
    }
}
