package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

//Константы
public class ConstantNode extends BaseNode {
    public ConstantNode(String str) {
        ww = OnecConverter.toStringArray(str);
    }

    public String getType() { return ww[4]; }

    public String getLength() { return ww[5]; }

    public String getPrecision() { return ww[6]; }

    public String getRefToObject() { return ww[7]; }

    public String getNonNegative() { return ww[8]; }

    public String getSplitTriads() { return ww[9]; }

    public String getIsPeriodic() { return ww[10]; }
        //"5369","IDD","IDD","IDD","S","7","0",  "0","0","0","0"
}