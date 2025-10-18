package com.example.labo1.Controller;

import com.example.labo1.Model.Person;
import com.example.labo1.Repositories.RepositoryPerson;
import com.example.labo1.Service.BcryptService;
import com.example.labo1.security.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Contrôleur pour la gestion de l'authentification des utilisateurs.
 * Fournit des endpoints pour le login, l'inscription et la récupération
 * des informations de l'utilisateur connecté.
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    /**
     * Repository pour accéder aux données des utilisateurs.
     */
    private final RepositoryPerson userRepository;

    /**
     * Service pour le hachage et la vérification des mots de passe.
     */
    private final BcryptService bcryptService;

    /**
     * Service pour la génération de tokens JWT.
     */
    private final JwtService jwtService;

    /**
     * Endpoint pour l'authentification d'un utilisateur.
     *
     * @param request Objet contenant l'email et le mot de passe.
     * @return ResponseEntity avec le token JWT et l'email si succès,
     *         ou un code 401 si mot de passe invalide.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Person user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!bcryptService.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe invalide");
        }

        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(Map.of("token", token, "email", user.getEmail()));
    }

    /**
     * Endpoint pour l'inscription d'un nouvel utilisateur.
     *
     * @param request Objet contenant les informations de l'utilisateur à créer.
     * @return ResponseEntity avec le token JWT si succès,
     *         ou un code 409 si l'email est déjà utilisé.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email déjà utilisé");
        }

        Person user = Person.builder()
                .email(request.getEmail())
                .name(request.getUsername())
                .password(bcryptService.encode(request.getPassword()))
                .gender(request.getGender())
                .lastName(request.getLastName())
                .build();

        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(Map.of("token", token));
    }

    /**
     * Endpoint pour récupérer les informations de l'utilisateur connecté.
     *
     * @param request HttpServletRequest contenant l'utilisateur attaché par le filtre JWT.
     * @return ResponseEntity avec l'ID et l'email de l'utilisateur,
     *         ou un code 401 si non connecté.
     */
    @GetMapping("/me")
    public ResponseEntity<?> me(HttpServletRequest request) {
        Person user = (Person) request.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Non connecté");
        }
        return ResponseEntity.ok(Map.of("id", user.getId(), "email", user.getEmail()));
    }
}
