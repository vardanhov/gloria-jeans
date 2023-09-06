package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;


import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class SupplyMenuDocumentScreenView extends Screen {
    public SupplyMenuDocumentScreenView() {
        Button button = new Button();
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                )
        );
        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("supplyButtonText");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        button.setContent(text);
        button.width(400);
        button.paddingHorizontal(5);
        button.background(new Color(179, 179, 179, 255));
        button.setClickAction(action);
        getItems().add(button);

        button = new Button();
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("confidentialAcceptanceButtonText");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        button.setContent(text);
        button.width(400);
        button.paddingHorizontal(5);
        button.background(new Color(255, 255, 255, 255));
        button.setClickAction(action);
        getItems().add(button);

        button = new Button();
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("removeFromHoldingButtonText");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        button.setContent(text);
        button.width(400);
        button.paddingHorizontal(5);
        button.background(new Color(255, 255, 255, 255));
        button.setClickAction(action);
        getItems().add(button);

        button = new Button();
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("printingPackingListButtonText");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        button.setContent(text);
        button.width(400);
        button.paddingHorizontal(5);
        button.background(new Color(255, 255, 255, 255));
        button.setClickAction(action);
        getItems().add(button);

        button = new Button();
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("printingTrade13ButtonText");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        button.setContent(text);
        button.width(400);
        button.paddingHorizontal(5);
        button.background(new Color(255, 255, 255, 255));
        button.setClickAction(action);
        getItems().add(button);
    }

    @Override
    public void initHeader() {
        Header header = new Header();
        IconButton iconButton = new IconButton();
        iconButton.setIcon(Icon.Back);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_VIEW_DOCUMENT.getWarehouseScreen()
                )
        );
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("headerTitle");
        text.setContent(bindingProperty);
        header.getContents().add(text);

        this.setHeader(header);
    }
}
