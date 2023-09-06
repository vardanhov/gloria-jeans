package ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gloria_jeans.core.v1.receiving.models.response.EmployeeModel;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.List;

public class SupplyEmployeeListScreenView extends Screen {
    @JsonIgnore
    private Container mainContainer;

    public SupplyEmployeeListScreenView() {
        mainContainer = new Container();
        mainContainer.setHasScroll(true);

        Container backspace = new Container();
        backspace.paddingVertical(15);

        mainContainer.getItems().add(backspace);

        getItems().add(mainContainer);
    }

    public void createEmployeeList(List<EmployeeModel> employeeModels) {
        Container employeeContainer = new Container();
        employeeContainer.setHasScroll(false);
        employeeContainer.paddingHorizontal(10).paddingVertical(10);

        for (EmployeeModel employee : employeeModels) {
            Container container = new Container();
            container.setDirection(Direction.VERTICAL);
            container.paddingHorizontal(16)
                    .paddingVertical(2)
                    .width(322);

            Text text = new Text();
            BindingProperty bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(employee.getFio());
            text.setContent(bindingProperty);
            text.setFontSize(14);
            text.setFontWeight(FontWeight.W500);
            container.getItems().add(text);

            text = new Text();
            bindingProperty = new BindingProperty();
            bindingProperty.setSelfContained(true);
            bindingProperty.setValue(employee.getPosition());
            text.setContent(bindingProperty);
            text.setTextAlign(TextAlign.Right);
            text.width(322)
                    .heigth(24);
            text.setFontSize(14);
            text.setFontWeight(FontWeight.W500);
            container.getItems().add(text);

            Container lineContainer = new Container();
            lineContainer.paddingVertical(6)
                    .width(500)
                    .heigth(1)
                    .background(238, 238, 238, 255);

            container.getItems().add(lineContainer);

            Action action = new Action();
            action.setActionUri(
                    String.format(
                            "%s/%s?id=%s&idd=%s&fullName=%s&position=%s",
                            UrlHelper.getUrlToCurrentResource(),
                            WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen(),
                            employee.getId(),
                            employee.getIdd(),
                            employee.getFio(),
                            employee.getPosition()
                    )
            );

            container.setClickAction(action);

            mainContainer.getItems().add(container);
        }
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
                WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
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

        this.setHeader(header);
    }
}
