package ru.gloria_jeans.core.v1.receiving.models.request;

import java.io.Serializable;

public class AcceptanceDocument implements Serializable {
    private String idd;
    private String acceptBy;
    private String createdBy;
    private String comment;

    public AcceptanceDocument() {
    }

    public AcceptanceDocument(String idd, String acceptBy, String comment) {
        this.idd = idd;
        this.acceptBy = acceptBy;
        this.comment = comment;
    }

    public AcceptanceDocument(String idd, String acceptBy, String createdBy, String comment) {
        this.idd = idd;
        this.acceptBy = acceptBy;
        this.createdBy = createdBy;
        this.comment = comment;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getAcceptBy() {
        return acceptBy;
    }

    public void setAcceptBy(String acceptBy) {
        this.acceptBy = acceptBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
