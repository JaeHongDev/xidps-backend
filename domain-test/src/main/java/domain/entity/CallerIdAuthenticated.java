package domain.entity;


public class CallerIdAuthenticated {

    public static CallerIdAuthenticated setUserRegistrationCertificate(ManagementFile file) {
        return new CallerIdAuthenticated(Classification.FILE_AUTHENTICATION, file, false);
    }


    public CallerIdAuthenticated(
            Classification classification,
            ManagementFile userRegistrationCertificate,
            boolean certificationByProxy) {
        this.classification              = classification;
        this.userRegistrationCertificate = userRegistrationCertificate;
        this.certificationByProxy        = certificationByProxy;
    }

    private Classification classification;
    private ManagementFile userRegistrationCertificate; // 통신서비스 이용가입증명원
    private boolean        certificationByProxy; //대리 발신 여부
    private ManagementFile idCard; // 대리인 신분증
    private ManagementFile powerOfAttorney; // 위임장

    private String apiKey;
}
