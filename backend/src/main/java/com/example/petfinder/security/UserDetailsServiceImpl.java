package com.example.petfinder.security;

import com.example.petfinder.model.user.User;
import com.example.petfinder.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final WebApplicationContext applicationContext;
    private UserRepository userRepository;

    public UserDetailsServiceImpl(WebApplicationContext applicationContext, UserRepository userRepository) {
        super();
        this.applicationContext = applicationContext;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void completeSetup() {
        userRepository = applicationContext.getBean(UserRepository.class);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new AppUserPrincipal(user);
//        if("user".equals(s)){
//            return new AppUserPrincipal(User.builder().id(1L).username("user").password("$2a$10$DiFd8WP/ew/OO6mccRFYXuiM6.4RWArO413LkzCpBu1KDqGddL4b.").build());// user:pass
//        }
//        else{
//            throw new UsernameNotFoundException("user not found");
//        }
    }
}
