package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.product_information;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.core.v1.catalog.models.response.SizeRangeModel;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductInformationDataContext extends ProductInformationSearchDataContext {
    private String productName = Strings.EMPTY;
    private String markdown = Strings.EMPTY;
    private String priceLabel = Strings.EMPTY;
    private String price = Strings.EMPTY;
    private String date = Strings.EMPTY;
    private String balanceLabel = Strings.EMPTY;
    private String balance = Strings.EMPTY;
    private String imageUrl = Strings.EMPTY;
    private String expandedHeader = Strings.EMPTY;
    private String remainsName = Strings.EMPTY;
    private String priceName = Strings.EMPTY;
    private String totalBalanceLabel = Strings.EMPTY;
    private String totalBalance = Strings.EMPTY;
    private String cityBalance = Strings.EMPTY;
    private List<SizeRangeModel> modelsBalanceList;
    private String selectedProductIdd;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public String getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(String priceLabel) {
        this.priceLabel = priceLabel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBalanceLabel() {
        return balanceLabel;
    }

    public void setBalanceLabel(String balanceLabel) {
        this.balanceLabel = balanceLabel;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getExpandedHeader() {
        return expandedHeader;
    }

    public void setExpandedHeader(String expandedHeader) {
        this.expandedHeader = expandedHeader;
    }

    public String getRemainsName() {
        return remainsName;
    }

    public void setRemainsName(String remainsName) {
        this.remainsName = remainsName;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public String getTotalBalanceLabel() {
        return totalBalanceLabel;
    }

    public void setTotalBalanceLabel(String totalBalanceLable) {
        this.totalBalanceLabel = totalBalanceLable;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getCityBalance() {
        return cityBalance;
    }

    public void setCityBalance(String cityBalance) {
        this.cityBalance = cityBalance;
    }

    public List<SizeRangeModel> getModelsBalanceList() {
        return modelsBalanceList;
    }

    public void setModelsBalanceList(List<SizeRangeModel> modelsBalanceList) {
        this.modelsBalanceList = modelsBalanceList;
    }

    public String getSelectedProductIdd() {
        return selectedProductIdd;
    }

    public void setSelectedProductIdd(String selectedProductIdd) {
        this.selectedProductIdd = selectedProductIdd;
    }
}
