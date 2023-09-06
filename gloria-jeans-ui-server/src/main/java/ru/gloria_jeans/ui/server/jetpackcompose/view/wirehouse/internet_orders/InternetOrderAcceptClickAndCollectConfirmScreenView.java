package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.ClipShape;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Direction;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Border;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class InternetOrderAcceptClickAndCollectConfirmScreenView extends Screen {
    public InternetOrderAcceptClickAndCollectConfirmScreenView() {
        Container container = new Container();
        container.setDirection(Direction.VERTICAL);
        container.paddingVertical(70);
        container.border(new Border(100,
                new Color(0, 0, 0),
                new Shape(ClipShape.CircleShape, 100)));
        Container labelContainer = new Container();
        labelContainer.paddingVertical(20);
        Container buttonContainer = new Container();
        buttonContainer.setDirection(Direction.HORIZONTAL);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("confirmLabel");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        text.setFontSize(16);
        labelContainer.getItems().add(text);
        container.getItems().add(labelContainer);


        Button button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("acceptButton");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_ACCEPT_CLICK_COLLECT_CONFIRM.getWarehouseScreen()
                )
        );
        button.paddingHorizontal(40);
        button.background(new Color(50, 205, 50, 255));
        button.setContent(text);
        button.setClickAction(action);
        buttonContainer.getItems().add(button);

        button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("cancelButton");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_ACCEPT_CLICK_COLLECT.getWarehouseScreen()
                )
        );
        button.paddingHorizontal(30);
        button.background(new Color(255, 0, 0, 255));
        button.setContent(text);
        button.setClickAction(action);
        buttonContainer.getItems().add(button);
        container.getItems().add(buttonContainer);
        getItems().add(container);
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
                        WarehouseScreen.INTERNET_ORDERS.getWarehouseScreen()
                )
        );
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("headerTitle");
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