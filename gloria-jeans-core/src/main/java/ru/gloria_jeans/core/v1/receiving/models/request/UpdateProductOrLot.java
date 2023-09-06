package ru.gloria_jeans.core.v1.receiving.models.request;

import java.io.Serializable;

public class UpdateProductOrLot implements Serializable {
    private String lotId;
    private String id;
    private String quantityFact;

    private String lineNumberLot;


    public UpdateProductOrLot() {
    }

    public UpdateProductOrLot(String lotId, String id, String quantityFact, String lineNumberLot) {
        this.lotId = lotId;
        this.id = id;
        this.quantityFact = quantityFact;
        this.lineNumberLot = lineNumberLot;
    }

    public String getLotId() {
        return lotId;
    }

    public void setLotId(String lotId) {
        this.lotId = lotId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantityFact() {
        return quantityFact;
    }

    public void setQuantityFact(String quantityFact) {
        this.quantityFact = quantityFact;
    }

    public String getLineNumberLot() {
        return lineNumberLot;
    }

    public void setLineNumberLot(String lineNumberLot) {
        this.lineNumberLot = lineNumberLot;
    }
}
