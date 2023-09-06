package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;


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
import java.util.Objects;
import java.util.stream.Collectors;

public class SupplyViewingDocumentScreenView extends Screen {
    @JsonIgnore
    private Container mainContainer;
    @JsonIgnore
    private Container documentContainer;

    public SupplyViewingDocumentScreenView() {

        mainContainer = new Container();
        mainContainer.setHasScroll(true);
        mainContainer.setDirection(Direction.VERTICAL);
        mainContainer.fillMaxSize();

        Container headerContainer = new Container();
        headerContainer.paddingHorizontal(16);
        headerContainer.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));

        Container backspaceTop = new Container();
        backspaceTop.paddingVertical(12);
        mainContainer.getItems().add(backspaceTop);

        headerContainer.setHasScroll(false);
        headerContainer.setDirection(Direction.VERTICAL);
        documentContainer = new Container();
        documentContainer.setHasScroll(false);
        documentContainer.setDirection(Direction.HORIZONTAL);
        Container senderContainer = new Container();
        senderContainer.setHasScroll(false);
        senderContainer.setDirection(Direction.HORIZONTAL);
        Container senderContainer1 = new Container();
        senderContainer1.setHasScroll(false);
        senderContainer1.setDirection(Direction.HORIZONTAL);

        backspaceTop = new Container();
        backspaceTop.paddingVertical(6);

        headerContainer.getItems().add(backspaceTop);

        Container backspace = new Container();
        backspace.paddingHorizontal(4);

        documentContainer.getItems().add(backspace);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("docDate");
        text.setContent(bindingProperty);
        text.paddingHorizontal(16);
        text.setColor(new Color(0, 0, 0, 100));
        text.setFontSize(14);
        documentContainer.getItems().add(text);
        documentContainer
                .heigth(25).width(360)
                .background(new Color(255, 255, 255, 0));

        headerContainer.getItems().add(documentContainer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("documentNumber");
        text.setContent(bindingProperty);
        text.paddingHorizontal(16)
                .paddingVertical(3);
        text.setFontSize(19);
        text.setFontWeight(FontWeight.W500);
        headerContainer.getItems().add(text);

        //Тип
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("type");
        text.setContent(bindingProperty);
        text.paddingHorizontal(16)
                .paddingVertical(6);
        text.setFontSize(12);
        text.setColor(new Color(0, 0, 0, 100));
        headerContainer.getItems().add(text);

        Spacer spacer = new Spacer();
        spacer.paddingHorizontal(6);
        senderContainer.getItems().add(spacer);

        //Отправитель
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("senderText");
        bindingProperty.setSelfContained(false);
        text.paddingHorizontal(5)
                .paddingVertical(6);
        text.setFontSize(12);
        text.setContent(bindingProperty);
        text.setColor(new Color(0, 0, 0, 100));
        senderContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("sender");
        text.setContent(bindingProperty);
        text.paddingVertical(6);
        text.setFontSize(13);
        text.setFontWeight(FontWeight.W500);
        text.setTextAlign(TextAlign.Left);
        text.width(220);
        senderContainer.getItems().add(text);
        senderContainer
                .width(360)
                .background(new Color(255, 255, 255, 0));
        headerContainer.getItems().add(senderContainer);

        Container lineContainer = new Container();
        lineContainer.paddingHorizontal(16)
                .paddingVertical(6)
                .width(500)
                .heigth(1)
                .background(238, 238, 238, 255);

        headerContainer.getItems().add(lineContainer);

        Container horizontalContainer = new Container();
        horizontalContainer.setDirection(Direction.HORIZONTAL);
        horizontalContainer.paddingVertical(11);
        Container verticalContainer = new Container();
        verticalContainer.setDirection(Direction.VERTICAL);

        //Принято коробок
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("acceptedBoxText");
        text.paddingHorizontal(16);
        text.setFontSize(12);
        text.setContent(bindingProperty);
        text.setColor(new Color(0, 0, 0, 100));


        verticalContainer.getItems().add(text);

        //Принято коробок количество
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("quantityBox");
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
        bindingProperty.setValue("unitText");
        text.paddingHorizontal(16);
        text.setFontSize(12);
        text.setContent(bindingProperty);
        text.setColor(new Color(0, 0, 0, 100));

        verticalContainer.getItems().add(text);

        //Принято штук количество
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("quantity");
        text.setContent(bindingProperty);
        text.paddingVertical(2);
        text.setFontSize(13);
        text.setFontWeight(FontWeight.W500);
        text.paddingHorizontal(16);

        verticalContainer.getItems().add(text);

        horizontalContainer.getItems().add(verticalContainer);

        headerContainer.getItems().add(horizontalContainer);

        mainContainer.getItems().add(headerContainer);
        senderContainer1.heigth(10);
        mainContainer.getItems().add(senderContainer1);

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
                        WarehouseScreen.SUPPLY_SEARCH_BOX.getWarehouseScreen()
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

        iconButton = new IconButton();
        iconButton.setIcon(Icon.Burger);

        DropdownMenu dropdownMenu = new DropdownMenu();
        Modifier modifier = new Modifier();
        modifier.setWidth(300);
        dropdownMenu.getModifiers()
                .add(modifier);

        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "supplyButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                                        )
                                )
                        )
                );

        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "Проблемные марки",
                                        true
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                                        )
                                ), Boolean.FALSE
                        )
                );

        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "Подтверждение расхождений",
                                        true
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                                        )
                                )
                        )
                );

        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "confidentialAcceptanceButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                                        )
                                ),
                                Boolean.FALSE
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "removeFromHoldingButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                                        )
                                ),
                                Boolean.FALSE
                        )
                );

        Container lineContainer = new Container();
        lineContainer.paddingHorizontal(16).paddingVertical(15)
                .width(500)
                .heigth(1)
                .background(238, 238, 238, 255);

        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "printingPackingListButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                                        )
                                ),
                                Boolean.FALSE
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "printingTrade13ButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                                        )
                                ),
                                Boolean.FALSE
                        )
                );

        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "printingTrade13ButtonTextPlan",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                                        )
                                ),
                                Boolean.FALSE
                        )
                );

        iconButton.setDropdownMenu(dropdownMenu);
        header.getContents().add(iconButton);

        this.setHeader(header);
    }

    public void setTable(String[] header, String[][] data) {
        Row headerRow = new Row();
        headerRow.setCells(Arrays.stream(header)
                .map(c -> new Cell(c,
                        new Color(0, 0, 0, 0),
                        new Color(0, 0, 0, 0),
                        34,
                        Arrays.asList(header).indexOf(c) == 0 ? 150 : 80)
                )
                .collect(Collectors.toList()));

        Container horizontalContainer = new Container();
        horizontalContainer.setDirection(Direction.HORIZONTAL);

        for (int i = 0; i < headerRow.getCells().size(); i++) {
            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(headerRow.getCells().get(i).getText());
            text.setContent(bindingProperty);
            text.paddingVertical(2);
            if (i == 0) {
                text.width(190);
                text.paddingHorizontal(42);
            } else {
                text.width(102);
            }
            text.setTextAlign(TextAlign.Left);
            text.setColor(new Color(0, 0, 0, 100));
            text.paddingVertical(0);
            text.setFontSize(14);
            horizontalContainer.getItems().add(text);
        }
        mainContainer.getItems().add(horizontalContainer);

        Container backspace = new Container();
        backspace.paddingVertical(4);

        mainContainer.getItems().add(backspace);

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
            Container tableLine = new Container();
            tableLine.setDirection(Direction.HORIZONTAL);
            tableLine.paddingHorizontal(16);
            Action action = new Action();

            String boxPicLogo = null;
            if (row.getCells().get(3).getText().equals("true")) {
                boxPicLogo = BaseStringImages.BOX_SCREEN_GREEN_CHECK_MARK;
            } else if (row.getCells().get(3).getText().equals("false")) {
                boxPicLogo = BaseStringImages.BOX_SCREEN_RED_CHECK_MARK;
            }

            Image imageIcon = new Image();
            imageIcon.setImage(boxPicLogo);
            imageIcon.paddingHorizontal(2)
                    .paddingVertical(2);
            imageIcon.size(14);

            tableLine.getItems().add(imageIcon);

            for (int j = 0; j < row.getCells().size() - 1; j++) {

                Spacer spacer = new Spacer();
                spacer.paddingHorizontal(4);
                tableLine.getItems().add(spacer);

                Text text = new Text();
                BindingProperty bindingProperty = new BindingProperty();
                bindingProperty.setSelfContained(true);
                bindingProperty.setValue(row.getCells().get(j).getText());
                text.setContent(bindingProperty);
                if (j == 0) {
                    text.width(141);

                } else {
                    text.width(95);
                }
                if (j == 2 && Integer.parseInt(row.getCells().get(j).getText()) < 0) {
                    text.setColor(new Color(255, 0, 0, 255));
                }
                text.setTextAlign(TextAlign.Left);
                text.setFontWeight(FontWeight.W500);
                text.paddingVertical(0);
                text.setFontSize(13);
                tableLine.getItems().add(text);
            }
            action.setActionUri(String.format(
                            "%s/%s?args=%s",
                            UrlHelper.getUrlToCurrentResource(),
                            WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen(),
                            row.getCells().get(0).getText()
                    )
            );
            tableLine.setClickAction(action);
            mainContainer.getItems().add(tableLine);

            //Горизонтальная линия
            Container lineContainer = new Container();
            lineContainer.paddingHorizontal(16).paddingVertical(14)
                    .width(500)
                    .heigth(1)
                    .background(238, 238, 238, 255);
            mainContainer.getItems().add(lineContainer);
        }
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
        scanCodeImage.paddingHorizontal(7).paddingVertical(3);
        scanCodeImage.width(16).heigth(16);
        scanCodeImage.setImage(ico);

        documentContainer.getItems().add(1, scanCodeImage);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("status");
        text.width(184);
        text.setTextAlign(TextAlign.Left);
        text.setContent(bindingProperty);
        text.setColor(color);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);

        documentContainer.getItems().add(2, text);
    }
}