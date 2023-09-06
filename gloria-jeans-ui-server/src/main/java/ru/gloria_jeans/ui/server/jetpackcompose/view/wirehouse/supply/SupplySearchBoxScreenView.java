package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class SupplySearchBoxScreenView extends Screen {
    public SupplySearchBoxScreenView() {
        Container container = new Container();
        container.setHasScroll(true);
        container.fillMaxSize();

        Container emptyContainer = new Container();
        emptyContainer.setHasScroll(false);
        emptyContainer.heigth(24);
        container.getItems().add(emptyContainer);

        Container barCodeContainer = new Container();
        barCodeContainer.setHasScroll(false);
        barCodeContainer.setDirection(Direction.HORIZONTAL);
        barCodeContainer.heigth(45).width(328);
        barCodeContainer.paddingHorizontal(16);
        Image scanCodeImage = new Image();
        scanCodeImage.fillMaxHeigth();
        scanCodeImage.paddingHorizontal(5);
        scanCodeImage.width(32).heigth(32);
        scanCodeImage.setImage(BaseStringImages.SCAN_CODE_LOGO);
        barCodeContainer.getItems().add(scanCodeImage);

        Container barCodeLabelContainer = new Container();
        barCodeLabelContainer.setHasScroll(false);
        barCodeLabelContainer.paddingHorizontal(10);
        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("scanBarCodeLabel");
        bindingProperty.setSelfContained(false);
        text.setFontSize(20);
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        barCodeLabelContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("boxNumberLabel");
        bindingProperty.setSelfContained(false);
        text.setFontSize(14);
        text.setContent(bindingProperty);
        barCodeLabelContainer.getItems().add(text);
        barCodeContainer.getItems().add(barCodeLabelContainer);
        container.getItems().add(barCodeContainer);

        emptyContainer = new Container();
        emptyContainer.setHasScroll(false);
        emptyContainer.heigth(33);
        container.getItems().add(emptyContainer);

        bindingProperty = new BindingProperty();
        bindingProperty.setValue("barcodeBox");
        bindingProperty.setSelfContained(false);
        TextField textField = new TextField();
        textField.setValue(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("barcodeBoxPlaceholder");
        bindingProperty.setSelfContained(false);
        textField.setLabel(bindingProperty);
        textField.setSingleLine(true);
        textField.heigth(65).width(359);
        textField.paddingHorizontal(16);
        Action inputAction = new Action();
        inputAction.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen()
                )
        );
        textField.setClickAction(inputAction);
        container.getItems().add(textField);

        Button button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("buttonSearchText");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setFontSize(14);
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen()
                )
        );
        button.paddingVertical(23).paddingHorizontal(16);
        button.setContent(text);
        button.setClickAction(action);
        button.width(327).heigth(36);
        container.getItems().add(button);
        getItems().add(container);
    }

    @Override
    public void initHeader() {
        Header header = new Header();
        IconButton iconButton = new IconButton();
        iconButton.setIcon(Icon.Back);
        Action action = new Action();
        action.setActionUri(UrlHelper.getUrlToCurrentResource());
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("headerTitle");
        text.setContent(bindingProperty);
        text.setFontSize(15);
        text.setFontWeight(FontWeight.W500);
        text.setColor(new Color(255, 255, 255, 255));
        header.getContents().add(text);

        iconButton = new IconButton();
        iconButton.setIcon(Icon.Burger);
        DropdownMenu dropdownMenu = new DropdownMenu();
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "buttonSearchDocumentText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_SEARCH_DOCUMENT.getWarehouseScreen()
                                        )
                                )
                        )
                );
        iconButton.setDropdownMenu(dropdownMenu);
        header.getContents().add(iconButton);

        this.setHeader(header);
    }
}
