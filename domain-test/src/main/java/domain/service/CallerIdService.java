package domain.service;


import domain.payload.CreateCallerIdByUserRegistrationCertificateDto;
import domain.repository.CallerIdRepository;

public class CallerIdService {
    private final CallerIdRepository callerIdRepository = new CallerIdRepository();

    public Long addUserRegistrationCertificate(CreateCallerIdByUserRegistrationCertificateDto createCallerIdDto) {
        return this.callerIdRepository.save(createCallerIdDto.toEntity());
    }
}
