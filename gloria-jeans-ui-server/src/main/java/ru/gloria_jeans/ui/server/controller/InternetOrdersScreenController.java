package ru.gloria_jeans.ui.server.controller;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gloria_jeans.core.v1.orders.enums.ReasonAbsence;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.control.Screen;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders.*;
import ru.gloria_jeans.ui.server.model.enums.ModalDialogAction;
import ru.gloria_jeans.ui.server.services.screen.InternetOrdersScreenService;
import ru.gloria_jeans.ui.server.services.screen.ScreenService;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.util.Objects;

@RestController
@RequestMapping("/screen/warehouse")
public class InternetOrdersScreenController {
    private final InternetOrdersScreenService internetOrdersScreenService;

    @Autowired
    public InternetOrdersScreenController(InternetOrdersScreenService internetOrdersScreenService) {
        this.internetOrdersScreenService = internetOrdersScreenService;
        UrlHelper.setCurrentResource("warehouse");
    }

    //Складские операции. Интернет заказ
    @RequestMapping(
            path = "/internet/orders",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getInternetOrderScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init();
    }

    //Складские операции. Интернет заказ. Принять C&C
    @RequestMapping(
            path = "/internet/orders/accept/click/collect",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getInternetOrderAcceptClickAndCollect(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderSearchDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_accept_click_collect");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Принять C&C. Подтверждение
    @RequestMapping(
            path = "/internet/orders/accept/click/collect/confirm",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getInternetOrderAcceptClickAndCollectConfirm(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderAcceptClickAndCollectConfirmDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_accept_click_collect_confirm");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Собрать заказ
    @RequestMapping(
            path = "/internet/orders/collect/orders",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getResultCollectOrders(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(value = "back", required = false) Boolean back,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderCollectOrdersDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_collect_orders");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);

        if (Objects.nonNull(back)){

            screenService.doBack(dataContext);
        }


        return screenService.init();
    }

    //Складские операции. Интернет заказ. Собрать заказ. Содержимое заказа
    @RequestMapping(
            path = "/internet/orders/collect/orders/content/order",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getContentOrder(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "updateUserId", required = false, defaultValue = "false") Boolean updateUserId,
            @RequestBody InternetOrderCollectOrdersContentOrderDataContext dataContext
    ) {
        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setDocumentNumber(args);
        }

        if (!Strings.isNullOrEmpty(userId)) {
            dataContext.setUserId(userId);
        } else {
            dataContext.setUserId(deviceSerial);
        }
        dataContext.setScanType(scanType);
        dataContext.setScanData(scanData);
        dataContext.setUpdateUserId(updateUserId);
        UrlHelper.setCurrentScreen("internet_orders_collect_orders_content_order", dataContext);
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }
    @RequestMapping(
            path = "internet/orders/collect/orders/content/order/after/packages",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getContentOrderAfterPackages(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "updateUserId", required = false, defaultValue = "false") Boolean updateUserId,
            @RequestBody InternetOrderCollectOrdersPackagesDataContext dataContext
    ) {
        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setDocumentNumber(args);
        }

        if (!Strings.isNullOrEmpty(userId)) {
            dataContext.setUserId(userId);
        } else {
            dataContext.setUserId(deviceSerial);
        }
        dataContext.setScanType(scanType);
        dataContext.setScanData(scanData);
        dataContext.setUpdateUserId(updateUserId);
        UrlHelper.setCurrentScreen("internet_orders_collect_orders_content_order_after_packages");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Собрать заказ. Просмотр позиции
    @RequestMapping(
            path = "/internet/orders/collect/orders/view/position",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getViewPosition(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestParam(value = "orderItemId", required = false) String orderItemId,
            @RequestBody InternetOrderCollectOrdersViewPositionDataContext dataContext
    ) {

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setOrderItemId(args);
        }

        if (!Strings.isNullOrEmpty(orderItemId)) {
            dataContext.setOrderItemId(orderItemId);
        }

        dataContext.setScanType(scanType);
        dataContext.setScanData(scanData);
        UrlHelper.setCurrentScreen("internet_orders_collect_orders_view_position", dataContext);
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Собрать заказ. Меню заказа
    @RequestMapping(
            path = "/internet/orders/collect/orders/menu/order",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getCollectOrdersMenuOrder(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderCollectOrdersMenuOrderDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_collect_orders_menu_order");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Собрать заказ. Подтвердить сборку заказа
    @RequestMapping(
            path = "/internet/orders/collect/orders/confirm/assembly/order",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getConfirmAssemblyOrder(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderCollectOrdersConfirmAssemblyOrderDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_collect_orders_confirm_assembly_order");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Пакеты
    @RequestMapping(
            path = "/internet/orders/collect/orders/packages",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getPackages(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String employeeId,
            @RequestBody InternetOrderCollectOrdersPackagesDataContext dataContext
    ) {

        if (!Strings.isNullOrEmpty(employeeId)) {
            dataContext.setCollectorFullName(employeeId);
        }

        UrlHelper.setCurrentScreen("internet_orders_collect_orders_packages");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Пакеты. Изменить количество
    @RequestMapping(
            path = "internet/orders/collect/orders/packages/change/quantity",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen incrementPackage(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody InternetOrderCollectOrdersPackagesDataContext dataContext
    ) {
        if (args.contains("increment")) {
            switch (args){
                    case "smallincrement":
                        dataContext.setSmallPackageQuantity(String.valueOf(Integer.parseInt(dataContext.getSmallPackageQuantity()) + 1));
                        break;
                    case "mediumincrement":
                        dataContext.setMediumPackageQuantity(String.valueOf(Integer.parseInt(dataContext.getMediumPackageQuantity()) + 1));
                        break;
                    case "largeincrement":
                        dataContext.setLargePackageQuantity(String.valueOf(Integer.parseInt(dataContext.getLargePackageQuantity()) + 1));
                        break;
                };
            }
            if(args.contains("decrement")){
                switch (args){
                    case "smalldecrement":
                        if (Integer.parseInt(dataContext.getSmallPackageQuantity())<=0){
                            dataContext.setSmallPackageQuantity("0");
                        }
                        else{
                            dataContext.setSmallPackageQuantity(String.valueOf(Integer.parseInt(dataContext.getSmallPackageQuantity()) - 1));
                            break;
                        }

                    case "mediumdecrement":
                        if (Integer.parseInt(dataContext.getMediumPackageQuantity())<=0){
                            dataContext.setMediumPackageQuantity("0");
                        }
                        else{
                            dataContext.setMediumPackageQuantity(String.valueOf(Integer.parseInt(dataContext.getMediumPackageQuantity()) - 1));
                            break;
                        }
                        break;
                    case "largedecrement":
                        if (Integer.parseInt(dataContext.getLargePackageQuantity())<=0){
                            dataContext.setLargePackageQuantity("0");
                        }
                        else{
                            dataContext.setLargePackageQuantity(String.valueOf(Integer.parseInt(dataContext.getLargePackageQuantity()) - 1));
                            break;
                        }
                        break;
                };
            }


        UrlHelper.setCurrentScreen("internet_orders_collect_orders_packages_change_quantity");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }


    //Складские операции. Интернет заказ. Выдача курьеру
    @RequestMapping(
            path = "/internet/orders/courier/delivery",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getCourierDeliveryScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderCourierDeliveryDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_courier_delivery");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Выдача курьеру. Список заказов
    @RequestMapping(
            path = "/internet/orders/courier/delivery/orders/list",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getCourierDeliveryOrdersListScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String tk,
            @RequestBody InternetOrderSearchDataContext dataContext
    ) {
        dataContext.setScanType(scanType);
        dataContext.setScanData(Strings.isNullOrEmpty(scanData) ? "" : scanData.trim());
        dataContext.setHandleSearch(dataContext.getHandleSearch().trim());

        if (!Strings.isNullOrEmpty(tk)) {
            dataContext.setTk(tk);
        }

        UrlHelper.setCurrentScreen("internet_orders_courier_delivery_orders_list");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Возврат от курьера
    @RequestMapping(
            path = "/internet/orders/courier/return",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getCourierReturnScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderCourierReturnDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_courier_return");

        if (!Strings.isNullOrEmpty(scanData)) {
            dataContext.setHandleSearch(scanData);
        }

        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Расформирование заказа. Окно поиска
    @RequestMapping(
            path = "/internet/orders/order/disbandment",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getOrderDisbandmentScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderSearchDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_order_disbandment");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Расформирование заказа. Расформирование
    @RequestMapping(
            path = "/internet/orders/order/disbandment/result",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen orderDisbandment(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestHeader(value = "Scan-LDATA_TYPE", required = false) String scanType,
            @RequestHeader(value = "Scan-LDATA_STRING", required = false) String scanData,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderSearchDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_order_disbandment_result");
        dataContext.setScanType(scanType);
        dataContext.setScanData(scanData);
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Информация по заказу
    @RequestMapping(
            path = "/internet/orders/order/information",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getOrderInformationScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderOrderInformationDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_order_information");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Информация по заказу. Список заказов
    @RequestMapping(
            path = "/internet/orders/order/information/orders/list",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getOrderInformationOrdersListScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody DataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_order_information_orders_list");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Информация о заказе
    @RequestMapping(
            path = "/internet/orders/information/about/order",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getInformationAboutOrderScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody InternetOrderInformationAboutOrderDataContext dataContext
    ) {

        if(!Strings.isNullOrEmpty(args)) {
            dataContext.setOrderBarcode(args);
        }

        UrlHelper.setCurrentScreen("internet_orders_information_about_order");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Складские операции. Интернет заказ. Информация о заказе. Меню заказа
    @RequestMapping(
            path = "/internet/orders/information/about/order/menu/order",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getInformationAboutOrderMenuOrderScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderInformationAboutOrderMenuOrderDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_information_about_order_menu_order");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    //Поставка. Выбор сотрудника
    @RequestMapping(
            path = "/internet/orders/employees/list",
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
            @RequestBody InternetOrderCollectOrdersContentOrderDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_employees_list");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/internet/orders/order/check_current_user_id",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen getCheckCurrentUserIdScreen(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderCollectOrdersContentOrderDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_check_current_user_id");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/internet/orders/clear/fact/position",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen clearFactPosition(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) String args,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderCollectOrdersContentOrderDataContext dataContext
    ) {
        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setOrderItemId(args);
        }

        UrlHelper.setCurrentScreen("internet_orders_clear_fact_position");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }
    @RequestMapping(
            path = "/internet/orders/change/quantity",
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
            @RequestBody InternetOrderChangeQuantityDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_change_quantity");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setOrderItemId(args);
        }

        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/internet/orders/change/quantity/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen saveFactQuantity(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderChangeQuantityDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_change_quantity_update");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/internet/orders/delete/position",
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
            @RequestBody InternetOrderCollectOrdersContentOrderDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_delete_position");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setOrderItemId(args);
        }

        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/internet/orders/confirmation/document",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen acceptanceDocument(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody InternetOrderCollectOrdersPackagesDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_confirmation_document");

        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setDocumentNumber(args);
        }

        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/internet/orders/finish/issuing/orders",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen finishIssuingOrders(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderSearchDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_finish_issuing_orders");

        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/internet/orders/return/complete",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen returnComplete(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestBody InternetOrderCourierReturnDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_return_complete");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }
    @RequestMapping(
            path = "internet/orders/causes/of/not/assembly",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen causesOfNotAssembly(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody InternetOrderCausesOfNotAssemblyDataContext dataContext
    ) {
        if (!Strings.isNullOrEmpty(args)) {
            dataContext.setOrderItemId(args);
        }
        UrlHelper.setCurrentScreen("internet_orders_causes_of_not_assembly");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }
    @RequestMapping(
            path = "/internet/orders/causes/of/not/assembly/after/choice",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen causesOfNotAssemblyAfterChoice(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) ReasonAbsence args,
            @RequestBody InternetOrderCausesOfNotAssemblyDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_causes_of_not_assembly_after_choice");
        if (!Objects.isNull(args)) {
            dataContext.setReason(args);
        }

        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

    @RequestMapping(
            path = "/internet/orders/check/acceptance/document",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.ALL_VALUE
    )
    public Screen checkAcceptanceDocument(
            @RequestHeader("Device-Serial") String deviceSerial,
            @RequestHeader("Device-Model") String deviceModel,
            @RequestHeader("Device-Manufacturer") String deviceManufacturer,
            @RequestParam(required = false) ModalDialogAction modalDialogAction,
            @RequestParam(required = false) String args,
            @RequestBody InternetOrderCollectOrdersContentOrderDataContext dataContext
    ) {
        UrlHelper.setCurrentScreen("internet_orders_check_acceptance_document");
        ScreenService screenService = new ScreenService(internetOrdersScreenService);
        return screenService.init(dataContext, modalDialogAction);
    }

}
