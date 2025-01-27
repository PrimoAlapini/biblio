package bj.highfiveuniversity.biblio.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.biblio.configuration.JwtTokenUtil;
import bj.highfiveuniversity.biblio.dto.RegisterDTO;
import bj.highfiveuniversity.biblio.dto.LoginDTO;
import bj.highfiveuniversity.biblio.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService ; 
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil ;

    @PostMapping("register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO registerDto) {
        userService.register(registerDto);
        return ResponseEntity.ok("Utiliateur ajouté avec succès");
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDto) {
        try {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
            loginDto.getUsername(),
            loginDto.getPassword()
            ) 
        );
        final UserDetails  userDetails =  userDetailsService.loadUserByUsername( loginDto.getUsername()) ;
        // Générer un token pour l'utilisateur
        final String token = jwtTokenUtil.genrateToken(userDetails) ;
        
        return ResponseEntity.ok("connexion réussie , voici le token : " + token); 
    } catch (AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Echec de l'authentification" + e.getMessage()) ; 
    }
    }
}
