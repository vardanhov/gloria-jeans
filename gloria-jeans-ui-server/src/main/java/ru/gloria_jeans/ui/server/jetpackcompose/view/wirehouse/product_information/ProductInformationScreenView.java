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

public class ProductInformationScreenView extends Screen {
    @JsonIgnore
    Container horizontalContainer;
    @JsonIgnore
    Container expandedContainer;
    @JsonIgnore
    Container mainContainer;

    public ProductInformationScreenView() {
        mainContainer = new Container();
        mainContainer.setHasScroll(true);
        mainContainer.fillMaxSize();
        Container productInfoContainer = new Container();
        productInfoContainer.setDirection(Direction.HORIZONTAL);
        Container priceInfoContainer = new Container();
        Container markdownContainer = new Container();
        Container priceContainer = new Container();
        priceContainer.setDirection(Direction.HORIZONTAL);

        expandedContainer = new Container();
        expandedContainer.setDirection(Direction.VERTICAL);
        expandedContainer.fillMaxSize();
        expandedContainer.setCollapse(true);
        expandedContainer.setHasScroll(false);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("productName");
        text.setFontSize(18);
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        text.width(400).paddingHorizontal(16);
        mainContainer.getItems().add(text);


        Image image = new Image();
        BindingProperty imageProperty = new BindingProperty();
        imageProperty.setSelfContained(false);
        imageProperty.setValue("imageUrl");
        image.setUrl(imageProperty);
        image.width(180).heigth(180)
                .paddingVertical(10)
                .paddingHorizontal(10);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.CATALOG_ENLARGE_PRODUCT_IMAGE.getWarehouseScreen()
                )
        );
        image.setClickAction(action);
        productInfoContainer.getItems().add(image);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("markdown");
        text.setContent(bindingProperty);
        text
                .paddingHorizontal(20)
                .paddingVertical(10);
        markdownContainer.width(250).heigth(40);
        markdownContainer.background(new Color(255, 255, 255, 255));
        markdownContainer.getItems().add(text);
        priceInfoContainer.getItems().add(markdownContainer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("priceLabel");
        text.paddingVertical(5);
        text.setContent(bindingProperty);
        priceContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("price");
        text.setFontSize(18);
        text.setFontWeight(FontWeight.Bold);
        text.paddingHorizontal(5);
        text.setContent(bindingProperty);
        priceContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("date");
        text.paddingVertical(5).paddingHorizontal(10);
        text.setContent(bindingProperty);
        priceContainer.paddingVertical(5);

        priceContainer.getItems().add(text);
        priceInfoContainer.paddingVertical(10);
        priceInfoContainer.getItems().add(priceContainer);
        productInfoContainer.getItems().add(priceInfoContainer);
        mainContainer.getItems().add(productInfoContainer);

        Container balanceContainer = new Container();
        balanceContainer.setDirection(Direction.HORIZONTAL);
        balanceContainer.heigth(70).width(400);

        Container balance = new Container();
        balance.heigth(65).width(100);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("balanceLabel");
        text.setFontSize(14);
        text.paddingVertical(5).paddingHorizontal(20);
        text.setContent(bindingProperty);
        balance.getItems().add(text);

        Spacer spacer = new Spacer();
        spacer.paddingVertical(8);
        balance.getItems().add(spacer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("balance");
        text.setFontSize(18);
        text.setFontWeight(FontWeight.Bold);
        text.paddingHorizontal(35);
        text.setContent(bindingProperty);
        balance.getItems().add(text);
        balanceContainer.getItems().add(balance);

        Container remains = new Container();

        remains.heigth(65).width(100);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.CATALOG_PRODUCT_GET_MODELS_BALANCE.getWarehouseScreen()
                )
        );
        remains.setClickAction(action);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("totalBalanceLabel");
        text.setFontSize(14);
        text.paddingVertical(5);
        text.setContent(bindingProperty);
        remains.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("totalBalance");
        text.setFontSize(18);
        text.setFontWeight(FontWeight.Bold);
        text.paddingHorizontal(35);
        text.setContent(bindingProperty);
        remains.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("");
        text.setFontSize(18);
        text.setFontWeight(FontWeight.Bold);
        text.paddingHorizontal(35);
        text.setContent(bindingProperty);
        remains.getItems().add(text);
        balanceContainer.getItems().add(remains);

        Container otherShopsBalanceContainer = new Container();

        otherShopsBalanceContainer.heigth(65).width(100);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.CATALOG_PRODUCT_CITY_BALANCE.getWarehouseScreen()
                )
        );
        otherShopsBalanceContainer.setClickAction(action);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("cityBalance");
        text.setFontSize(14);
        text.paddingVertical(5);
        text.setContent(bindingProperty);
        otherShopsBalanceContainer.getItems().add(text);
        balanceContainer.getItems().add(otherShopsBalanceContainer);

        mainContainer.getItems().add(balanceContainer);
        mainContainer.getItems().add(expandedContainer);
        getItems().add(mainContainer);
    }

    public void setTable(String[][] data, String collapseTextButton, String price) {

        expandedContainer.setCollapseButtonText(collapseTextButton);
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

            if (!price.equals(cellList.get(2).getText())) {
                text.setColor(new Color(239, 62, 66, 255));
                expandedContainer.setCollapseButtonColor(new Color(239, 62, 66, 255));
            }

            horizontalContainer.getItems().add(text);
            tableContainer.getItems().add(horizontalContainer);
            expandedContainer.getItems().add(tableContainer);
        }
    }

    public void setMark(Boolean isMark, Boolean isValid, String markNumber, String markStatus) {

        if (isMark) {
            Spacer spacer = new Spacer();
            spacer.paddingVertical(2);

            Container marks = new Container();
            Image image = new Image();
            marks.setDirection(Direction.HORIZONTAL);
            marks.paddingHorizontal(26);
            if (!isValid) {
                image.setImage(BaseStringImages.BOX_SCREEN_RED_MARK);
            } else {
                image.setImage(BaseStringImages.BOX_SCREEN_GREEN_MARK);
            }
            image.size(16);
            marks.getItems().add(image);

            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(markNumber);
            text.setContent(bindingProperty);
            text.paddingHorizontal(20);
            marks.getItems().add(text);

            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(markStatus);
            text.setContent(bindingProperty);
            text.paddingHorizontal(10);
            marks.getItems().add(text);

            mainContainer.getItems().add(1, spacer);
            mainContainer.getItems().add(2, marks);
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
                        WarehouseScreen.CATALOG_SEARCH_PRODUCT.getWarehouseScreen()
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
}
