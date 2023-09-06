package ru.gloria_jeans.ui.server.services.screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.core.v1.export.model.ExportMovingDocumentModel;
import ru.gloria_jeans.ui.server.component.LocaleComponent;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DeviceInfo;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Screen;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Signal;
import ru.gloria_jeans.ui.server.jetpackcompose.control.UserInfo;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.export.ExportCollectBoxDataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.export.ExportDataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.export.ExportMovingListDataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.helper.ModalDialogHelper;
import ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.export.ExportCollectBoxView;
import ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.export.ExportMovingListScreenView;
import ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.export.ExportScreenView;
import ru.gloria_jeans.ui.server.services.ExportService;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ExportScreenService extends BaseScreenService {

    private final ExportService exportService;
    private final LocaleComponent localeComponent;
    private DateFormat dateFormat;

    @Autowired
    public ExportScreenService(
            @Value("${base-server-url}") String baseServerUrl,
            ExportService exportService,
            LocaleComponent localeComponent,
            Locale locale
    ) {
        super(baseServerUrl);
        this.exportService = exportService;
        this.localeComponent = localeComponent;
        this.dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
    }

    @Override
    public Screen getScreen(Object payload, DeviceInfo deviceInfo, UserInfo userInfo) {
        Screen screen = null;

        switch (WarehouseScreen.valueOf(UrlHelper.getCurrentScreen().toUpperCase())) {
            case EXPORT:
                screen = new ExportScreenView();
                ExportDataContext exportDataContext = new ExportDataContext();
                exportDataContext.setHeaderTitle(localeComponent.locale("warehouse.export.screen.title"));
                exportDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                exportDataContext.setMovementDecree(localeComponent.locale("warehouse.export.movement.decree.button.text"));
                exportDataContext.setMovement(localeComponent.locale("warehouse.export.movements.button.text"));
                exportDataContext.setMovementRequests(localeComponent.locale("warehouse.export.movement.request.button.text"));
                screen.setDataContext(exportDataContext);
                break;
            case EXPORT_MOVING_LIST:
                screen = getExportMovingListScreenView((ExportMovingListDataContext) payload);
                break;
            case EXPORT_COLLECT_BOX:
                screen = new ExportCollectBoxView();
                ExportCollectBoxDataContext dataContext = new ExportCollectBoxDataContext();
                dataContext.setClearBoxButtonText(localeComponent.locale("warehouse.export.clear.box.button.text"));
                dataContext.setCreateBoxButtonText(localeComponent.locale("warehouse.export.create.box.button.text"));
                dataContext.setBarcodeLabel(localeComponent.locale("warehouse.internet.order.collect.orders.content.order.barcode.label"));
                dataContext.setSearchButtonText(localeComponent.locale("warehouse.supply.search.screen.button"));
                dataContext.setHeaderTitle(localeComponent.locale("warehouse.export.create.box.title"));
                dataContext.setLabel(localeComponent.locale("warehouse.export.search.box.screen.barcode.label"));
                dataContext.setLabelUnderLabel(localeComponent.locale("warehouse.export.input.item.barcode.manually.label"));
                dataContext.setStaticTextLabel(localeComponent.locale("warehouse.export.static.text.date"));
                dataContext.setExportLabel(localeComponent.locale("warehouse.export.static.text.label"));
                dataContext.setDocumentNumber("9999999");
                dataContext.setExportDate("25.10.23");
                dataContext.setBoxNumber("999");
                screen.setDataContext(dataContext);
        }

        if (Objects.nonNull(screen)) {
            screen.initHeader();
            screen.initFooter();
        }

        return screen;
    }

    private Screen getExportMovingListScreenView(ExportMovingListDataContext payload) {
        ExportMovingListScreenView screen = new ExportMovingListScreenView();
        ExportMovingListDataContext exportDataContext = new ExportMovingListDataContext();
        exportDataContext.setHeaderTitle(localeComponent.locale("warehouse.export.moving.list.screen.title"));
        exportDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        exportDataContext.setMovingListCountLabel(localeComponent.locale("warehouse.export.moving.list.count.label"));
        exportDataContext.setFrom(localeComponent.locale("warehouse.supply.view.document.screen.header.from"));

        try {
            List<ExportMovingDocumentModel> result = exportService.getMovingDocumentList();
            screen.resultCount(result.size());
            screen.setTable(result
                    .parallelStream()
                    .map(x -> {
                        String[] row = new String[8];
                        row[0] = localeComponent.locale(x.getStatus());
                        row[1] = localeComponent.locale(x.getMoving());
                        row[2] = x.getAcceptanceDate() != null ? dateFormat.format(x.getAcceptanceDate()) : "-";
                        row[3] = x.getNumber().trim();
                        row[4] = dateFormat.format(x.getDateCreated());
                        row[5] = x.getPurpose();
                        row[6] = x.getConsigneeWarehouse();
                        row[7] = x.getBasis() != null ? x.getBasis() : "";
                        return row;
                    })
                    .collect(Collectors.toList())
                    .toArray(String[][]::new));
            screen.setDataContext(exportDataContext);
        } catch (Exception exception) {
            logger.error(
                    "Collect moving document throws exception.",
                    exception
            );
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.export.moving.list.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.EXPORT_MOVING_LIST.getWarehouseScreen()
                            )
                    )
            );
            screen.hideControls();
        }
        return screen;
    }
}
