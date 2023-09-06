package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

public class BaseNode {
    public String[] ww;
    public String DbPrefix;

    public BaseNode() {
        this.DbPrefix = "";
    }

    public String getID() { return ww[0]; }

    public String getIdentity() { return ww[1]; }

    public String getComment() { return ww[2]; }

    public String getSynonim() { return ww[3]; }

    public String getDbName() { return String.format("%s%s", DbPrefix, getID()); }
}