package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;


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
import java.util.Objects;
import java.util.stream.Collectors;

public class SupplySearchResultScreenView extends Screen {
    @JsonIgnore
    private Container mainContainer;
    @JsonIgnore
    Container horizontalContainer;

    public SupplySearchResultScreenView() {
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
                    .paddingVertical(8);
            tableContainer.heigth(166).width(360);
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


            setColorStatus(
                    cellList.get(0).getText(),
                    cellList.get(9).getText()
            );

            //Дата
            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(1).getText());
            text.setContent(bindingProperty);
            text.setColor(new Color(0, 0, 0, 100));
            text.setFontSize(14);

            horizontalContainer.getItems().add(text);

            tableContainer.getItems().add(horizontalContainer);

            //Номер документа
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(2).getText());
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
            bindingProperty.setValue(cellList.get(3).getText());
            text.setContent(bindingProperty);
            text.paddingHorizontal(16)
                    .paddingVertical(6);
            text.setFontSize(12);
            text.setColor(new Color(0, 0, 0, 100));

            tableContainer.getItems().add(text);

            Container lineContainer = new Container();
            lineContainer.paddingHorizontal(16).
                    paddingVertical(6)
                    .width(500)
                    .heigth(1)
                    .background(238, 238, 238, 255);

            tableContainer.getItems().add(lineContainer);

            horizontalContainer = new Container();
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.paddingVertical(4);

            Container verticalContainer = new Container();
            verticalContainer.setDirection(Direction.VERTICAL);

            //Принято коробок
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(4).getText());
            text.paddingHorizontal(16);
            text.setFontSize(12);
            text.setContent(bindingProperty);
            text.setColor(new Color(0, 0, 0, 100));

            verticalContainer.getItems().add(text);

            //Принято коробок количество
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(5).getText());
            text.setContent(bindingProperty);
            text.paddingVertical(2);
            text.setFontSize(13);
            text.setFontWeight(FontWeight.W500);
            text.paddingHorizontal(16);

            verticalContainer.getItems().add(text);

            horizontalContainer.getItems().add(verticalContainer);

            verticalContainer = new Container();

            //Принято штук
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(6).getText());
            text.paddingHorizontal(16);
            text.setFontSize(12);
            text.setContent(bindingProperty);
            text.setColor(new Color(0, 0, 0, 100));

            verticalContainer.getItems().add(text);

            //Принято штук количество
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(7).getText());
            text.setContent(bindingProperty);
            text.paddingVertical(2);
            text.setFontSize(13);
            text.setFontWeight(FontWeight.W500);
            text.paddingHorizontal(16);

            verticalContainer.getItems().add(text);

            horizontalContainer.getItems().add(verticalContainer);

            tableContainer.getItems().add(horizontalContainer);

            action.setActionUri(String.format(
                            "%s/%s?args=%s",
                            UrlHelper.getUrlToCurrentResource(),
                            WarehouseScreen.SUPPLY_VIEW_DOCUMENT.getWarehouseScreen(),
                            cellList.get(8).getText()
                    )
            );
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
                        WarehouseScreen.SUPPLY_SEARCH_DOCUMENT.getWarehouseScreen()
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

    public void setColorStatus(String status, String translateText) {

        Color color = null;
        String ico = null;

        switch (status) {
            case "warehouse.supply.result.search.document.status.new":
                color = new Color(150, 25, 134, 255);
                ico = BaseStringImages.STAR;
                break;
            case "warehouse.supply.result.search.document.status.in_work":
            case "warehouse.supply.result.search.document.status.hold":
                color = new Color(255, 160, 0, 255);
                ico = BaseStringImages.IN_WORK;
                break;
            case "warehouse.supply.result.search.document.status.ready":
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
        bindingProperty.setValue(translateText);
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
