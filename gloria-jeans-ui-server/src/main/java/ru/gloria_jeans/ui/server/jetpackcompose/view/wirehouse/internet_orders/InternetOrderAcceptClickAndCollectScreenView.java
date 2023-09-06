package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class InternetOrderAcceptClickAndCollectScreenView extends Screen {
    public InternetOrderAcceptClickAndCollectScreenView() {
        Container container = new Container();
        container.setHasScroll(true);
        container.fillMaxSize();
        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("barcodeLabel");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        container.getItems().add(text);

        Container horizontalContainer = new Container();
        horizontalContainer.setDirection(Direction.HORIZONTAL);
        Image scanCodeImage = new Image();
        scanCodeImage.fillMaxHeigth();
        scanCodeImage.paddingHorizontal(5);
        scanCodeImage.width(60).heigth(60);
        scanCodeImage.setImage(BaseStringImages.SCAN_CODE);
        horizontalContainer.getItems().add(scanCodeImage);
        TextField textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("barcode");
        textField.setValue(bindingProperty);
        textField.heigth(60).width(230);
        horizontalContainer.getItems().add(textField);
        Image searchImage = new Image();
        searchImage.setImage(BaseStringImages.SEARCH);
        searchImage.width(60).heigth(60);
        Action action = new Action();
        action.
                setActionUri(
                        String.format(
                                "%s/%s",
                                UrlHelper.getUrlToCurrentResource(),
                                WarehouseScreen.INTERNET_ORDERS_ACCEPT_CLICK_COLLECT_CONFIRM.getWarehouseScreen()

                        )
                );
        searchImage.setClickAction(action);
        horizontalContainer.getItems().add(searchImage);
        container.getItems().add(horizontalContainer);
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
        text.setFontWeight(FontWeight.Medium);
        text.setColor(new Color(255, 255, 255, 255));
        text.setContent(bindingProperty);
        header.getContents().add(text);

        iconButton = new IconButton();
        iconButton.setIcon(Icon.Burger);
        action = new Action();
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        this.setHeader(header);
    }
}

