package ru.gloria_jeans.core.v1.export.model;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.List;

public class ExportMovingDocumentListModel extends BaseResponse {

    private List<ExportMovingDocumentModel> exportMovingDocumentModelList;

    public ExportMovingDocumentListModel() {
    }

    public ExportMovingDocumentListModel(List<ExportMovingDocumentModel> exportMovingDocumentModelList) {
        this.exportMovingDocumentModelList = exportMovingDocumentModelList;
    }

    public List<ExportMovingDocumentModel> getExportMovingDocumentModelList() {
        return exportMovingDocumentModelList;
    }

    public void setExportMovingDocumentModelList(List<ExportMovingDocumentModel> exportMovingDocumentModelList) {
        this.exportMovingDocumentModelList = exportMovingDocumentModelList;
    }
}
