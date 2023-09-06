package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Modifier;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.List;

public class InternetOrderCollectOrdersContentOrderScreenView extends Screen {
    @JsonIgnore
    private Container body;

    public InternetOrderCollectOrdersContentOrderScreenView() {
        Container backspace = new Container();
        backspace.paddingVertical(11);

        getItems().add(backspace);

        Container headerContainer = new Container();
        headerContainer.setDirection(Direction.VERTICAL);
        headerContainer.paddingHorizontal(16)
                .width(340)
                .heigth(45)
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
        spacer.width(5);
        documentContainer.getItems().add(spacer);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("documentNumber");
        text.setContent(bindingProperty);
        text.paddingHorizontal(20);
        text.setTextAlign(TextAlign.Left);
        text.setColor(new Color(0, 0, 0, 255));
        text.setFontSize(14);
        text.setFontWeight(FontWeight.W500);
        documentContainer.getItems().add(text);

        spacer = new Spacer();
        spacer.width(50);
        documentContainer.getItems().add(spacer);

        text = new Text();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("dk");
        text.paddingHorizontal(20);
        text.setContent(bindingProperty);
        text.setColor(new Color(0, 0, 0, 100));
        text.setFontSize(14);
        documentContainer.getItems().add(text);
        documentContainer
                .heigth(25).width(360)
                .background(new Color(255, 255, 255, 0));

        headerContainer.getItems().add(documentContainer);
        getItems().add(headerContainer);

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
                        "%s/%s?back=true",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS.getWarehouseScreen()
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
                                        "confirmAssemblyOrderButtonText",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_CHECK_ACCEPTANCE_DOCUMENT.getWarehouseScreen()
                                        )
                                )
                        )
                );
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "viewPictureButton",
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
