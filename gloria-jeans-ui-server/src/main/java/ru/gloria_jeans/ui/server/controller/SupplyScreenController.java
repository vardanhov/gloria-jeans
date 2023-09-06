package ru.gloria_jeans.ui.server.controller;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Screen;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply.*;
import ru.gloria_jeans.ui.server.model.enums.ModalDialogAction;
import ru.gloria_jeans.ui.server.services.screen.ScreenService;
import ru.gloria_jeans.ui.server.services.screen.SupplyScreenService;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.Objects;

@RestController
@RequestMapping("/screen/warehouse")
public class SupplyScreenController {
    private final SupplyScreenService supplyScreenService;

    @Autowired
    public SupplyScreenController(SupplyScreenService supplyScreenService) {
        this.supplyScreenService = supplyScreenService;
        UrlHelper.setCurrentResource("warehouse");
    }

    //Поставка. Поиск коробки
    @RequestMapping(
            path = "/supply/search/box",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getSearchBoxScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody SupplyDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_search_box");
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init();
    }

    //Поставка. Искать документ
    @RequestMapping(
            path = "/supply/search/document",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getSearchDocumentScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String status,
            @RequestBody SupplySearchDocumentDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_search_document");

        if (Objects.nonNull(status)) {
            dataContext.setDocumentStatus(status);
        }

        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext);
    }

    //Поставка. Результат поиска
    @RequestMapping(
            path = "/supply/result/search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getResultSearchScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody SupplySearchDocumentDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_result_search");
        dataContext.setScanType(scanType);
        dataContext.setScanData(scanData);
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext);
    }

    //Поставка. Просмотр документа
    @RequestMapping(
            path = "/supply/view/document",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getSupplyViewDocument(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody SupplyViewDocumentDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_view_document");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setSelectedDocumentIdd(args);
        }

        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext);
    }

    //Поставка. Пересчет коробки
    @RequestMapping(
            path = "/supply/recalculation/box",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getRecalculationBox(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestParam(required = false) boolean isShowTextField,
            @RequestBody SupplyRecalculationBoxDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_recalculation_box");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setBarcodeBox(args);
        }

        dataContext.setScanType(scanType);
        dataContext.setScanData(scanData);
        dataContext.setShowTextField(isShowTextField);
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Поставка. Пересчет коробки. Ввод данных на форме.
    @RequestMapping(
            path = "/supply/recalculation/box/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getRecalculationBoxUpdate(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) boolean isShowTextField,
            @RequestParam(required = false) String args,
            @RequestParam(required = false) Integer lineNumber,
            @RequestParam(required = false) boolean linkToOpenLot,
            @RequestBody SupplyRecalculationLotDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_recalculation_box_update");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setHandleSearch(args);
        }

        dataContext.setLineNumber(lineNumber);
        dataContext.setNotCountQuantityLot(linkToOpenLot);
        dataContext.setScanType(scanType);
        dataContext.setScanData(scanData);
        dataContext.setShowTextField(isShowTextField);
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Поставка. Пересчет лота
    @RequestMapping(
            path = "/supply/recalculation/lot",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getRecalculationLot(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestParam(required = false) boolean isShowTextField,
            @RequestParam(required = false) boolean buttonFinish,
            @RequestBody SupplyRecalculationLotDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_recalculation_lot");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setHandleSearch(args);
        }

        dataContext.setButtonFinish(buttonFinish);
        dataContext.setScanType(scanType);
        dataContext.setScanData(scanData);
        dataContext.setShowTextField(isShowTextField);
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Просмотр изображения товара
    @RequestMapping(
            path = "/supply/good/image",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getGoodImage(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody SupplyImageProductDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_good_image");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setSelectedProductId(args);
        }

        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Лист проблемных марок
    @RequestMapping(
            path = "/supply/list/problem/marks",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getListProblemMarks(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody SupplySearchDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_list_problem_marks");
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Поставка. Меню лист проблемных марок.
    @RequestMapping(
            path = "/supply/menu/list/problem/marks",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getMenuListProblemMarks(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody SupplySearchDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_menu_list_problem_marks");
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Подтверждение расхождений
    @RequestMapping(
            path = "/supply/confirm/discrepancy",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getConfirmDiscrepancy(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String idd,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String position,
            @RequestBody SupplyConfirmDiscrepancyDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_confirm_discrepancy");
        if (!Strings.isNullOrEmpty(id)) {
            dataContext.setId(id);
        }

        if (!Strings.isNullOrEmpty(idd)) {
            dataContext.setIdd(idd);
        }

        if (!Strings.isNullOrEmpty(fullName)) {
            dataContext.setFullName(fullName);
        }

        if (!Strings.isNullOrEmpty(position)) {
            dataContext.setPosition(position);
        }

        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/supply/confirm/discrepancy/popup",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getConfirmDiscrepansyPopup(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestBody SupplyConfirmDiscrepansyPopupDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_confirm_discrepancy_popup");
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext);
    }

    @RequestMapping(
            path = "/supply/confirm/acceptance/delivery/yes",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getConfirmAcceptanceDeliveryYes(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody SupplyConfirmDiscrepancyDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_confirm_acceptance_delivery_yes");
        dataContext.setAcceptBy(deviceModel);
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Изменить количество
    @RequestMapping(
            path = "/supply/change/quantity",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen changeQuantity(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody SupplyChangeQuantityDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_change_quantity");
        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setSelectedProductId(args);
        }
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Сохранить фактическое количество
    @RequestMapping(
            path = "/supply/change/quantity/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen saveFactQuantity(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody SupplyChangeQuantityDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_change_quantity_update");
        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/supply/clear/fact/position",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen clearFactPosition(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody SupplyMenuProductDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_clear_fact_position");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setSelectedProductId(args);
        }

        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/supply/clear/fact/all/positions",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen clearFactAllPositions(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody SupplyMenuProductDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_clear_fact_all_positions");

        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/supply/delete/position",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen deletePosition(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody SupplyMenuProductDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_delete_position");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setSelectedProductId(args);
        }

        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Поставка. Выбор сотрудника
    @RequestMapping(
            path = "/supply/employees/list",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getEmployeeListScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody SupplyConfirmDiscrepancyDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("supply_employees_list");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setSelectedTextField(args);
        }

        ScreenService screenService = new ScreenService(supplyScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }
}
