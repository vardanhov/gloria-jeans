package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

public class EnumVal extends BaseNode {
    private String _t;

    public EnumVal(String inText) {
        ww = OnecConverter.toStringArray(inText);
    }

    public String getDbValue() {
        if (_t == null) {
            _t = OnecConverter.toBase36(this.getID());
        }

        return _t;
    }
}
