package ru.gloria_jeans.ui.server.services.screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.ui.server.component.LocaleComponent;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DeviceInfo;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Screen;
import ru.gloria_jeans.ui.server.jetpackcompose.control.UserInfo;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.warehouse.WarehouseMainDataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.WarehouseMainScreenView;
import ru.gloria_jeans.ui.server.services.ReceivingService;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.Objects;


@Service
public class WarehouseScreenService extends BaseScreenService {
    private final LocaleComponent localeComponent;

    @Autowired
    public WarehouseScreenService(
            @Value("${base-server-url}") String baseServerUrl,
            ReceivingService receivingService,
            LocaleComponent localeComponent
    ) {
        super(baseServerUrl);
        this.localeComponent = localeComponent;
    }

    @Override
    public Screen getScreen(Object payload, DeviceInfo deviceInfo, UserInfo userInfo) {
        Screen screen = null;

        switch (WarehouseScreen.valueOf(UrlHelper.getCurrentScreen().toUpperCase())) {
            case MAIN:
                screen = new WarehouseMainScreenView();
                WarehouseMainDataContext dataContext = new WarehouseMainDataContext();
                dataContext.setSupplyButtonLabel(localeComponent.locale("warehouse.main.screen.supply"));
                dataContext.setExportButtonLabel(localeComponent.locale("warehouse.main.screen.export"));
                dataContext.setItemInformationButtonLabel(localeComponent.locale("warehouse.main.screen.item.information"));
                dataContext.setInventoryButtonLabel(localeComponent.locale("warehouse.main.screen.inventory"));
                dataContext.setInternetOrderButtonLabel(localeComponent.locale("warehouse.main.screen.internet.order"));
                dataContext.setHeaderTitle(localeComponent.locale("warehouse.main.screen.title"));
                dataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                screen.setDataContext(dataContext);
                break;
        }

        if (Objects.nonNull(screen)) {
            screen.initHeader();
            screen.initFooter();
        }

        return screen;
    }
}