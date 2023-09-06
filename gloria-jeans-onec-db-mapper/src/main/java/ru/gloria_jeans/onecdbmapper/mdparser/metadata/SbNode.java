package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.util.ArrayList;
import java.util.List;

//Справочники
public class SbNode extends BaseNode {
    private List<SbNodeField> Fields;
    private List<SbNodeForm> Forms;

    //-
    public String getParentRefObj() { return ww[4]; }     //"0"
    public String getCodeLength() { return ww[5]; } //"11"
    public String getParam7() { return ww[6]; }  //"2"
    public String getParam8() { return ww[7]; } //"1",
    public String getParam9() { return ww[8]; }//"1",
    public String getDescrLength() { return ww[9]; }//"48",
    public String getParam11() { return ww[10]; }//"1",
    public String getParam12() { return ww[11]; }//"0",
    public String getLevels() { return ww[12]; }//"1",
    public String getParam14() { return ww[13]; }//"8358",
    public String getParam15() { return ww[14]; }//"8358",
    public String getParam16() { return ww[15]; }//"0",
    public String getParam17() { return ww[16]; }//"0",
    public String getParam18() { return ww[17]; }//"1",,,

    public List<SbNodeField> getFields() {
        return Fields;
    }

    public SbNode(Node inNode) {
        DbPrefix = "SC";
        ww = OnecConverter.toStringArray(inNode.Text);

        for (Node zItem : inNode.Childs) {
            switch (OnecConverter.trim(zItem.Text)) {
                case "Params":
                    //- fields
                    Fields = new ArrayList<>();
                    // predefined
                    Fields.add(new SbNodeField(String.format("\"ROW_ID\",\"Row ID\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "I", "0")));
                    Fields.add(new SbNodeField(String.format("\"ID\",\"ID\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", "9")));
                    Fields.add(new SbNodeField(String.format("\"ISMARK\",\"ISMARK\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "B", "1")));

                    if (!this.getCodeLength().equals("0")) {
                        Fields.add(new SbNodeField(String.format("\"CODE\",\"CODE\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", this.getCodeLength())));
                    }

                    if (!this.getCodeLength().equals("0")) {
                        Fields.add(new SbNodeField(String.format("\"DESCR\",\"DESCR\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", this.getCodeLength())));
                    }

                    //for multilevel ref - 2 fields
                    if (Integer.parseInt(this.getLevels()) > 1) {
                        Fields.add(new SbNodeField(String.format("\"PARENTID\",\"PARENTID\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", "9")));
                        Fields.add(new SbNodeField(String.format("\"ISFOLDER\",\"ISFOLDER\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "Y", "1")));
                    }

                    //for parExt
                    if (!this.getParentRefObj().equals("0")) {
                        Fields.add(new SbNodeField(String.format("\"PARENTEXT\",\"PARENTEXT\",\"\",\"\",\"%s\",\"%s\",\"0\",\"0\"", "S", "9")));
                    }

                    for (Node ParamItem : zItem.Childs){
                        SbNodeField sbNodeField = new SbNodeField(ParamItem.Text);
                        sbNodeField.DbPrefix = "SP";
                        Fields.add(sbNodeField);
                    }

                    break;
                case "Form":
                    Forms = new ArrayList<>();

                    for (Node FormsItem : zItem.Childs) {
                        Forms.add(new SbNodeForm(FormsItem.Text));
                    }

                    break;
                default:
                    break;
            }
        }
    }
}
