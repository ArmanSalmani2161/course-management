package com.cdac.course_management.controller;

import com.cdac.course_management.dto.AuthRequest;
import com.cdac.course_management.dto.AuthResponse;
import com.cdac.course_management.dto.RegisterRequest;
import com.cdac.course_management.entity.User;
import com.cdac.course_management.repository.UserRepository;
import com.cdac.course_management.security.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authManager, JwtService jwtService,
                          UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getUserName(), request.getPassword());
        authManager.authenticate(authentication);

        String token = jwtService.generateToken(
                request.getUserName(),
                Map.of("role", userRepository.findByUserName(request.getUserName())
                        .map(User::getRoleType).orElse("USER"))
        );
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req) {
        if (userRepository.findByUserName(req.getUserName()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        User u = new User();
        u.setName(req.getName());
        u.setUserName(req.getUserName());
        u.setPassword(passwordEncoder.encode(req.getPassword())); // hash!
        u.setRoleType(req.getRoleType() == null ? "USER" : req.getRoleType().toUpperCase());
        userRepository.save(u);

        String token = jwtService.generateToken(u.getUserName(), Map.of("role", u.getRoleType()));
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
