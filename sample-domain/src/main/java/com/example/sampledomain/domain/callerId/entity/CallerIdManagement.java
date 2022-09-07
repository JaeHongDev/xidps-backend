package com.example.sampledomain.domain.callerId.entity;


import javax.persistence.Embeddable;

@Embeddable
public class CallerIdManagement {
    private enum callerIdGovernment {
       FILE_AUTHENTICATION,
       API_AUTHENTICATION
    };

    private String fileUrl;
    private boolean consignmentCertificationStatus;// 위탁발신 여부;
    private String fileUrl1;
    private String idCardImageUrl;

    private String apiId;
    private String apiCertificationStatus; // api 인증여부
}
