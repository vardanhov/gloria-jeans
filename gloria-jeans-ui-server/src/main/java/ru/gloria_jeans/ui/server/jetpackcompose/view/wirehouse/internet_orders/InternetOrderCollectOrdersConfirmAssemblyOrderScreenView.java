package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Direction;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;


public class InternetOrderCollectOrdersConfirmAssemblyOrderScreenView extends Screen {

    public InternetOrderCollectOrdersConfirmAssemblyOrderScreenView() {
        Container mainContainer = new Container();
        mainContainer.setHasScroll(true);
        Container imageContainer = new Container();
        imageContainer.setHasScroll(true);
        Container nomenclatureContainer = new Container();
        nomenclatureContainer.setDirection(Direction.HORIZONTAL);
        Container buttonContainer = new Container();
        buttonContainer.setDirection(Direction.HORIZONTAL);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("nomenclatureLabel");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        nomenclatureContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("nomenclature");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        nomenclatureContainer.getItems().add(text);
        mainContainer.getItems().add(nomenclatureContainer);

        imageContainer.heigth(160);
        mainContainer.getItems().add(imageContainer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("reasonForAbsenceLabel");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        text.setFontSize(14);
        text.paddingHorizontal(70);
        mainContainer.getItems().add(text);


        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("reasonForAbsence");
        bindingProperty.setSelfContained(false);
        text.setContent(bindingProperty);
        Spinner spinner = new Spinner();
        spinner.setContent(text);
        spinner.paddingHorizontal(60);
        mainContainer.getItems().add(spinner);

        Button button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("confirmButton");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_PACKAGES.getWarehouseScreen()
                )
        );
        button.paddingHorizontal(30);
        button.background(new Color(50, 205, 50, 255));
        button.setContent(text);
        button.setClickAction(action);
        buttonContainer.getItems().add(button);

        button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("cancelButton");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONFIRM_ASSEMBLY_ORDER.getWarehouseScreen()
                )
        );
        button.paddingHorizontal(30);
        button.background(new Color(255, 0, 0, 255));
        button.setContent(text);
        button.setClickAction(action);
        buttonContainer.paddingVertical(50);
        buttonContainer.getItems().add(button);
        mainContainer.getItems().add(buttonContainer);
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
