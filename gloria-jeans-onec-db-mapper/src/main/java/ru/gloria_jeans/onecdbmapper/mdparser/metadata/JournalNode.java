package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

public class JournalNode extends BaseNode {
    public JournalNode(Node inNode) {
        ww = OnecConverter.toStringArray(inNode.Text);
    }
}