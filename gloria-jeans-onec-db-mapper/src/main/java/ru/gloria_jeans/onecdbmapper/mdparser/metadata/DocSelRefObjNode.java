package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.util.ArrayList;
import java.util.List;

public class DocSelRefObjNode extends BaseNode {
    public List<String> Ref;

    public DocSelRefObjNode(Node inNode) {
        ww = OnecConverter.toStringArray(inNode.Text);
        Ref = new ArrayList<>();

        for (Node Refers : inNode.Childs){
            for (Node itmRef : Refers.Childs) {
                Ref.add(itmRef.Text);
            }
        }
    }

    public String getGetEmpty() { return ww[4]; }

    public String getType() { return ww[5]; }

    public String getRefToObject() { return ww[6]; }
}