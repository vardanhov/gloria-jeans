package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DocStreamNode extends BaseNode {
    public Map<String,RegisterNode> Registers;
    public Map<String,DocumentNode> Documents;

    public DocStreamNode(
            Node inNode,
            Map<String, DocumentNode> docSrc,
            Map<String, RegisterNode> RegSrc
    ) {
        Registers = new HashMap<>();
        Documents = new HashMap<>();
        ww = OnecConverter.toStringArray(inNode.Text);

        for (Node zItem : inNode.Childs) {
            String[] tmp = OnecConverter.toStringArray(zItem.Text);

            if (tmp[0].equals("Registers")) {
                for (int i = 1; i < tmp.length; i++) {
                    String regName = tmp[i];
                    Map.Entry<String, RegisterNode> rg = RegSrc
                            .entrySet()
                            .parallelStream()
                            .filter(c -> c.getValue().getID().equals(regName))
                            .findFirst()
                            .orElse(null);

                    if (Objects.nonNull(rg)) {
                        this.Registers.put(rg.getValue().getIdentity(), rg.getValue());
                    }
                }
            } else if (tmp[1].equals("Documents")) {
                for (int i = 1; i < tmp.length; i++) {
                    String dgName = tmp[i];
                    Map.Entry<String, DocumentNode> dg = docSrc
                            .entrySet()
                            .parallelStream()
                            .filter(c -> c.getValue().getID().equals(dgName))
                            .findFirst()
                            .orElse(null);

                    if (Objects.nonNull(dg)) {
                        this.Documents.put(dg.getValue().getIdentity(), dg.getValue());
                    }
                }
            }
        }
    }
}