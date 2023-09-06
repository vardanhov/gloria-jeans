package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DnLockIdentificator implements Serializable {
    private String dnprefix;
    private String docno;

    public String getDnprefix() {
        return dnprefix;
    }

    public void setDnprefix(String dnprefix) {
        this.dnprefix = dnprefix;
    }

    public String getDocno() {
        return docno;
    }

    public void setDocno(String docno) {
        this.docno = docno;
    }
}
