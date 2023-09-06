package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Direction;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class SupplyScanMarksScreenView extends Screen {

    public SupplyScanMarksScreenView() {
        Container mainContainer = new Container();
        mainContainer.setDirection(Direction.VERTICAL);
        mainContainer.setHasScroll(true);
        Container headTextContainer = new Container();
        Container scanContainer = new Container();
        Container buttonContainer = new Container();
        buttonContainer.setDirection(Direction.HORIZONTAL);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("Отсканируйте или введите марку");
        bindingProperty.setSelfContained(true);
        text.setContent(bindingProperty);
        text.paddingHorizontal(60);
        headTextContainer.getItems().add(text);
        mainContainer.getItems().add(headTextContainer);

        TextField textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("barcode");
        textField.setValue(bindingProperty);
        textField.heigth(60).width(370);
        textField.paddingHorizontal(50);
        scanContainer.getItems().add(textField);
        mainContainer.getItems().add(scanContainer);

        Button button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("Принять");
        bindingProperty.setSelfContained(true);
        text = new Text();
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen()
                )
        );
        button.paddingHorizontal(36).paddingVertical(100);
        button.setContent(text);
        button.setClickAction(action);
        buttonContainer.getItems().add(button);

        button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("Отмена");
        bindingProperty.setSelfContained(true);
        text = new Text();
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen()
                )
        );
        button.paddingHorizontal(36).paddingVertical(100);
        button.setContent(text);
        button.setClickAction(action);
        buttonContainer.getItems().add(button);
        mainContainer.getItems().add(buttonContainer);
        getItems().add(mainContainer);
    }
}
