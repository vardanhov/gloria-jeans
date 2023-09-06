package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;


import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.helper.ControlHelper;
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

public class SupplyConfirmDiscrepancyScreenView extends Screen {
    @JsonIgnore
    private Container mainContainer;

    public SupplyConfirmDiscrepancyScreenView() {
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
        Container documentContainer = new Container();
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

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("type");
        text.width(224);
        text.paddingHorizontal(16);
        text.setTextAlign(TextAlign.Left);
        text.setContent(bindingProperty);
        text.setColor(new Color(0, 0, 0, 100));
        text.setFontSize(12);
        documentContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
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
        text.paddingHorizontal(16);
        text.setFontSize(20);
        text.setFontWeight(FontWeight.W500);
        headerContainer.getItems().add(text);

        //Отправитель
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("senderText");
        bindingProperty.setSelfContained(false);
        text.paddingHorizontal(16)
                .paddingVertical(8);
        text.setFontSize(12);
        text.setContent(bindingProperty);
        text.setColor(new Color(0, 0, 0, 100));
        senderContainer.getItems().add(text);

        Container backspace = new Container();
        backspace.paddingHorizontal(6);
        senderContainer.getItems().add(backspace);

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

        mainContainer.getItems().add(headerContainer);
        senderContainer1.heigth(10);
        mainContainer.getItems().add(senderContainer1);

        getItems().add(mainContainer);
    }

    public void setData(String[] header, String[][] data) {

        Row headerRow = new Row();
        headerRow.setCells(Arrays.stream(header)
                .map(c -> new Cell(c,
                        new Color(0, 0, 0, 0),
                        new Color(0, 0, 0, 0),
                        34,
                        Arrays.asList(header).indexOf(c) == 0 ? 150 : 53)
                )
                .collect(Collectors.toList()));

        List<Row> rows = Arrays.stream(data)
                .map(row -> new Row((Arrays.stream(row)
                        .map(c -> new Cell(c,
                                new Color(0, 0, 0, 0),
                                new Color(0, 0, 0, 0),
                                34,
                                Arrays.asList(row).indexOf(c) == 0 ? 200 : 53)
                        )
                        .collect(Collectors.toList()))))
                .collect(Collectors.toList());

        Container tableHeader = new Container();
        tableHeader.setDirection(Direction.HORIZONTAL);

        for (int i = 0; i < headerRow.getCells().size(); i++) {
            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(headerRow.getCells().get(i).getText());
            text.setContent(bindingProperty);
            text.paddingVertical(2);
            if (i == 0) {
                text.width(160);
                text.paddingHorizontal(16);
            } else {
                text.width(68);
            }
            text.setTextAlign(TextAlign.Left);
            text.setColor(new Color(0, 0, 0, 100));
            text.paddingVertical(0);
            text.setFontSize(14);
            tableHeader.getItems().add(text);
        }

        mainContainer.getItems().add(tableHeader);

        Container backspace = new Container();
        backspace.paddingVertical(5);
        mainContainer.getItems().add(backspace);

        for (int i = 0; i < rows.size(); i++) {
            Container tableLine = new Container();
            tableLine.setDirection(Direction.HORIZONTAL);

            for (int j = 0; j < rows.get(i).getCells().size(); j++) {
                Text text = new Text();
                BindingProperty bindingProperty = new BindingProperty();
                bindingProperty.setSelfContained(true);
                if (j == 3) {
                    rows.get(i).getCells().get(j).setText(
                            ControlHelper.plusMinusSetter(
                                    rows.get(i).getCells().get(j).getText()
                            )
                    );
                }
                bindingProperty.setValue(rows.get(i).getCells().get(j).getText());
                text.setContent(bindingProperty);
                text.paddingHorizontal(17);
                if (j == 0) {
                    text.width(110);
                } else {
                    text.width(34);
                    text.setTextAlign(TextAlign.Center);
                }
                text.setTextAlign(TextAlign.Left);
                if (Integer.parseInt(rows.get(i).getCells().get(3).getText()) < 0 || Integer.parseInt(rows.get(i).getCells().get(3).getText()) > 0) {
                    text.setColor(new Color(255, 0, 0, 225));
                } else {
                    text.setColor(new Color(102, 180, 107, 225));
                }
                text.setFontWeight(FontWeight.W500);
                text.paddingVertical(0);
                text.setFontSize(14);
                tableLine.getItems().add(text);
            }
            mainContainer.getItems().add(tableLine);

            //Горизонтальная линия
            Container lineContainer = new Container();
            lineContainer.paddingHorizontal(16).paddingVertical(13)
                    .width(500)
                    .heigth(1)
                    .background(238, 238, 238, 255);
            mainContainer.getItems().add(lineContainer);
        }
    }

    public void createButton() {
        Container fieldContainer = new Container();
        fieldContainer.setHasScroll(false);
        fieldContainer.setDirection(Direction.HORIZONTAL);
        Container labelContainer = new Container();
        labelContainer.setHasScroll(false);
        labelContainer.setDirection(Direction.VERTICAL);
        Container textFieldContainer = new Container();
        textFieldContainer.setHasScroll(false);
        textFieldContainer.setDirection(Direction.VERTICAL);

        Text text;
        BindingProperty bindingProperty;
        Action action;

        Container backspace = new Container();
        backspace.paddingVertical(10);
        mainContainer.getItems().add(backspace);

        ButtonOutLine buttonAccept = new ButtonOutLine();
        buttonAccept.width(360);
        buttonAccept.heigth(75);
        buttonAccept.paddingVertical(8);
        buttonAccept.paddingHorizontal(16);
        TextField textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("receivingPerson");
        textField.setValue(bindingProperty);
        textField.setPlaceholder(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("acceptedLabel");
        textField.setLabel(bindingProperty);

        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s?args=%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_EMPLOYEES_LIST.getWarehouseScreen(),
                        "receivingPerson"
                )
        );

        buttonAccept.setClickAction(action);
        buttonAccept.background(0, 0, 0, 1);

        buttonAccept.setTextField(textField);

        mainContainer.getItems().add(buttonAccept);

        ButtonOutLine buttonConfirm = new ButtonOutLine();
        buttonConfirm.width(360);
        buttonAccept.heigth(75);
        textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("confirmingPerson");
        textField.setValue(bindingProperty);
        textField.setPlaceholder(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("confirmedLabel");
        textField.setLabel(bindingProperty);

        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s?args=%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_EMPLOYEES_LIST.getWarehouseScreen(),
                        "confirmingPerson"
                )
        );

        buttonConfirm.setClickAction(action);
        buttonConfirm.paddingHorizontal(16);
        buttonConfirm.background(0, 0, 0, 1);

        buttonConfirm.setTextField(textField);

        mainContainer.getItems().add(buttonConfirm);

        Button button;

        Container backspaceFooter = new Container();
        backspaceFooter.paddingVertical(4);
        mainContainer.getItems().add(backspaceFooter);

        //Кнопка далее
        button = new Button();
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY_POPUP.getWarehouseScreen()
                )
        );

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("further");
        text.setContent(bindingProperty);
        button.paddingHorizontal(16);
        button.width(360);
        button.setContent(text);
        button.setClickAction(action);
        mainContainer.getItems().add(button);
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
                        WarehouseScreen.SUPPLY_VIEW_DOCUMENT.getWarehouseScreen()
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
        text.setColor(new Color(255,255,255,255));
        header.getContents().add(text);

        this.setHeader(header);
    }
}
