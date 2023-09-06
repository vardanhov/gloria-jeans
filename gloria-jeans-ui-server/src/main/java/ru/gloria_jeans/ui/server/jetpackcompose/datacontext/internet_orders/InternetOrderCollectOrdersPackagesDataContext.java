package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.core.v1.orders.model.response.OrderPackageItemModel;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderCollectOrdersPackagesDataContext extends InternetOrderCollectOrdersContentOrderDataContext {
    private String smallPackageButtonText = Strings.EMPTY;
    private String smallPackageQuantity = "0";
    private String mediumPackageButtonText = Strings.EMPTY;
    private String mediumPackageQuantity = "0";
    private String largePackageButtonText = Strings.EMPTY;
    private String largePackageQuantity = "0";
    private String confirmButtonText = Strings.EMPTY;
    private String packageName = Strings.EMPTY;
    private String packageQuantityLabel = Strings.EMPTY;
    private String packageQuantity = Strings.EMPTY;
    List<OrderPackageItemModel> packages = new ArrayList<>();

    public String getSmallPackageButtonText() {
        return smallPackageButtonText;
    }

    public void setSmallPackageButtonText(String smallPackageButtonText) {
        this.smallPackageButtonText = smallPackageButtonText;
    }

    public String getMediumPackageButtonText() {
        return mediumPackageButtonText;
    }

    public void setMediumPackageButtonText(String mediumPackageButtonText) {
        this.mediumPackageButtonText = mediumPackageButtonText;
    }

    public String getLargePackageButtonText() {
        return largePackageButtonText;
    }

    public void setLargePackageButtonText(String largePackageButtonText) {
        this.largePackageButtonText = largePackageButtonText;
    }

    public String getConfirmButtonText() {
        return confirmButtonText;
    }

    public void setConfirmButtonText(String confirmButtonText) {
        this.confirmButtonText = confirmButtonText;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageQuantityLabel() {
        return packageQuantityLabel;
    }

    public void setPackageQuantityLabel(String packageQuantityLabel) {
        this.packageQuantityLabel = packageQuantityLabel;
    }

    public String getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(String packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getSmallPackageQuantity() {
        return smallPackageQuantity;
    }

    public void setSmallPackageQuantity(String smallPackageQuantity) {
        this.smallPackageQuantity = smallPackageQuantity;
    }

    public String getMediumPackageQuantity() {
        return mediumPackageQuantity;
    }

    public void setMediumPackageQuantity(String mediumPackageQuantity) {
        this.mediumPackageQuantity = mediumPackageQuantity;
    }

    public String getLargePackageQuantity() {
        return largePackageQuantity;
    }

    public void setLargePackageQuantity(String largePackageQuantity) {
        this.largePackageQuantity = largePackageQuantity;
    }

    public List<OrderPackageItemModel> getPackages() {
        return packages;
    }

    public void setPackages(List<OrderPackageItemModel> packages) {
        this.packages = packages;
    }
}
