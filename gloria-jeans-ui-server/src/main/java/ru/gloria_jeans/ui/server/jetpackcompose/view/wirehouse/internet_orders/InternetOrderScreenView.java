package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class InternetOrderScreenView extends Screen {
    public InternetOrderScreenView() {
        Container firstLineContainer = new Container();
        firstLineContainer.setDirection(Direction.HORIZONTAL);
        Spacer spacerHorizontal = new Spacer();
        spacerHorizontal.width(15);
        Spacer spacerVertical = new Spacer();
        spacerVertical.heigth(9);

        Container mainContainer = new Container();
        mainContainer
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeigth();

        mainContainer.getItems().add(spacerVertical);

        Container oneLine = new Container();
        oneLine.setDirection(Direction.HORIZONTAL);
        oneLine.getItems().add(spacerHorizontal);

        //Принять С&С

        Container menuContainer = new Container();
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(156)
                .heigth(160);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 2)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(3, new Color(255, 255, 255, 255));

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("acceptLabel");
        bindingProperty.setSelfContained(false);
        Image image = new Image();
        image.setImage(BaseStringImages.ACCEPT_ORDER);
        image.paddingHorizontal(26)
                .paddingVertical(10);
        image.size(100);
        menuContainer.getItems().add(image);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Center);
        menuContainer.getItems().add(text);
        Action action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.INTERNET_ORDERS_ACCEPT_CLICK_COLLECT.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);
        oneLine.getItems().add(menuContainer);

        //Собрать

        menuContainer = new Container();
        menuContainer.paddingHorizontal(16);
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(156)
                .heigth(160);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 2)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(3, new Color(255, 255, 255, 255));

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("collectOrderLabel");
        bindingProperty.setSelfContained(false);
        image = new Image();
        image.setImage(BaseStringImages.COLLECT_ORDER);
        image.paddingHorizontal(26)
                .paddingVertical(10);
        image.size(100);
        menuContainer.getItems().add(image);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Center);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);

        oneLine.getItems().add(menuContainer);
        mainContainer.getItems().add(oneLine);
        mainContainer.getItems().add(spacerVertical);

        Container twoLine = new Container();
        twoLine.setDirection(Direction.HORIZONTAL);
        twoLine.getItems().add(spacerHorizontal);

        //Выдать SFS заказ

        menuContainer = new Container();
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(156)
                .heigth(160);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 2)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(3, new Color(255, 255, 255, 255));

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("passToCourierLabel");
        bindingProperty.setSelfContained(false);
        image = new Image();
        image.setImage(BaseStringImages.ORDER_SFS_PASS);
        image.paddingHorizontal(26)
                .paddingVertical(10);
        image.size(100);
        menuContainer.getItems().add(image);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Center);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.INTERNET_ORDERS_COURIER_DELIVERY.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);

        twoLine.getItems().add(menuContainer);


        //Расформировать заказ

        menuContainer = new Container();
        menuContainer.paddingHorizontal(16);
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(156)
                .heigth(160);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 2)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(3, new Color(255, 255, 255, 255));

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("disbandOrderLabel");
        bindingProperty.setSelfContained(false);
        image = new Image();
        image.setImage(BaseStringImages.DISBAND_ORDER);
        image.paddingHorizontal(26)
                .paddingVertical(10);
        image.size(100);
        menuContainer.getItems().add(image);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Center);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.INTERNET_ORDERS_ORDER_DISBANDMENT.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);

        twoLine.getItems().add(menuContainer);

        mainContainer.getItems().add(twoLine);
        mainContainer.getItems().add(spacerVertical);


        Container threeLine = new Container();
        threeLine.setDirection(Direction.HORIZONTAL);
        threeLine.getItems().add(spacerHorizontal);
        //Возврат от курьера

        menuContainer = new Container();
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(156)
                .heigth(160);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 2)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(4, new Color(255, 255, 255, 255));

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("returnFromCourierLabel");
        bindingProperty.setSelfContained(false);
        image = new Image();
        image.setImage(BaseStringImages.RETURN_ORDER_FROM_CURIER);
        image.paddingHorizontal(26)
                .paddingVertical(10);
        image.size(100);
        menuContainer.getItems().add(image);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Center);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.INTERNET_ORDERS_COURIER_RETURN.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);

        threeLine.getItems().add(menuContainer);
        //Информация по товару
        menuContainer = new Container();
        menuContainer.paddingHorizontal(16);
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(156)
                .heigth(160);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 2)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(4, new Color(255, 255, 255, 255));

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderInformationLabel");
        bindingProperty.setSelfContained(false);
        image = new Image();
        image.setImage(BaseStringImages.ORDER_INFORMATION);
        image.paddingHorizontal(26)
                .paddingVertical(10);
        image.size(100);
        menuContainer.getItems().add(image);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Center);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.INTERNET_ORDERS_ORDER_INFORMATION.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);

        threeLine.getItems().add(menuContainer);

        mainContainer.getItems().add(threeLine);

        this.getItems().add(mainContainer);
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
        this.setHeader(header);
    }
}
