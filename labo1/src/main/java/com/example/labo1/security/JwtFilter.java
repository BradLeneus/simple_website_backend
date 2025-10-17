package com.example.labo1.security;

import com.example.labo1.Model.Person;
import com.example.labo1.Repositories.RepositoryPerson;
import com.example.labo1.security.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final RepositoryPerson userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7); // enlève "Bearer "

        try {
            Claims claims = jwtService.validateToken(token);
            String email = claims.getSubject();
            System.out.println("this is your email" + email);
            Person user = userRepository.findByEmail(email).orElse(null);

            // ⚡ Vérifie ici
            if(user == null) {
                System.out.println("User not found from email in token");
            } else {
                System.out.println("User found: " + user.getEmail());
            }

            request.setAttribute("user", user);  // ATTENTION : c’est ici que tu fixes le user
        } catch (Exception e) {
            System.out.println("Token invalide ou expiré: " + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
}
