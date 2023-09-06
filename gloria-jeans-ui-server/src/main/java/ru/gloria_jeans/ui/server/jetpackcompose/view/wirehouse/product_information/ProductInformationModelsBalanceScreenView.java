package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.product_information;

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

public class ProductInformationModelsBalanceScreenView extends Screen {
    @JsonIgnore
    Container expandedContainer;
    @JsonIgnore
    Container horizontalContainer;


    public ProductInformationModelsBalanceScreenView (){
        Container mainContainer = new Container();
        mainContainer.setDirection(Direction.VERTICAL);
        mainContainer.setHasScroll(true);
        mainContainer.fillMaxSize()
                .background(255, 255, 255, 255);

        expandedContainer = new Container();
        expandedContainer.setDirection(Direction.VERTICAL);
        expandedContainer.fillMaxSize();
        expandedContainer.setHasScroll(false);
        mainContainer.getItems().add(expandedContainer);
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
            tableContainer.fillMaxSize();
            tableContainer.width(370);
            tableContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));

            horizontalContainer = new Container();
            horizontalContainer.setHasScroll(false);
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.paddingHorizontal(6);

            Container backspace = new Container();
            backspace.paddingVertical(3);

            tableContainer.getItems().add(backspace);

            //Название
            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(0).getText());
            text.setContent(bindingProperty);
            text.paddingHorizontal(4);
            text.setFontSize(13);
            text.setFontWeight(FontWeight.W500);
            text.setTextAlign(TextAlign.Left);
            horizontalContainer.getItems().add(text);

            tableContainer.getItems().add(horizontalContainer);

            horizontalContainer = new Container();
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.paddingVertical(4);
            Spacer spacer = new Spacer();
            spacer.paddingHorizontal(5);
            horizontalContainer.getItems().add(spacer);

            //Количество текст
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(false);
            bindingProperty.setValue("remainsName");
            text.setContent(bindingProperty);
            text.setFontSize(13);
            text.setColor(new Color(0, 0, 0, 100));
            horizontalContainer.getItems().add(text);


            //Количество
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(1).getText());
            text.setContent(bindingProperty);
            text.setFontSize(13);
            text.setFontWeight(FontWeight.W500);
            horizontalContainer.getItems().add(text);

            spacer = new Spacer();
            spacer.paddingHorizontal(78);
            horizontalContainer.getItems().add(spacer);

            //Цена текст
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(false);
            bindingProperty.setValue("priceName");
            text.setContent(bindingProperty);
            text.setFontSize(13);
            text.setColor(new Color(0, 0, 0, 100));
            horizontalContainer.getItems().add(text);

            //Цена
            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(cellList.get(2).getText());
            text.setContent(bindingProperty);
            text.setFontSize(13);
            text.setFontWeight(FontWeight.W500);

            horizontalContainer.getItems().add(text);
            tableContainer.getItems().add(horizontalContainer);
            expandedContainer.getItems().add(tableContainer);
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
                        WarehouseScreen.CATALOG_PRODUCT_INFORMATION_RESULT.getWarehouseScreen()
                )
        );
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("totalBalanceLabel");
        text.setContent(bindingProperty);
        text.setFontSize(15);
        text.setFontWeight(FontWeight.W500);
        text.setColor(new Color(255, 255, 255, 255));
        header.getContents().add(text);

        this.setHeader(header);
    }
}
