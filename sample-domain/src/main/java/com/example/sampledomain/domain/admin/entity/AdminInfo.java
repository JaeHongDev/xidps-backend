package com.example.sampledomain.domain.admin.entity;

import javax.persistence.*;

public class AdminInfo {
    private AdminEntity admin;

    private String password;

    private String accessToken;
    private String refreshToken;
}
