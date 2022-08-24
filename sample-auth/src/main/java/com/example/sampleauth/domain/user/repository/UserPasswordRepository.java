package com.example.sampleauth.domain.user.repository;

import com.example.sampleauth.domain.user.entity.UserPassword;
import com.example.sampleauth.domain.user.entity.Users;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;



public interface UserPasswordRepository extends JpaRepository<UserPassword,String>{

}
