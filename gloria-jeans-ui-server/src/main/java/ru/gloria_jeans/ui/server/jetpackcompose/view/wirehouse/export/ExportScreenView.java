package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.export;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class ExportScreenView extends Screen {
    public ExportScreenView() {
        Container firstLineContainer = new Container();
        firstLineContainer.setDirection(Direction.HORIZONTAL);
        Spacer spacerHorizontal = new Spacer();
        spacerHorizontal.width(15);
        Spacer spacerVertical = new Spacer();
        spacerVertical.heigth(15);
        Spacer spacerBlockMenu = new Spacer();
        spacerBlockMenu.heigth(8);

        firstLineContainer.getItems().add(spacerHorizontal);
        //Распоряжения на перемещение
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
        bindingProperty.setValue("movementDecree");
        bindingProperty.setSelfContained(false);
        Spacer spacer = new Spacer();
        spacer.paddingVertical(10);
        menuContainer.getItems().add(spacer);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Center);
        text.paddingHorizontal(14);
        menuContainer.getItems().add(text);
        Action action = new Action();
        action.setActionUri(
                UrlHelper.getUrlToCurrentResource());
        menuContainer.setClickAction(action);

        firstLineContainer.getItems().add(menuContainer);
        firstLineContainer.getItems().add(spacerHorizontal);

        //Перемещения
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
        bindingProperty.setValue("movement");
        bindingProperty.setSelfContained(false);
        spacer = new Spacer();
        spacer.paddingVertical(10);
        menuContainer.getItems().add(spacer);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(150);
        text.setTextAlign(TextAlign.Center);
        text.paddingHorizontal(14);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.EXPORT_MOVING_LIST.getWarehouseScreen())
        );
        menuContainer.setClickAction(action);
        firstLineContainer.getItems().add(menuContainer);

        Container secondLineContainer = new Container();
        secondLineContainer.setDirection(Direction.HORIZONTAL);
        secondLineContainer.fillMaxWidth();
        secondLineContainer.getItems().add(spacerHorizontal);

        //Заявки на перемещение
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
        bindingProperty.setValue("movementRequests");
        bindingProperty.setSelfContained(false);
        spacer = new Spacer();
        spacer.paddingVertical(10);
        menuContainer.getItems().add(spacer);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.width(130);
        text.setTextAlign(TextAlign.Center);
        text.paddingHorizontal(14);
        menuContainer.getItems().add(text);
        action = new Action();
        action.setActionUri(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.EXPORT_COLLECT_BOX.getWarehouseScreen()));
        menuContainer.setClickAction(action);

        secondLineContainer.getItems().add(menuContainer);
        secondLineContainer.getItems().add(spacerHorizontal);

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
        this.getItems().add(mainContainer);
    }
}
