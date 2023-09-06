package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import ru.gloria_jeans.core.v1.orders.enums.Tk;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.FontWeight;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class InternetOrderCourierDeliveryScreenView extends Screen {

    public InternetOrderCourierDeliveryScreenView() {
        Container mainContainer = new Container();
        mainContainer.setHasScroll(true);

        Button button = new Button();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("russianPost");
        bindingProperty.setSelfContained(false);
        Text text = new Text();
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s?tk=%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COURIER_DELIVERY_ORDERS_LIST.getWarehouseScreen(),
                        Tk.RUSSIAN_POST.getName()
                )
        );
        button.width(360).heigth(65);
        button.background(new Color(255, 255, 255, 255));
        button.border(1, new Color(148, 163, 170, 200));
        button.setContent(text);
        button.setClickAction(action);
        mainContainer.getItems().add(button);

        button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("cdek");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s?tk=%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COURIER_DELIVERY_ORDERS_LIST.getWarehouseScreen(),
                        Tk.CDEK.getName()
                )
        );
        button.width(360).heigth(65);
        button.background(new Color(255, 255, 255, 255));
        button.border(1, new Color(148, 163, 170, 200));
        button.setContent(text);
        button.setClickAction(action);
        mainContainer.getItems().add(button);

        button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("pickPoint");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s?tk=%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COURIER_DELIVERY_ORDERS_LIST.getWarehouseScreen(),
                        Tk.PICK_POINT.getName()
                )
        );
        button.width(360).heigth(65);
        button.background(new Color(255, 255, 255, 255));
        button.border(1, new Color(148, 163, 170, 200));
        button.setContent(text);
        button.setClickAction(action);
        mainContainer.getItems().add(button);

        getItems().add(mainContainer);

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
        text.setFontSize(16);
        text.setFontWeight(FontWeight.W500);
        text.setColor(new Color(255, 255, 255, 255));
        header.getContents().add(text);

        this.setHeader(header);
    }
}
