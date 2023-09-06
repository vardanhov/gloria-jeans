package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.product_information;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class ProductInformationSearchScreenView extends Screen {

    public ProductInformationSearchScreenView() {
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
        bindingProperty.setValue("label");
        bindingProperty.setSelfContained(false);
        text.setFontSize(20);
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        barCodeLabelContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("labelUnderLabel");
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
        bindingProperty.setValue("handleSearch");
        bindingProperty.setSelfContained(false);
        TextField textField = new TextField();
        textField.setValue(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("barcodeLabel");
        bindingProperty.setSelfContained(false);
        textField.setLabel(bindingProperty);
        textField.setSingleLine(true);
        textField.heigth(65).width(359);
        textField.paddingHorizontal(16);
        container.getItems().add(textField);

        Button button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("searchButtonText");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setFontSize(14);
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.CATALOG_PRODUCT_INFORMATION_RESULT.getWarehouseScreen()
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
        text.setFontSize(15);
        text.setFontWeight(FontWeight.W500);
        text.setColor(new Color(255, 255, 255, 255));
        text.setContent(bindingProperty);
        header.getContents().add(text);

        this.setHeader(header);
    }
}