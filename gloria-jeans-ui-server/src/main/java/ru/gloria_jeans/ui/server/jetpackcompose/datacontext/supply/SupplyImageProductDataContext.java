package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplyImageProductDataContext extends SupplyMenuProductDataContext {

    private String imageUrl = Strings.EMPTY;
    private String productTitle = Strings.EMPTY;

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
