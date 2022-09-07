package domain.entity;


import lombok.Builder;
import lombok.Getter;

@Getter
public class CallerId {
    private Long index; // key
    private String Id;
    private String name;
    private String departmentName;

    public void setIndex(Long index) {
        this.index = index;
    }

    private enum status{
        USABLE,
        UNABLE
    }
    private String memo;
    private CallerIdAuthenticated callerIdAuthenticated;


    @Builder
    public CallerId(
            String id,
            String name,
            String departmentName,
            String memo,
            CallerIdAuthenticated callerIdAuthenticated) {
        Id                         = id;
        this.name                  = name;
        this.departmentName        = departmentName;
        this.memo                  = memo;
        this.callerIdAuthenticated = callerIdAuthenticated;
    }
}
