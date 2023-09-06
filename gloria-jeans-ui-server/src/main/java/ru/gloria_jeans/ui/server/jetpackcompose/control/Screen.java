package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.Icon;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Screen {
    private List<Composable> items = new ArrayList<>();
    private ModalDialog modalDialog;
    private ScanAction scanAction;
    private Signal signal;
    private Header header;
    private Footer footer;
    private Object dataContext;

    public List<Composable> getItems() {
        return items;
    }

    public void setItems(List<Composable> items) {
        this.items = items;
    }

    public ModalDialog getModalDialog() {
        return modalDialog;
    }

    public void setModalDialog(ModalDialog modalDialog) {
        this.modalDialog = modalDialog;
    }

    public ScanAction getScanAction() {
        return scanAction;
    }

    public void setScanAction(ScanAction scanAction) {
        this.scanAction = scanAction;
    }

    public Signal getSignal() {
        return signal;
    }

    public void setSignal(Signal signal) {
        this.signal = signal;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public Object getDataContext() {
        return dataContext;
    }

    public void setDataContext(Object dataContext) {
        this.dataContext = dataContext;
    }

    public void hideControls() {
        for (Composable item : items) {
            item.hide();
        }
    }

    public void showControls() {
        for (Composable item : items) {
            item.show();
        }
    }

    public void initHeader() {
        Header header = new Header();

        IconButton iconButton = new IconButton();
        iconButton.setIcon(Icon.Back);
        Action action = new Action();
        action.setActionUri(UrlHelper.getUrlToBack());
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        Text text = new Text();
        BindingProperty bindingProperty = new BindingProperty();
        bindingProperty.setValue("headerTitle");
        text.setContent(bindingProperty);
        header.getContents().add(text);

        iconButton = new IconButton();
        iconButton.setIcon(Icon.Burger);
        action = new Action();
        action.setActionUri(UrlHelper.getUrlToCurrentScreen());
        iconButton.setClickAction(action);
        header.getContents().add(iconButton);

        this.setHeader(header);
    }

    public void initFooter() {
//        Footer footer = new Footer();
//        Text text = new Text();
//        BindingProperty bindingProperty = new BindingProperty();
//        bindingProperty.setValue("footerText");
//        text.setContent(bindingProperty);
//        footer.setContent(text);
//        this.setFooter(footer);
        this.setFooter(null);
    }
}
