package com.example.sampleauth.domain.user.service;

import com.example.sampleauth.domain.user.repository.UserPasswordRepository;
import com.example.sampleauth.domain.user.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserPasswordRepository userPasswordRepository;

    @PersistenceContext
    EntityManager em;
}
