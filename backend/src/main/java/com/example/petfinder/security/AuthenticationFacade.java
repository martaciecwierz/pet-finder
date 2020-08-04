package com.example.petfinder.security;

import com.example.petfinder.model.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Long getLoggedUserId() {
        return ((AppUserPrincipal) getAuthentication().getPrincipal()).getUser().getId();
    }
}
