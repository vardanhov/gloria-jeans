package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;


import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Modifier;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.model.table.Cell;
import ru.gloria_jeans.ui.server.model.table.Row;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InternetOrderCourierReturnScreenView extends Screen {
    public InternetOrderCourierReturnScreenView() {
        Container container = new Container();
        container.setHasScroll(true);
        container.fillMaxSize();

        Container emptyContainer = new Container();
        emptyContainer.setHasScroll(false);
        emptyContainer.heigth(24);
        container.getItems().add(emptyContainer);

        Container barCodeContainer = new Container();
        barCodeContainer.setHasScroll(false);
        barCodeContainer.setDirection(Direction.HORIZONTAL);
        barCodeContainer.heigth(45).width(328);
        barCodeContainer.paddingHorizontal(16);
        Image scanCodeImage = new Image();
        scanCodeImage.fillMaxHeigth();
        scanCodeImage.paddingHorizontal(5);
        scanCodeImage.width(32).heigth(32);
        scanCodeImage.setImage(BaseStringImages.SCAN_CODE_LOGO);
        barCodeContainer.getItems().add(scanCodeImage);

        Container barCodeLabelContainer = new Container();
        barCodeLabelContainer.setHasScroll(false);
        barCodeLabelContainer.paddingHorizontal(10);
        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("label");
        bindingProperty.setSelfContained(false);
        text.setFontSize(20);
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        barCodeLabelContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("labelUnderLabel");
        bindingProperty.setSelfContained(false);
        text.setFontSize(14);
        text.setContent(bindingProperty);
        barCodeLabelContainer.getItems().add(text);
        barCodeContainer.getItems().add(barCodeLabelContainer);
        container.getItems().add(barCodeContainer);

        emptyContainer = new Container();
        emptyContainer.setHasScroll(false);
        emptyContainer.heigth(33);
        container.getItems().add(emptyContainer);

        bindingProperty = new BindingProperty();
        bindingProperty.setValue("handleSearch");
        bindingProperty.setSelfContained(false);
        TextField textField = new TextField();
        textField.setValue(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("barcodeLabel");
        bindingProperty.setSelfContained(false);
        textField.setLabel(bindingProperty);
        textField.setSingleLine(true);
        textField.heigth(65).width(359);
        textField.paddingHorizontal(16);
        container.getItems().add(textField);

        Button button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("searchButtonText");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setFontSize(14);
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COURIER_RETURN.getWarehouseScreen()
                )
        );
        button.paddingVertical(23).paddingHorizontal(16);
        button.setContent(text);
        button.setClickAction(action);
        button.width(327).heigth(36);
        container.getItems().add(button);
        getItems().add(container);
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
                                        "internetOrderMenuReturnComplete",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_RETURN_COMPLETE.getWarehouseScreen()
                                        )
                                )
                        )
                );
        iconButton.setDropdownMenu(dropdownMenu);
        header.getContents().add(iconButton);
        this.setHeader(header);
    }

    public void setBody(String[][] data) {
        List<Row> rows = Arrays.stream(data)
                .map(row -> new Row((Arrays.stream(row)
                        .map(c -> new Cell(c,
                                new Color(255, 255, 255, 255),
                                new Color(0, 0, 0, 255),
                                50,
                                Arrays.asList(row).indexOf(c) == 0 ? 200 : 80)
                        )
                        .collect(Collectors.toList()))))
                .collect(Collectors.toList());

        for (Row row : rows) {
            List<Cell> cellList = row.getCells();
            Container tableContainer = new Container();
            tableContainer.setDirection(Direction.VERTICAL);
            tableContainer.paddingHorizontal(16)
                    .paddingVertical(6);
            tableContainer.heigth(110).width(360);
            tableContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));
            Action action = new Action();

            Container horizontalContainer = new Container();
            horizontalContainer.setHasScroll(false);
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.paddingHorizontal(16);
            horizontalContainer.paddingVertical(8);

            Container backspace = new Container();
            backspace.paddingVertical(3);

            tableContainer.getItems().add(backspace);

            Color color = null;
            String ico = null;
            String status = row.getCells().get(3).getText();
            status = Objects.isNull(status) ? "Подтвержден" : status;
            switch (status) {
                case "Ожидает сборки":
                    color = new Color(150, 25, 134, 255);
                    ico = BaseStringImages.STAR;
                    break;
                case "В работе":
                case "В процессе сборки":
                    color = new Color(255, 160, 0, 255);
                    ico = BaseStringImages.IN_WORK;
                    break;
                case "Подтвержден":
                    color = new Color(102, 180, 107, 255);
                    ico = BaseStringImages.APPROVE;
                    break;
            }

            Image scanCodeImage = new Image();
            scanCodeImage.paddingVertical(2);
            scanCodeImage.width(16).heigth(16);
            scanCodeImage.setImage(ico);

            horizontalContainer.getItems().add(0, scanCodeImage);

            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(status);
            text.width(208);
            text.paddingHorizontal(8);
            text.setTextAlign(TextAlign.Left);
            text.setContent(bindingProperty);
            text.setColor(color);
            text.setFontSize(14);
            text.setFontWeight(FontWeight.W500);

            horizontalContainer.getItems().add(1, text);

            //Дата
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(2).getText());
            text.setContent(bindingProperty);
            text.setColor(new Color(0, 0, 0, 100));
            text.setFontSize(14);

            horizontalContainer.getItems().add(text);

            tableContainer.getItems().add(horizontalContainer);

            //Номер документа
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(0).getText());
            text.setContent(bindingProperty);
            text.paddingHorizontal(16)
                    .paddingVertical(0);
            text.setFontSize(19);
            text.setFontWeight(FontWeight.W500);

            tableContainer.getItems().add(text);

            //Тип
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue("Пополнение");
            text.setContent(bindingProperty);
            text.paddingHorizontal(16)
                    .paddingVertical(6);
            text.setFontSize(12);
            text.setColor(new Color(0, 0, 0, 100));

            tableContainer.getItems().add(text);

            horizontalContainer = new Container();
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.paddingVertical(2);
            tableContainer.getItems().add(horizontalContainer);

            action.setActionUri(String.format(
                    "%s/%s?args=%s",
                    UrlHelper.getUrlToCurrentResource(),
                    WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen(),
                    cellList.get(0).getText()
            ));
            tableContainer.setClickAction(action);
            this.getItems().add(tableContainer);
        }
    }
}
