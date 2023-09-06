package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

public class SbNodeField extends BaseNode {
        public SbNodeField(String inText) {
                ww = OnecConverter.toStringArray(inText);
        }

        public String getType() { return ww[4]; }

        public String getLength() { return ww[5]; }

        public String getPrecision() { return ww[6]; }

        public String getRefToObject() { return ww[7]; }
}
