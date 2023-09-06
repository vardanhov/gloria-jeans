package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IddocLinenumberIdentity implements Serializable {
    private String idDoc;
    private Integer lineNo_;

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public Integer getLineNo() {
        return lineNo_;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo_ = lineNo;
    }
}
