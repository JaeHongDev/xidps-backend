package domain.repository;


import domain.entity.CallerId;

import java.util.ArrayList;
import java.util.List;

public class CallerIdRepository {
    private final List<CallerId> callerIdList = new ArrayList<>();
    private Long index = 1L;

    public Long save(CallerId callerId){
        callerId.setIndex(index++);
        this.callerIdList.add(callerId);
        return callerId.getIndex();
    }
}
