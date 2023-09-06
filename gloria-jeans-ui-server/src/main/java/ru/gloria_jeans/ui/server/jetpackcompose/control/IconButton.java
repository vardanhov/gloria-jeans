package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ElementType;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IconButton extends ButtonBase {
    private Icon icon;

    private DropdownMenu dropdownMenu;
    public IconButton() {
        this.setElementType(ElementType.IconButton);
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public DropdownMenu getDropdownMenu() {
        return dropdownMenu;
    }

    public void setDropdownMenu(DropdownMenu dropdownMenu) {
        this.dropdownMenu = dropdownMenu;
    }
}
