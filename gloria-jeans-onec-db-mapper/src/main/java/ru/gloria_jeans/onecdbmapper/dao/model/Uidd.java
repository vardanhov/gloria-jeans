package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Uidd implements Serializable {
    @Id
    private String uidd;

    public String getUidd() {
        return uidd;
    }

    public void setUidd(String uidd) {
        this.uidd = uidd;
    }
}
