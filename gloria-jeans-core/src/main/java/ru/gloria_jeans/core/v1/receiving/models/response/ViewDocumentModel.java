package ru.gloria_jeans.core.v1.receiving.models.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

import java.util.ArrayList;
import java.util.List;

public class ViewDocumentModel extends BaseResponse {
    private DocumentResultSearchModel viewDocument;
    private List<ViewDocumentBoxModel> boxes = new ArrayList<>();

    public DocumentResultSearchModel getViewDocument() {
        return viewDocument;
    }

    public void setViewDocument(DocumentResultSearchModel viewDocument) {
        this.viewDocument = viewDocument;
    }

    public List<ViewDocumentBoxModel> getBoxes() {
        return boxes;
    }

    public void setBoxes(List<ViewDocumentBoxModel> boxes) {
        this.boxes = boxes;
    }
}
