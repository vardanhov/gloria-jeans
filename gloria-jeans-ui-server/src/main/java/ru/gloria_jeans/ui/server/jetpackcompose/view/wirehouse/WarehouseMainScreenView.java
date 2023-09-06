package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class WarehouseMainScreenView extends Screen {
    public WarehouseMainScreenView() {
        Container firstLineContainer = new Container();
        firstLineContainer.setDirection(Direction.HORIZONTAL);
        Spacer spacerHorizontal = new Spacer();
        spacerHorizontal.width(15);
        Spacer spacerVertical = new Spacer();
        spacerVertical.heigth(15);
        Spacer spacerBlockMenu = new Spacer();
        spacerBlockMenu.heigth(8);

        firstLineContainer.getItems().add(spacerHorizontal);
        //Поставка
        Container menuContainer = new Container();
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(158)
                .heigth(100);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(3, new Color(255, 255, 255, 255));

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("supplyButtonLabel");
        bindingProperty.setSelfContained(false);
        Image image = new Image();
        image.setImage(BaseStringImages.SUPPLY);
        image.paddingHorizontal(12)
                .paddingVertical(12);
        menuContainer.getItems().add(image);
        menuContainer.getItems().add(spacerBlockMenu);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Left);
        text.paddingHorizontal(14);
        menuContainer.getItems().add(text);
        Action action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.SUPPLY_SEARCH_BOX.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);

        firstLineContainer.getItems().add(menuContainer);
        firstLineContainer.getItems().add(spacerHorizontal);
        //Вывоз
        menuContainer = new Container();
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(158)
                .heigth(100);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(3, new Color(255, 255, 255, 255));

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("exportButtonLabel");
        bindingProperty.setSelfContained(false);
        image = new Image();
        image.setImage(BaseStringImages.EXPORT);
        image.paddingHorizontal(12)
                .paddingVertical(12);
        menuContainer.getItems().add(image);
        menuContainer.getItems().add(spacerBlockMenu);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Left);
        text.paddingHorizontal(14);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.EXPORT.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);

        firstLineContainer.getItems().add(menuContainer);

        Container secondLineContainer = new Container();
        secondLineContainer.setDirection(Direction.HORIZONTAL);
        secondLineContainer.fillMaxWidth();
        secondLineContainer.getItems().add(spacerHorizontal);
        //Информация о товаре
        menuContainer = new Container();
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(158)
                .heigth(100);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(3, new Color(255, 255, 255, 255));

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("itemInformationButtonLabel");
        bindingProperty.setSelfContained(false);
        image = new Image();
        image.setImage(BaseStringImages.SEARCH_BY_POSITION);
        image.paddingHorizontal(12)
                .paddingVertical(12);
        menuContainer.getItems().add(image);
        Spacer spacer = new Spacer();
        spacer.paddingVertical(4);
        menuContainer.getItems().add(spacer);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(120);
        text.setTextAlign(TextAlign.Left);
        text.paddingHorizontal(14);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.CATALOG_SEARCH_PRODUCT.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);

        secondLineContainer.getItems().add(menuContainer);
        secondLineContainer.getItems().add(spacerHorizontal);

        //Инвентаризация
        menuContainer = new Container();
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(158)
                .heigth(100);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(3, new Color(255, 255, 255, 255));

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("inventoryButtonLabel");
        bindingProperty.setSelfContained(false);
        image = new Image();
        image.setImage(BaseStringImages.INVENTORY);
        image.paddingHorizontal(12)
                .paddingVertical(12);
        menuContainer.getItems().add(image);
        menuContainer.getItems().add(spacerBlockMenu);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Left);
        text.paddingHorizontal(14);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.EXPORT.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);
        secondLineContainer.getItems().add(menuContainer);

        Container thirdLineContainer = new Container();
        thirdLineContainer.setDirection(Direction.HORIZONTAL);
        thirdLineContainer.fillMaxWidth();
        thirdLineContainer.getItems().add(spacerHorizontal);
        //Интернет заказ
        menuContainer = new Container();
        menuContainer.background(new Color(255, 255, 255, 255))
                .width(158)
                .heigth(100);
        menuContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));
        menuContainer.setHasScroll(false);
        menuContainer.setDirection(Direction.VERTICAL);
        menuContainer.border(3, new Color(255, 255, 255, 255));

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("internetOrderButtonLabel");
        bindingProperty.setSelfContained(false);
        image = new Image();
        image.setImage(BaseStringImages.INVENTORY);
        image.paddingHorizontal(12)
                .paddingVertical(12);
        menuContainer.getItems().add(image);
        menuContainer.getItems().add(spacerBlockMenu);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Left);
        text.paddingHorizontal(14);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.INTERNET_ORDERS.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);
        thirdLineContainer.getItems().add(menuContainer);

        Container mainContainer = new Container();
        mainContainer
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeigth();
        mainContainer.getItems().add(spacerVertical);
        mainContainer.getItems().add(firstLineContainer);
        mainContainer.getItems().add(spacerVertical);
        mainContainer.getItems().add(secondLineContainer);
        mainContainer.getItems().add(spacerVertical);
        mainContainer.getItems().add(thirdLineContainer);
        this.getItems().add(mainContainer);
    }

    @Override
    public void initHeader() {
        Header header = new Header();
        IconButton iconButton = new IconButton();
        iconButton.setIcon(Icon.Burger);
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
