package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "_1SDNLOCK")
public class DnLock {
    @EmbeddedId
    private DnLockIdentificator dnLockIdentificator;

    public DnLockIdentificator getDnLockIdentificator() {
        return dnLockIdentificator;
    }

    public void setDnLockIdentificator(DnLockIdentificator dnLockIdentificator) {
        this.dnLockIdentificator = dnLockIdentificator;
    }
}
