package ru.gloria_jeans.core.v1.catalog.models.request;

import java.io.Serializable;

public class SearchingProduct implements Serializable {
    private String barcode;

    public SearchingProduct() {
    }

    public SearchingProduct(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}

