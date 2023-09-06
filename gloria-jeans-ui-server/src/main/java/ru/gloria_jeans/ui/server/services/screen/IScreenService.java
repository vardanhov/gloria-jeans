package ru.gloria_jeans.ui.server.services.screen;

import org.springframework.stereotype.Service;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DeviceInfo;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Screen;
import ru.gloria_jeans.ui.server.jetpackcompose.control.UserInfo;

@Service
public interface IScreenService {
    Screen getScreen(Object payload, DeviceInfo deviceInfo, UserInfo userInfo);
    void doBack(Object payload);
}
