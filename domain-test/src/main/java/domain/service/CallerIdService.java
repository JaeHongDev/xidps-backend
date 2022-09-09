package domain.service;


import domain.payload.CreateCallerIdByUserRegistrationCertificateDto;
import domain.payload.CreateProxyCallerIdByUserRegistrationCertificateDto;
import domain.repository.CallerIdRepository;

public class CallerIdService {
    private final CallerIdRepository callerIdRepository = new CallerIdRepository();

    public Long addUserRegistrationCertificate(CreateCallerIdByUserRegistrationCertificateDto createCallerIdDto) {
        return this.callerIdRepository.save(createCallerIdDto.toEntity());
    }

    // 대리 등록
    public Long addProxyUserRegistrationCertificate(CreateProxyCallerIdByUserRegistrationCertificateDto createProxyCallerIdByUserRegistrationCertificateDto) {
        return 1L;
    }
}
