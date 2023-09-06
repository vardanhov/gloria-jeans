package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Direction;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class InternetOrderInformationAboutOrderMenuOrderScreenView extends Screen {
    @JsonIgnore
    private Container container;
    @JsonIgnore
    private Container tableContainer;

    public InternetOrderInformationAboutOrderMenuOrderScreenView() {
        container = new Container();
        container.setHasScroll(true);
        container.fillMaxSize();
        Container orderContainer = new Container();
        orderContainer.setDirection(Direction.HORIZONTAL);
        orderContainer.paddingHorizontal(50);
        Container transportCompanyContainer = new Container();
        transportCompanyContainer.setDirection(Direction.HORIZONTAL);
        transportCompanyContainer.paddingHorizontal(45);
        Container customerNameContainer = new Container();
        customerNameContainer.setDirection(Direction.HORIZONTAL);
        customerNameContainer.paddingHorizontal(70);
        Container orderStatusContainer = new Container();
        orderStatusContainer.setDirection(Direction.HORIZONTAL);
        orderStatusContainer.paddingHorizontal(70);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderLabel");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        orderContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderNumber");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        orderContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("from");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        orderContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderDate");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        orderContainer.getItems().add(text);
        container.getItems().add(orderContainer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("transportCompanyLabel");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        transportCompanyContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("transportCompany");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        transportCompanyContainer.getItems().add(text);
        container.getItems().add(transportCompanyContainer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("customerNameLabel");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        customerNameContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("customerName");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        customerNameContainer.getItems().add(text);
        container.getItems().add(customerNameContainer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderStatusLabel");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        orderStatusContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderStatus");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        orderStatusContainer.getItems().add(text);
        container.getItems().add(orderStatusContainer);

        Button button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("courierDeliveryButton");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COURIER_DELIVERY.getWarehouseScreen()
                )
        );
        button.width(360);
        button.background(new Color(255, 255, 255, 255));
        button.border(1, new Color(148, 163, 170, 200));
        button.setContent(text);
        button.setClickAction(action);
        container.getItems().add(button);

        button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("courierReturnButton");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COURIER_RETURN.getWarehouseScreen()
                )
        );
        button.width(360);
        button.background(new Color(209, 209, 209, 255));
        button.border(1, new Color(148, 163, 170, 200));
        button.setContent(text);
        button.setClickAction(action);
        container.getItems().add(button);

        button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderDisbandmentButton");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_ORDER_DISBANDMENT.getWarehouseScreen()
                )
        );
        button.width(360);
        button.background(new Color(255, 255, 255, 255));
        button.border(1, new Color(148, 163, 170, 200));
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
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_INFORMATION_ABOUT_ORDER_MENU_ORDER.getWarehouseScreen()
                )
        );
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        this.setHeader(header);
    }
}
