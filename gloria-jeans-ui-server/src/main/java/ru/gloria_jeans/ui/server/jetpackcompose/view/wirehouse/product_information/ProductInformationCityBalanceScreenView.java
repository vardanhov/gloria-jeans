package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.product_information;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.core.v1.catalog.models.response.ProductInformationModel;
import ru.gloria_jeans.core.v1.catalog.models.response.ShopQuantity;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Border;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shadow;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Shape;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.List;


public class ProductInformationCityBalanceScreenView extends Screen {
    @JsonIgnore
    Container mainContainer;

    public ProductInformationCityBalanceScreenView() {
        mainContainer = new Container();
        mainContainer.setHasScroll(true);
        mainContainer.fillMaxSize();
        Container productInfoContainer = new Container();
        productInfoContainer.setDirection(Direction.HORIZONTAL);
        Container priceContainer = new Container();
        priceContainer.setDirection(Direction.HORIZONTAL);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("productName");
        text.setFontSize(18);
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        text.width(400).paddingHorizontal(16);
        mainContainer.getItems().add(text);
        getItems().add(mainContainer);
    }

    @Override
    public void initHeader() {
        Header header = new Header();
        IconButton iconButton = new IconButton();
        iconButton.setIcon(Icon.Back);
        Action action = new Action();
        action.setActionUri(String.format(
                "%s/%s",
                UrlHelper.getUrlToCurrentResource(),
                WarehouseScreen.CATALOG_PRODUCT_INFORMATION_RESULT.getWarehouseScreen()
        ));
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

    public void setTable(List<ShopQuantity> shopQuantities) {
        for (ShopQuantity shopQuantity : shopQuantities) {
            Container block = new Container();
            block.fillMaxWidth();
            block.shadow(new Shadow(2, new Shape(ClipShape.RoundedCornerShape, 4)));
            block.padding(6);
            Container horizontalContainer = new Container();
            horizontalContainer.setHasScroll(false);
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.heigth(24).width(328);
            horizontalContainer.paddingHorizontal(16);

            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setValue(shopQuantity.getShopName());
            bindingProperty.setSelfContained(true);
            text.setFontSize(15);
            text.setContent(bindingProperty);
            text.setColor(new Color(0,0,0, 255));
            text.setTextAlign(TextAlign.Left);
            text.setFontWeight(FontWeight.Bold);
            horizontalContainer.getItems().add(text);

            block.getItems().add(horizontalContainer);

            horizontalContainer = new Container();
            horizontalContainer.setHasScroll(false);
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.heigth(24).width(370);
            horizontalContainer.paddingHorizontal(16);

            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setValue("cityBalanceQuantity");
            bindingProperty.setSelfContained(false);
            text.setFontSize(15);
            text.setContent(bindingProperty);
            text.setColor(new Color(0, 0, 0, 100));
            text.setTextAlign(TextAlign.Left);
            horizontalContainer.getItems().add(text);

            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setValue(String.valueOf(shopQuantity.getQuantity()));
            bindingProperty.setSelfContained(true);
            text.setFontSize(15);
            text.setContent(bindingProperty);
            text.setColor(new Color(0,0,0, 255));
            text.setTextAlign(TextAlign.Left);
            text.setFontWeight(FontWeight.Bold);
            horizontalContainer.getItems().add(text);

            block.getItems().add(horizontalContainer);
            mainContainer.getItems().add(block);
        }
    }
}
