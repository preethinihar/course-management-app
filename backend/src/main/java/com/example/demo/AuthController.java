package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AppUserRepository repo;

    public AuthController(AppUserRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/register")
    public String register(@RequestBody AppUser user) {
        repo.save(user);
        return "REGISTERED";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password) {

        AppUser user = repo.findByUsername(username);

        if (user == null) return "USER_NOT_FOUND";
        if (!user.getPassword().equals(password))
            return "INVALID_PASSWORD";

        return "LOGIN_OK";
    }
}
