package ru.gloria_jeans.receiving.model.marks;

import java.io.Serializable;

public class ResponseMark implements Serializable {
    private String sbis_idd;
    private String sbis_attach_idd;
    private String error;

    public String getSbis_idd() {
        return sbis_idd;
    }

    public void setSbis_idd(String sbis_idd) {
        this.sbis_idd = sbis_idd;
    }

    public String getSbis_attach_idd() {
        return sbis_attach_idd;
    }

    public void setSbis_attach_idd(String sbis_attach_idd) {
        this.sbis_attach_idd = sbis_attach_idd;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
