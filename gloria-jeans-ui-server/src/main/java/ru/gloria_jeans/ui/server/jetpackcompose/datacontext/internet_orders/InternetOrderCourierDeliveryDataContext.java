package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderCourierDeliveryDataContext extends DataContext {
    private String scanBarcode = Strings.EMPTY;
    private String russianPost = Strings.EMPTY;
    private String cdek = Strings.EMPTY;
    private String pickup = Strings.EMPTY;
    private String pickPoint = Strings.EMPTY;


    public String getScanBarcode() {
        return scanBarcode;
    }

    public void setScanBarcode(String scanBarcode) {
        this.scanBarcode = scanBarcode;
    }

    public String getRussianPost() {
        return russianPost;
    }

    public void setRussianPost(String russianPost) {
        this.russianPost = russianPost;
    }

    public String getCdek() {
        return cdek;
    }

    public void setCdek(String cdek) {
        this.cdek = cdek;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getPickPoint() {
        return pickPoint;
    }

    public void setPickPoint(String pickPoint) {
        this.pickPoint = pickPoint;
    }
}
