package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders;


import ru.gloria_jeans.core.v1.orders.enums.ReasonAbsence;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class InternetOrderCausesOfNotAssembly extends Screen {
    private String backUrl;
    public InternetOrderCausesOfNotAssembly(String backUrl){
        setBackUrl(backUrl);
        Container mainContainer = new Container();
        mainContainer.setHasScroll(true);

        Button button = new Button();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("defectCause");
        bindingProperty.setSelfContained(false);
        Text text = new Text();
        text.setContent(bindingProperty);
        Action action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s?args=%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_CAUSES_OF_NOT_ASSEMBLY_AFTER_CHOICE.getWarehouseScreen(),
                        ReasonAbsence.DEFECT
                )
        );
        button.width(360).heigth(65);
        button.background(new Color(255, 255, 255, 255));
        button.border(1, new Color(148, 163, 170, 200));
        button.setContent(text);
        button.setClickAction(action);
        mainContainer.getItems().add(button);

        button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("productNotFoundCause");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s?args=%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_CAUSES_OF_NOT_ASSEMBLY_AFTER_CHOICE.getWarehouseScreen(),
                        ReasonAbsence.PRODUCT_NOT_FOUND)
        );
        button.width(360).heigth(65);
        button.background(new Color(255, 255, 255, 255));
        button.border(1, new Color(148, 163, 170, 200));
        button.setContent(text);
        button.setClickAction(action);
        mainContainer.getItems().add(button);

        button = new Button();
        bindingProperty = new BindingProperty();
        bindingProperty.setValue("badMarkCause");
        bindingProperty.setSelfContained(false);
        text = new Text();
        text.setContent(bindingProperty);
        action = new Action();
        action.setActionUri(
                String.format(
                        "%s/%s?args=%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.INTERNET_ORDERS_CAUSES_OF_NOT_ASSEMBLY_AFTER_CHOICE.getWarehouseScreen(),
                        ReasonAbsence.PROBLEM_WITH_MARK
                )
        );
        button.width(360).heigth(65);
        button.background(new Color(255, 255, 255, 255));
        button.border(1, new Color(148, 163, 170, 200));
        button.setContent(text);
        button.setClickAction(action);
        mainContainer.getItems().add(button);


        getItems().add(mainContainer);

    }

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    @Override
    public void initHeader() {
        Header header = new Header();
        IconButton iconButton = new IconButton();
        iconButton.setIcon(Icon.Back);
        Action action = new Action();
        action.setActionUri(backUrl);
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);
        this.setHeader(header);
    }
}
