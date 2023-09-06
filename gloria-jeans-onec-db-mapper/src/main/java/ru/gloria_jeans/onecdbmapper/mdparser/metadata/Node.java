package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public String Text;
    public List<Node> Childs;

    public Node() {
        Childs = new ArrayList<>();
    }
}