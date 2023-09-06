package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;


public class SupplyConfirmDiscrepancyPopupScreenView extends Screen {

    @JsonIgnore
    private Container mainContainer;

    public SupplyConfirmDiscrepancyPopupScreenView() {
        mainContainer = new Container();
        mainContainer.fillMaxSize();
        mainContainer.background(new Color(139, 139, 139, 255));
        Container windowContainer = new Container();
        windowContainer.paddingHorizontal(40).paddingVertical(142);
        windowContainer.shadow(new Shadow(14, new Shape(ClipShape.RoundedCornerShape, 2)));
        windowContainer.background(new Color(255, 255, 255, 255));
        windowContainer.heigth(170);

        Container buttonContainer = new Container();
        buttonContainer.setHasScroll(false);
        buttonContainer.setDirection(Direction.HORIZONTAL);

        Spacer spacer = new Spacer();
        spacer.paddingVertical(7);
        windowContainer.getItems().add(spacer);

        Image scanCodeImage = new Image();
        scanCodeImage.paddingHorizontal(125);
        scanCodeImage.width(24).heigth(24);
        scanCodeImage.setImage(BaseStringImages.DISCREPTANSY_POPUP_PIC);
        windowContainer.getItems().add(scanCodeImage);

        spacer = new Spacer();
        spacer.paddingVertical(6);
        windowContainer.getItems().add(spacer);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("headerTitleText");
        bindingProperty.setSelfContained(false);
        text.setFontSize(15);
        text.paddingHorizontal(38);
        text.setContent(bindingProperty);
        windowContainer.getItems().add(text);

        spacer = new Spacer();
        spacer.paddingVertical(8);
        windowContainer.getItems().add(spacer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("messageText");
        bindingProperty.setSelfContained(false);
        text.setFontSize(13);
        text.paddingHorizontal(98);
        text.setContent(bindingProperty);
        text.setFontWeight(FontWeight.W500);
        text.setColor(new Color(0, 0, 0, 100));
        windowContainer.getItems().add(text);

        spacer = new Spacer();
        spacer.paddingVertical(16);
        windowContainer.getItems().add(spacer);

        spacer = new Spacer();
        spacer.paddingHorizontal(90);
        buttonContainer.getItems().add(spacer);

        bindingProperty = new BindingProperty();
        bindingProperty.setValue("saveButtonText");
        text = new Text();
        text.setColor(new Color(255, 0, 0, 255));
        text.width(50);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format("%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_CONFIRM_ACCEPTANCE_DELIVERY_YES.getWarehouseScreen()
                )
        );
        text.setClickAction(action);
        buttonContainer.getItems().add(text);

        bindingProperty = new BindingProperty();
        bindingProperty.setValue("closeButtonText");
        text = new Text();
        text.setColor(new Color(0, 0, 0, 100));
        text.width(40);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format("%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                )
        );
        text.setClickAction(action);
        buttonContainer.getItems().add(text);

        windowContainer.getItems().add(buttonContainer);
        mainContainer.getItems().add(windowContainer);
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
                        WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
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
