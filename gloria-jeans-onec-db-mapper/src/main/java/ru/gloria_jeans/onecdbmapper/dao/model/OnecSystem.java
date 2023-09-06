package ru.gloria_jeans.onecdbmapper.dao.model;

import java.util.Date;

public class OnecSystem {
    private Date curdate;
    private Integer curtime;
    private String eventidta;
    private String dbsign;
    private String dbsetuuid;
    private String snapshper;
    private Date accdate;
    private Integer flags;

    public Date getCurdate() {
        return curdate;
    }

    public void setCurdate(Date curdate) {
        this.curdate = curdate;
    }

    public Integer getCurtime() {
        return curtime;
    }

    public void setCurtime(Integer curtime) {
        this.curtime = curtime;
    }

    public String getEventidta() {
        return eventidta;
    }

    public void setEventidta(String eventidta) {
        this.eventidta = eventidta;
    }

    public String getDbsign() {
        return dbsign;
    }

    public void setDbsign(String dbsign) {
        this.dbsign = dbsign;
    }

    public String getDbsetuuid() {
        return dbsetuuid;
    }

    public void setDbsetuuid(String dbsetuuid) {
        this.dbsetuuid = dbsetuuid;
    }

    public String getSnapshper() {
        return snapshper;
    }

    public void setSnapshper(String snapshper) {
        this.snapshper = snapshper;
    }

    public Date getAccdate() {
        return accdate;
    }

    public void setAccdate(Date accdate) {
        this.accdate = accdate;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }
}
