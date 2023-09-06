package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.core.v1.orders.model.response.OrderViewPositionModel;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Modifier;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.Objects;

public class InternetOrderCollectOrdersViewPositionScreenView extends Screen {
    @JsonIgnore
    private Container documentContainer;

    private String itemId;

    public InternetOrderCollectOrdersViewPositionScreenView() {
        Container mainContainer = new Container();
        mainContainer.setHasScroll(true);
        mainContainer.fillMaxSize();

        documentContainer = new Container();
        documentContainer.setHasScroll(false);
        documentContainer.setDirection(Direction.HORIZONTAL);

        Container nomenclatureContainer = new Container();
        nomenclatureContainer.setDirection(Direction.HORIZONTAL);

        Container imageContainer = new Container();
        imageContainer.setDirection(Direction.HORIZONTAL);

        Container productContainer = new Container();
        productContainer.setDirection(Direction.HORIZONTAL);

        Button button = new Button();
        button.paddingHorizontal(16)
                .width(360);
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("absenceReasonButtonText");
        Text text = new Text();
        text.setFontSize(13);
        text.setFontWeight(FontWeight.Bold);
        text.setContent(bindingProperty);
        button.setContent(text);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_CAUSES_OF_NOT_ASSEMBLY.getWarehouseScreen())
        );
        button.setClickAction(action);
        mainContainer.getItems().add(button);

        Spacer spacer = new Spacer();
        spacer.paddingVertical(8);
        getItems().add(spacer);
        getItems().add(documentContainer);
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
                WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen()
        ));
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
        modifier.setWidth(160);
        dropdownMenu.getModifiers()
                .add(modifier);
        dropdownMenu.getDropdownMenuItems()
                .add(
                        new DropdownMenuItem(
                                new BindingProperty(
                                        "clearFactPositionButton",
                                        false
                                ),
                                new Action(
                                        String.format(
                                                "%s/%s?args=%s",
                                                UrlHelper.getUrlToCurrentResource(),
                                                WarehouseScreen.INTERNET_ORDERS_CLEAR_FACT_POSITION.getWarehouseScreen(),
                                                itemId
                                        )
                                )
                        )
                );
        iconButton.setDropdownMenu(dropdownMenu);
        header.getContents().add(iconButton);

        this.setHeader(header);
    }

    public void setBody(OrderViewPositionModel orderViewPositionModel) {
        itemId = orderViewPositionModel.getId();
        Container quantityContainer = new Container();
        quantityContainer.setDirection(Direction.HORIZONTAL);
        Container header = new Container();
        header.setDirection(Direction.VERTICAL);
        Container headerTitle = new Container();
        headerTitle.setDirection(Direction.HORIZONTAL);
        Container logoTitle = new Container();
        logoTitle.setDirection(Direction.HORIZONTAL);
        Image imageIcon;
        Spacer spacer = new Spacer();

        spacer.width(16);
        logoTitle.getItems().add(spacer);

        if (!orderViewPositionModel.isMark()) {
            spacer = new Spacer();
            spacer.width(16);
            logoTitle.getItems().add(spacer);
        }
        if (!orderViewPositionModel.isShowReasonForAbsence()) {
            spacer = new Spacer();
            spacer.width(16);
            logoTitle.getItems().add(spacer);
        }
        if (orderViewPositionModel.isMark()) {
            imageIcon = new Image();
            imageIcon.setImage(orderViewPositionModel.isScannedMark() ? BaseStringImages.BOX_SCREEN_GREEN_MARK : BaseStringImages.BOX_SCREEN_RED_MARK);
            imageIcon.size(16);
            logoTitle.getItems().add(imageIcon);
        }
        if (orderViewPositionModel.isShowReasonForAbsence()) {
            Image absent = new Image();
            absent.setImage(BaseStringImages.BAN);
            absent.size(16);
            logoTitle.getItems().add(absent);
        }


        String strDiff;
        Color colorText;
        Color colorCount;

        int diff = Integer.parseInt(orderViewPositionModel.getProductPlan()) - Integer.parseInt(orderViewPositionModel.getProductFact());
        int quantity = Integer.parseInt(orderViewPositionModel.getProductPlan());
        if (quantity > 0 && diff == 0) {
            strDiff = BaseStringImages.BOX_SCREEN_GREEN_CHECK_MARK;
            colorText = new Color(158, 158, 158, 255);
            colorCount = new Color(0, 0, 0, 255);
        } else {
            strDiff = BaseStringImages.BOX_SCREEN_RED_CHECK_MARK;
            colorText = new Color(239, 62, 66, 255);
            colorCount = colorText;
        }

        imageIcon = new Image();
        imageIcon.setImage(strDiff);
        imageIcon.size(16);
        logoTitle.getItems().add(imageIcon);

        headerTitle.getItems().add(logoTitle);

        Container productContainer = new Container();
        productContainer.setDirection(Direction.HORIZONTAL);


        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("productFullName");
        text.setContent(bindingProperty);
        text.setFontSize(16);
        text.paddingHorizontal(4);
        text.setTextAlign(TextAlign.Center);
        text.width(230);
        productContainer.getItems().add(text);

        spacer = new Spacer();
        spacer.paddingHorizontal(2);
        productContainer.getItems().add(spacer);

        headerTitle.getItems().add(productContainer);

        header.getItems().add(headerTitle);

        spacer = new Spacer();
        spacer.paddingVertical(8);
        header.getItems().add(spacer);

        Container imageContainer = new Container();
        imageContainer.setDirection(Direction.HORIZONTAL);


        if (Objects.nonNull(orderViewPositionModel.getLinkBack())) {
            Container backArrowContainer = new Container();
            Image image = new Image();
            image.setImage(BaseStringImages.BACK_ARROW);
            image.width(30).heigth(34);
            Action action = new Action();
            action.setActionUri(
                    String.format(
                            "%s/%s?args=%s",
                            UrlHelper.getUrlToCurrentResource(),
                            WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_VIEW_POSITION.getWarehouseScreen(),
                            orderViewPositionModel.getLinkBack())
            );
            image.setClickAction(action);
            backArrowContainer.paddingVertical(150);
            backArrowContainer.getItems().add(image);
            imageContainer.getItems().add(backArrowContainer);
        } else {
            spacer = new Spacer();
            spacer.width(30);
            imageContainer.getItems().add(spacer);
        }


        Image image = new Image();
        BindingProperty imageProperty = new BindingProperty();
        imageProperty.setSelfContained(false);
        imageProperty.setValue("imageUrl");
        image.setUrl(imageProperty);
        image.width(302).heigth(335);
        imageContainer.getItems().add(image);

        if (Objects.nonNull(orderViewPositionModel.getLinkForward())) {
            Container forwardArrowContainer = new Container();
            image = new Image();
            image.setImage(BaseStringImages.FORWARD_ARROW);
            image.width(30).heigth(34);
            Action action = new Action();
            action.setActionUri(
                    String.format(
                            "%s/%s?args=%s",
                            UrlHelper.getUrlToCurrentResource(),
                            WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_VIEW_POSITION.getWarehouseScreen(),
                            orderViewPositionModel.getLinkForward())
            );
            image.setClickAction(action);
            forwardArrowContainer.paddingVertical(150);
            forwardArrowContainer.getItems().add(image);
            imageContainer.getItems().add(forwardArrowContainer);
        }

        spacer = new Spacer();
        spacer.width(100);
        quantityContainer.getItems().add(spacer);

        Text quantityText = new Text();
        quantityText.setFontWeight(FontWeight.W500);
        quantityText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("productPlanLabel");
        quantityText.setContent(bindingProperty);
        quantityText.heigth(20);
        quantityContainer.getItems().add(quantityText);

        quantityText = new Text();
        quantityText.setFontWeight(FontWeight.W500);
        quantityText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("productPlan");
        quantityText.setContent(bindingProperty);
        quantityText.heigth(20);
        quantityText.paddingHorizontal(2);
        quantityContainer.getItems().add(quantityText);

        spacer = new Spacer();
        spacer.paddingHorizontal(2);
        quantityContainer.getItems().add(spacer);

        Text quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.W500);
        quantityFactText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("productFactLabel");
        quantityFactText.setContent(bindingProperty);
        quantityFactText.heigth(20);
        quantityContainer.getItems().add(quantityFactText);

        quantityFactText = new Text();
        quantityFactText.setFontWeight(FontWeight.W500);
        quantityFactText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("productFact");
        quantityFactText.setContent(bindingProperty);
        quantityFactText.heigth(20);
        quantityFactText.paddingHorizontal(2);
        quantityContainer.getItems().add(quantityFactText);

        quantityContainer.getItems().add(spacer);

        Text quantityDiffText = new Text();
        quantityDiffText.setFontWeight(FontWeight.W500);
        quantityDiffText.setColor(new Color(158, 158, 158, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("productDiffLabel");
        quantityDiffText.setContent(bindingProperty);
        quantityDiffText.heigth(20);
        quantityDiffText.setColor(colorText);
        quantityContainer.getItems().add(quantityDiffText);

        quantityDiffText = new Text();
        quantityDiffText.setFontWeight(FontWeight.W500);
        quantityDiffText.setColor(new Color(0, 0, 0, 255));
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("productDiff");
        quantityDiffText.setContent(bindingProperty);
        quantityDiffText.setColor(colorCount);
        quantityDiffText.heigth(20);
        quantityDiffText.paddingHorizontal(2);
        quantityContainer.getItems().add(quantityDiffText);

        header.getItems().add(imageContainer);

        spacer = new Spacer();
        spacer.heigth(14);
        header.getItems().add(spacer);

        header.getItems().add(quantityContainer);

        spacer = new Spacer();
        spacer.heigth(6);
        header.getItems().add(spacer);
        documentContainer.getItems().add(header);
    }
}
