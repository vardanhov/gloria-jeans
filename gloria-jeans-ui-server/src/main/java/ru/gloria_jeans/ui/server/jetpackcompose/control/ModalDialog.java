package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModalDialog {
    private BindingProperty header;
    private BindingProperty message;
    private boolean showModal;
    private boolean local;
    private List<Button> buttons = new ArrayList<>();

    public BindingProperty getHeader() {
        return header;
    }

    public void setHeader(BindingProperty header) {
        this.header = header;
    }

    public BindingProperty getMessage() {
        return message;
    }

    public void setMessage(BindingProperty message) {
        this.message = message;
    }

    public boolean isShowModal() {
        return showModal;
    }

    public void setShowModal(boolean showModal) {
        this.showModal = showModal;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }
}
