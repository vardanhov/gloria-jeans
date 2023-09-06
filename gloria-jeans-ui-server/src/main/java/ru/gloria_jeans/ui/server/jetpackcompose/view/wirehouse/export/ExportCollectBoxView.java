package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.export;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.checkerframework.checker.units.qual.C;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Modifier;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.List;

public class ExportCollectBoxView extends Screen {
    @JsonIgnore
    private Container body;

    public ExportCollectBoxView() {
        Container backspace = new Container();
        backspace.paddingVertical(11);

        getItems().add(backspace);

        Container headerContainer = new Container();
        headerContainer.setDirection(Direction.HORIZONTAL);
        headerContainer.paddingHorizontal(16)
                .width(340)
                .heigth(80)
                .shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));
        Container numberContainer = new Container();
        numberContainer.setDirection(Direction.HORIZONTAL);
        numberContainer.width(80)
                .heigth(70);
        Image boxLogo = new Image();
        boxLogo.fillMaxHeigth();
        boxLogo.paddingHorizontal(5);
        boxLogo.paddingHorizontal(8).paddingVertical(2).size(20);
        boxLogo.setImage(BaseStringImages.BOX_SCREEN_PIC);
        numberContainer.getItems().add(boxLogo);


        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("boxNumber");
        bindingProperty.setSelfContained(false);
        text.setFontSize(18);
        text.setFontWeight(FontWeight.Bold);
        text.setColor(new Color(0,0,0,255));
        text.setContent(bindingProperty);
        text.paddingVertical(21);
        numberContainer.getItems().add(text);

        Spacer spacer = new Spacer();
        spacer.width(60).heigth(80);

        Container infoRight = new Container();
        infoRight.setDirection(Direction.VERTICAL);
        infoRight.width(200)
                .heigth(80).paddingVertical(10);

        Container info1 = new Container();
        info1.width(200)
                .heigth(30);
        info1.setDirection(Direction.HORIZONTAL);

        spacer = new Spacer();
        spacer.width(65).heigth(30);
        info1.getItems().add(spacer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("exportLabel");
        bindingProperty.setSelfContained(false);
        text.setFontSize(16);
        text.setColor(new Color(80,80,80,150));
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        info1.getItems().add(text);

        Container info2 = new Container();
        info2.width(200)
                .heigth(30);

        info2.setDirection(Direction.HORIZONTAL);

        spacer = new Spacer();
        spacer.width(30).heigth(30);
        info2.getItems().add(spacer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("documentNumber");
        bindingProperty.setSelfContained(false);
        text.setFontSize(16);
        text.setColor(new Color(80,80,80,150));
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        info2.getItems().add(text);

        Spacer spacer1 = new Spacer();
        spacer1.width(5).heigth(5);
        info2.getItems().add(spacer1);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("staticTextLabel");
        bindingProperty.setSelfContained(false);
        text.setFontSize(16);
        text.setColor(new Color(80,80,80,150));
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        info2.getItems().add(text);

        spacer1 = new Spacer();
        spacer1.width(5).heigth(5);
        info2.getItems().add(spacer1);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("exportDate");
        bindingProperty.setSelfContained(false);
        text.setFontSize(16);
        text.setColor(new Color(80,80,80,150));
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        info2.getItems().add(text);


        infoRight.getItems().add(info1);
        infoRight.getItems().add(info2);
        headerContainer.getItems().add(numberContainer);
        headerContainer.getItems().add(spacer);
        headerContainer.getItems().add(infoRight);
        getItems().add(headerContainer);

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
        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("label");
        bindingProperty.setSelfContained(false);
        text.setFontSize(18);
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        barCodeLabelContainer.getItems().add(text);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("labelUnderLabel");
        bindingProperty.setSelfContained(false);
        text.setFontSize(14);
        text.setContent(bindingProperty);
        text.setColor(new Color(128,128,128,200));
        barCodeLabelContainer.getItems().add(text);
        barCodeContainer.getItems().add(barCodeLabelContainer);
        getItems().add(barCodeContainer);

        Container searchContainer = new Container();
        searchContainer.setHasScroll(false);
        searchContainer.setDirection(Direction.VERTICAL);
        searchContainer.heigth(128);

        spacer = new Spacer();
        spacer.paddingVertical(7);
        searchContainer.getItems().add(spacer);

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
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen()
                )
        );
        textField.setClickAction(inputAction);

        searchContainer.getItems().add(textField);

        spacer = new Spacer();
        spacer.paddingVertical(5);
        searchContainer.getItems().add(spacer);

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
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen())
        );
        searchButton.setClickAction(action);
        searchContainer.getItems().add(searchButton);
        getItems().add(searchContainer);

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
                                        "createBoxButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                UrlHelper
                                                        .getUrlToCurrentResource()
                                                        .concat("/")
                                                        .concat(WarehouseScreen.EXPORT_COLLECT_BOX.getWarehouseScreen())


                        )
                )));
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "clearBoxButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_VIEW_POSITION.getWarehouseScreen()
                                        )
                                )
                        )
                );
        iconButton.setDropdownMenu(dropdownMenu);
        header.getContents().add(iconButton);

        this.setHeader(header);
    }

    public void setBody(List<Composable> blocks) {
        body = new Container();
        body.setHasScroll(true);
        body.setDirection(Direction.VERTICAL);
        body.fillMaxSize();

        for (Composable block : blocks) {
            body.getItems().add(block);
        }

        getItems().add(body);
    }
}
