package com.example.demo.service;

import com.example.demo.entity.User;   
import com.example.demo.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    private final String SECRET_KEY = "your_secret_key";
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();
        }
        return null;
    }

    public void registerUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}
