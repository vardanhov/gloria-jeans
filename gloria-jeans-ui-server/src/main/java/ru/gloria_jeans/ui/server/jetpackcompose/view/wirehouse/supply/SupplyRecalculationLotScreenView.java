package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;


import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.helper.ControlHelper;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.List;

public class SupplyRecalculationLotScreenView extends Screen {
    @JsonIgnore
    private Container body;
    @JsonIgnore
    private boolean showTextField;

    public SupplyRecalculationLotScreenView(boolean isShowTextField) {
        showTextField = isShowTextField;
        Container backspace = new Container();
        backspace.paddingVertical(11);

        getItems().add(backspace);

        Container headerContainer = new Container();
        headerContainer.setDirection(Direction.VERTICAL);
        headerContainer.paddingHorizontal(16)
                .width(340)
                .heigth(126)
                .shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));

        Container documentContainer = new Container();
        documentContainer.setHasScroll(false);
        documentContainer.setDirection(Direction.HORIZONTAL);
        documentContainer.paddingVertical(10)
                .heigth(20);

        backspace = new Container();
        backspace.paddingVertical(2);

        headerContainer.getItems().add(backspace);

        Spacer spacer = new Spacer();
        spacer.width(8);

        documentContainer.getItems().add(spacer);

        Image lotLogo = new Image();
        lotLogo.setImage(BaseStringImages.LOT_SCREEN_PIC);
        lotLogo.paddingHorizontal(8).paddingVertical(2).size(16);

        documentContainer.getItems().add(lotLogo);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("lotName");
        text.width(274);
        text.heigth(14);
        text.setTextAlign(TextAlign.Left);
        text.setContent(bindingProperty);
        text.setColor(new Color(0, 0, 0, 255));
        text.setFontSize(13);
        text.setFontWeight(FontWeight.W500);
        documentContainer.getItems().add(text);

        headerContainer.getItems().add(documentContainer);

        Container lineContainer = new Container();
        lineContainer.paddingHorizontal(16)
                .width(500)
                .heigth(1)
                .background(238, 238, 238, 255);

        headerContainer.getItems().add(lineContainer);

        Container circleContainer = new Container();
        circleContainer.setDirection(Direction.HORIZONTAL);

        circleContainer.getItems().add(
                ControlHelper.getCircleLabel("quantity", "quantityLabel", new Color(150, 25, 134, 255))
                        .paddingVertical(8)
                        .paddingHorizontal(40)
        );
        circleContainer.getItems().add(
                ControlHelper.getCircleLabel("quantityFact", "quantityFactLabel", new Color(102, 180, 107, 255))
                        .paddingVertical(8)
                        .paddingHorizontal(18)
        );
        circleContainer.getItems().add(
                ControlHelper.getCircleLabel("quantityDiff", "quantityDiffLabel", new Color(239, 62, 66, 255))
                        .paddingVertical(8)
                        .paddingHorizontal(40)
        );

        headerContainer.getItems().add(circleContainer);

        getItems().add(headerContainer);

        if (isShowTextField) {

            Container searchContainer = new Container();
            searchContainer.setHasScroll(false);
            searchContainer.setDirection(Direction.VERTICAL);
            searchContainer.heigth(128);

            spacer = new Spacer();
            spacer.paddingVertical(7);
            searchContainer.getItems().add(spacer);

            TextField textField = new TextField();
            bindingProperty = new BindingProperty();
            bindingProperty.setValue("barcodeProduct");
            textField.setValue(bindingProperty);
            bindingProperty = new BindingProperty();
            bindingProperty.setValue("codeNumberText");
            textField.setLabel(bindingProperty);
            textField.paddingHorizontal(16)
                    .heigth(60)
                    .width(360)
                    .background(new Color(255, 255, 255, 255));
            searchContainer.getItems().add(textField);

            spacer = new Spacer();
            spacer.paddingVertical(5);
            searchContainer.getItems().add(spacer);

            Button searchButton = new Button();
            searchButton.paddingHorizontal(16)
                    .width(360);
            bindingProperty = new BindingProperty();
            bindingProperty.setValue("buttonSearchText");
            text = new Text();
            text.setContent(bindingProperty);
            searchButton.setContent(text);
            Action action = new Action();
            action.setActionUri(
                    String.format(
                            "%s/%s?buttonFinish=%s",
                            UrlHelper.getUrlToCurrentResource(),
                            WarehouseScreen.SUPPLY_RECALCULATION_LOT.getWarehouseScreen(),
                            true
                    )
            );
            searchButton.setClickAction(action);
            searchContainer.getItems().add(searchButton);
            getItems().add(searchContainer);
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
                        WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen()
                )
        );
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("headerTitle");
        text.setFontSize(15);
        text.setFontWeight(FontWeight.W500);
        text.setColor(new Color(255, 255, 255, 255));
        text.setContent(bindingProperty);
        header.getContents().add(text);

        iconButton = new IconButton();
        iconButton.setIcon(Icon.Burger);
        DropdownMenu dropdownMenu = new DropdownMenu();
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "manualInputBarcodeButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?isShowTextField=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_RECALCULATION_LOT.getWarehouseScreen(),
                                                !showTextField
                                        )
                                )
                        )
                );

        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "clearFactAllPositionButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.SUPPLY_CLEAR_FACT_ALL_POSITIONS.getWarehouseScreen()
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
                                        "viewDiscrepanciesButtonText",
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

        Container finishButtonContainer = new Container();
        Button button = new Button();
        button.width(360);
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("finish");
        bindingProperty.setSelfContained(false);
        Text text = new Text();
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen()
                )
        );
        button.paddingHorizontal(16).paddingVertical(16);
        button.setContent(text);
        button.setClickAction(action);
        finishButtonContainer.getItems().add(button);
        body.getItems().add(finishButtonContainer);
        getItems().add(body);
    }
}
