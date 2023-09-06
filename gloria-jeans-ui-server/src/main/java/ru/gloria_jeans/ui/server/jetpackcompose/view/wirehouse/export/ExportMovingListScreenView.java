package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.export;

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

public class ExportMovingListScreenView extends Screen {
    @JsonIgnore
    private Container mainContainer;
    @JsonIgnore
    Container horizontalContainer;

    public ExportMovingListScreenView() {
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
        bindingProperty.setValue("movingListCountLabel");
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


        backspace = new Container();
        backspace.paddingVertical(20);

        mainContainer.getItems().add(backspace);

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
            tableContainer.heigth(135).width(360);
            tableContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));
            Action action = new Action();

            horizontalContainer = new Container();
            horizontalContainer.setHasScroll(false);
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.paddingHorizontal(7)
                    .paddingVertical(3);


            Container backspace = new Container();
            backspace.paddingVertical(3);
            tableContainer.getItems().add(backspace);

            setDocumentStatus(cellList.get(0).getText());

            //Называние документа
            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(1).getText());
            text.width(208);
            text.paddingHorizontal(7)
                    .paddingVertical(3);
            text.setTextAlign(TextAlign.Left);
            text.setContent(bindingProperty);
            text.setFontSize(12);
            text.setFontWeight(FontWeight.Bold);
            text.setColor(new Color(182, 182, 182, 255));
            text.setFontWeight(FontWeight.W500);
            horizontalContainer.getItems().add(text);

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

            horizontalContainer = new Container();
            horizontalContainer.setHasScroll(false);
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.paddingHorizontal(6);

            //Номер документа
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(3).getText());
            text.setContent(bindingProperty);
            text.paddingHorizontal(7);
            text.setFontSize(19);
            text.setFontWeight(FontWeight.W500);
            horizontalContainer.getItems().add(text);

            //от
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue("от");
            text.setContent(bindingProperty);
            text.setFontSize(19);
            text.setFontWeight(FontWeight.W500);
            horizontalContainer.getItems().add(text);

            //дата документа
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(4).getText());
            text.setContent(bindingProperty);
            text.paddingHorizontal(7);
            text.setFontSize(19);
            text.setFontWeight(FontWeight.W500);
            horizontalContainer.getItems().add(text);
            tableContainer.getItems().add(horizontalContainer);

            //Назначение
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(5).getText());
            text.setContent(bindingProperty);
            text.paddingHorizontal(13)
                    .paddingVertical(2);
            text.setFontSize(11);
            text.setColor(new Color(0, 0, 0, 100));
            tableContainer.getItems().add(text);

            //Склад получатель
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(6).getText());
            text.setContent(bindingProperty);
            text.paddingHorizontal(13)
                    .paddingVertical(2);
            text.setFontSize(11);
            text.setColor(new Color(0, 0, 0, 100));
            tableContainer.getItems().add(text);

            //Основание
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(7).getText());
            text.setContent(bindingProperty);
            text.paddingHorizontal(13)
                    .paddingVertical(2);
            text.setFontSize(11);
            text.setColor(new Color(0, 0, 0, 100));
            tableContainer.getItems().add(text);
            action.setActionUri(String.format(
                            "%s/%s",
                            UrlHelper.getUrlToCurrentResource(),
                            WarehouseScreen.EXPORT_MOVING_LIST.getWarehouseScreen()
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
                        WarehouseScreen.EXPORT.getWarehouseScreen()
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

        this.setHeader(header);
    }

    public void setDocumentStatus(String status) {
        Spacer spacer = new Spacer();
        spacer.width(6);
        horizontalContainer.getItems().add(spacer);

        String icon = null;

        switch (status) {
            case "В работе":
                icon = BaseStringImages.IN_WORK_BLACK;
                break;
            case "Загружен":
                icon = BaseStringImages.LOADED;
                break;
            case "Проведён":
                icon = BaseStringImages.CONDUCTED;
                break;
        }

        Image image = new Image();
        image.width(23).heigth(23);
        image.setImage(icon);
        horizontalContainer.getItems().add(image);
    }
}

