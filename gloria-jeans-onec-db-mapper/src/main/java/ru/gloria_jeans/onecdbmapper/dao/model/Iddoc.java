package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Iddoc implements Serializable {
    @Id
    private String iddoc;

    public String getIddoc() {
        return iddoc;
    }

    public void setIddoc(String iddoc) {
        this.iddoc = iddoc;
    }
}
