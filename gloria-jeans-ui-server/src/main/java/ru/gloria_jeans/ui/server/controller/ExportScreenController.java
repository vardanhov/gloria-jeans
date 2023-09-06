package ru.gloria_jeans.ui.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Screen;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.export.ExportDataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.export.ExportMovingListDataContext;
import ru.gloria_jeans.ui.server.model.enums.ModalDialogAction;
import ru.gloria_jeans.ui.server.services.screen.ExportScreenService;
import ru.gloria_jeans.ui.server.services.screen.ScreenService;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

@RestController
@RequestMapping("/screen/warehouse")
public class ExportScreenController {
    private final ExportScreenService exportScreenService;

    @Autowired
    public ExportScreenController(ExportScreenService exportScreenService) {
        this.exportScreenService = exportScreenService;
        UrlHelper.setCurrentResource("warehouse");
    }

    //Вывоз
    @RequestMapping(
            path = "/export",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getExportScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody ExportDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("export");
        ScreenService screenService = new ScreenService(exportScreenService);
        return screenService.init();
    }

    //Вывоз. Список Перемещений
    @RequestMapping(
            path = "/export/moving/list",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getExportMovingListScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody ExportMovingListDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("export_moving_list");
        ScreenService screenService = new ScreenService(exportScreenService);
        return screenService.init();
    }
//Вывоз. Создание коробки
    @RequestMapping(
            path = "/export/collect/box",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen createBox(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody ExportMovingListDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("export_collect_box");
        ScreenService screenService = new ScreenService(exportScreenService);
        return screenService.init();
    }
}
