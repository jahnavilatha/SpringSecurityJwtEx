package com.security.SpringSecurityExample.service;

import com.security.SpringSecurityExample.model.Users;
import com.security.SpringSecurityExample.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication=
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        else{
            return "Failed to authenricate";
        }
    }
}
