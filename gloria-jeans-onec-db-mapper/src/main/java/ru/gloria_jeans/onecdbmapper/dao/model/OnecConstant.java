package ru.gloria_jeans.onecdbmapper.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "_1SCONST")
public class OnecConstant implements Serializable {
    @Id
    @Column(name = "ROW_ID")
    private long rowId;

    @Column(name = "OBJID")
    private String objId;

    @Column(name = "ID")
    private long id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "DOCID")
    private String docId;

    @Column(name = "TIME")
    private int time;

    @Column(name = "ACTNO")
    private int actNo;

    @Column(name = "LINENO_")
    private short lineNo;

    @Column(name = "TVALUE")
    private String tValue;

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getActNo() {
        return actNo;
    }

    public void setActNo(int actNo) {
        this.actNo = actNo;
    }

    public short getLineNo() {
        return lineNo;
    }

    public void setLineNo(short lineNo) {
        this.lineNo = lineNo;
    }

    public String gettValue() {
        return tValue;
    }

    public void settValue(String tValue) {
        this.tValue = tValue;
    }
}
