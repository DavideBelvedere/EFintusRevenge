package logistica.rest.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import logistica.entities.superType.Orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponsePO<PO extends Orm> implements Serializable {
    private List<PO> responseList = new ArrayList<>();

    @JsonGetter
    public List<PO> getResponseList() {
        return responseList;
    }

    @JsonSetter
    public void setResponseList(List<PO> responseList) {
        this.responseList = responseList;
    }

    public void addResponsePO(PO po) {
        responseList.add(po);
    }
}
