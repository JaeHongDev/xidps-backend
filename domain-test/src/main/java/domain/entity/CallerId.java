package domain.entity;


import lombok.Builder;
import lombok.Getter;

@Getter
public class CallerId {
    private String uuid; // key
    private String Id;
    private String name;
    private String departmentName;
    private enum status{
        USABLE,
        UNABLE
    }
    private String memo;
    private CallerIdAuthenticated callerIdAuthenticated;


    @Builder
    public CallerId(
            String uuid,
            String id,
            String name,
            String departmentName,
            String memo,
            CallerIdAuthenticated callerIdAuthenticated) {
        this.uuid                  = uuid;
        Id                         = id;
        this.name                  = name;
        this.departmentName        = departmentName;
        this.memo                  = memo;
        this.callerIdAuthenticated = callerIdAuthenticated;
    }
}
