package com.weddingplanner.services;

import com.weddingplanner.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserDetails> optionalUserDetails = Optional.ofNullable(userRepository.findByUsername(username)
                .map(com.weddingplanner.services.MyUserDetails :: new).orElseThrow(() -> new UsernameNotFoundException("Username not found.")));

        if (!optionalUserDetails.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return optionalUserDetails.get();
    }
}
