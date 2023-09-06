package ru.gloria_jeans.core.v1.receiving.models.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.ArrayList;
import java.util.List;

public class DocumentResultSearchListModel extends BaseResponse {
    private List<DocumentResultSearchModel> documentResultSearchModels = new ArrayList<>();

    public DocumentResultSearchListModel(){}

    public DocumentResultSearchListModel(List<DocumentResultSearchModel> documentResultSearchModels) {
        this.documentResultSearchModels = documentResultSearchModels;
    }

    public List<DocumentResultSearchModel> getDocumentResultSearchModels() {
        return documentResultSearchModels;
    }

    public void setDocumentResultSearchModels(List<DocumentResultSearchModel> documentResultSearchModels) {
        this.documentResultSearchModels = documentResultSearchModels;
    }
}
