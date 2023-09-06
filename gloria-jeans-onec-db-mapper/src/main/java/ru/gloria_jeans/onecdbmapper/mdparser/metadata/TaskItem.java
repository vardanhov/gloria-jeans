package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

//Описание конфы
public class TaskItem extends BaseNode {
    public TaskItem(String str) {
        ww = OnecConverter.toStringArray(str);
    }

    public String getPwd() { return ww[4]; }

    public String getLang() { return ww[5]; }

    public String getParam7() { return ww[6]; }

    public String getDirectDel() { return ww[7]; }

    public String getRound() { return ww[8]; }

    public String getParam10() { return ww[9]; }
}
