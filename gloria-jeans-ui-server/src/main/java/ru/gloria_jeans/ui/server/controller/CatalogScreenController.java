package ru.gloria_jeans.ui.server.controller;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Screen;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.product_information.ProductInformationCityBalanceDataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.product_information.ProductInformationDataContext;
import ru.gloria_jeans.ui.server.model.enums.ModalDialogAction;
import ru.gloria_jeans.ui.server.services.screen.CatalogScreenService;
import ru.gloria_jeans.ui.server.services.screen.ScreenService;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

@RestController
@RequestMapping("/screen/warehouse")
public class CatalogScreenController {
    private final CatalogScreenService productInformationScreenService;

    @Autowired
    public CatalogScreenController(CatalogScreenService productInformationScreenService) {
        this.productInformationScreenService = productInformationScreenService;
        UrlHelper.setCurrentResource("warehouse");
    }

    //Информация о товаре. Поиск товара
    @RequestMapping(
            path = "/catalog/search/product",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getSearchProductScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody DataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("catalog_search_product");
        ScreenService screenService = new ScreenService(productInformationScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Информация о товаре. Товар
    @RequestMapping(
            path = "/catalog/product/information/result",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getProductInformationScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) String args,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody ProductInformationDataContext dataContext
    ) {
        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setHandleSearch(args);
        }

        if (!Strings.isNullOrEmpty(scanData)) {
            dataContext.setHandleSearch(scanData);
        }

        UrlHelper.setCurrentScreen("catalog_product_information_result");
        ScreenService screenService = new ScreenService(productInformationScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Информация о товаре. Увеличить картинку
    @RequestMapping(
            path = "/catalog/enlarge/product/image",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getEnlargedImageScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody ProductInformationDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("catalog_enlarge_product_image");
        ScreenService screenService = new ScreenService(productInformationScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }
    //Информация о товаре. Поиск товара по артикулу
    @RequestMapping(
            path = "catalog/search/product/by/vendor/code",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getSearchProductByVendorCodeScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody DataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("catalog_search_product_by_vendor_code");
        ScreenService screenService = new ScreenService(productInformationScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }
    @RequestMapping(
            path = "catalog/product/list",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getProductListScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody  ProductInformationDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("catalog_product_list");
        ScreenService screenService = new ScreenService(productInformationScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }
    @RequestMapping(
            path = "/get/{barcode}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Screen getProductFromProductListScreen(
            @PathVariable String barcode
    ) {
        UrlHelper.setCurrentScreen("catalog_product_from_list");
        ScreenService screenService = new ScreenService(productInformationScreenService);
        ProductInformationDataContext payload = new ProductInformationDataContext();
        payload.setBarcode(barcode);
        return productInformationScreenService.getProductInformationScreen(payload);
    }

    @RequestMapping(
            path = "catalog/product/get/models/balance",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getModelsBalance(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody ProductInformationDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("catalog_product_get_models_balance");
        ScreenService screenService = new ScreenService(productInformationScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "catalog/product/city/balance",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getCityBalance(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody ProductInformationCityBalanceDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("catalog_product_city_balance");
        ScreenService screenService = new ScreenService(productInformationScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }
}
