package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;
import java.util.List;

public class SupplySearchDocumentScreenView extends Screen {
    @JsonIgnore
    private Container mainContainer;
    public SupplySearchDocumentScreenView() {
        mainContainer = new Container();
        mainContainer.setHasScroll(true);
        mainContainer.fillMaxSize();

        Text text;
        BindingProperty bindingProperty;
        TextField textField;

        Container horizontalContainer = new Container();
        horizontalContainer.setDirection(Direction.HORIZONTAL);

        Container verticalContainer = new Container();
        verticalContainer.setDirection(Direction.HORIZONTAL);

        Container backspaceCode = new Container();
        verticalContainer.setDirection(Direction.VERTICAL);
        backspaceCode.paddingVertical(6);
        verticalContainer.getItems().add(backspaceCode);

        //Штрихкод
        Image scanCodeImage = new Image();
        scanCodeImage.fillMaxHeigth();
        scanCodeImage.paddingHorizontal(16).paddingVertical(18);
        scanCodeImage.width(32).heigth(32);
        scanCodeImage.setImage(BaseStringImages.SCAN_CODE_LOGO);
        verticalContainer.getItems().add(scanCodeImage);

        horizontalContainer.getItems().add(verticalContainer);

        Container containerNext = new Container();
        containerNext.setDirection(Direction.VERTICAL);

        //Контейнер верхний пробел
        Container backspace = new Container();
        backspace.paddingVertical(10);
        containerNext.getItems().add(backspace);

        //Головной текст
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("label");
        Text textTop = new Text();
        textTop.setFontWeight(FontWeight.W500);
        textTop.setFontSize(20);
        textTop.setContent(bindingProperty);

        containerNext.getItems().add(textTop);

        //Текст под головным текстом
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

        //Горизонтальная линия
        Container lineContainer = new Container();
        lineContainer.paddingHorizontal(16).paddingVertical(5)
                .width(500)
                .heigth(1)
                .background(238, 238, 238, 255);
        mainContainer.getItems().add(lineContainer);

        //Поле ввода idd или баркода
        textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("documentBarcode");
        textField.setValue(bindingProperty);
        textField.setSingleLine(true);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("documentNumber");
        textField.setLabel(bindingProperty);
        textField.paddingHorizontal(16)
                .paddingVertical(10)
                .heigth(64)
                .width(500);

        Action inputAction = new Action();
        inputAction.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_RESULT_SEARCH.getWarehouseScreen()
                )
        );
        textField.setClickAction(inputAction);
        textField.setAutoFocus(false);
        mainContainer.getItems().add(textField);

        //Начальная дата
        textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("dateFrom");
        textField.setValue(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("labelDateFrom");
        textField.setLabel(bindingProperty);
        textField.border(1, new Color(238, 238, 238, 255));
        DatePicker datePicker = new DatePicker();
        datePicker.paddingHorizontal(16)
                .heigth(64)
                .width(500);
        datePicker.setTextField(textField);

        mainContainer.getItems().add(datePicker);

        //Конечная дата
        textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(true);
        textField.setPlaceholder(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("dateTo");
        bindingProperty.setSelfContained(false);
        textField.setValue(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("labelDateTo");
        textField.setLabel(bindingProperty);
        datePicker = new DatePicker();
        datePicker.setTextField(textField);
        datePicker.paddingHorizontal(16)
                .heigth(62)
                .width(500);

        mainContainer.getItems().add(datePicker);

        //Горизонтальная линия
        lineContainer = new Container();
        lineContainer.paddingHorizontal(16).paddingVertical(16)
                .width(500)
                .heigth(1)
                .background(238, 238, 238, 255);
        mainContainer.getItems().add(lineContainer);

        //Кнопка поиска
        Button button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("buttonSearchText");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        text.size(20);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_RESULT_SEARCH.getWarehouseScreen()
                )
        );
        button.paddingHorizontal(16)
                .paddingVertical(8)
                .heigth(36)
                .width(600);
        button.setContent(text);
        button.setClickAction(action);
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
                        WarehouseScreen.SUPPLY_SEARCH_BOX.getWarehouseScreen()
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

    public void setStatusList(List<MultiSelectorItem> statusList) {

        Container backspaceThree = new Container();
        backspaceThree.paddingVertical(2);
        mainContainer.getItems().add(5, backspaceThree);

        // Множественный выбор в выпадающем окне
        MultiSelector multiSelector = new MultiSelector();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("selectedItems");
        multiSelector.setSelectedItems(bindingProperty);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("labelStatus");
        Text text = new Text();
        text.setContent(bindingProperty);
        multiSelector.setLabelName(text);
        multiSelector.setItemsList(statusList);
        mainContainer.getItems().add(6, multiSelector);
    }


}

