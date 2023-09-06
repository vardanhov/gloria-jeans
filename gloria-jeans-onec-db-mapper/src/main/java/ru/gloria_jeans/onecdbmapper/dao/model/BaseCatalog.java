package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseCatalog implements Serializable {
    @Id
    @Column(name = "Row ID")
    private long rowId;

    @Column(name = "ID")
    private String id;

    @Column(name = "ISMARK")
    private boolean isMark;

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isMark() {
        return isMark;
    }

    public void setMark(boolean mark) {
        isMark = mark;
    }
}
