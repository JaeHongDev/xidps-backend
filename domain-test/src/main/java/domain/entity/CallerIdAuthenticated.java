package domain.entity;


public class CallerIdAuthenticated {

    private enum classification {
        FILE_AUTHENTICATION,
        API_AUTHENTICATION
    };
    private ManagementFile userRegistrationCertificate; // 통신서비스 이용가입증명원
    private boolean certificationByProxy; //대리 발신 여부
    private ManagementFile idCard; // 대리인 신분증
    private ManagementFile powerOfAttorney; // 위임장

    private String apiKey;
}
