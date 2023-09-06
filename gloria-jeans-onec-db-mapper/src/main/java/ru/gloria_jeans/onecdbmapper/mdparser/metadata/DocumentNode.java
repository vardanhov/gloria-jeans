package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.util.ArrayList;
import java.util.List;

//Документы
public class DocumentNode extends BaseNode {
    public List<SbNodeField> Head;
    public List<SbNodeField> Table;
    public String getIDJOURNAL() { return ww[8]; }
    public String getIDNumerator() { return ww[11]; }

    public DocumentNode(Node inNode) throws Exception {
        DbPrefix = "DH";
        String tx = inNode.Text;
        ww = OnecConverter.toStringArray(tx);

        if (ww.length != 24) {
            throw new Exception("Что то не так со структурой документов. " + tx + " ");
        }

        for (Node zItem : inNode.Childs) {
            switch (OnecConverter.trim(zItem.Text)) {
                case "Head Fields":
                    //- fields
                    Head = new ArrayList<>();
                    Head.add(new SbNodeField(String.format("\"IDDOC\",\"IDDOC\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", "9")));

                    for (Node ParamItem : zItem.Childs) {
                        SbNodeField sbNodeField = new SbNodeField(ParamItem.Text);
                        sbNodeField.DbPrefix = "SP";
                        Head.add(sbNodeField);
                    }

                    break;
                case "Table Fields":
                    Table = new ArrayList<>();
                    Table.add(new SbNodeField(String.format("\"IDDOC\",\"IDDOC\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", "9")));
                    Table.add(new SbNodeField(String.format("\"LINENO_\",\"LINENO_\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "I", "0")));

                    for (Node FormsItem : zItem.Childs) {
                        SbNodeField sbNodeField = new SbNodeField(FormsItem.Text);
                        sbNodeField.DbPrefix = "SP";
                        Table.add(sbNodeField);
                    }

                    break;
                default:
                    break;
            }
        }
    }
}