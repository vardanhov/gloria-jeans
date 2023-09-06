package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Modifier;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DropdownMenu {
    private List<DropdownMenuItem> dropdownMenuItems = new ArrayList<>();
    private List<Modifier> modifiers = new ArrayList<>();

    public DropdownMenu() {
    }

    public DropdownMenu(List<DropdownMenuItem> dropdownMenuItems) {
        this.dropdownMenuItems = dropdownMenuItems;
    }

    public DropdownMenu(List<DropdownMenuItem> dropdownMenuItems, List<Modifier> modifiers) {
        this.dropdownMenuItems = dropdownMenuItems;
        this.modifiers = modifiers;
    }

    public List<DropdownMenuItem> getDropdownMenuItems() {
        return dropdownMenuItems;
    }

    public void setDropdownMenuItems(List<DropdownMenuItem> dropdownMenuItems) {
        this.dropdownMenuItems = dropdownMenuItems;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }
}
