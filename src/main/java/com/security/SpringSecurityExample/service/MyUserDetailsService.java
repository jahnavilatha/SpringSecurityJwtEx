package com.security.SpringSecurityExample.service;


import com.security.SpringSecurityExample.model.UserPrincipal;
import com.security.SpringSecurityExample.model.Users;
import com.security.SpringSecurityExample.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users=userRepo.findByUsername(username);

        if(users==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(users);
    }
}
