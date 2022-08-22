package com.example.sampleauth.domain.user.repository;

import com.example.sampleauth.domain.user.entity.Users;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class UserRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public UserRepository(EntityManager em){
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public Optional<Users> findByUserId(String userId){
        return Optional.ofNullable(this.em.createQuery("select u from Users u where u.id =:userId", Users.class)
                .setParameter("userId", userId)
                .getSingleResult());
    }

}
