package domain.service;

import domain.entity.CallerId;
import domain.payload.CreateCallerIdDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class CallerIdServiceTest {
    private CallerIdService callerIdService;

    @Before
    public void setup(){
        this.callerIdService = new CallerIdService();
    }
    @After
    public void tearDown(){
        this.callerIdService = null;
    }

    @Test
    public void 발신번호가정상적으로생성된다(){

        CreateCallerIdDto createCallerIdDto = new CreateCallerIdDto();
        this.callerIdService.newCallerId();
    }
}