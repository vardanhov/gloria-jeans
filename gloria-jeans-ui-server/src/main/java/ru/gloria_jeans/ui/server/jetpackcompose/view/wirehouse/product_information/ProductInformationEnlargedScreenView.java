package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.product_information;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.FontWeight;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class ProductInformationEnlargedScreenView extends Screen {

    public ProductInformationEnlargedScreenView() {
        Container mainContainer = new Container();
        mainContainer.setHasScroll(true);
        mainContainer.fillMaxSize();

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
        image.width(350).heigth(350)
                .paddingVertical(10);

        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.CATALOG_PRODUCT_INFORMATION_RESULT.getWarehouseScreen()
                )
        );
        image.setClickAction(action);
        mainContainer.getItems().add(image);

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
                        WarehouseScreen.CATALOG_PRODUCT_INFORMATION_RESULT.getWarehouseScreen()
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
