package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.List;

public class ScannedDocumentListModel extends BaseResponse {

    private List<ScannedDocumentModel> scannedDocumentModels;

    public ScannedDocumentListModel() {
    }

    public ScannedDocumentListModel(List<ScannedDocumentModel> scannedDocumentModels) {
        this.scannedDocumentModels = scannedDocumentModels;
    }

    public List<ScannedDocumentModel> getScannedDocumentModels() {
        return scannedDocumentModels;
    }

    public void setScannedDocumentModels(List<ScannedDocumentModel> scannedDocumentModels) {
        this.scannedDocumentModels = scannedDocumentModels;
    }
}
