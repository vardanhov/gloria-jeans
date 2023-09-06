package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;


public class InternetOrderCheckUserCollectorPopupScreenView extends Screen {

    @JsonIgnore
    private Container mainContainer;

    @JsonIgnore
    private String userId;

    public InternetOrderCheckUserCollectorPopupScreenView(String userId) {
        this.userId = userId;

        mainContainer = new Container();
        mainContainer.fillMaxSize();
        mainContainer.background(new Color(139, 139, 139, 255));
        Container windowContainer = new Container();
        windowContainer.paddingHorizontal(40).paddingVertical(142);
        windowContainer.shadow(new Shadow(14, new Shape(ClipShape.RoundedCornerShape, 2)));
        windowContainer.background(new Color(255, 255, 255, 255));
        windowContainer.heigth(150);

        Container buttonContainer = new Container();
        buttonContainer.setHasScroll(false);
        buttonContainer.setDirection(Direction.HORIZONTAL);

        Spacer spacer = new Spacer();
        spacer.paddingVertical(0);
        windowContainer.getItems().add(spacer);

//        Image scanCodeImage = new Image();
//        scanCodeImage.paddingHorizontal(125);
//        scanCodeImage.width(24).heigth(24);
//        scanCodeImage.setImage(BaseStringImages.DISCREPTANSY_POPUP_PIC);
//        windowContainer.getItems().add(scanCodeImage);

        spacer = new Spacer();
        spacer.paddingVertical(7);
        windowContainer.getItems().add(spacer);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("titleText");
        bindingProperty.setSelfContained(false);
        text.setFontSize(15);
        text.paddingHorizontal(24);
        text.setContent(bindingProperty);
        windowContainer.getItems().add(text);

        spacer = new Spacer();
        spacer.paddingVertical(8);
        windowContainer.getItems().add(spacer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("bodyText");
        bindingProperty.setSelfContained(false);
        text.setFontSize(13);
        text.paddingHorizontal(46);
        text.setContent(bindingProperty);
        text.setFontWeight(FontWeight.W500);
        text.setColor(new Color(0, 0, 0, 100));
        windowContainer.getItems().add(text);

        spacer = new Spacer();
        spacer.paddingVertical(16);
        windowContainer.getItems().add(spacer);

        spacer = new Spacer();
        spacer.paddingHorizontal(50);
        buttonContainer.getItems().add(spacer);

        bindingProperty = new BindingProperty();
        bindingProperty.setValue("continueButtonText");
        text = new Text();
        text.setColor(new Color(255, 0, 0, 255));
        text.width(120);
        text.setFontSize(13);
        text.setFontWeight(FontWeight.W500);
        text.setContent(bindingProperty);
        text.paddingHorizontal(10);
        Action action = new Action();
        action.setActionUri(
                String.format("%s/%s?userId=%s&updateUserId=%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen(),
                        userId,
                        true
                )
        );
        text.setClickAction(action);
        buttonContainer.getItems().add(text);

        bindingProperty = new BindingProperty();
        bindingProperty.setValue("exitButtonText");
        text = new Text();
        text.setColor(new Color(0, 0, 0, 100));
        text.width(50);
        text.setFontSize(13);
        text.setFontWeight(FontWeight.W500);
        text.setContent(bindingProperty);
        text.paddingHorizontal(10);
        action = new Action();
        action.setActionUri(
                String.format("%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS.getWarehouseScreen()
                )
        );
        text.setClickAction(action);
        buttonContainer.getItems().add(text);

        windowContainer.getItems().add(buttonContainer);
        mainContainer.getItems().add(windowContainer);
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
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS.getWarehouseScreen()
                )
        );
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

        this.setHeader(header);
    }
}
