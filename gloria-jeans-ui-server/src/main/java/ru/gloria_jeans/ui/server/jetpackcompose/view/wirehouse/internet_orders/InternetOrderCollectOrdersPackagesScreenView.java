package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import ru.gloria_jeans.core.v1.orders.model.response.OrderPackageItemModel;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Direction;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.FontWeight;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.List;

public class InternetOrderCollectOrdersPackagesScreenView extends Screen {
    public InternetOrderCollectOrdersPackagesScreenView(List<OrderPackageItemModel> packages) {
        Container mainContainer = new Container();
        mainContainer.setHasScroll(false);
        Spacer spacer = new Spacer();
        spacer.paddingVertical(4);
        mainContainer.getItems().add(spacer);

        for (OrderPackageItemModel package1 : packages){
            Container horizontalContainer = new Container();
            horizontalContainer.setHasScroll(false);
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.heigth(150).width(400);
            Button minusButton = new Button();
            minusButton.background(255,255,255,255);
            minusButton.paddingHorizontal(30).paddingVertical(50).width(50).heigth(50);
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setValue("-");
            bindingProperty.setSelfContained(true);
            Text text = new Text();
            text.setContent(bindingProperty);
            text.setFontSize(20);
            minusButton.setContent(text);
            Action action = new Action();
            action.setActionUri(String.format(
                    "%s/%s?args=%s",
                    UrlHelper.getUrlToCurrentResource(),
                    WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_PACKAGES_CHANGE_QUANTITY.getWarehouseScreen(),
                    package1.getButtonName()+"decrement"
            ));
            minusButton.setClickAction(action);
            horizontalContainer.getItems().add(minusButton);


            Container button = new Container();
            button
                    .background(new Color(255, 255, 255, 255))
                    .width(100)
                    .heigth(150);
            text = new Text();
            Image image = new Image();
            image.width(90).heigth(90);
            if(package1.getButtonName().equals("small")){
                text.paddingHorizontal(10);
            }
            else {
                text.paddingHorizontal(20);
            }

            image.setImage(package1.getLogoPic());
            bindingProperty = new BindingProperty();
            bindingProperty.setValue(package1.getButtonName() + "PackageButtonText");
            bindingProperty.setSelfContained(false);
            text.setContent(bindingProperty);
            button.getItems().add(image);
            spacer = new Spacer();
            spacer.paddingHorizontal(5);
            button.getItems().add(spacer);
            button.getItems().add(text);

            action = new Action();
            action.setActionUri(
                    UrlHelper
                            .getUrlToCurrentResource()
                            .concat("/")
                            .concat(WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_PACKAGES.getWarehouseScreen())
            );

            horizontalContainer.getItems().add(button);

            text = new Text();
            text.paddingVertical(60).width(50).heigth(50);
            text.setFontSize(20);
            bindingProperty = new BindingProperty();
            bindingProperty.setValue(package1.getButtonName()+"PackageQuantity");
            text.setContent(bindingProperty);
            horizontalContainer.getItems().add(text);

            Button plusButton = new Button();
            plusButton.background(255,255,255,255);
            plusButton.paddingVertical(50).width(50).heigth(50);
            bindingProperty = new BindingProperty();
            bindingProperty.setValue("+");
            bindingProperty.setSelfContained(true);
            text = new Text();
            text.setContent(bindingProperty);
            text.setFontSize(20);
            plusButton.setContent(text);
            action = new Action();
            action.setActionUri(String.format(
                    "%s/%s?args=%s",
                    UrlHelper.getUrlToCurrentResource(),
                    WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_PACKAGES_CHANGE_QUANTITY.getWarehouseScreen(),
                    package1.getButtonName()+"increment"
            ));
            plusButton.setClickAction(action);
            horizontalContainer.getItems().add(plusButton);
            mainContainer.getItems().add(horizontalContainer);
        }


        Button searchButton = new Button();
        searchButton.paddingHorizontal(16)
                .width(360);
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("confirmButtonText");
        Text text = new Text();
        text.setContent(bindingProperty);
        searchButton.setContent(text);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_CONFIRMATION_DOCUMENT.getWarehouseScreen())
        );
        searchButton.setClickAction(action);
        mainContainer.getItems().add(searchButton);
        getItems().add(mainContainer);
    }

    @Override
    public void initHeader() {
        Header header = new Header();
        IconButton iconButton = new IconButton();
        iconButton.setIcon(Icon.Back);
        Action action = new Action();
        action.setActionUri(String.format(
                "%s/%s",
                UrlHelper.getUrlToCurrentResource(),
                WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen()
        ));
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
