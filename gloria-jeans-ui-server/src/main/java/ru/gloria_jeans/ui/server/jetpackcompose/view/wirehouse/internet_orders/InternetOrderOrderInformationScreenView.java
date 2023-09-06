package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.List;

public class InternetOrderOrderInformationScreenView extends Screen {

    @JsonIgnore
    private Container mainContainer;

    public InternetOrderOrderInformationScreenView() {
        mainContainer = new Container();
        mainContainer.setHasScroll(true);
        mainContainer.fillMaxSize();

        Container horizontalContainer = new Container();
        horizontalContainer.setDirection(Direction.HORIZONTAL);

        Container verticalContainer = new Container();
        verticalContainer.setDirection(Direction.HORIZONTAL);

        Image scanCodeImage = new Image();
        scanCodeImage.fillMaxHeigth();
        scanCodeImage.paddingHorizontal(16).paddingVertical(18);
        scanCodeImage.width(32).heigth(32);
        scanCodeImage.setImage(BaseStringImages.SCAN_CODE_LOGO);
        verticalContainer.getItems().add(scanCodeImage);
        horizontalContainer.getItems().add(verticalContainer);

        Container containerNext = new Container();
        containerNext.setDirection(Direction.VERTICAL);

        Container backspace = new Container();
        backspace.paddingVertical(10);
        containerNext.getItems().add(backspace);

        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("label");
        Text textTop = new Text();
        textTop.setFontWeight(FontWeight.W500);
        textTop.setFontSize(20);
        textTop.setContent(bindingProperty);
        containerNext.getItems().add(textTop);

        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("labelUnderLabel");
        Text textBottom = new Text();
        textBottom.setFontSize(14);
        textBottom.setFontWeight(FontWeight.W400);
        textBottom.setColor(new Color(0, 0, 0, 100));
        textBottom.setContent(bindingProperty);
        containerNext.getItems().add(textBottom);
        horizontalContainer.getItems().add(containerNext);
        mainContainer.getItems().add(horizontalContainer);

        TextField textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("documentNumberLabel");
        bindingProperty.setSelfContained(false);
        textField.setLabel(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderBarcode");
        textField.setValue(bindingProperty);
        textField.setSingleLine(true);
        textField.paddingHorizontal(16)
                .paddingVertical(9)
                .heigth(60)
                .width(330);

        Action inputAction = new Action();
        inputAction.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_INFORMATION_ABOUT_ORDER.getWarehouseScreen()
                )
        );
        textField.setClickAction(inputAction);
        textField.setAutoFocus(false);
        mainContainer.getItems().add(textField);

        textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("dateFrom");
        textField.setValue(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("dateFromLabel");
        textField.setLabel(bindingProperty);
        textField.border(1, new Color(238, 238, 238, 255));
        DatePicker datePicker = new DatePicker();
        datePicker.paddingHorizontal(16)
                .heigth(60)
                .width(330);
        datePicker.setTextField(textField);
        mainContainer.getItems().add(datePicker);

        textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("dateTo");
        textField.setValue(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("dateToLabel");
        textField.setLabel(bindingProperty);
        textField.border(1, new Color(238, 238, 238, 255));
        datePicker = new DatePicker();
        datePicker.paddingHorizontal(16)
                .heigth(60)
                .width(330);
        datePicker.setTextField(textField);
        mainContainer.getItems().add(datePicker);

        Button button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("searchButtonText");
        bindingProperty.setSelfContained(false);
        Text text = new Text();
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_INFORMATION_ABOUT_ORDER.getWarehouseScreen()
                )
        );
        button.setContent(text);
        button.setClickAction(action);
        button.paddingHorizontal(16)
                .paddingVertical(9)
                .heigth(40)
                .width(330);
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
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.setColor(new Color(255, 255, 255, 255));
        header.getContents().add(text);

        this.setHeader(header);
    }

    public void setStatusList(List<MultiSelectorItem> orderTypes, List<MultiSelectorItem> orderStatuses) {

        Container backspaceThree = new Container();
        backspaceThree.paddingVertical(2);
        mainContainer.getItems().add(5, backspaceThree);

        // Множественный выбор в выпадающем окне - Тип Заказа
        MultiSelector multiSelector = new MultiSelector();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("selectedOrderTypes");
        multiSelector.setSelectedItems(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderTypeLabel");
        Text text = new Text();
        text.setContent(bindingProperty);
        multiSelector.setLabelName(text);
        multiSelector.setItemsList(orderTypes);
        mainContainer.getItems().add(4, multiSelector);

        // Статус заказа
        multiSelector = new MultiSelector();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("selectedOrderStatus");
        multiSelector.setSelectedItems(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("orderStatusLabel");
        text = new Text();
        text.setContent(bindingProperty);
        multiSelector.setLabelName(text);
        multiSelector.setItemsList(orderStatuses);
        mainContainer.getItems().add(5, multiSelector);
    }
}
