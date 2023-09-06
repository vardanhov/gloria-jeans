package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

//Общие реквизиты
public class JrnlFldDefNode extends BaseNode {
    public JrnlFldDefNode(String str) {
        ww = OnecConverter.toStringArray(str);
    }

    public JrnlFldDefNode(String str, String pref) {
        ww = OnecConverter.toStringArray(str);
        this.DbPrefix = pref;
    }

    public String getType() { return ww[4]; }

    public String getLength() { return ww[5]; }

    public String getPrecision() { return ww[6]; }

    public String getRefToObject() { return ww[7]; }

    public String getNonNegative() { return ww[8]; }

    public String getSplitTriads() { return ww[9]; }

    public String getIndexed() { return ww[10]; }
}