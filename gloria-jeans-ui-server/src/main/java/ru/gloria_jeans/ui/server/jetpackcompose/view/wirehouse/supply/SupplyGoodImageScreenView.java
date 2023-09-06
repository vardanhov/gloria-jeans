package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.FontWeight;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;

public class SupplyGoodImageScreenView extends Screen {
    private String urlToBack;
    private String imageUrl;
    private String productTitle;
    @JsonIgnore
    private Container mainContainer;

    public SupplyGoodImageScreenView() {
        mainContainer = new Container();
        mainContainer.setHasScroll(true);
        mainContainer.fillMaxSize();

        Image image = new Image();
        BindingProperty imageProperty = new BindingProperty();
        imageProperty.setSelfContained(false);
        imageProperty.setValue("imageUrl");
        image.setUrl(imageProperty);
        image.width(400)
                .paddingVertical(30)
                .paddingHorizontal(16);
        mainContainer.getItems().add(image);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setSelfContained(false);
        bindingProperty.setValue("productTitle");
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
        action.setActionUri(this.urlToBack);
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

    public String getUrlToBack() {
        return urlToBack;
    }

    public void setUrlToBack(String urlToBack) {
        this.urlToBack = urlToBack;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
}
