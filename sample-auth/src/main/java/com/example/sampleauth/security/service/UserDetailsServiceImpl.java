package com.example.sampleauth.security.service;

import com.example.sampleauth.domain.user.entity.Users;
import com.example.sampleauth.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
   private final UserRepository userRepository;

   @Override
    @Transactional
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException{
       Users user = this.userRepository.findById(id)
               .orElseThrow(()-> new UsernameNotFoundException("User not Found with userid:" + id));
       return UserDetailsImpl.build(user);
   }

}
