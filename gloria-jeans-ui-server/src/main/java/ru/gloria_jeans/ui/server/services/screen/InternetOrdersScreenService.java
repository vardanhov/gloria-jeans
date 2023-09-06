package ru.gloria_jeans.ui.server.services.screen;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.core.v1.orders.enums.OrderStatus;
import ru.gloria_jeans.core.v1.orders.enums.OrderType;
import ru.gloria_jeans.core.v1.orders.model.response.*;
import ru.gloria_jeans.core.v1.receiving.models.response.EmployeeListModel;
import ru.gloria_jeans.ui.server.component.LocaleComponent;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.helper.ControlHelper;
import ru.gloria_jeans.ui.server.jetpackcompose.helper.ModalDialogHelper;
import ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.internet_orders.*;
import ru.gloria_jeans.ui.server.services.OrdersService;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class InternetOrdersScreenService extends BaseScreenService {

    @Value("${receiving.image}")
    String getImageUrl;
    @Value("${receiving.attribute}")
    String getImageAttribute;
    private final OrdersService ordersService;
    private final LocaleComponent localeComponent;
    private final DateFormat dateFormat;

    @Autowired
    public InternetOrdersScreenService(
            @Value("${base-server-url}") String baseServerUrl,
            OrdersService ordersService,
            Locale locale,
            LocaleComponent localeComponent
    ) {
        super(baseServerUrl);
        this.ordersService = ordersService;
        this.localeComponent = localeComponent;
        this.dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
    }

    @Override
    public Screen getScreen(Object payload, DeviceInfo deviceInfo, UserInfo userInfo) {
        Screen screen = null;

        switch (WarehouseScreen.valueOf(UrlHelper.getCurrentScreen().toUpperCase())) {
            case INTERNET_ORDERS:
                screen = new InternetOrderScreenView();
                InternetOrderDataContext internetOrderDataContext = new InternetOrderDataContext();
                internetOrderDataContext.setAcceptLabel(localeComponent.locale("warehouse.internet.order.screen.accept.button"));
                internetOrderDataContext.setCollectOrderLabel(localeComponent.locale("warehouse.internet.order.screen.collect_order.button"));
                internetOrderDataContext.setPassToCourierLabel(localeComponent.locale("warehouse.internet.order.screen.pass_to_courier.button"));
                internetOrderDataContext.setReturnFromCourierLabel(localeComponent.locale("warehouse.internet.order.screen.return_from_courier.button"));
                internetOrderDataContext.setDisbandOrderLabel(localeComponent.locale("warehouse.internet.order.screen.disband_order.button"));
                internetOrderDataContext.setOrderInformationLabel(localeComponent.locale("warehouse.internet.order.screen.order_information.button"));
                internetOrderDataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.screen.title"));
                internetOrderDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                screen.setDataContext(internetOrderDataContext);
                break;
            case INTERNET_ORDERS_ACCEPT_CLICK_COLLECT:
                screen = new InternetOrderAcceptClickAndCollectScreenView();
                InternetOrderSearchDataContext internetOrderSearchDataContext = new InternetOrderSearchDataContext();
                internetOrderSearchDataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.accept.click.collect.screen.title"));
                internetOrderSearchDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                internetOrderSearchDataContext.setBarcodeLabel(localeComponent.locale("warehouse.internet.order.accept.click.collect.screen.label"));
                screen.setDataContext(internetOrderSearchDataContext);
                break;
            case INTERNET_ORDERS_ACCEPT_CLICK_COLLECT_CONFIRM:
                screen = new InternetOrderAcceptClickAndCollectConfirmScreenView();
                InternetOrderAcceptClickAndCollectConfirmDataContext warehouseInternetOrderAcceptClickAndCollectConfirmDataContext = new InternetOrderAcceptClickAndCollectConfirmDataContext();
                warehouseInternetOrderAcceptClickAndCollectConfirmDataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.accept.click.collect.screen.title"));
                warehouseInternetOrderAcceptClickAndCollectConfirmDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                warehouseInternetOrderAcceptClickAndCollectConfirmDataContext.setConfirmLabel(localeComponent.locale("warehouse.internet.order.accept.click.collect.confirm.label"));
                warehouseInternetOrderAcceptClickAndCollectConfirmDataContext.setAcceptButton(localeComponent.locale("warehouse.internet.order.accept.click.collect.confirm.accept.button"));
                warehouseInternetOrderAcceptClickAndCollectConfirmDataContext.setCancelButton(localeComponent.locale("warehouse.internet.order.accept.click.collect.confirm.cancel.button"));
                screen.setDataContext(warehouseInternetOrderAcceptClickAndCollectConfirmDataContext);
                break;
            case INTERNET_ORDERS_COLLECT_ORDERS:
                screen = collectOrders((InternetOrderCollectOrdersDataContext) payload);
                break;
            case INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER:
                screen = getContentOrder((InternetOrderCollectOrdersContentOrderDataContext) payload);
                break;
            case INTERNET_ORDERS_COLLECT_ORDERS_MENU_ORDER:
                screen = new InternetOrderCollectOrdersMenuOrderScreenView();
                InternetOrderCollectOrdersMenuOrderDataContext internetOrderCollectOrdersMenuOrderDataContext = (InternetOrderCollectOrdersMenuOrderDataContext) payload;
                internetOrderCollectOrdersMenuOrderDataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.collect.orders.menu.order.title"));
                internetOrderCollectOrdersMenuOrderDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                internetOrderCollectOrdersMenuOrderDataContext.setConfirmAssemblyOrderButton(localeComponent.locale("warehouse.internet.order.collect.orders.menu.order.confirm.assembly.order.button"));
                internetOrderCollectOrdersMenuOrderDataContext.setQuantityPackagesButton(localeComponent.locale("warehouse.internet.order.collect.orders.menu.order.quantity.packages.button"));
                screen.setDataContext(internetOrderCollectOrdersMenuOrderDataContext);
                break;
            case INTERNET_ORDERS_COLLECT_ORDERS_CONFIRM_ASSEMBLY_ORDER:
                screen = new InternetOrderCollectOrdersConfirmAssemblyOrderScreenView();
                InternetOrderCollectOrdersConfirmAssemblyOrderDataContext warehouseInternetOrderCollectOrdersConfirmAssemblyOrderDataContext = (InternetOrderCollectOrdersConfirmAssemblyOrderDataContext) payload;
                warehouseInternetOrderCollectOrdersConfirmAssemblyOrderDataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.title"));
                warehouseInternetOrderCollectOrdersConfirmAssemblyOrderDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                warehouseInternetOrderCollectOrdersConfirmAssemblyOrderDataContext.setNomenclatureLabel(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.nomenclature"));
                warehouseInternetOrderCollectOrdersConfirmAssemblyOrderDataContext.setReasonForAbsenceLabel(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.absence.reason.label"));
                warehouseInternetOrderCollectOrdersConfirmAssemblyOrderDataContext.setReasonForAbsence(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.absence.reason"));
                warehouseInternetOrderCollectOrdersConfirmAssemblyOrderDataContext.setConfirmButton(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.confirm.button"));
                warehouseInternetOrderCollectOrdersConfirmAssemblyOrderDataContext.setCancelButton(localeComponent.locale("warehouse.internet.order.accept.click.collect.confirm.cancel.button"));
                screen.setDataContext(warehouseInternetOrderCollectOrdersConfirmAssemblyOrderDataContext);
                break;
            case INTERNET_ORDERS_COLLECT_ORDERS_PACKAGES:
                screen = getPackageScreenNew((InternetOrderCollectOrdersContentOrderDataContext) payload);
                break;
            case INTERNET_ORDERS_COLLECT_ORDERS_PACKAGES_CHANGE_QUANTITY:
                screen = getPackagesChangeQuantity((InternetOrderCollectOrdersPackagesDataContext) payload);
                break;
            case INTERNET_ORDERS_COURIER_DELIVERY:
                screen = new InternetOrderCourierDeliveryScreenView();
                InternetOrderCourierDeliveryDataContext dataContext = (InternetOrderCourierDeliveryDataContext) payload;
                dataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.courier.delivery.title"));
                dataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                dataContext.setScanBarcode(localeComponent.locale("warehouse.internet.order.courier.delivery.scan.barcode.button"));
                dataContext.setRussianPost(localeComponent.locale("warehouse.internet.order.courier.delivery.russian.post.button"));
                dataContext.setCdek(localeComponent.locale("warehouse.internet.order.courier.delivery.cdek.button"));
                dataContext.setPickup(localeComponent.locale("warehouse.internet.order.courier.delivery.pickup.button"));
                dataContext.setPickPoint(localeComponent.locale("warehouse.internet.order.courier.delivery.pick_point.button"));
                screen.setDataContext(dataContext);
                break;
            case INTERNET_ORDERS_COURIER_DELIVERY_ORDERS_LIST:
                screen = getCourierDeliveryOrdersList((InternetOrderSearchDataContext) payload);
                break;
            case INTERNET_ORDERS_COURIER_RETURN:
                screen = orderReturn((InternetOrderCourierReturnDataContext) payload);
                break;
            case INTERNET_ORDERS_RETURN_COMPLETE:
                screen = orderReturnComplete((InternetOrderCourierReturnDataContext) payload);
                break;
            case INTERNET_ORDERS_ORDER_DISBANDMENT:
                screen = new InternetOrderDisbandmentOrderScreenView();
                internetOrderSearchDataContext = (InternetOrderSearchDataContext) payload;
                internetOrderSearchDataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.disbandment.order.title"));
                internetOrderSearchDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                internetOrderSearchDataContext.setLabel(localeComponent.locale("warehouse.supply.search.box.screen.barcode.label"));
                internetOrderSearchDataContext.setLabelUnderLabel(localeComponent.locale("warehouse.internet.order.input.order.number.manually.label"));
                internetOrderSearchDataContext.setBarcodeLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.code_number"));
                internetOrderSearchDataContext.setSearchButtonText(localeComponent.locale("warehouse.supply.search.screen.button"));
                screen.setDataContext(internetOrderSearchDataContext);
                screen.setScanAction(
                        new ScanAction(
                                String.format(
                                        "%s/%s",
                                        UrlHelper.getUrlToCurrentResource(),
                                        WarehouseScreen.INTERNET_ORDERS_ORDER_DISBANDMENT_RESULT.getWarehouseScreen()
                                )
                        )
                );
                break;
            case INTERNET_ORDERS_ORDER_DISBANDMENT_RESULT:
                screen = orderDisbandment((InternetOrderSearchDataContext) payload);
                break;
            case INTERNET_ORDERS_ORDER_INFORMATION:
                screen = new InternetOrderOrderInformationScreenView();
                InternetOrderOrderInformationDataContext internetOrderOrderInformationDataContext = (InternetOrderOrderInformationDataContext) payload;
                internetOrderOrderInformationDataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.information.title"));
                internetOrderOrderInformationDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                internetOrderOrderInformationDataContext.setLabel(localeComponent.locale("warehouse.supply.search.document.screen.label"));
                internetOrderOrderInformationDataContext.setLabelUnderLabel(localeComponent.locale("warehouse.supply.search.document.screen.labelUnderLabel"));
                internetOrderOrderInformationDataContext.setDocumentNumberLabel(localeComponent.locale("warehouse.internet.order.information.order.document.number.label"));
                internetOrderOrderInformationDataContext.setDateFromLabel(localeComponent.locale("warehouse.supply.search.document.screen.date_from"));
                internetOrderOrderInformationDataContext.setDateToLabel(localeComponent.locale("warehouse.supply.search.document.screen.date_to"));
                internetOrderOrderInformationDataContext.setOrderTypeLabel(localeComponent.locale("warehouse.internet.order.information.order.type.label"));
                internetOrderOrderInformationDataContext.setOrderStatusLabel(localeComponent.locale("warehouse.internet.order.information.order.status.label"));
                internetOrderOrderInformationDataContext.setSearchButtonText(localeComponent.locale("warehouse.supply.search.screen.button"));
                internetOrderOrderInformationDataContext.setOrderBarcode(StringUtils.EMPTY);

                List<MultiSelectorItem> orderTypes = new ArrayList<>();
                List<OrderType> orderTypeList = new ArrayList<>(List.of(OrderType.values()));
                orderTypeList.remove(OrderType.EMPTY);
                orderTypeList.forEach(e -> orderTypes.add(new MultiSelectorItem(e.name(), localeComponent.locale(e.locale))));

                ((InternetOrderOrderInformationScreenView)screen).setStatusList(
                        orderTypes,
                        Arrays.stream(OrderStatus.values()).map(x -> {
                     return new MultiSelectorItem(x.name(), localeComponent.locale(x.getLocale()));
                }).collect(Collectors.toList()));

                screen.setDataContext(internetOrderOrderInformationDataContext);
                break;
            case INTERNET_ORDERS_ORDER_INFORMATION_ORDERS_LIST:
                screen = getOrderInformationOrdersList((DataContext) payload);
                break;
            case INTERNET_ORDERS_INFORMATION_ABOUT_ORDER:
                screen = getInformationAboutOrder((InternetOrderInformationAboutOrderDataContext) payload);
                break;
            case INTERNET_ORDERS_INFORMATION_ABOUT_ORDER_MENU_ORDER:
                screen = new InternetOrderInformationAboutOrderMenuOrderScreenView();
                InternetOrderInformationAboutOrderMenuOrderDataContext warehouseInternetOrderInformationAboutOrderMenuOrderDataContext = (InternetOrderInformationAboutOrderMenuOrderDataContext) payload;
                warehouseInternetOrderInformationAboutOrderMenuOrderDataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.information.about.order.menu.order.title"));
                warehouseInternetOrderInformationAboutOrderMenuOrderDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                warehouseInternetOrderInformationAboutOrderMenuOrderDataContext.setOrderLabel(localeComponent.locale("warehouse.internet.order.collect.orders.content.order.label"));
                warehouseInternetOrderInformationAboutOrderMenuOrderDataContext.setFrom(localeComponent.locale("warehouse.supply.view.document.screen.header.from"));
                warehouseInternetOrderInformationAboutOrderMenuOrderDataContext.setTransportCompanyLabel(localeComponent.locale("warehouse.internet.order.information.about.order.transport.company.label"));
                warehouseInternetOrderInformationAboutOrderMenuOrderDataContext.setFullNameLabel(localeComponent.locale("warehouse.internet.order.information.about.order.customer.name.label"));
                warehouseInternetOrderInformationAboutOrderMenuOrderDataContext.setOrderStatusLabel(localeComponent.locale("warehouse.internet.order.information.about.order.order.status.label"));
                warehouseInternetOrderInformationAboutOrderMenuOrderDataContext.setCourierDeliveryButton(localeComponent.locale("warehouse.internet.order.courier.delivery.title"));
                warehouseInternetOrderInformationAboutOrderMenuOrderDataContext.setCourierReturnButton(localeComponent.locale("warehouse.internet.order.courier.return.title"));
                warehouseInternetOrderInformationAboutOrderMenuOrderDataContext.setOrderDisbandmentButton(localeComponent.locale("warehouse.internet.order.disbandment.order.title"));
                screen.setDataContext(warehouseInternetOrderInformationAboutOrderMenuOrderDataContext);
                break;
            case INTERNET_ORDERS_EMPLOYEES_LIST:
                screen = getEmployeeList((InternetOrderCollectOrdersContentOrderDataContext) payload);
                break;
            case INTERNET_ORDERS_CHECK_ACCEPTANCE_DOCUMENT:
                screen = checkAcceptanceDocument((InternetOrderCollectOrdersContentOrderDataContext) payload);
                break;
            case INTERNET_ORDERS_COLLECT_ORDERS_VIEW_POSITION:
                screen = getViewPositionScreen((InternetOrderCollectOrdersViewPositionDataContext) payload);
                break;
            case INTERNET_ORDERS_CHECK_CURRENT_USER_ID:
                screen = getCurrentUserIdOrderPopUp((InternetOrderCollectOrdersContentOrderDataContext) payload);
                break;
            case INTERNET_ORDERS_CLEAR_FACT_POSITION:
                screen = clearFactPosition((InternetOrderCollectOrdersContentOrderDataContext) payload);
                break;
            case INTERNET_ORDERS_CHANGE_QUANTITY:
                screen = setChangeQuantityScreen((InternetOrderChangeQuantityDataContext) payload);
                break;
            case INTERNET_ORDERS_CHANGE_QUANTITY_UPDATE:
                screen = changeQuantityUpdate((InternetOrderChangeQuantityDataContext) payload);
                break;
            case INTERNET_ORDERS_DELETE_POSITION:
                screen = deletePosition((InternetOrderCollectOrdersContentOrderDataContext) payload);
                break;
            case INTERNET_ORDERS_CONFIRMATION_DOCUMENT:
                screen = getConfirmationDocument((InternetOrderCollectOrdersPackagesDataContext) payload);
                break;
            case INTERNET_ORDERS_FINISH_ISSUING_ORDERS:
                screen = finishIssuingOrders((InternetOrderSearchDataContext) payload);
                break;
            case INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER_AFTER_PACKAGES:
                InternetOrderCollectOrdersPackagesDataContext payloadForSave = (InternetOrderCollectOrdersPackagesDataContext) payload;
                try {
                    OrderPackageModel request = new OrderPackageModel();
                    for (OrderPackageItemModel item : payloadForSave.getPackages()) {
                        switch (item.getButtonName()) {
                            case "small":
                                item.setQuantity(payloadForSave.getSmallPackageQuantity());
                                break;
                            case "medium":
                                item.setQuantity(payloadForSave.getMediumPackageQuantity());
                                break;
                            case "large":
                                item.setQuantity(payloadForSave.getLargePackageQuantity());
                                break;
                        }
                    }
                    request.setPackagesList(payloadForSave.getPackages());
                    request.setOrderNumber(payloadForSave.getDocumentNumber());
                    ordersService.savePackages(request, payloadForSave.getDocumentNumber());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                screen = getContentOrder((InternetOrderCollectOrdersPackagesDataContext) payload);
                break;
            case INTERNET_ORDERS_CAUSES_OF_NOT_ASSEMBLY:
                InternetOrderCausesOfNotAssemblyDataContext internetOrderCausesOfNotAssemblyDataContext = (InternetOrderCausesOfNotAssemblyDataContext) payload;
                internetOrderCausesOfNotAssemblyDataContext.setDefectCause(localeComponent
                        .locale("warehouse.internet.order.collect.orders.causes.defect"));
                internetOrderCausesOfNotAssemblyDataContext.setBadMarkCause(localeComponent
                        .locale("warehouse.internet.order.collect.orders.causes.bad.mark"));
                internetOrderCausesOfNotAssemblyDataContext.setProductNotFoundCause(localeComponent
                        .locale("warehouse.internet.order.collect.orders.causes.product.not.found"));
                internetOrderCausesOfNotAssemblyDataContext.setLastUrl(internetOrderCausesOfNotAssemblyDataContext.getLastURLs()
                        .get(internetOrderCausesOfNotAssemblyDataContext.getLastURLs().size() - 1));

                String urlToBack = String.format(
                        "%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.valueOf(internetOrderCausesOfNotAssemblyDataContext.getLastUrl().toUpperCase())
                                .getWarehouseScreen());
                screen = new InternetOrderCausesOfNotAssembly(urlToBack);
                screen.setDataContext(internetOrderCausesOfNotAssemblyDataContext);
                break;
            case INTERNET_ORDERS_CAUSES_OF_NOT_ASSEMBLY_AFTER_CHOICE:
                screen = getScreenAfterChoiceReasonAbsence((InternetOrderCausesOfNotAssemblyDataContext) payload);
                break;
        }

        if (Objects.nonNull(screen)) {
            screen.initHeader();
            screen.initFooter();
        }

        return screen;
    }

    private Screen getPackageScreenNew(InternetOrderCollectOrdersContentOrderDataContext payload) {
        OrderPackageModel orderPackageModel = new OrderPackageModel();

        try {
            orderPackageModel = ordersService.getPackage(payload.getDocumentNumber());
        } catch (Exception e) {
            logger.error(
                    "Collect orders got exception.",
                    e
            );
        }
        List<OrderPackageItemModel> packages = orderPackageModel.getPackagesList();
        InternetOrderCollectOrdersPackagesScreenView screen = new InternetOrderCollectOrdersPackagesScreenView(orderPackageModel.getPackagesList());
        InternetOrderCollectOrdersPackagesDataContext internetOrderCollectOrdersPackagesDataContext = (InternetOrderCollectOrdersPackagesDataContext) payload;
        internetOrderCollectOrdersPackagesDataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.collect.orders.packages.title"));
        internetOrderCollectOrdersPackagesDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        internetOrderCollectOrdersPackagesDataContext.setSmallPackageButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.packages.small.button.text"));
        internetOrderCollectOrdersPackagesDataContext.setMediumPackageButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.packages.medium.button.text"));
        internetOrderCollectOrdersPackagesDataContext.setLargePackageButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.packages.large.button.text"));
        internetOrderCollectOrdersPackagesDataContext.setPackageQuantityLabel(localeComponent.locale("warehouse.internet.order.collect.orders.packages.quantity.label"));
        internetOrderCollectOrdersPackagesDataContext.setConfirmButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.confirm.button"));
        internetOrderCollectOrdersPackagesDataContext.setPackages(orderPackageModel.getPackagesList());
        screen.setDataContext(internetOrderCollectOrdersPackagesDataContext);

        for (OrderPackageItemModel packageFromOrders : packages) {
            switch (packageFromOrders.getButtonName()) {
                case "small":
                    internetOrderCollectOrdersPackagesDataContext.setSmallPackageQuantity(packageFromOrders.getQuantity());
                    break;
                case "medium":
                    internetOrderCollectOrdersPackagesDataContext.setMediumPackageQuantity(packageFromOrders.getQuantity());
                    break;
                case "large":
                    internetOrderCollectOrdersPackagesDataContext.setLargePackageQuantity(packageFromOrders.getQuantity());
                    break;
            }
        }
        return screen;
    }


    private Screen getPackagesChangeQuantity(InternetOrderCollectOrdersPackagesDataContext payload) {
        try {
            OrderPackageModel request = new OrderPackageModel();
            List<OrderPackageItemModel> orderPackageItemModelList = payload.getPackages();
            for (OrderPackageItemModel item : orderPackageItemModelList) {
                switch (item.getButtonName()) {
                    case "small":
                        item.setQuantity(payload.getSmallPackageQuantity());
                        break;
                    case "medium":
                        item.setQuantity(payload.getMediumPackageQuantity());
                        break;
                    case "large":
                        item.setQuantity(payload.getLargePackageQuantity());
                        break;
                }
            }
            request.setPackagesList(orderPackageItemModelList);
            request.setOrderNumber(payload.getDocumentNumber());
            ordersService.savePackages(request, payload.getDocumentNumber());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        InternetOrderCollectOrdersPackagesScreenView screen = new InternetOrderCollectOrdersPackagesScreenView(payload.getPackages());
        InternetOrderCollectOrdersPackagesDataContext internetOrderCollectOrdersPackagesDataContext = payload;
        internetOrderCollectOrdersPackagesDataContext.setHeaderTitle(localeComponent.locale("warehouse.internet.order.collect.orders.packages.title"));
        internetOrderCollectOrdersPackagesDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        internetOrderCollectOrdersPackagesDataContext.setSmallPackageButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.packages.small.button.text"));
        internetOrderCollectOrdersPackagesDataContext.setMediumPackageButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.packages.medium.button.text"));
        internetOrderCollectOrdersPackagesDataContext.setLargePackageButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.packages.large.button.text"));
        internetOrderCollectOrdersPackagesDataContext.setPackageQuantityLabel(localeComponent.locale("warehouse.internet.order.collect.orders.packages.quantity.label"));
        internetOrderCollectOrdersPackagesDataContext.setConfirmButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.confirm.button"));
        internetOrderCollectOrdersPackagesDataContext.setSmallPackageQuantity(payload.getSmallPackageQuantity());
        internetOrderCollectOrdersPackagesDataContext.setMediumPackageQuantity(payload.getMediumPackageQuantity());
        internetOrderCollectOrdersPackagesDataContext.setLargePackageQuantity(payload.getLargePackageQuantity());
        screen.setDataContext(internetOrderCollectOrdersPackagesDataContext);
        return screen;
    }

    private Screen collectOrders(InternetOrderCollectOrdersDataContext payload) {
        if (Objects.isNull(payload)) {
            payload = new InternetOrderCollectOrdersDataContext();
        }

        InternetOrderCollectOrdersScreenView screen = new InternetOrderCollectOrdersScreenView();
        payload.setHeaderTitle(localeComponent.locale("warehouse.internet.order.collect.orders.screen.title"));
        payload.setResultCountText(localeComponent.locale("warehouse.supply.search.result.screen.title.result_count_text"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        screen.setDataContext(payload);

        try {
            List<OrderModel> result = ordersService.getOrders();
            screen.resultCount(result.size());
            screen.setTable(
                    result
                            .parallelStream()
                            .map(x -> {
                                String[] row = new String[5];
                                row[0] = x.getOrderNumber();
                                row[1] = x.getShippingType().value;
                                row[2] = dateFormat.format(x.getOrderDate());
                                row[3] = localeComponent.locale(x.getOrderStatus());
                                row[4] = x.getShippingMethod();
                                return row;
                            })
                            .collect(Collectors.toList())
                            .toArray(String[][]::new));
            screen.setSignal(Signal.success());
        } catch (Exception exception) {
            logger.error(
                    "Collect orders got exception.",
                    exception
            );
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.collect.orders.title.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
        }
        return screen;
    }

    private Screen getContentOrder(InternetOrderCollectOrdersContentOrderDataContext payload) {
        OrderDocumentModel orderDocumentModel;

        if (Objects.isNull(payload)) {
            payload = new InternetOrderCollectOrdersContentOrderDataContext();
        }
        Screen screen = new InternetOrderCollectOrdersContentOrderScreenView();
        UrlHelper.setCurrentScreen(WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreenWithoutSlashes(), payload);
        payload.setHeaderTitle(localeComponent.locale("warehouse.internet.order.collect.orders.content.order.title"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setBarcodeLabel(localeComponent.locale("warehouse.internet.order.collect.orders.content.order.barcode.label"));
        payload.setSearchButtonText(localeComponent.locale("warehouse.supply.search.screen.button"));
        payload.setConfirmAssemblyOrderButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.menu.confirm.assembly.button.text"));
        payload.setPackageSelectionButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.menu.package.selection.packages.button.text"));
        payload.setEmployeeSelectionButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.menu.employee.selection.button.text"));
        payload.setChangeQuantityButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.change_quantity"));
        payload.setClearPositionFactButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.clear_position_fact"));
        payload.setRemovePositionButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.remove_position"));
        payload.setViewPositionImageButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.view_position_image"));
        payload.setAddMarkButton(localeComponent.locale("warehouse.supply.popup.menu.goods.button.label.add_mark"));
        payload.setReasonForAbsenceProduct(localeComponent.locale("warehouse.internet.order.collect.orders.causes.for.absence"));
        payload.setViewPictureButton(localeComponent.locale("warehouse.internet.order.collect.orders.content.view"));
        screen.setDataContext(payload);
        screen.setScanAction(new ScanAction(UrlHelper.getUrlToCurrentScreen()));
        try {

            if (!Strings.isNullOrEmpty(payload.getHandleSearch()) || !Strings.isNullOrEmpty(payload.getScanData())) {
                payload.setScannedSearch(payload.getScanData());
                ordersService.acceptanceOrderItem(
                        payload.getDocumentNumber(),
                        payload.getHandleSearch(),
                        payload.getScannedSearch(),
                        ""
                );
                payload.setHandleSearch("");
                payload.setScannedSearch("");
            }

            orderDocumentModel = ordersService.getOrderDocument(payload.getDocumentNumber(), payload.getUserId(), payload.getUpdateUserId());
            payload.setDocumentIdd(orderDocumentModel.getIdd());

            if (!Strings.isNullOrEmpty(orderDocumentModel.getCurrentUserId())) {
                screen = getCurrentUserIdOrderPopUp(payload);
                return screen;
            }

            payload.setBarcode(null);

            if (orderDocumentModel.getOrderDocumentItemModels().size() > 0) {
                List<Composable> blocks = orderDocumentModel.getOrderDocumentItemModels()
                        .parallelStream()
                        .map(
                                //TODO set up additional fields
                                x -> ControlHelper.getBlockItem(
                                        x.getProductName(),
                                        x.getQuantity(),
                                        x.getQuantityFact(),
                                        x.getQuantityDiff(),
                                        x.getQuantityDiff(),
                                        x.getIsMark(),
                                        x.getMarksOk(),
                                        null,
                                        x.getId().toString(),
                                        orderDocumentModel.getIdd(),
                                        null,
                                        x.getIdd(),
                                        x.getListMarks()
                                )
                        )
                        .collect(Collectors.toList());
                ((InternetOrderCollectOrdersContentOrderScreenView) screen).setBody(blocks);
                payload.setDk(orderDocumentModel.getDk());
            }
            screen.setDataContext(payload);
            return screen;
        } catch (Exception exception) {
            logger.error(
                    "Content order got exception.",
                    exception
            );
            payload.setBarcode(null);
            payload.setScannedSearch(null);
            payload.setHandleSearch(null);
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.collect.orders.content.order.title.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
            screen.setDataContext(payload);
        }
        return screen;
    }

    private Screen orderReturn(InternetOrderCourierReturnDataContext payload) {
        ReturnOrderDocumentListModel returnOrderDocumentListModel = null;


        if (Objects.isNull(payload)) {
            payload = new InternetOrderCourierReturnDataContext();
        }

        payload.setHeaderTitle(localeComponent.locale("warehouse.internet.order.courier.return.title"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setLabel(localeComponent.locale("warehouse.supply.search.box.screen.barcode.label"));
        payload.setLabelUnderLabel(localeComponent.locale("warehouse.internet.order.input.order.number.manually.label"));
        payload.setBarcodeLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.code_number"));
        payload.setSearchButtonText(localeComponent.locale("warehouse.supply.search.screen.button"));
        payload.setInternetOrderMenuReturnComplete(localeComponent.locale("warehouse.internet.order.courier.menu.return.complete"));

        try {
            returnOrderDocumentListModel = ordersService.orderReturn(
                    payload.getHandleSearch(),
                    payload.getScannedSearch()
            );
            InternetOrderCourierReturnTableScreenView screen = new InternetOrderCourierReturnTableScreenView();
            screen.setTable(
                    returnOrderDocumentListModel
                            .getOrderModels()
                            .parallelStream()
                            .map(x -> {
                                String[] row = new String[4];
                                row[0] = x.getOrderNumber();
                                row[1] = x.getShippingType().value;
                                row[2] = dateFormat.format(x.getOrderDate());
                                row[3] = localeComponent.locale(x.getOrderStatus());
                                return row;
                            })
                            .collect(Collectors.toList())
                            .toArray(String[][]::new)
            );
            screen.setDataContext(payload);
            return screen;
        } catch (Exception exception) {
            InternetOrderCourierReturnScreenView screen = new InternetOrderCourierReturnScreenView();
            logger.error(
                    "Content order got exception.",
                    exception
            );
            payload.setScanData(null);
            payload.setScanType(null);
            payload.setHandleSearch("");
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.courier.return.title"),
                            exception.getMessage(),

                            String.format(
                                    "%s/%s?%s", UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_COURIER_RETURN.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
            screen.setScanAction(
                    new ScanAction(
                            UrlHelper
                                    .getUrlToCurrentResource()
                                    .concat("/")
                                    .concat(WarehouseScreen.INTERNET_ORDERS_COURIER_RETURN.getWarehouseScreen())
                    )
            );
            screen.setDataContext(payload);
            return screen;
        }
    }

    private Screen clearFactPosition(InternetOrderCollectOrdersContentOrderDataContext payload) {
        Screen screen;

        try {
            ordersService.clearFactPosition(payload.getOrderItemId());
            screen = getContentOrder(payload);
        } catch (Exception exception) {
            logger.error(
                    "Clear fact position got error",
                    exception
            );
            screen = getContentOrder(payload);
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.collect.orders.content.order.title.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
        }
        return screen;
    }

    private Screen getCurrentUserIdOrderPopUp(InternetOrderCollectOrdersContentOrderDataContext payload) {
        Screen screen = new InternetOrderCheckUserCollectorPopupScreenView(payload.getUserId());
        payload.setTitleText(String.format("%s%s%s",
                localeComponent.locale("warehouse.internet.order.collect.orders.content.check.user.id.title.text.start"),
                " " + payload.getDocumentNumber() + " ",
                localeComponent.locale("warehouse.internet.order.collect.orders.content.check.user.id.title.text.end")));
        payload.setBodyText(localeComponent.locale("warehouse.internet.order.collect.orders.content.check.user.id.body.text"));
        payload.setContinueButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.content.check.user.id.button.yes"));
        payload.setExitButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.content.check.user.id.button.no"));
        screen.setDataContext(payload);
        return screen;
    }

    private Screen setChangeQuantityScreen(InternetOrderChangeQuantityDataContext payload) {
        Screen screen;
        try {
            if (Strings.isNullOrEmpty(payload.getOrderItemId())) {
                throw new Exception("warehouse.internet.order.change.quantity.order.id.is.empty");
            } else {
                OrderDocumentItemModel orderDocumentItemModel = ordersService.getOrderProductModel(payload.getOrderItemId());
                screen = getChangeQuantityScreenView(payload, orderDocumentItemModel);
            }
        } catch (Exception exception) {
            logger.error(
                    "Change quantity got exception",
                    exception
            );
            screen = getContentOrder(payload);
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.change.quantity.order.change.quantity.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
        }
        return screen;
    }

    private Screen getChangeQuantityScreenView(InternetOrderChangeQuantityDataContext payload, OrderDocumentItemModel orderDocumentItemModel) {
        InternetOrderChangeQuantityScreenView screen;
        payload.setHeaderTitle(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.change_quantity"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setProductNameLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.table.header.goods"));
        payload.setChangeQuantityLabel(localeComponent.locale("warehouse.supply.update.fact.position.screen.label"));
        payload.setProductPlanLabel(localeComponent.locale("warehouse.supply.search.result.screen.table.header.plan"));
        payload.setProductFactLabel(localeComponent.locale("warehouse.supply.search.result.screen.table.header.actual"));
        payload.setSelectedProductName(orderDocumentItemModel.getProductName());
        payload.setSelectedProductCountPlan(orderDocumentItemModel.getQuantity().toString());
        payload.setSelectedProductCountFact(orderDocumentItemModel.getQuantityFact().toString());
        payload.setSaveButtonText(localeComponent.locale("warehouse.supply.popup.menu.goods.button.label.save"));
        payload.setCloseButtonText(localeComponent.locale("warehouse.supply.update.fact.position.screen.close.button.text"));

        String urlToBack = String.format(
                "%s/%s",
                UrlHelper.getUrlToCurrentResource(),
                WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen());

        screen = new InternetOrderChangeQuantityScreenView(urlToBack);
        screen.setDataContext(payload);

        return screen;
    }

    private Screen changeQuantityUpdate(InternetOrderChangeQuantityDataContext payload) {
        Screen screen;

        try {
            if (Strings.isNullOrEmpty(payload.getSelectedProductCountFact())) {
                throw new Exception(localeComponent.locale("warehouse.supply.popup.menu.goods.fact.count.null.or.empty.error"));
            }

            if (Integer.parseInt(payload.getSelectedProductCountFact()) < 0) {
                throw new Exception(localeComponent.locale("warehouse.supply.popup.menu.goods.fact.count.less.zero.error"));
            }

            ordersService.updateOrderItem(payload.getOrderItemId(), payload.getSelectedProductCountFact());
            screen = getContentOrder(payload);
        } catch (Exception exception) {
            logger.error(
                    "Change quantity got exception",
                    exception
            );
            screen = getContentOrder(payload);
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.change.quantity.order.change.quantity.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_CONTENT_ORDER.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
        }

        return screen;
    }

    private Screen deletePosition(InternetOrderCollectOrdersContentOrderDataContext payload) {
        Screen screen;
        try {
            if (Strings.isNullOrEmpty(payload.getOrderItemId())) {
                throw new Exception(localeComponent.locale("warehouse.supply.popup.menu.goods.fact.count.null.or.empty.error"));
            }
            ordersService.deleteOrderItem(payload.getOrderItemId());
            screen = getContentOrder(payload);
        } catch (Exception exception) {
            logger.error(
                    "Deleting orderItem threw an exception.",
                    exception
            );
            screen = getContentOrder(payload);
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.delete.position.error"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();
        }

        return screen;
    }

    private Screen checkAcceptanceDocument(InternetOrderCollectOrdersContentOrderDataContext payload) {
        Screen screen = null;
        try {
            CheckAcceptanceDocument result = ordersService.checkAcceptanceDocument(
                    payload.getDocumentNumber());
            if (result.getCheckResult()) {
                screen = getPopupAcceptanceDocument(payload);
            } else {
                screen = getEmployeeList(payload);
            }
        } catch (Exception exception) {
            logger.error(
                    "Check acceptance document threw an exception.",
                    exception
            );
            screen = getContentOrder(payload);
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.collect.orders.content.order.title.error"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();        }

        return screen;
    }

    private Screen getConfirmationDocument(InternetOrderCollectOrdersPackagesDataContext payload) {
        Screen screen = null;

        for (OrderPackageItemModel item : payload.getPackages()) {
            switch (item.getButtonName()) {
                case "small":
                    item.setQuantity(payload.getSmallPackageQuantity());
                    break;
                case "medium":
                    item.setQuantity(payload.getMediumPackageQuantity());
                    break;
                case "large":
                    item.setQuantity(payload.getLargePackageQuantity());
                    break;
            }
        }

        try {
            OrderPackageModel request = new OrderPackageModel();
            request.setPackagesList(payload.getPackages());
            request.setOrderNumber(payload.getDocumentNumber());
            ordersService.savePackages(request, payload.getDocumentNumber());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            ordersService.confirmationDocument(
                    payload.getDocumentNumber(),
                    payload.getCollectorFullName(),
                    ((SimpleDateFormat)dateFormat).toPattern()
            );

            screen = collectOrders(new InternetOrderCollectOrdersDataContext());
            screen.setSignal(Signal.warning());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.collect.orders.content.order.title"),
                            localeComponent.locale("warehouse.internet.order.collect.orders.content.confirmation.success"),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
        } catch (Exception exception) {
            logger.error(
                    "Accepting document threw an exception.",
                    exception
            );
            screen = getContentOrder(payload);
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.confirm.acceptance.document.mismatch.error"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();
        }
        return screen;
    }

    private Screen getPopupAcceptanceDocument(InternetOrderCollectOrdersContentOrderDataContext payload) {
        Screen screen = new InternetOrderMismatchAcceptanceDocumentPopupScreenView();

        payload.setTitleText(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.confirm.acceptance.document.mismatch.title"));
        payload.setHeaderTitle(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.confirm.acceptance.document"));
        payload.setBodyText(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.confirm.acceptance.document.mismatch.text"));
        payload.setContinueButtonText(localeComponent.locale("warehouse.internet.order.document.finish_issuing_orders.popup.button"));
        screen.setDataContext(payload);

        return screen;
    }

    private Screen getCourierDeliveryOrdersList(InternetOrderSearchDataContext payload) {

        if (Objects.isNull(payload)) {
            payload = new InternetOrderSearchDataContext();
        }
        InternetOrderCourierDeliveryOrdersListScreenView screen = new InternetOrderCourierDeliveryOrdersListScreenView();
        payload.setHeaderTitle(localeComponent.locale("warehouse.internet.order.courier.delivery.orders.list.title"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setSearchButtonText(localeComponent.locale("warehouse.supply.search.screen.button"));
        payload.setBarcodeLabel(localeComponent.locale("warehouse.internet.order.collect.orders.content.order.barcode.or.order.number.label"));
        payload.setFinishIssuanceOrders(localeComponent.locale("warehouse.internet.order.courier.delivery.finish.issuance.orders.button.text"));
        screen.setScanAction(new ScanAction(UrlHelper.getUrlToCurrentScreen()));

        try {

            if (!Strings.isNullOrEmpty(payload.getHandleSearch()) || !Strings.isNullOrEmpty(payload.getScanData())) {
                payload.setScannedSearch(payload.getScanData());
                ordersService.confirmationDeliveryDocument(
                        payload.getHandleSearch(),
                        payload.getScannedSearch()
                );
                payload.setHandleSearch("");
                payload.setScannedSearch("");
            }

            List<ScannedDocumentModel> result = ordersService.getOrdersForDelivery(payload.getTk());
            payload.setScanLabel(localeComponent.locale("warehouse.internet.order.courier.delivery.scanned.label") +
                    " " + result.parallelStream()
                    .filter(e -> localeComponent.locale(e.getOrderStatus())
                            .equals(localeComponent.locale("warehouse.internet.order.document.status.delivery.scanned")))
                    .count() + " " +
                    localeComponent.locale("warehouse.internet.order.courier.delivery.from.label") +
                    " " +
                    result.size());
            if (result.size() == 0) {
                screen.setSignal(Signal.warning());
                screen.setModalDialog(
                        ModalDialogHelper.getModalDialogOk(
                                localeComponent.locale("warehouse.supply.search.result.title.not_found"),
                                localeComponent.locale("warehouse.supply.search.result.message.not_found"),
                                String.format(
                                        "%s/%s?%s",
                                        UrlHelper.getUrlToCurrentResource(),
                                        WarehouseScreen.INTERNET_ORDERS_COURIER_DELIVERY_ORDERS_LIST.getWarehouseScreen(),
                                        UrlHelper.CLOSE_MODAL_DIALOG
                                )
                        )
                );
                screen.hideControls();
            } else {
                screen.setTable(
                        result
                                .parallelStream()
                                .map(x -> {
                                    String[] row = new String[5];
                                    row[0] = x.getOrderNumber();
                                    row[1] = x.getOrderType();
                                    row[2] = dateFormat.format(x.getDateCreated());
                                    row[3] = localeComponent.locale(x.getOrderStatus());
                                    row[4] = x.getShippingMethod();
                                    return row;
                                })
                                .collect(Collectors.toList())
                                .toArray(String[][]::new));
                screen.setSignal(Signal.success());
            }
            screen.setDataContext(payload);
        } catch (Exception exception) {
            logger.error(
                    "Scanned order document got exception.",
                    exception
            );

            payload.setHandleSearch("");
            payload.setScannedSearch("");
            screen = new InternetOrderCourierDeliveryOrdersListScreenView();
            screen.setDataContext(payload);

            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.document.status.delivery.scan.exception.header"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_COURIER_DELIVERY.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
        }
        return screen;
    }

    private Screen getOrderInformationOrdersList(DataContext payload) {
        if (Objects.isNull(payload)) {
            payload = new DataContext();
        }

        InternetOrderOrderInformationOrdersListScreenView screen = new InternetOrderOrderInformationOrdersListScreenView();
        payload.setHeaderTitle(localeComponent.locale("warehouse.internet.order.order.information.orders.list.title"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        screen.setDataContext(payload);

        try {
            List<OrderModel> result = ordersService.getOrders();

            if (result.size() == 0) {
                screen.setSignal(Signal.warning());
                screen.setModalDialog(
                        ModalDialogHelper.getModalDialogOk(
                                localeComponent.locale("warehouse.supply.search.result.title.not_found"),
                                localeComponent.locale("warehouse.supply.search.result.message.not_found"),
                                String.format(
                                        "%s/%s?%s",
                                        UrlHelper.getUrlToCurrentResource(),
                                        WarehouseScreen.INTERNET_ORDERS_ORDER_INFORMATION_ORDERS_LIST.getWarehouseScreen(),
                                        UrlHelper.CLOSE_MODAL_DIALOG
                                )
                        )
                );
                screen.hideControls();
            } else {
                screen.setTable(
                        result
                                .parallelStream()
                                .map(x -> {
                                    String[] row = new String[4];
                                    row[0] = x.getOrderNumber();
                                    row[1] = x.getShippingType().value;
                                    row[2] = dateFormat.format(x.getOrderDate());
                                    row[3] = dateFormat.format(x.getOrderDate());
                                    return row;
                                })
                                .collect(Collectors.toList())
                                .toArray(String[][]::new));
                screen.setSignal(Signal.success());
            }
        } catch (Exception exception) {
            logger.error(
                    "Collect orders got exception.",
                    exception
            );
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.collect.orders.title.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_ORDER_INFORMATION_ORDERS_LIST.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
        }
        return screen;
    }

    private Screen getInformationAboutOrder(InternetOrderInformationAboutOrderDataContext payload) {
        if (Objects.isNull(payload)) {
            payload = new InternetOrderInformationAboutOrderDataContext();
        }
        Screen screen = new InternetOrderInformationAboutOrderScreenView();
        payload.setHeaderTitle(localeComponent.locale("warehouse.internet.order.information.about.order.title"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setSenderLabel(localeComponent.locale("warehouse.supply.view.document.screen.header.sender_text"));
        payload.setFullNameLabel(localeComponent.locale("warehouse.internet.order.information.about.order.customer.name.label"));
        payload.setCourierDeliveryButton(localeComponent.locale("warehouse.internet.order.information.about.order.menu.delivery"));
        payload.setCourierReturnButton(localeComponent.locale("warehouse.internet.order.information.about.order.menu.return"));
        payload.setOrderDisbandmentButton(localeComponent.locale("warehouse.internet.order.information.about.order.menu.disbandment"));

        try {
            OrderDocumentInformationModel orderModel = ordersService.getOrderDocument(
                    payload.getOrderBarcode(),
                    payload.getDateFrom(),
                    payload.getDateTo(),
                    payload.getSelectedOrderStatus().parallelStream()
                                    .map(x -> Enum.valueOf(OrderStatus.class, x))
                                            .collect(Collectors.toList()),
                    payload.getSelectedOrderTypes().parallelStream()
                            .map(x -> Enum.valueOf(OrderType.class, x))
                            .collect(Collectors.toList())
            );
            if (orderModel.getOrderDocumentModelList().size() == 1) {
                OrderDocumentModel orderDocumentModel = orderModel.getOrderDocumentModelList().get(0);
                payload.setSelectedOrderStatus(new ArrayList<>());
                payload.setSelectedOrderTypes(new ArrayList<>());
                payload.setOrderStatus(localeComponent.locale(orderDocumentModel.getStatusOrder()));
                payload.setOrderDate(dateFormat.format(orderDocumentModel.getDocumentDate()));
                payload.setFullName(orderDocumentModel.getBuyer());
                payload.setSender(orderDocumentModel.getWarehouse());
                payload.setOrderNumber(orderDocumentModel.getOrderNumber());
                if (orderDocumentModel.getOrderDocumentItemModels().size() > 0) {
                    List<Composable> blocks = orderDocumentModel.getOrderDocumentItemModels()
                            .parallelStream()
                            .map(
                                    x -> ControlHelper.getBlockItemForInternetOrder(
                                            x.getProductName(),
                                            x.getQuantity(),
                                            x.getQuantityFact(),
                                            x.getQuantityDiff(),
                                            x.getQuantityDiff(),
                                            false,
                                            false,
                                            false,
                                            null,
                                            null,
                                            null,
                                            null
                                    )
                            )
                            .collect(Collectors.toList());
                    ((InternetOrderInformationAboutOrderScreenView)screen).setBody(blocks);
                    ((InternetOrderInformationAboutOrderScreenView)screen).setColorStatus(payload.getOrderStatus());
                }
            } else {
                screen = new InternetOrderInformationAboutOrdersListScreenView();
                payload.setSelectedOrderStatus(new ArrayList<>());
                payload.setSelectedOrderTypes(new ArrayList<>());
                ((InternetOrderInformationAboutOrdersListScreenView)screen).setTable(
                        orderModel.getOrderDocumentModelList()
                                .parallelStream()
                                .map(x -> {
                                    String[] row = new String[5];
                                    row[0] = x.getOrderNumber();
                                    row[1] = x.getOrderStatus();
                                    row[2] = dateFormat.format(x.getCreatedDate());
                                    row[3] = localeComponent.locale(x.getStatusOrder());
                                    row[4] = x.getShippingMethod();
                                    return row;
                                })
                                .collect(Collectors.toList())
                                .toArray(String[][]::new));
                screen.setSignal(Signal.success());
            }
            payload.setDateFrom("");
            payload.setDateTo("");
            screen.setDataContext(payload);
        } catch (Exception exception) {
            logger.error(
                    "Information about order got exception.",
                    exception
            );
            payload.setSelectedOrderStatus(new ArrayList<>());
            payload.setSelectedOrderTypes(new ArrayList<>());
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.information.about.order.title.error"),
                            exception.getMessage(),

                            String.format(
                                    "%s/%s?%s", UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_ORDER_INFORMATION.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
            screen.setDataContext(payload);
        }
        return screen;
    }

    public Screen getEmployeeList(InternetOrderCollectOrdersContentOrderDataContext payload) {
        InternetOrderEmployeeListScreenView screen = new InternetOrderEmployeeListScreenView();

        try {
            payload.setHeaderTitle(localeComponent.locale("warehouse.supply.employee.list.screen.title"));
            payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
            screen.setDataContext(payload);
            screen.setScanAction(new ScanAction(UrlHelper.getUrlToCurrentScreen()));
            EmployeeListModel employeeListModel = ordersService.getEmployeeList();
            if (employeeListModel.getEmployeeModels().size() > 0) {
                screen.createEmployeeList(employeeListModel.getEmployeeModels());
            }
        } catch (Exception exception) {
            logger.error(
                    "Getting employee list threw an exception.",
                    exception
            );
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.employee.list.error"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();
        }
        return screen;
    }

    public Screen getViewPositionScreen(InternetOrderCollectOrdersViewPositionDataContext payload) {
        InternetOrderCollectOrdersViewPositionScreenView screen = new InternetOrderCollectOrdersViewPositionScreenView();
        UrlHelper.setCurrentScreen(WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_VIEW_POSITION.getWarehouseScreen());
        payload.setHeaderTitle(localeComponent.locale("warehouse.internet.order.collect.orders.content.order.title"));
        payload.setClearFactPositionButton(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.clear_position_fact"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setNomenclatureLabel(localeComponent.locale("warehouse.internet.order.collect.orders.by.images.nomenclature.label"));
        payload.setProductPlanLabel(localeComponent.locale("warehouse.internet.order.collect.orders.by.images.plan.label"));
        payload.setProductFactLabel(localeComponent.locale("warehouse.internet.order.collect.orders.by.images.fact.label"));
        payload.setProductDiffLabel(localeComponent.locale("warehouse.internet.order.collect.orders.by.images.diff.label"));
        payload.setAbsenceReasonButtonText(localeComponent.locale("warehouse.internet.order.collect.orders.by.images.absence.reason.button.text"));
        screen.setScanAction(new ScanAction(UrlHelper.getUrlToCurrentScreen()));
        OrderViewPositionModel orderViewPositionModel;
        try {

            if (Objects.nonNull(payload.getScanData())) {
                payload.setScannedSearch(payload.getScanData());
                ordersService.acceptanceOrderItem(
                        payload.getDocumentNumber(),
                        payload.getHandleSearch(),
                        payload.getScannedSearch(),
                        payload.getOrderItemId()
                );
                payload.setHandleSearch("");
                payload.setScannedSearch("");
                payload.setScanData(null);
            }
            orderViewPositionModel = ordersService.getOrderViewPosition(
                    payload.getOrderItemId(),
                    payload.getDocumentIdd()
            );

            if (!orderViewPositionModel.isUserCanEnter()) {
                return getContentOrder(payload);
            }

            if (!Objects.isNull(orderViewPositionModel)) {
                payload.setBarcode(orderViewPositionModel.getProductBarcode());
                payload.setProductDiff(orderViewPositionModel.getProductDiff());
                payload.setProductFact(orderViewPositionModel.getProductFact());
                payload.setProductPlan(orderViewPositionModel.getProductPlan());
                payload.setProductFullName(orderViewPositionModel.getProductFullName());
                payload.setNomenclature(orderViewPositionModel.getItemId());
                payload.setImageUrl(
                        String.format(
                                "%s/%s%s",
                                getImageUrl,
                                payload.getBarcode(),
                                getImageAttribute
                        )
                );
            }
            screen.setBody(orderViewPositionModel);
            screen.setDataContext(payload);
        } catch (Exception exception) {
            logger.error(
                    "Getting getViewPositionScreen threw an exception.",
                    exception
            );
            payload.setHandleSearch("");
            payload.setScannedSearch("");
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.collect.orders.by.images.error"),
                            exception.getMessage(),

                            String.format(
                                    "%s/%s?%s", UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_COLLECT_ORDERS_VIEW_POSITION.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
            screen.setDataContext(payload);
        }
        return screen;
    }

    public Screen orderDisbandment(InternetOrderSearchDataContext payload) {
        InternetOrderDisbandmentOrderScreenView screen = new InternetOrderDisbandmentOrderScreenView();
        OrderDisbandment status;

        try {
            status = ordersService.orderDisbandment(Strings.isNullOrEmpty(payload.getScanData()) ? payload.getBarcode() : payload.getScanData());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.disbandment.order.title"),
                            localeComponent.locale(status.getScreenText()),
                            String.format(
                                    "%s/%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS.getWarehouseScreen()
                            )
                    )
            );
            screen.setDataContext(payload);
        } catch (Exception exception) {
            logger.error(
                    "Order disbandment threw an exception.",
                    exception
            );
            screen.setSignal(Signal.error());
            payload.setBarcode("");
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.disbandment.error"),
                            localeComponent.locale(exception.getMessage()),

                            String.format(
                                    "%s/%s?%s", UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS_ORDER_DISBANDMENT.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
            screen.setDataContext(payload);
        }

        return screen;
    }

    private Screen finishIssuingOrders(InternetOrderSearchDataContext payload) {
        Screen screen = null;
        OrderFinishIssuingOrders orderFinishIssuingOrders;

        try {
            orderFinishIssuingOrders = ordersService.finishIssuingOrders(payload.getTk());
            if (Objects.nonNull(orderFinishIssuingOrders)) {
                screen = getPopupSuccessFinishIssuingOrders(orderFinishIssuingOrders);
            }
        } catch (Exception exception) {
            screen = getCourierDeliveryOrdersList(payload);
            logger.error(
                    "Finish issuing orders threw an exception.",
                    exception
            );
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.document.finish_issuing_orders.exception"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();
        }

        return screen;
    }

    private Screen getPopupSuccessFinishIssuingOrders(OrderFinishIssuingOrders orderFinishIssuingOrders) {
        InternetOrderPopupSuccessFinishIssuingOrdersScreenView screen = new InternetOrderPopupSuccessFinishIssuingOrdersScreenView(orderFinishIssuingOrders.getIssuedOrders());
        InternetOrderPopupSuccessFinishIssuingContext payload = new InternetOrderPopupSuccessFinishIssuingContext();
        payload.setHeaderTitle(localeComponent.locale("warehouse.internet.order.collect.orders.confirm.assembly.order.confirm.acceptance.document"));
        payload.setHeader(localeComponent.locale("warehouse.internet.order.document.finish_issuing_orders.popup_orders"));
        payload.setFooter(localeComponent.locale("warehouse.internet.order.document.finish_issuing_orders.popup_delivery"));
        payload.setButton(localeComponent.locale("warehouse.internet.order.document.finish_issuing_orders.popup.button"));
        screen.setDataContext(payload);

        return screen;
    }

    private Screen orderReturnComplete(InternetOrderCourierReturnDataContext payload) {
        Screen screen;

        try {
            ordersService.orderReturnComplete();
            screen = new Screen();
            screen.setSignal(Signal.success());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.courier.return.title"),
                            localeComponent.locale("warehouse.internet.order.return.complete.message.success"),
                            String.format(
                                    "%s/%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.INTERNET_ORDERS.getWarehouseScreen()
                            )
                    )
            );
            screen.hideControls();
            screen.setDataContext(payload);
        } catch (Exception exception) {
            payload.setHandleSearch("");
            payload.setScannedSearch("");
            screen = orderReturn(payload);
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.return.complete.error"),
                            localeComponent.locale(exception.getMessage())
                    )
            );
            screen.hideControls();
        }

        return screen;
    }

    private Screen getScreenAfterChoiceReasonAbsence(InternetOrderCausesOfNotAssemblyDataContext payload) {
        Screen screen;

        try {
            ordersService.reasonAbsence(
                    payload.getDocumentIdd(),
                    payload.getOrderItemId(),
                    payload.getReason()
            );
            screen = getContentOrder(payload);
        } catch (Exception exception) {
            screen = getContentOrder(payload);
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.internet.order.collect.orders.causes.error.title"),
                            localeComponent.locale(exception.getMessage())
                    )
            );
        }

        return screen;
    }
    @Override
    public void doBack(Object payload) {
        switch (WarehouseScreen.valueOf(UrlHelper.getCurrentScreen().toUpperCase())) {
            case INTERNET_ORDERS_COLLECT_ORDERS:
                InternetOrderCollectOrdersDataContext dataContext = (InternetOrderCollectOrdersDataContext) payload;
                ordersService.setStatusNew(dataContext.getDocumentIdd());
                break;
        }
    }

}
