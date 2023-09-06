package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.model.table.Cell;
import ru.gloria_jeans.ui.server.model.table.Row;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InternetOrderOrderInformationOrdersListScreenView extends Screen {

    @JsonIgnore
    private Container mainContainer;
    @JsonIgnore
    Container horizontalContainer;

    public InternetOrderOrderInformationOrdersListScreenView() {
        mainContainer = new Container();
        mainContainer.setHasScroll(true);
        getItems().add(mainContainer);
    }

    public void resultCount(Integer count) {

        Container backspace = new Container();
        backspace.paddingVertical(6);

        mainContainer.getItems().add(backspace);

        Container container = new Container();
        container.setDirection(Direction.HORIZONTAL);
        container.paddingHorizontal(16)
                .paddingVertical(8);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("resultCountText");
        text.setContent(bindingProperty);
        text.setFontWeight(FontWeight.W500);
        text.setFontSize(16);
        container.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(true);
        bindingProperty.setValue(count.toString());
        text.setContent(bindingProperty);
        text.setFontWeight(FontWeight.W500);
        text.setFontSize(16);
        text.paddingHorizontal(4);
        container.getItems().add(text);

        mainContainer.getItems().add(container);

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
            Action action = new Action();

            horizontalContainer = new Container();
            horizontalContainer.setHasScroll(false);
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.paddingHorizontal(16);
            horizontalContainer.paddingVertical(8);

            Container backspace = new Container();
            backspace.paddingVertical(3);

            tableContainer.getItems().add(backspace);

            setColorStatus("В работе");

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
                    WarehouseScreen.INTERNET_ORDERS_INFORMATION_ABOUT_ORDER.getWarehouseScreen(),
                    cellList.get(0).getText()
            ));
            tableContainer.setClickAction(action);
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

        this.setHeader(header);
    }

    public void setColorStatus(String status) {

        Color color = null;
        String ico = null;

        switch (status) {
            case "Новый":
                color = new Color(150, 25, 134, 255);
                ico = BaseStringImages.STAR;
                break;
            case "В работе":
            case "Ожидание":
                color = new Color(255, 160, 0, 255);
                ico = BaseStringImages.IN_WORK;
                break;
            case "Проведен":
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

