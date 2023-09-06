package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Direction;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class InternetOrderCollectOrdersMenuOrderScreenView extends Screen {

    public InternetOrderCollectOrdersMenuOrderScreenView() {
        Container container = new Container();
        Container labelContainer = new Container();
        labelContainer.setDirection(Direction.HORIZONTAL);
        labelContainer.paddingHorizontal(90);


        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderLabel");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        labelContainer.getItems().add(text);


        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderNumber");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        labelContainer.getItems().add(text);
        container.getItems().add(labelContainer);

        Button button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("confirmAssemblyOrderButton");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONFIRM_ASSEMBLY_ORDER.getWarehouseScreen()
                )
        );
        button.width(360);
        button.background(new Color(255, 255, 255, 255));
        button.setContent(text);
        button.setClickAction(action);
        container.getItems().add(button);

        button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("quantityPackagesButton");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_MENU_ORDER.getWarehouseScreen()
                )
        );
        button.width(360);
        button.background(new Color(209, 209, 209, 255));
        button.setContent(text);
        button.setClickAction(action);
        container.getItems().add(button);
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
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen()
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
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_MENU_ORDER.getWarehouseScreen()
                )
        );
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        this.setHeader(header);
    }
}
