package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "_1SUSERS")
public class OnecUser {
    @Id
    @Column(name = "USRSCNT", nullable = false)
    private Integer usrscnt;
    @Column(name = "NETCHGCN", nullable = false)
    private Integer netchgcn;

    public Integer getUsrscnt() {
        return usrscnt;
    }

    public void setUsrscnt(Integer usrscnt) {
        this.usrscnt = usrscnt;
    }

    public Integer getNetchgcn() {
        return netchgcn;
    }

    public void setNetchgcn(Integer netchgcn) {
        this.netchgcn = netchgcn;
    }
}
