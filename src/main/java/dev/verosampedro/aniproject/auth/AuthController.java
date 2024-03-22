package dev.verosampedro.aniproject.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "${api-endpoint}")
public class AuthController {

    @GetMapping(path = "/login")
    public ResponseEntity<Map<String, String>> login() {
        
        SecurityContext context = SecurityContextHolder.getContext();
        
        Authentication auth = context.getAuthentication();
        
        String username = auth.getName();
        String role = auth.getAuthorities().iterator().next().getAuthority();
        
        Map<String, String> json = new HashMap<>();
        json.put("message", "Logged");
        json.put("username", username);
        json.put("role", role);
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
    }
}

