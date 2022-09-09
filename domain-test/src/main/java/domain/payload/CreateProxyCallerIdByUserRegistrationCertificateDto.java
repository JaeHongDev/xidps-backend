package domain.payload;

import domain.entity.CallerId;
import domain.entity.CallerIdAuthenticated;
import domain.entity.ManagementFile;

public class CreateProxyCallerIdByUserRegistrationCertificateDto {

    private String callerId;
    private String userRegistrationCertificateFileName;
    private String userRegistrationCertificateFileData;
    private String userRegistrationCertificateFileSize;
    private String userRegistrationCertificateFileType;

    public CallerId toEntity() {
        var callerIdAuthenticated = CallerIdAuthenticated
                .setUserRegistrationCertificate(
                        ManagementFile.saveFile(this.userRegistrationCertificateFileName,
                                                this.userRegistrationCertificateFileSize,
                                                this.userRegistrationCertificateFileType,
                                                this.userRegistrationCertificateFileData
                        )
                );
        return CallerId.builder()
                       .id(callerId)
                       .callerIdAuthenticated(callerIdAuthenticated)
                       .build();
    }
}
