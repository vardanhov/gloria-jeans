package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiSelector extends Composable {
    private List<MultiSelectorItem> itemsList = new ArrayList<>();
    private BindingProperty selectedItems = new BindingProperty();
    private Text labelName = new Text();

    public MultiSelector() {
        super();
        setElementType(ElementType.MultiSelector);
    }

    public BindingProperty getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(BindingProperty selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<MultiSelectorItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<MultiSelectorItem> itemsList) {
        this.itemsList = itemsList;
    }

    public Text getLabelName() {
        return labelName;
    }

    public void setLabelName(Text labelName) {
        this.labelName = labelName;
    }
}
