package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Modifier;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.List;


public class InternetOrderInformationAboutOrderScreenView extends Screen {
    @JsonIgnore
    private Container body;
    @JsonIgnore
    private Container documentContainer;

    public InternetOrderInformationAboutOrderScreenView() {

        Container headerContainer = new Container();
        headerContainer.paddingHorizontal(16);
        headerContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 2)));

        Container backspaceTop = new Container();
        backspaceTop.paddingVertical(12);
        getItems().add(backspaceTop);

        headerContainer.setHasScroll(false);
        headerContainer.setDirection(Direction.VERTICAL);
        documentContainer = new Container();
        documentContainer.setHasScroll(false);
        documentContainer.setDirection(Direction.HORIZONTAL);
        Container senderContainer = new Container();
        senderContainer.setHasScroll(false);
        senderContainer.setDirection(Direction.HORIZONTAL);

        backspaceTop = new Container();
        backspaceTop.paddingVertical(6);
        headerContainer.getItems().add(backspaceTop);

        Container backspace = new Container();
        backspace.paddingHorizontal(8);
        documentContainer.getItems().add(backspace);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderDate");
        text.setContent(bindingProperty);
        text.paddingHorizontal(16);
        text.setColor(new Color(0, 0, 0, 100));
        text.setFontSize(14);
        documentContainer.getItems().add(text);
        documentContainer
                .heigth(25).width(360)
                .background(new Color(255, 255, 255, 0));

        headerContainer.getItems().add(documentContainer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderNumber");
        text.setContent(bindingProperty);
        text.paddingHorizontal(16)
                .paddingVertical(3);
        text.setFontSize(19);
        text.setFontWeight(FontWeight.W500);
        headerContainer.getItems().add(text);

        Spacer spacer = new Spacer();
        spacer.paddingHorizontal(6);
        senderContainer.getItems().add(spacer);

        //Отправитель
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("senderLabel");
        text.setContent(bindingProperty);
        text.paddingHorizontal(5)
                .paddingVertical(6);
        text.setFontSize(12);
        text.setColor(new Color(0, 0, 0, 100));
        senderContainer.getItems().add(text);

        //Название отправителя
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("sender");
        text.setContent(bindingProperty);
        text.paddingVertical(6);
        text.setFontSize(12);
        text.setFontWeight(FontWeight.W500);
        text.setTextAlign(TextAlign.Left);
        text.width(220);
        senderContainer.getItems().add(text);
        senderContainer
                .width(330)
                .background(new Color(255, 255, 255, 0));
        headerContainer.getItems().add(senderContainer);

        senderContainer = new Container();
        senderContainer.setHasScroll(false);
        senderContainer.setDirection(Direction.HORIZONTAL);
        senderContainer.heigth(32);

        backspace = new Container();
        backspace.paddingHorizontal(6);
        senderContainer.getItems().add(backspace);

        //ФИО
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("fullNameLabel");
        text.setContent(bindingProperty);
        text.paddingHorizontal(5)
                .paddingVertical(6);
        text.setFontSize(12);
        text.setColor(new Color(0, 0, 0, 100));
        senderContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("fullName");
        text.setContent(bindingProperty);
        text.paddingVertical(6);
        text.setFontSize(12);
        text.setFontWeight(FontWeight.W500);
        senderContainer.getItems().add(text);
        headerContainer.getItems().add(senderContainer);

        Container horizontalContainer = new Container();
        horizontalContainer.setDirection(Direction.HORIZONTAL);
        Container verticalContainer = new Container();
        verticalContainer.setDirection(Direction.VERTICAL);
        horizontalContainer.getItems().add(verticalContainer);
        headerContainer.getItems().add(horizontalContainer);

        getItems().add(headerContainer);
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
                        WarehouseScreen.INTERNET_ORDERS_ORDER_INFORMATION.getWarehouseScreen()
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
        DropdownMenu dropdownMenu = new DropdownMenu();
        Modifier modifier = new Modifier();
        modifier.setWidth(235);
        dropdownMenu.getModifiers()
                .add(modifier);
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "courierDeliveryButton",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_INFORMATION_ABOUT_ORDER.getWarehouseScreen()
                                        )
                                ),
                                false
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "courierReturnButton",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_INFORMATION_ABOUT_ORDER.getWarehouseScreen()
                                        )
                                ),
                                false
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "orderDisbandmentButton",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_INFORMATION_ABOUT_ORDER.getWarehouseScreen()
                                        )
                                ),
                                false
                        )
                );
        iconButton.setDropdownMenu(dropdownMenu);
        header.getContents().add(iconButton);
        this.setHeader(header);
    }

    public void setBody(List<Composable> blocks) {
        body = new Container();
        body.setHasScroll(true);
        body.setDirection(Direction.VERTICAL);
        body.fillMaxSize();
        for (Composable block : blocks) {
            body.getItems().add(block);
        }
        getItems().add(body);
    }

    public void setColorStatus(String status) {

        Color color = null;
        String ico = null;
        //TODO временно убрал по согласованию с Настей
//        switch (status) {
//            case "Активный":
//                color = new Color(150, 25, 134, 255);
//                ico = BaseStringImages.STAR;
//                break;
//            case "Не активный":
//                color = new Color(255, 160, 0, 255);
//                ico = BaseStringImages.IN_WORK;
//                break;
//            case "Подтвержден":
//                color = new Color(102, 180, 107, 255);
//                ico = BaseStringImages.APPROVE;
//                break;
//        }

        Image scanCodeImage = new Image();
        scanCodeImage.paddingHorizontal(7).paddingVertical(3);
        scanCodeImage.width(16).heigth(16);
        scanCodeImage.setImage(ico);

        documentContainer.getItems().add(1, scanCodeImage);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderStatus");
        text.width(184);
        text.setTextAlign(TextAlign.Left);
        text.setContent(bindingProperty);
        text.setColor(color);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);

        documentContainer.getItems().add(2, text);
    }
}
