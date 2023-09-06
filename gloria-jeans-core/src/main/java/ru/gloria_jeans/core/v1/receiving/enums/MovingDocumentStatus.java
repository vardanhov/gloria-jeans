package ru.gloria_jeans.core.v1.receiving.enums;

public enum MovingDocumentStatus {
    NEW(
            "warehouse.supply.result.search.document.status.new"
    ),
    READY(
            "warehouse.supply.result.search.document.status.ready"
    ),
    IN_WORK(
            "warehouse.supply.result.search.document.status.in_work"
    );


    private String locale;

    MovingDocumentStatus(String locale) {
        this.locale = locale;
    }


    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
