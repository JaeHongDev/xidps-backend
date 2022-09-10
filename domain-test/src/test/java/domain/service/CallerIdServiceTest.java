package domain.service;

import domain.payload.CreateCallerIdByUserRegistrationCertificateDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CallerIdServiceTest {
    private CallerIdService callerIdService;


    @Test
    public void 통신서비스이용가입증명원을등록방식으로전화등록하기(){
        this.callerIdService = new CallerIdService();
        CreateCallerIdByUserRegistrationCertificateDto createCallerIdDto = new CreateCallerIdByUserRegistrationCertificateDto();
        Long id = this.callerIdService.addUserRegistrationCertificate(createCallerIdDto);
        Assertions.assertEquals(id, 1L);
    }

    @Test
    public void 통신서비스이용가입증명원위탁방식으로전화등록하기(){
        this.callerIdService = new CallerIdService();

        this.callerIdService.addProxyUserRegistrationCertificate(k)
    }
}