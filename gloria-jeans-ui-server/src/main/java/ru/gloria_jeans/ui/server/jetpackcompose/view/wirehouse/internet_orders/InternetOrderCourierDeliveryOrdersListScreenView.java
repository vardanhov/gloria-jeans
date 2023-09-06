package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.stream.Collectors;

public class InternetOrderCourierDeliveryOrdersListScreenView extends Screen {


    @JsonIgnore
    private Container mainContainer;
    @JsonIgnore
    Container horizontalContainer;

    public InternetOrderCourierDeliveryOrdersListScreenView() {
        mainContainer = new Container();
        mainContainer.setHasScroll(true);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("scanLabel");
        text.setContent(bindingProperty);
        text.paddingHorizontal(40);
        text.setColor(new Color(0, 0, 0, 200));
        text.setFontSize(14);
        text.paddingVertical(10);
        mainContainer.getItems().add(text);

        TextField textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("handleSearch");
        textField.setValue(bindingProperty);
        textField.setSingleLine(true);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("barcodeLabel");
        textField.setLabel(bindingProperty);
        textField.paddingHorizontal(16)
                .heigth(60)
                .width(360)
                .background(new Color(255, 255, 255, 255));

        Action inputAction = new Action();
        inputAction.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COURIER_DELIVERY_ORDERS_LIST.getWarehouseScreen()
                )
        );
        textField.setClickAction(inputAction);

        mainContainer.getItems().add(textField);

        Spacer spacer = new Spacer();
        spacer.paddingVertical(5);
        mainContainer.getItems().add(spacer);

        Button searchButton = new Button();
        searchButton.paddingHorizontal(16)
                .width(360);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("searchButtonText");
        text = new Text();
        text.setContent(bindingProperty);
        searchButton.setContent(text);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COURIER_DELIVERY_ORDERS_LIST.getWarehouseScreen())
        );
        searchButton.setClickAction(action);
        mainContainer.getItems().add(searchButton);

        getItems().add(mainContainer);
    }

    public void setTable(String[][] data) {
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

            horizontalContainer = new Container();
            horizontalContainer.setHasScroll(false);
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.paddingHorizontal(16);
            horizontalContainer.paddingVertical(8);

            Container backspace = new Container();
            backspace.paddingVertical(3);

            tableContainer.getItems().add(backspace);

            setColorStatus(cellList.get(3).getText());

            //Дата
            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
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
            bindingProperty.setValue(cellList.get(4).getText());
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

            mainContainer.getItems().add(tableContainer);
        }
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
                        WarehouseScreen.INTERNET_ORDERS_COURIER_DELIVERY.getWarehouseScreen()
                )
        );
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
                                        "finishIssuanceOrders",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_FINISH_ISSUING_ORDERS.getWarehouseScreen()
                                        )
                                )
                        )
                );
        iconButton.setDropdownMenu(dropdownMenu);
        header.getContents().add(iconButton);


        this.setHeader(header);
    }

    public void setColorStatus(String status) {

        Color color = null;
        String ico = null;

        switch (status) {
            case "Ожидание сканирования":
                color = new Color(255, 160, 0, 255);
                ico = BaseStringImages.IN_WORK;
                break;
            case "Отсканирован":
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
    }

}
