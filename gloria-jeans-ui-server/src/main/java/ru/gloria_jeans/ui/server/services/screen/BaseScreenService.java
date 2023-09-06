package ru.gloria_jeans.ui.server.services.screen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.ui.server.component.LocaleComponent;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DeviceInfo;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Screen;
import ru.gloria_jeans.ui.server.jetpackcompose.control.UserInfo;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.Locale;

@Service
public class BaseScreenService implements IScreenService {
    public Logger logger = LoggerFactory.getLogger("ScreenService");
    private MessageSource messageSource;
    private Locale locale;
    private LocaleComponent localeComponent;

    public BaseScreenService(LocaleComponent localeComponent) {
        this.localeComponent = localeComponent;
    }

    @Autowired
    public BaseScreenService(@Value("${base-server-url}") String baseServerUrl) {
        UrlHelper.setBaseServerUrl(baseServerUrl);
    }

    @Override
    public Screen getScreen(Object payload, DeviceInfo deviceInfo, UserInfo userInfo) {
        Screen screen = new Screen();
        DataContext dataContext = new DataContext();
        dataContext.setHeaderTitle(localeComponent.locale("main.title"));
        dataContext.setFooterText(localeComponent.locale("main.footer"));
        screen.setDataContext(dataContext);
        return screen;
    }
    @Override
    public void doBack(Object payload) {
    }

}
