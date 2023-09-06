package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "_1SCRDOC")
public class OnecSrcdoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROW_ID")
    private long rowId;

    @Column(name = "MDID")
    private long mdId;

    @Column(name = "PARENTVAL")
    private String parentVal;

    @Column(name = "CHILD_DATE_TIME_IDDOC")
    private String childDateTimeIddoc;

    @Column(name = "CHILDID")
    private String childId;

    @Column(name = "FLAGS")
    private int flags;

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    public long getMdId() {
        return mdId;
    }

    public void setMdId(long mdId) {
        this.mdId = mdId;
    }

    public String getParentVal() {
        return parentVal;
    }

    public void setParentVal(String parentVal) {
        this.parentVal = parentVal;
    }

    public String getChildDateTimeIddoc() {
        return childDateTimeIddoc;
    }

    public void setChildDateTimeIddoc(String childDateTimeIddoc) {
        this.childDateTimeIddoc = childDateTimeIddoc;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }
}
