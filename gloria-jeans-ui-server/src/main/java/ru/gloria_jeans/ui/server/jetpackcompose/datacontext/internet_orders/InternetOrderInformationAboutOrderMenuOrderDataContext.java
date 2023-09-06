package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import org.apache.logging.log4j.util.Strings;

public class InternetOrderInformationAboutOrderMenuOrderDataContext extends InternetOrderInformationAboutOrderDataContext {
    private String courierDeliveryButton = Strings.EMPTY;
    private String courierReturnButton = Strings.EMPTY;
    private String orderDisbandmentButton = Strings.EMPTY;

    public String getCourierDeliveryButton() {
        return courierDeliveryButton;
    }

    public void setCourierDeliveryButton(String courierDeliveryButton) {
        this.courierDeliveryButton = courierDeliveryButton;
    }

    public String getCourierReturnButton() {
        return courierReturnButton;
    }

    public void setCourierReturnButton(String courierReturnButton) {
        this.courierReturnButton = courierReturnButton;
    }

    public String getOrderDisbandmentButton() {
        return orderDisbandmentButton;
    }

    public void setOrderDisbandmentButton(String orderDisbandmentButton) {
        this.orderDisbandmentButton = orderDisbandmentButton;
    }
}
