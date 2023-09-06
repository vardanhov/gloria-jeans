package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModalView {
    private String modalHeader = StringUtils.EMPTY;
    private String modalText = StringUtils.EMPTY;
    private ActionData okData;
    private ActionData cancelData;
    private boolean showModal = true;

    public ModalView(String modalHeader, String modalText, ActionData okData, ActionData cancelData, boolean showModal) {
        this.modalHeader = modalHeader;
        this.modalText = modalText;
        this.okData = okData;
        this.cancelData = cancelData;
        this.showModal = showModal;
    }

    public String getModalHeader() {
        return modalHeader;
    }

    public void setModalHeader(String modalHeader) {
        this.modalHeader = modalHeader;
    }

    public String getModalText() {
        return modalText;
    }

    public void setModalText(String modalText) {
        this.modalText = modalText;
    }

    public ActionData getOkData() {
        return okData;
    }

    public void setOkData(ActionData okData) {
        this.okData = okData;
    }

    public ActionData getCancelData() {
        return cancelData;
    }

    public void setCancelData(ActionData cancelData) {
        this.cancelData = cancelData;
    }

    public boolean isShowModal() {
        return showModal;
    }

    public void setShowModal(boolean showModal) {
        this.showModal = showModal;
    }
}
