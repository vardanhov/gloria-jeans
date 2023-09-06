package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.product_information;

import ru.gloria_jeans.core.v1.catalog.models.response.ProductInformationModel;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Direction;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.TextAlign;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.List;


public class ProductInformationTableScreenView extends Screen {
    public ProductInformationTableScreenView(List <ProductInformationModel> products) {
        Container mainContainer = new Container();
        mainContainer.setDirection(Direction.VERTICAL);
        mainContainer.setHasScroll(true);
        mainContainer.fillMaxSize()
                .background(255, 255, 255, 255);



        for (ProductInformationModel product : products){
            String title = product.getProductName() + " " + product.getVendorCode();
            Container horizontalContainer = new Container();
            horizontalContainer.setHasScroll(false);
            horizontalContainer.setDirection(Direction.HORIZONTAL);
            horizontalContainer.heigth(55).width(328);
            horizontalContainer.paddingHorizontal(16);

            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setValue(title);
            bindingProperty.setSelfContained(true);
            text.setFontSize(15);
            text.setContent(bindingProperty);
            text.setColor(new Color(0,0,0, 255));
            text.setTextAlign(TextAlign.Left);
            Action action = new Action();
            action.setActionUri(
                    String.format(
                            "%s/%s?args=%s",
                            UrlHelper.getUrlToCurrentResource(),
                            WarehouseScreen.CATALOG_PRODUCT_INFORMATION_RESULT.getWarehouseScreen(),
                            product.getIdd()
                    )
            );
            text.setClickAction(action);
            horizontalContainer.getItems().add(text);
            mainContainer.getItems().add(horizontalContainer);
            Container lineContainer = new Container();
            lineContainer.setHasScroll(false);
            lineContainer.setDirection(Direction.HORIZONTAL);
            lineContainer.heigth(1)
                    .width(328)
                    .background(80,80,80,100);
            lineContainer.paddingHorizontal(16);
            mainContainer.getItems().add(lineContainer);
        }
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
                WarehouseScreen.CATALOG_SEARCH_PRODUCT.getWarehouseScreen()
        ));
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("headerTitle");
        text.setContent(bindingProperty);
        header.getContents().add(text);
        this.setHeader(header);
    }
}
