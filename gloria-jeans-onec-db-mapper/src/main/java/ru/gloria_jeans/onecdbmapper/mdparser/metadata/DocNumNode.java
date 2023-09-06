package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

//Номера документов
public class DocNumNode extends BaseNode {
    public DocNumNode(String str) {
        ww = OnecConverter.toStringArray(str);
    }

    public String getLength() { return ww[4]; }

    public String getParam6() { return ww[5]; }

    public String getParam7() { return ww[6]; }

    public String getParam8() { return ww[7]; }

    public String getParam9() { return ww[8]; }
        //"12125","ТТН","","","12","1","1","2","1"
}
