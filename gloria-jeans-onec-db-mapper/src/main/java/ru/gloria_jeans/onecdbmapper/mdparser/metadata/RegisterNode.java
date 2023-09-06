package ru.gloria_jeans.onecdbmapper.mdparser.metadata;

import ru.gloria_jeans.onecdbmapper.mdparser.utils.OnecConverter;

import java.util.ArrayList;
import java.util.List;

public class RegisterNode extends BaseNode {
    public List<SbNodeField> Props;
    public List<SbNodeField> Flds;
    public List<SbNodeField> Figures;
    public List<SbNodeField> All;

    public RegisterNode(Node inNode) throws Exception {
        DbPrefix = "RA";
        ww = OnecConverter.toStringArray(inNode.Text);

        if (ww.length != 10) {
            throw new Exception("Что то не так со структурой регистров. " + inNode.Text + " ");
        }

        Props = new ArrayList<>();
        Flds = new ArrayList<>();
        Figures = new ArrayList<>();
        All = new ArrayList<>();

        for (Node item : inNode.Childs){
            switch (OnecConverter.trim(item.Text)) {
                case "Props":
                    for (Node PropItem : item.Childs) {
                        SbNodeField prop = new SbNodeField(PropItem.Text);
                        prop.DbPrefix = "SP";
                        Props.add(prop);
                        All.add(prop);
                    }

                    break;
                case "Flds":
                    for (Node PropItem : item.Childs) {
                        SbNodeField fld = new SbNodeField(PropItem.Text);
                        fld.DbPrefix = "SP";
                        Flds.add(fld);
                        All.add(fld);
                    }

                    break;
                case "Figures":
                    for (Node PropItem : item.Childs) {
                        SbNodeField figure = new SbNodeField(PropItem.Text);
                        figure.DbPrefix = "SP";
                        Figures.add(figure);
                        All.add(figure);
                    }

                    break;
                default:
                    break;
            }
        }
    }
}
