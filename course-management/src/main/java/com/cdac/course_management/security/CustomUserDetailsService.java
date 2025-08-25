package com.cdac.course_management.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cdac.course_management.entity.User;
import com.cdac.course_management.repository.UserRepository;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repo.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Expect role_type like "ADMIN" or "USER"
        List<GrantedAuthority> auth = List.of(new SimpleGrantedAuthority("ROLE_" + u.getRoleType()));
        return new org.springframework.security.core.userdetails.User(
                u.getUserName(),
                u.getPassword(),
                auth
        );
    }
}
