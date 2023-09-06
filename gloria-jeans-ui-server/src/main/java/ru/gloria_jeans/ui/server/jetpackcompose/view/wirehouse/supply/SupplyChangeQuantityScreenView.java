package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class SupplyChangeQuantityScreenView extends Screen {
    @JsonIgnore
    private Container mainContainer;
    private String urlToBack;

    public SupplyChangeQuantityScreenView(String urlToBack) {
        this.urlToBack = urlToBack;
        mainContainer = new Container();
        mainContainer.fillMaxSize();
        mainContainer.background(new Color(139, 139, 139, 255));
        Container windowContainer = new Container();
        windowContainer.paddingHorizontal(40).paddingVertical(93);
        windowContainer.shadow(new Shadow(14, new Shape(ClipShape.RoundedCornerShape, 2)));
        windowContainer.background(new Color(255, 255, 255, 255));
        windowContainer.heigth(267);
        Container buttonContainer = new Container();
        buttonContainer.setHasScroll(false);
        buttonContainer.setDirection(Direction.HORIZONTAL);
        buttonContainer.paddingVertical(20);

        Spacer spacer = new Spacer();
        spacer.paddingVertical(8);
        windowContainer.getItems().add(spacer);

        Image scanCodeImage = new Image();
        scanCodeImage.paddingHorizontal(125);
        scanCodeImage.width(27).heigth(27);
        scanCodeImage.setImage(BaseStringImages.SETTINGS_RED);
        windowContainer.getItems().add(scanCodeImage);

        spacer = new Spacer();
        spacer.paddingVertical(3);
        windowContainer.getItems().add(spacer);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("changeQuantityLabel");
        bindingProperty.setSelfContained(false);
        text.setFontSize(16);
        text.paddingHorizontal(55);
        text.setContent(bindingProperty);
        windowContainer.getItems().add(text);

        ButtonOutLine buttonAccept = new ButtonOutLine();
        buttonAccept.width(360);
        buttonAccept.heigth(70);
        buttonAccept.paddingVertical(4);
        buttonAccept.paddingHorizontal(16);
        TextField textField = new TextField();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("selectedProductCountPlan");
        textField.setValue(bindingProperty);
        textField.setPlaceholder(bindingProperty);
        textField.setKeyboardType(TextFieldKeyboardType.Number);
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("productPlanLabel");
        textField.setLabel(bindingProperty);
        buttonAccept.background(0, 0, 0, 1);
        buttonAccept.setTextField(textField);

        windowContainer.getItems().add(buttonAccept);

        bindingProperty = new BindingProperty();
        bindingProperty.setValue("selectedProductCountFact");
        bindingProperty.setSelfContained(false);
        textField = new TextField();
        textField.paddingHorizontal(17);
        textField.setValue(bindingProperty);
        textField.heigth(60);
        textField.setKeyboardType(TextFieldKeyboardType.Number);
        textField.setClickAction(
                new Action(
                        String.format("%s/%s",
                                UrlHelper.getUrlToCurrentResource(),
                                WarehouseScreen.SUPPLY_CHANGE_QUANTITY_UPDATE.getWarehouseScreen()
                        )
                )
        );
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("productFactLabel");
        bindingProperty.setSelfContained(false);
        textField.setLabel(bindingProperty);
        windowContainer.getItems().add(textField);

        spacer = new Spacer();
        spacer.paddingVertical(4);
        windowContainer.getItems().add(spacer);

        spacer = new Spacer();
        spacer.paddingHorizontal(37);
        buttonContainer.getItems().add(spacer);

        bindingProperty = new BindingProperty();
        bindingProperty.setValue("saveButtonText");
        text = new Text();
        text.setColor(new Color(255, 0, 0, 255));
        text.width(115);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.setContent(bindingProperty);
        Action action = new Action(
                String.format("%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_CHANGE_QUANTITY_UPDATE.getWarehouseScreen()
                )
        );
        text.setClickAction(action);
        buttonContainer.getItems().add(text);

        bindingProperty = new BindingProperty();
        bindingProperty.setValue("closeButtonText");
        text = new Text();
        text.setColor(new Color(0, 0, 0, 100));
        text.width(80);
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(urlToBack);
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
        action.setActionUri(urlToBack);

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
