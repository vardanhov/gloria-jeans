package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IddocLinenumberActionnumberIdentity implements Serializable {
    private String idDoc;
    private Integer lineNo_;
    private Integer actno;

    public String getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(String idDoc) {
        this.idDoc = idDoc;
    }

    public Integer getLineNo() {
        return lineNo_;
    }

    public void setLineNo(Integer lineNo_) {
        this.lineNo_ = lineNo_;
    }

    public Integer getActno() {
        return actno;
    }

    public void setActno(Integer actno) {
        this.actno = actno;
    }
}
