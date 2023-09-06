package ru.gloria_jeans.ui.server.jetpackcompose.helper;

import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

public class ModalDialogHelper {
    public static ModalDialog getModalDialogYesNo(String title, String message, String yesUrl, String noUrl) {
        ModalDialog modalDialog = new ModalDialog();
        BindingProperty headerBindingProperty = new BindingProperty();
        headerBindingProperty.setSelfContained(true);
        headerBindingProperty.setValue(title);

        BindingProperty messageBindingProperty = new BindingProperty();
        messageBindingProperty.setSelfContained(true);
        messageBindingProperty.setValue(message);

        Button button = new Button();
        BindingProperty buttonBindingProperty = new BindingProperty();
        buttonBindingProperty.setSelfContained(false);
        buttonBindingProperty.setValue("yesButtonText");
        Text buttonText = new Text();
        buttonText.setFontSize(14);
        buttonText.setColor(new Color(237, 62, 65,255));
        buttonText.setContent(buttonBindingProperty);
        Action action = new Action();
        action.setActionUri(yesUrl);
        button.width(115);
        button.background(new Color(255, 255, 255, 255));
        button.setContent(buttonText);
        button.setClickAction(action);
        modalDialog.getButtons().add(button);

        button = new Button();
        buttonBindingProperty = new BindingProperty();
        buttonBindingProperty.setSelfContained(false);
        buttonBindingProperty.setValue("noButtonText");
        buttonText = new Text();
        buttonText.setFontSize(14);
        buttonText.setColor(new Color(0, 0, 0,255));
        buttonText.setContent(buttonBindingProperty);
        action = new Action();
        action.setActionUri(noUrl);
        button.width(115);
        button.background(new Color(255, 255, 255, 255));
        button.setContent(buttonText);
        button.setClickAction(action);
        modalDialog.getButtons().add(button);

        modalDialog.setShowModal(true);
        modalDialog.setLocal(true);
        modalDialog.setMessage(messageBindingProperty);
        modalDialog.setHeader(headerBindingProperty);
        return modalDialog;
    }
    public static ModalDialog getModalDialogOk(String title, String message) {
        return getModalDialogOk(title, message, UrlHelper.getUrlToCurrentScreen().concat("?modalDialogAction=CLOSE"));
    }

    public static ModalDialog getModalDialogOk(String title, String message, String url) {
        BindingProperty headerBindingProperty = new BindingProperty();
        headerBindingProperty.setSelfContained(true);
        headerBindingProperty.setValue(title);

        BindingProperty messageBindingProperty = new BindingProperty();
        messageBindingProperty.setSelfContained(true);
        messageBindingProperty.setValue(message);

        Button button = new Button();
        BindingProperty buttonBindingProperty = new BindingProperty();
        buttonBindingProperty.setSelfContained(true);
        buttonBindingProperty.setValue("OK");
        Text buttonText = new Text();
        buttonText.setContent(buttonBindingProperty);
        Action action = new Action();
        action.setActionUri(url);
        button.setContent(buttonText);
        button.setClickAction(action);
        button.fillMaxWidth();

        ModalDialog modalDialog = new ModalDialog();
        modalDialog.setShowModal(true);
        modalDialog.setLocal(true);
        modalDialog.setMessage(messageBindingProperty);
        modalDialog.setHeader(headerBindingProperty);
        modalDialog.getButtons().add(button);
        return modalDialog;
    }
}
