package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

public class SbNodeForm {
    private String[] ww;
    public SbNodeForm(String inText)
    {
        ww = OnecConverter.toStringArray(inText);
    }
    public String getID() { return ww[0]; }

    public String getName() { return ww[1]; }

    public String getParam3() { return ww[2]; }

    public String getParam4() { return ww[3]; }
}
