package com.example.petfinder.controller.api;

import com.example.petfinder.controller.request.LoginRequest;
import com.example.petfinder.controller.response.LoginResponse;
import com.example.petfinder.error.exception.notFound.UserNotFoundException;
import com.example.petfinder.error.exception.unauthorized.InvalidPasswordException;
import com.example.petfinder.security.JwtTokenUtil;
import com.example.petfinder.security.UserDetailsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private UserDetailsServiceImpl userDetailsService;
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;

    public LoginController(UserDetailsServiceImpl userDetailsService,
                           AuthenticationManager authenticationManager,
                           JwtTokenUtil jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        String username = userDetails.getUsername();
        return new LoginResponse(token, username);
    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new UserNotFoundException(1L);
        } catch (BadCredentialsException e) {
            throw new InvalidPasswordException();
        }
    }
}
