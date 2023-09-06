package ru.gloria_jeans.ui.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Screen;
import ru.gloria_jeans.ui.server.services.screen.ScreenService;
import ru.gloria_jeans.ui.server.services.screen.WarehouseScreenService;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

@RestController
@RequestMapping("/screen/warehouse")
public class WarehouseScreenController {
    private final WarehouseScreenService warehouseScreenService;

    @Autowired
    public WarehouseScreenController(WarehouseScreenService warehouseScreenService) {
        this.warehouseScreenService = warehouseScreenService;
        UrlHelper.setCurrentResource("warehouse");
    }

    //Главное меню
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getWarehouseMainScreen() {
        UrlHelper.setCurrentScreen("main");
        ScreenService screenService = new ScreenService(warehouseScreenService);
        return screenService.init();
    }

    //Главное меню
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getWarehouseMainScreen(@RequestBody DataContext dataContext) {
        UrlHelper.setCurrentScreen("main");
        ScreenService screenService = new ScreenService(warehouseScreenService);
        return screenService.init();
    }
}
