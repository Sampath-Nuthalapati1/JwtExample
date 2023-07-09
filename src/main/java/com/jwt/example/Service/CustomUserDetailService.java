package com.jwt.example.Service;

import com.jwt.example.Model.User;
import com.jwt.example.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //we will load user from database
        User user = this.userRepo.findByEmail(username).orElseThrow( () -> new RuntimeException("User not found!"));
        return user;
    }
}
