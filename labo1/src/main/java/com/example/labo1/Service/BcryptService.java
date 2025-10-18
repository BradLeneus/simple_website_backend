package com.example.labo1.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service pour gérer le chiffrement et la vérification des mots de passe
 * à l'aide de l'algorithme BCrypt.
 */
@Service
public class BcryptService {

    /**
     * Instance de l'encodeur BCrypt utilisé pour chiffrer et vérifier les mots de passe.
     */
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Chiffre un mot de passe en clair avec BCrypt.
     *
     * @param rawPassword Le mot de passe en clair.
     * @return Le mot de passe chiffré.
     */
    public String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    /**
     * Vérifie si un mot de passe en clair correspond à un mot de passe chiffré.
     *
     * @param rawPassword Le mot de passe en clair.
     * @param encodedPassword Le mot de passe chiffré à comparer.
     * @return true si les mots de passe correspondent, false sinon.
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
