package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//ПЕречисления
public class EnumNode extends BaseNode {
    public List<EnumVal> Values;
    public Map<String, String> DbToIdentVals;
    public Map<String, String> IdentToDbVals;

    public EnumNode(Node inNode) {
        ww = OnecConverter.toStringArray(inNode.Text);

        for (Node zItem : inNode.Childs) {
            switch (OnecConverter.trim(zItem.Text)) {
                case "EnumVal":
                    Values = new ArrayList<>();
                    DbToIdentVals = new HashMap<>();
                    IdentToDbVals = new HashMap<>();

                    for (Node ParamItem : zItem.Childs) {
                        EnumVal t = new EnumVal(ParamItem.Text);
                        Values.add(t);
                        DbToIdentVals.put(t.getDbValue(), t.getIdentity());
                        IdentToDbVals.put(t.getDbValue(), t.getIdentity());
                    }

                    break;
                default:
                    break;
            }
        }
    }
}