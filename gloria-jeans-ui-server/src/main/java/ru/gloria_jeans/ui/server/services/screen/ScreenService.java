package ru.gloria_jeans.ui.server.services.screen;

import ru.gloria_jeans.ui.server.jetpackcompose.control.DeviceInfo;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Screen;
import ru.gloria_jeans.ui.server.jetpackcompose.control.UserInfo;
import ru.gloria_jeans.ui.server.model.enums.ModalDialogAction;

import java.util.Objects;

public class ScreenService {
    private final IScreenService screenService;

    public ScreenService(IScreenService screenService) {
        this.screenService = screenService;
    }

    public Screen init() {
        return init(null, null, null, null);
    }

    public Screen init(Object payload) {
        return init(payload, null, null, null);
    }
    public Screen init(Object payload, ModalDialogAction modalDialogAction) {
        return init(payload, null, null, modalDialogAction);
    }

    public Screen init(Object payload, UserInfo userInfo, ModalDialogAction modalDialogAction) {
        return init(payload, null, userInfo, modalDialogAction);
    }

    public Screen init(Object payload, DeviceInfo deviceInfo, ModalDialogAction modalDialogAction) {
        return init(payload, deviceInfo, null, modalDialogAction);
    }

    public Screen init(Object payload, DeviceInfo deviceInfo, UserInfo userInfo, ModalDialogAction modalDialogAction) {
        Screen screen = screenService.getScreen(payload, deviceInfo, userInfo);

        if (Objects.nonNull(screen.getModalDialog()) && Objects.nonNull(modalDialogAction) && ModalDialogAction.CLOSE == modalDialogAction) {
            screen.getModalDialog().setShowModal(false);
            screen.showControls();
            screen.setSignal(null);
        }

        return screen;
    }
    public void doBack(Object payload) {
        screenService.doBack(payload);
    }

}
