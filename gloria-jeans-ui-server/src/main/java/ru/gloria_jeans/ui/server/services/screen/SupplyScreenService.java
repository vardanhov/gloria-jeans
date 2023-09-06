package ru.gloria_jeans.ui.server.services.screen;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.core.v1.receiving.enums.MovingDocumentModelType;
import ru.gloria_jeans.core.v1.receiving.enums.MovingDocumentStatus;
import ru.gloria_jeans.core.v1.receiving.models.response.*;
import ru.gloria_jeans.ui.server.component.LocaleComponent;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply.*;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.helper.ControlHelper;
import ru.gloria_jeans.ui.server.jetpackcompose.helper.ModalDialogHelper;
import ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.supply.*;
import ru.gloria_jeans.ui.server.services.ReceivingService;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.text.DateFormat;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class SupplyScreenService extends BaseScreenService {
    private final ReceivingService receivingService;
    private final LocaleComponent localeComponent;
    private DateFormat dateTimeFormat;
    private DateFormat dateFormat;

    @Value("${receiving.image}")
    String getImageUrl;
    @Value("${receiving.attribute}")
    String getImageAttribute;

    @Autowired
    public SupplyScreenService(
            @Value("${base-server-url}") String baseServerUrl,
            ReceivingService receivingService,
            MessageSource messageSource,
            Locale locale,
            LocaleComponent localeComponent
    ) {
        super(baseServerUrl);
        this.receivingService = receivingService;
        this.localeComponent = localeComponent;
        this.dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM, locale);
        this.dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
    }

    @Override
    public Screen getScreen(Object payload, DeviceInfo deviceInfo, UserInfo userInfo) {
        Screen screen = null;

        switch (WarehouseScreen.valueOf(UrlHelper.getCurrentScreen().toUpperCase())) {
            case SUPPLY_SEARCH_BOX:
                screen = new SupplySearchBoxScreenView();
                SupplyDataContext supplyDataContext = new SupplyDataContext();
                supplyDataContext.setHeaderTitle(localeComponent.locale("warehouse.supply.search.box.screen.title"));
                supplyDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                supplyDataContext.setScanBarCodeLabel(localeComponent.locale("warehouse.supply.search.box.screen.barcode.label"));
                supplyDataContext.setBoxNumberLabel(localeComponent.locale("warehouse.supply.search.box.screen.box.number.label"));
                supplyDataContext.setBarcodeBoxPlaceholder(localeComponent.locale("warehouse.supply.search.box.screen.placeholder"));
                supplyDataContext.setButtonSearchText(localeComponent.locale("warehouse.supply.search.screen.button"));
                supplyDataContext.setButtonSearchDocumentText(localeComponent.locale("warehouse.supply.menu.search.screen.document.search.button"));
                screen.setDataContext(supplyDataContext);
                screen.setScanAction(
                        new ScanAction(
                                String.format(
                                        "%s/%s",
                                        UrlHelper.getUrlToCurrentResource(),
                                        WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen()
                                )
                        )
                );
                break;
            case SUPPLY_SEARCH_DOCUMENT:
                screen = new SupplySearchDocumentScreenView();
                SupplySearchDocumentDataContext searchDocumentDataContext = (SupplySearchDocumentDataContext) payload;
                searchDocumentDataContext.setHeaderTitle(localeComponent.locale("warehouse.supply.search.document.screen.title"));
                searchDocumentDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                searchDocumentDataContext.setLabel(localeComponent.locale("warehouse.supply.search.document.screen.label"));
                searchDocumentDataContext.setLabelUnderLabel(localeComponent.locale("warehouse.supply.search.document.screen.labelUnderLabel"));
                searchDocumentDataContext.setDocumentNumber(localeComponent.locale("warehouse.supply.search.document.screen.documentNumber"));
                searchDocumentDataContext.setOr(localeComponent.locale("warehouse.supply.search.document.screen.or"));
                searchDocumentDataContext.setLabelDateFrom(localeComponent.locale("warehouse.supply.search.document.screen.date_from"));
                searchDocumentDataContext.setLabelDateTo(localeComponent.locale("warehouse.supply.search.document.screen.date_to"));
                searchDocumentDataContext.setButtonSearchText(localeComponent.locale("warehouse.supply.search.screen.button"));
                searchDocumentDataContext.setDocumentBarcode(StringUtils.EMPTY);
                searchDocumentDataContext.setLabelStatus(localeComponent.locale("warehouse.supply.result.search.document.status"));

                List<MultiSelectorItem> statusList = new ArrayList<>();

                for (MovingDocumentStatus status : MovingDocumentStatus.values()) {
                    statusList.add(new MultiSelectorItem(status.name(), localeComponent.locale(status.getLocale())));
                }

                ((SupplySearchDocumentScreenView)screen).setStatusList(statusList);

                screen.setDataContext(searchDocumentDataContext);
                screen.setScanAction(
                        new ScanAction(
                                String.format(
                                        "%s/%s",
                                        UrlHelper.getUrlToCurrentResource(),
                                        WarehouseScreen.SUPPLY_RESULT_SEARCH.getWarehouseScreen()
                                )
                        )
                );
                break;
            case SUPPLY_RESULT_SEARCH:
                screen = getSupplyResultSearch((SupplySearchDocumentDataContext) payload);
                break;
            case SUPPLY_VIEW_DOCUMENT:
                screen = getSupplyViewDocument((SupplyViewDocumentDataContext) payload);
                break;
            case SUPPLY_RECALCULATION_BOX:
                screen = setRecalculationBoxScreenView((SupplyRecalculationBoxDataContext) payload);
                break;
            case SUPPLY_RECALCULATION_BOX_UPDATE:
                screen = setRecalculationBoxScreenViewUpdate((SupplyRecalculationLotDataContext) payload);
                break;
            case SUPPLY_SCAN_BLOCK_MARK_LOT:
                screen = getScanBlockedMarkLotPopupScreenView((SupplyScanBlockedMarkLotPopupDataContext) payload);
                break;
            case SUPPLY_RECALCULATION_LOT:
                screen = setRecalculationLotScreenView((SupplyRecalculationLotDataContext) payload);
                break;
            case SUPPLY_GOOD_IMAGE:
                screen = getGoodImageScreenView((SupplyImageProductDataContext) payload);
                break;
            case SUPPLY_LIST_PROBLEM_MARKS:
                screen = new SupplyListProblemMarksScreenView();
                SupplyDataContext listProblemMarksDataContext = new SupplyDataContext();
                listProblemMarksDataContext.setHeaderTitle(localeComponent.locale("warehouse.supply.problem.marks.title"));
                listProblemMarksDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                screen.setDataContext(listProblemMarksDataContext);
                screen.setScanAction(new ScanAction(UrlHelper.getUrlToCurrentScreen()));
                break;
            case SUPPLY_MENU_LIST_PROBLEM_MARKS:
                screen = new SupplyMenuListProblemMarksScreenView();
                SupplyDataContext menuListProblemMarksDataContext = new SupplyDataContext();
                menuListProblemMarksDataContext.setHeaderTitle("warehouse.supply.problem.marks.title");
                menuListProblemMarksDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                screen.setDataContext(menuListProblemMarksDataContext);
                screen.setScanAction(new ScanAction(UrlHelper.getUrlToCurrentScreen()));
                break;
            case SUPPLY_CONFIRM_DISCREPANCY:
                screen = getSupplyConfirmDiscrepancy((SupplyConfirmDiscrepancyDataContext) payload);
                break;
            case SUPPLY_CONFIRM_DISCREPANCY_POPUP:
                screen = getConfirmDiscrepansyPopupScreenView((SupplyConfirmDiscrepansyPopupDataContext) payload);
                break;
            case SUPPLY_CONFIRM_ACCEPTANCE_DELIVERY_YES:
                screen = confirmAcceptanceDelivery((SupplyConfirmDiscrepancyDataContext) payload);
                break;
            case SUPPLY_CHANGE_QUANTITY:
                screen = setChangeQuantityScreenView((SupplyChangeQuantityDataContext) payload);
                break;
            case SUPPLY_CHANGE_QUANTITY_UPDATE:
                screen = changeQuantityUpdate((SupplyChangeQuantityDataContext) payload);
                break;
            case SUPPLY_CLEAR_FACT_POSITION:
                screen = clearFactPosition((SupplyMenuProductDataContext) payload);
                break;
            case SUPPLY_CLEAR_FACT_ALL_POSITIONS:
                screen = clearFactAllPositions((SupplyMenuProductDataContext) payload);
                break;
            case SUPPLY_DELETE_POSITION:
                screen = deletePosition((SupplyMenuProductDataContext) payload);
                break;
            case SUPPLY_EMPLOYEES_LIST:
                screen = getEmployeeList((SupplyConfirmDiscrepancyDataContext) payload);
                break;
        }

        if (Objects.nonNull(screen)) {
            screen.initHeader();
            screen.initFooter();
        }

        return screen;
    }

    private Screen getSupplyViewDocument(SupplyViewDocumentDataContext payload) {
        SupplyViewingDocumentScreenView screen = new SupplyViewingDocumentScreenView();
        payload.setHeaderTitle(localeComponent.locale("warehouse.supply.view.document.screen.title"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setFrom(localeComponent.locale("warehouse.supply.view.document.screen.header.from"));
        payload.setSenderText(localeComponent.locale("warehouse.supply.view.document.screen.header.sender_text"));
        payload.setAcceptedBoxText(localeComponent.locale("warehouse.supply.view.document.screen.header.accepted_box_text"));
        payload.setUnitText(localeComponent.locale("warehouse.supply.view.document.screen.header.unit_text"));
        payload.setSupplyButtonText(localeComponent.locale("warehouse.supply.menu.document.screen.button.text.supply"));
        payload.setConfidentialAcceptanceButtonText(localeComponent.locale("warehouse.supply.menu.document.screen.button.text.confidential_acceptance"));
        payload.setRemoveFromHoldingButtonText(localeComponent.locale("warehouse.supply.menu.document.screen.button.text.remove_from_holding"));
        payload.setPrintingPackingListButtonText(localeComponent.locale("warehouse.supply.menu.document.screen.button.text.print_packaging_list"));
        payload.setPrintingTrade13ButtonText(localeComponent.locale("warehouse.supply.menu.document.screen.button.text.print_torg_13"));
        payload.setPrintingTrade13ButtonTextPlan(localeComponent.locale("warehouse.supply.menu.document.screen.button.text.print_torg_13_plan"));

        screen.setDataContext(payload);
        screen.setScanAction(
                new ScanAction(
                        String.format(
                                "%s/%s",
                                UrlHelper.getUrlToCurrentResource(),
                                WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen()
                        )
                )
        );

        try {
            if (Strings.isNullOrEmpty(payload.getSelectedDocumentIdd())) {
                throw new Exception(localeComponent.locale("warehouse.supply.result.view.idd_is_empty"));
            }

            ViewDocumentModel document = receivingService.getDocument(payload.getSelectedDocumentIdd());
            payload.setSender(document.getViewDocument().getWarehouse());
            payload.setType(document.getViewDocument().getType());
            payload.setStatus(localeComponent.locale(document.getViewDocument().getStatus()));
            payload.setDocDate(dateFormat.format(document.getViewDocument().getDocDate()));
            payload.setDocumentNumber(document.getViewDocument().getDocNumber());
            payload.setQuantityBox(
                    String.format(
                            "%s / %s",
                            document.getViewDocument().getFactBoxes(),
                            document.getViewDocument().getTotalBoxes()
                    )
            );
            payload.setQuantity(
                    String.format("%s / %s",
                            document.getViewDocument().getFactQuantity(),
                            document.getViewDocument().getTotalQuantity()
                    )
            );
            List<ViewDocumentBoxModel> result = document.getBoxes();
            String[] header = {
                    localeComponent.locale("warehouse.supply.view.document.screen.table.header.box"),
                    localeComponent.locale("warehouse.supply.view.document.screen.table.header.units"),
                    localeComponent.locale("warehouse.supply.view.document.screen.table.header.costs")
            };
            screen.setTable(
                    header,
                    result
                            .parallelStream()
                            .map(x -> {
                                String[] row = new String[4];
                                row[0] = x.getBarcode();
                                row[1] = String.format(
                                        "%s / %s",
                                        x.getFactQuantity(),
                                        x.getTotalQuantity()
                                );
                                row[2] = ControlHelper.plusMinusSetter(x.getDifferenceQuantity());
                                row[3] = x.isBoxAccepted().toString();
                                return row;
                            })
                            .collect(Collectors.toList())
                            .toArray(String[][]::new)
            );
            screen.setColorStatus(payload.getStatus());
            screen.setDataContext(payload);
        } catch (Exception exception) {
            logger.error(
                    "Viewing document got exception.",
                    exception
            );
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.result.view.title.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.SUPPLY_RESULT_SEARCH.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
        }

        return screen;
    }

    public Screen getConfirmDiscrepansyPopupScreenView(SupplyConfirmDiscrepansyPopupDataContext payload) {
        SupplyConfirmDiscrepancyPopupScreenView screen = new SupplyConfirmDiscrepancyPopupScreenView();
        payload.setHeaderTitle(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.title"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setHeaderTitleText(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.popup.title"));
        payload.setMessageText(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.popup.message"));
//        payload.setProductNameLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.table.header.goods"));
//        payload.setChangeQuantityLabel(localeComponent.locale("warehouse.supply.update.fact.position.screen.label"));
//        payload.setProductPlanLabel(localeComponent.locale("warehouse.supply.search.result.screen.table.header.plan"));
//        payload.setProductFactLabel(localeComponent.locale("warehouse.supply.search.result.screen.table.header.actual"));
//        payload.setSelectedProductName(productModel.getName());
//        payload.setSelectedProductCountPlan(productModel.getCountPlan().toString());
//        payload.setSelectedProductCountFact(productModel.getCountFact().toString());
        payload.setSaveButtonText(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.popup.yes"));
        payload.setCloseButtonText(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.popup.no"));
        screen.setDataContext(payload);
        return screen;
    }

    private Screen getSupplyResultSearch(SupplySearchDocumentDataContext payload) {
        if (Objects.isNull(payload)) {
            payload = new SupplySearchDocumentDataContext();
        }

        SupplySearchResultScreenView screen = new SupplySearchResultScreenView();
        payload.setHeaderTitle(localeComponent.locale("warehouse.supply.search.result.screen.title"));
        payload.setResultCountText(localeComponent.locale("warehouse.supply.search.result.screen.title.result_count_text"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        screen.setDataContext(payload);
        screen.setScanAction(new ScanAction(UrlHelper.getUrlToCurrentScreen()));

        try {
            if (!Strings.isNullOrEmpty(payload.getScanType()) && !Strings.isNullOrEmpty(payload.getScanData())) {
                String barcode = payload.getScanData();

                if (Objects.isNull(barcode)) {
                    throw new Exception(localeComponent.locale("warehouse.supply.error.problem_with_barcode"));
                } else {
                    payload.setDocumentBarcode(barcode);
                }
            }

            if (
                    Strings.isNullOrEmpty(payload.getDocumentBarcode()) &&
                            Strings.isNullOrEmpty(payload.getDateFrom()) &&
                            Strings.isNullOrEmpty(payload.getDateTo()) &&
                            Strings.isNullOrEmpty(payload.getSender()) &&
                            payload.getSelectedItems().size() == 0
            ) {
                throw new Exception(localeComponent.locale("warehouse.supply.search.result.error.empty_all_fields"));
            } else if (payload.getSelectedItems().size() > 0 &&
                    Strings.isNullOrEmpty(payload.getDocumentBarcode()) &&
                    ((Strings.isNullOrEmpty(payload.getDateFrom()) &&
                    Strings.isNullOrEmpty(payload.getDateTo())) ||
                    Strings.isNullOrEmpty(payload.getDateFrom()) ||
                    Strings.isNullOrEmpty(payload.getDateTo())))
            {
                throw new Exception(localeComponent.locale("warehouse.supply.search.document.screen.date_error"));
            } else {
                SupplySearchDocumentDataContext finalPayload = payload;
                List<DocumentResultSearchModel> result = receivingService.findDocuments(
                        payload.getDocumentBarcode(),
                        payload.getDateFrom(),
                        payload.getDateTo(),
                        payload.getSelectedItems().parallelStream()
                                .map(x -> Enum.valueOf(MovingDocumentStatus.class, x))
                                .collect(Collectors.toList())
                );
                payload.setSelectedItems(new ArrayList<>());

                if (result.size() == 0) {
                    screen.setSignal(Signal.warning());
                    screen.setModalDialog(
                            ModalDialogHelper.getModalDialogOk(
                                    localeComponent.locale("warehouse.supply.search.result.title.not_found"),
                                    localeComponent.locale("warehouse.supply.search.result.message.not_found"),
                                    String.format(
                                            "%s/%s?%s",
                                            UrlHelper.getUrlToCurrentResource(),
                                            WarehouseScreen.SUPPLY_SEARCH_DOCUMENT.getWarehouseScreen(),
                                            UrlHelper.CLOSE_MODAL_DIALOG
                                    )
                            )
                    );
                    screen.hideControls();

                    //RTL-1886 If scanned with error clear text field
                    if (!Strings.isNullOrEmpty(payload.getScanType()) && !Strings.isNullOrEmpty(payload.getScanData())) {
                        payload.setDocumentBarcode("");
                    }
                } else {
                    screen.resultCount(result.size());
                    screen.setTable(
                            result
                                    .parallelStream()
                                    .map(x -> {
                                        String[] row = new String[10];
                                        row[0] = x.getStatus();
                                        row[1] = dateFormat.format(x.getDocDate());
                                        row[2] = x.getDocNumber();
                                        row[3] = x.getType();
                                        row[4] = localeComponent.locale("warehouse.supply.view.document.screen.header.accepted_box_text");
                                        row[5] = String.format(
                                                "%s / %s",
                                                x.getFactBoxes(),
                                                x.getTotalBoxes()
                                        );
                                        row[6] = localeComponent.locale("warehouse.supply.view.document.screen.header.unit_text");
                                        row[7] = String.format(
                                                "%s / %s",
                                                x.getFactQuantity(),
                                                x.getTotalQuantity()
                                        );
                                        row[8] = x.getIdd();
                                        row[9] = localeComponent.locale(x.getStatus());
                                        return row;
                                    })
                                    .collect(Collectors.toList())
                                    .toArray(String[][]::new)
                    );
                    screen.setSignal(Signal.success());
                }
            }
        } catch (Exception exception) {
            logger.error(
                    "Searching document got exception.",
                    exception
            );

            //RTL-1886 If scanned with error clear text field
            if (!Strings.isNullOrEmpty(payload.getScanType()) && !Strings.isNullOrEmpty(payload.getScanData())) {
                payload.setDocumentBarcode("");
            }

            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.search.result.title.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.SUPPLY_SEARCH_DOCUMENT.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
        }

        return screen;
    }

    private Screen getRecalculationBoxScreenView(
            SupplyRecalculationBoxDataContext payload,
            MovingDocumentModel movingDocumentModel,
            boolean isNeedScannedMark
    ) {
        UrlHelper.setCurrentScreen(WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen());
        SupplyRecalculationBoxScreenView warehouseSupplySearchScreenView = new SupplyRecalculationBoxScreenView(payload.isShowTextField());
        payload.setHeaderTitle(localeComponent.locale("warehouse.supply.recalculation.box.screen.title"));
        payload.setFooterText(localeComponent.locale("warehouse.supply.recalculation.box.screen.footer"));
        payload.setQuantityLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.label.quantity_plan"));
        payload.setQuantityFactLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.label.quantity_fact"));
        payload.setQuantityDiffLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.label.quantity_diff"));
        payload.setChangeQuantityButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.change_quantity"));
        payload.setClearPositionFactButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.clear_position_fact"));
        payload.setRemovePositionButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.remove_position"));
        payload.setDeletePositionButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.remove_position"));
        payload.setViewPositionImageButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.view_position_image"));
        payload.setAddMarkButton(localeComponent.locale("warehouse.supply.popup.menu.goods.button.label.add_mark"));
        payload.setLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.label"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setHandleEnterCodeText(localeComponent.locale("warehouse.supply.recalculation.box.screen.handle_enter_code"));
        payload.setCodeNumberText(localeComponent.locale("warehouse.supply.recalculation.box.screen.code_number"));
        payload.setButtonSearchText(localeComponent.locale("warehouse.supply.search.screen.button"));
        payload.setClearFactAllPositionButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.clear_fact_all_position"));
        payload.setConfidentialAcceptanceButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.confidential_acceptance"));
        payload.setViewDiscrepanciesButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.view_discrepancies"));
        payload.setPrintingPackagingButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.printing_packaging"));


        if (Objects.nonNull(movingDocumentModel)) {
            payload.setIddDocument(movingDocumentModel.getId());
            payload.setStatus(movingDocumentModel.getStatus());
            payload.setCreatedAt(dateTimeFormat.format(movingDocumentModel.getCreatedDate()));
            payload.setCount(movingDocumentModel.getCount());
            payload.setIdLot(movingDocumentModel.getLotId());
            payload.setIddAcceptanceDocument(movingDocumentModel.getId());
            payload.setQuantity(movingDocumentModel.getQuantity());
            payload.setQuantityFact(movingDocumentModel.getQuantityFact());
            payload.setQuantityDiff(ControlHelper.plusMinusSetter(movingDocumentModel.getQuantityDiff()));
            warehouseSupplySearchScreenView.setSignal(Signal.success());

            if (movingDocumentModel.getProductModels().size() > 0) {
                List<Composable> blocks = movingDocumentModel.getProductModels()
                        .parallelStream()
                        .map(
                                x -> ControlHelper.getBlockItem(
                                        x.getName(),
                                        x.getCountPlan(),
                                        x.getCountFact(),
                                        x.getCountDiff(),
                                        x.getCountDiffProductsIntoLot(),
                                        x.isLot(),
                                        x.isMark(),
                                        x.isScannedMark(),
                                        x.getPrice(),
                                        x.getId(),
                                        x.getBarcode(),
                                        x.getLineNumber()
                                )
                        )
                        .collect(Collectors.toList());
                warehouseSupplySearchScreenView.setBody(blocks);
            }
        }

        if (isNeedScannedMark) {
            warehouseSupplySearchScreenView.setSignal(Signal.warning());
            warehouseSupplySearchScreenView.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.recalculation.box.screen.title.need_scanned_mark"),
                            localeComponent.locale("warehouse.supply.recalculation.box.screen.message.need_scanned_mark"),
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.SUPPLY_RECALCULATION_BOX_UPDATE.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
        }

        ScanAction scanAction = new ScanAction(
                UrlHelper
                        .getUrlToCurrentResource()
                        .concat("/")
                        .concat(WarehouseScreen.SUPPLY_RECALCULATION_BOX_UPDATE.getWarehouseScreen())
        );
        warehouseSupplySearchScreenView.setScanAction(scanAction);
        warehouseSupplySearchScreenView.setUrlToBack(
                String.format(
                        "%s/%s?args=%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.SUPPLY_VIEW_DOCUMENT.getWarehouseScreen(),
                        payload.getIddDocument()
                )
        );
        warehouseSupplySearchScreenView.setDataContext(payload);
        return warehouseSupplySearchScreenView;
    }

    public Screen getScanBlockedMarkLotPopupScreenView(SupplyRecalculationBoxDataContext payload) {
        SupplyScanBlockedMarkLotPopupScreenView screen = new SupplyScanBlockedMarkLotPopupScreenView();
        payload.setHeaderTitle(localeComponent.locale("warehouse.supply.problem.marks.title"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setTextLineFirst(localeComponent.locale("warehouse.supply.popup.scan.error.mark_lot_first_line"));
        payload.setTextLineSecond(localeComponent.locale("warehouse.supply.popup.scan.error.mark_lot_second_line"));
        payload.setTextButton(localeComponent.locale("warehouse.supply.popup.scan.error.button"));
        screen.setDataContext(payload);
        return screen;
    }

    private Screen setRecalculationBoxScreenView(SupplyRecalculationBoxDataContext payload) {
        Screen screen = null;

        try {
            if (!Strings.isNullOrEmpty(payload.getScanType()) && !Strings.isNullOrEmpty(payload.getScanData())) {
                String barcode = payload.getScanData();

                if (Objects.isNull(barcode)) {
                    throw new Exception(localeComponent.locale("warehouse.supply.error.problem_with_barcode"));
                } else {
                    payload.setBarcodeBox(barcode);
                }
            }

            if (
                    Strings.isNullOrEmpty(payload.getBarcodeBox()) &&
                            Strings.isNullOrEmpty(payload.getIddDocument())
            ) {
                throw new Exception(localeComponent.locale("warehouse.supply.search.message.empty_barcode_box_and_idd_document"));
            } else {
                MovingDocumentModel movingDocumentModel = receivingService.acceptanceBox(
                        payload.getBarcodeBox(),
                        payload.getIddDocument()
                );
                screen = getRecalculationBoxScreenView(payload, movingDocumentModel, false);
            }
        } catch (Exception exception) {
            payload.setScanData(null);
            payload.setScanType(null);
            screen = getRecalculationBoxScreenView(payload, null, false);
            logger.error(
                    "Supplying box got exception.",
                    exception
            );
            String message = exception.getMessage();

            if (Objects.nonNull(message) && message.contains("ui_warehouse_products")) {
                message = localeComponent.locale("warehouse.supply.search.message.ui_warehouse_products");
            }

            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.search.title.error"),
                            message,
                            String.format(
                                    "%s/%s?%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.SUPPLY_SEARCH_BOX.getWarehouseScreen(),
                                    UrlHelper.CLOSE_MODAL_DIALOG
                            )
                    )
            );
            screen.hideControls();
        }

        if (Objects.isNull(screen.getScanAction())) {
            screen.setScanAction(
                    new ScanAction(
                            String.format(
                                    "%s/%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen()
                            )
                    )
            );
        }
        return screen;
    }

    private Screen setRecalculationBoxScreenViewUpdate(SupplyRecalculationLotDataContext payload) {
        Screen screen = null;

        try {
            if (Strings.isNullOrEmpty(payload.getScanData()) && Strings.isNullOrEmpty(payload.getHandleSearch())) {
                throw new Exception(localeComponent.locale("warehouse.supply.search.message.error.search_is_empty"));
            }

            MovingDocumentModel movingDocumentModel = receivingService.acceptanceProduct(
                    payload.getIddAcceptanceDocument(),
                    payload.getBarcodeBox(),
                    payload.getHandleSearch(),
                    payload.getScanData(),
                    payload.getNotCountQuantityLot(),
                    payload.getLineNumber()
            );

            if (Objects.isNull(movingDocumentModel)) {
                if (receivingService.existBox(payload.getHandleSearch())) {
                    payload.setBarcodeBox(payload.getHandleSearch());
                    payload.setHandleSearch("");
                    screen = setRecalculationBoxScreenView(payload);
                } else {
                    throw new Exception(localeComponent.locale("warehouse.supply.search.message.error.product_not_found"));
                }
            } else {
                payload.setHandleSearch("");
                payload.setScanData("");

                if (movingDocumentModel.getType() == MovingDocumentModelType.PRODUCT) {
                    payload.setIdLot(null);
                    screen = getRecalculationBoxScreenView(payload, movingDocumentModel, false);
                } else if (movingDocumentModel.getType() == MovingDocumentModelType.SCANNED_MARK) {
                    screen = getRecalculationBoxScreenView(payload, movingDocumentModel, true);
                } else if (movingDocumentModel.getType() == MovingDocumentModelType.LOT) {
                    payload.setIdLot(movingDocumentModel.getLotId());
                    payload.setLineNumberLot(movingDocumentModel.getLineNumberLot());
                    screen = setRecalculationLotScreenView(payload);
                } else if (movingDocumentModel.getType() == MovingDocumentModelType.MARK_LOT) {
                    screen = getScanBlockedMarkLotPopupScreenView(payload);
                }
            }
        } catch (Exception exception) {
            payload.setScanData(null);
            payload.setScanType(null);
            payload.setHandleSearch("");
            screen = setRecalculationBoxScreenView(payload);
            logger.error(
                    "Acceptance good got exception.",
                    exception
            );
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.search.goods.title.error"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();
        }

        if (Objects.isNull(screen.getScanAction())) {
            screen.setScanAction(
                    new ScanAction(
                            String.format(
                                    "%s/%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.SUPPLY_RECALCULATION_BOX_UPDATE.getWarehouseScreen()
                            )
                    )
            );
        }

        return screen;
    }

    private Screen setRecalculationLotScreenView(SupplyRecalculationLotDataContext payload) {
        Screen screen = null;
        MovingDocumentModel movingDocumentModel = null;

        try {

            if (!Strings.isNullOrEmpty(payload.getScanData())) {
                payload.getScanData().toUpperCase();
            }

            movingDocumentModel = receivingService.acceptanceProductIntoLot(
                    payload.getIddAcceptanceDocument(),
                    payload.getBarcodeBox(),
                    payload.getBarcodeProduct(),
                    payload.getScanData(),
                    payload.getIdLot(),
                    payload.getLineNumberLot()
            );

            if (payload.isButtonFinish()) {
                if (Strings.isNullOrEmpty(payload.getScanData()) && Strings.isNullOrEmpty(payload.getBarcodeProduct())) {
                    throw new Exception(localeComponent.locale("warehouse.supply.search.message.error.search_is_empty"));
                }
            }

            payload.setButtonFinish(false);
            payload.setBarcodeProduct("");
            payload.setHandleSearch("");
            payload.setScanData("");

            if (movingDocumentModel.getType() == MovingDocumentModelType.SCANNED_MARK) {
                screen = getRecalculationLotScreenView(payload, movingDocumentModel, true);
            } else {
                screen = getRecalculationLotScreenView(payload, movingDocumentModel, false);
            }
        } catch (Exception exception) {
            if (Objects.isNull(movingDocumentModel) && !exception.getMessage().equals("warehouse.supply.search.goods.open.lot.error")) {
                screen = getRecalculationBoxScreenView(payload, null, false);
            } else {
                screen = getRecalculationLotScreenView(payload, movingDocumentModel, false);
            }


            logger.error(
                    "Acceptance lot got exception.",
                    exception
            );
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.search.lot.title.error"),
                            localeComponent.locale(exception.getMessage())
                    )
            );
            screen.hideControls();
        }

        return screen;
    }

    private Screen getRecalculationLotScreenView(
            SupplyRecalculationLotDataContext payload,
            MovingDocumentModel movingDocumentModel,
            boolean isNeedScannedMark
    ) {
        SupplyRecalculationLotScreenView supplyRecalculationLotScreenView = new SupplyRecalculationLotScreenView(payload.isShowTextField());
        payload.setHeaderTitle(localeComponent.locale("warehouse.supply.lot.recalculation.title"));
        payload.setFinish(localeComponent.locale("warehouse.supply.lot.recalculation.finish"));
        payload.setQuantityLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.label.quantity_plan"));
        payload.setQuantityFactLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.label.quantity_fact"));
        payload.setQuantityDiffLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.label.quantity_diff"));
        payload.setManualInputBarcodeButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.manual_input_barcode"));
        payload.setClearFactAllPositionButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.clear_fact_all_position"));
        payload.setConfidentialAcceptanceButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.confidential_acceptance"));
        payload.setViewDiscrepanciesButtonText(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.view_discrepancies"));
        payload.setHandleEnterCodeText(localeComponent.locale("warehouse.supply.recalculation.box.screen.handle_enter_code"));
        payload.setCodeNumberText(localeComponent.locale("warehouse.supply.recalculation.box.screen.code_number"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());

        if (Objects.nonNull(movingDocumentModel)) {
            payload.setLotName(movingDocumentModel.getLotName());
            payload.setIddDocument(movingDocumentModel.getId());
            payload.setIdLot(movingDocumentModel.getLotId());
            payload.setStatus(movingDocumentModel.getStatus());
            payload.setCreatedAt(dateTimeFormat.format(movingDocumentModel.getCreatedDate()));
            payload.setCount(movingDocumentModel.getCount());
            payload.setIddAcceptanceDocument(movingDocumentModel.getId());
            payload.setQuantity(movingDocumentModel.getQuantity());
            payload.setQuantityFact(movingDocumentModel.getQuantityFact());
            payload.setQuantityDiff(ControlHelper.plusMinusSetter(movingDocumentModel.getQuantityDiff()));

            List<Composable> blocks = movingDocumentModel.getProductModels()
                    .parallelStream()
                    .map(
                            x -> ControlHelper.getBlockItemLot(
                                    x.getName(),
                                    x.getCountPlan(),
                                    x.getCountFact(),
                                    x.getCountDiff(),
                                    x.isLot(),
                                    x.isMark(),
                                    x.isScannedMark(),
                                    x.getPrice(),
                                    x.getId()
                            )
                    )
                    .collect(Collectors.toList());
            supplyRecalculationLotScreenView.setBody(blocks);
            supplyRecalculationLotScreenView.setSignal(Signal.success());
        }

        if (isNeedScannedMark) {
            supplyRecalculationLotScreenView.setSignal(Signal.warning());
//            warehouseSupplyRecalculationLotScreenView.setModalDialog(
//                    ModalDialogHelper.getModalDialogOk(
//                            localeComponent.locale("warehouse.supply.recalculation.box.screen.need_scanned_mark"),
//                            localeComponent.locale("warehouse.supply.recalculation.box.screen.need_scanned_mark"),
//                            String.format(
//                                    "%s/%s?%s",
//                                    UrlHelper.getUrlToCurrentResource(),
//                                    WarehouseScreen.SUPPLY_RECALCULATION_BOX_UPDATE.getWarehouseScreen(),
//                                    UrlHelper.CLOSE_MODAL_DIALOG
//                            )
//                    )
//            );
        }

        supplyRecalculationLotScreenView.setScanAction(
                new ScanAction(
                        String.format(
                                "%s/%s",
                                UrlHelper.getUrlToCurrentResource(),
                                WarehouseScreen.SUPPLY_RECALCULATION_LOT.getWarehouseScreen()
                        )
                )
        );
        supplyRecalculationLotScreenView.setDataContext(payload);
        return supplyRecalculationLotScreenView;
    }

    private Screen getSupplyConfirmDiscrepancy(SupplyConfirmDiscrepancyDataContext payload) {
        SupplyConfirmDiscrepancyScreenView screen = new SupplyConfirmDiscrepancyScreenView();

        try {
            ConfirmDiscrepancyModel viewModel = receivingService.confirmDiscrepancy(payload.getSelectedDocumentIdd());
            payload.setHeaderTitle(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.title"));
            payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
            payload.setFurther(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.button.text"));
            payload.setAcceptedLabel(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.accepted_label"));
            payload.setConfirmedLabel(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.confirmed_label"));
            payload.setCommentLabel(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.comment_label"));
            payload.setDocumentNumber(viewModel.getDocumentNumber());
            if (!Strings.isNullOrEmpty(payload.getSelectedTextField())) {
                if (payload.getSelectedTextField().equals("receivingPerson")) {
                    payload.setReceivingPerson(payload.getFullName());
                    payload.setReceivingPersonId(payload.getId());
                }
                if (payload.getSelectedTextField().equals("confirmingPerson")) {
                    payload.setConfirmingPerson(payload.getFullName());
                    payload.setConfirmingPersonId(payload.getId());
                }
            } else {
                payload.setReceivingPerson(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.full.name"));
                payload.setConfirmingPerson(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.full.name"));
            }

            String[] header = {
                    localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.level"),
                    localeComponent.locale("warehouse.supply.search.result.screen.table.header.plan"),
                    localeComponent.locale("warehouse.supply.search.result.screen.table.header.actual"),
                    localeComponent.locale("warehouse.supply.recalculation.box.screen.table.header.consumption")
            };

            List<List<String>> lists = List.of(
                    List.of(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.box"), String.valueOf(viewModel.getBoxPlan()), String.valueOf(viewModel.getBoxFact()), String.valueOf(viewModel.getBoxFact() - viewModel.getBoxPlan())),
                    List.of(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.total_goods"), String.valueOf(viewModel.getProductPlan()), String.valueOf(viewModel.getProductFact()), String.valueOf(viewModel.getProductFact() - viewModel.getProductPlan())),
                    List.of(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.including_lots"), String.valueOf(viewModel.getLotPlan()), String.valueOf(viewModel.getLotFact()), String.valueOf(viewModel.getLotFact() - viewModel.getLotPlan())),
                    List.of(localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.including_goods_in_lots"), String.valueOf(viewModel.getLotProductPlan()), String.valueOf(viewModel.getLotProductFact()), String.valueOf(viewModel.getLotProductFact() - viewModel.getLotProductPlan()))
            );

            screen.setData(header, lists
                    .parallelStream()
                    .map(x -> x.toArray(String[]::new))
                    .toArray(String[][]::new));

            screen.setDataContext(payload);
            screen.createButton();
        } catch (Exception exception) {
            logger.error(
                    "Confirm discrepancy got exception.",
                    exception
            );
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.confirm.discrepancy.screen.error.title"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.SUPPLY_VIEW_DOCUMENT.getWarehouseScreen()
                            )
                    )
            );
            screen.setDataContext(payload);
        }
        return screen;
    }

    private Screen confirmAcceptanceDelivery(SupplyConfirmDiscrepancyDataContext payload) {
        SupplyConfirmDiscrepancyScreenView screen = new SupplyConfirmDiscrepancyScreenView();
        screen.setDataContext(payload);

        try {
            receivingService.confirmAcceptanceDelivery(
                    payload.getSelectedDocumentIdd(),
                    payload.getReceivingPersonId(),
                    payload.getConfirmingPersonId(),
                    payload.getComment()
            );
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.confirm.acceptance.delivery.yes.title"),
                            localeComponent.locale("warehouse.supply.confirm.acceptance.delivery.yes.message"),
                            UrlHelper.getUrlToCurrentResource()
                    )
            );
        } catch (Exception exception) {
            logger.error(
                    "Confirm acceptance got exception.",
                    exception
            );
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.confirm.acceptance.delivery.yes.title"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.SUPPLY_CONFIRM_DISCREPANCY.getWarehouseScreen()
                            )
                    )
            );
        }
        return screen;
    }

    public Screen getGoodImageScreenView(SupplyImageProductDataContext payload) {
        SupplyGoodImageScreenView screen = new SupplyGoodImageScreenView();
        payload.setHeaderTitle(localeComponent.locale("warehouse.supply.popup.menu.goods.image.title"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        try {
            if (
                    Strings.isNullOrEmpty(payload.getSelectedProductId())
            ) {
                throw new Exception(localeComponent.locale("warehouse.supply.popup.menu.good_is_null_or_empty"));
            } else {

                ProductModel productModel = null;

                if (Strings.isNullOrEmpty(payload.getIdLot())) {
                    productModel = receivingService.getProduct(payload.getSelectedProductId());
                } else {
                    productModel = receivingService.getOpenLot(payload.getSelectedProductId());
                }
                payload.setProductTitle(productModel.getName());
                payload.setImageUrl(
                        String.format(
                                "%s/%s%s",
                                getImageUrl,
                                productModel.getBarcode(),
                                getImageAttribute
                        )
                );
                screen.setDataContext(payload);
            }
        } catch (Exception exception) {
            logger.error(
                    "Failed to get a link to the product image.",
                    exception
            );
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.search.lot.title.error"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();
        }

        if (!Strings.isNullOrEmpty(payload.getIdLot())) {
            screen.setUrlToBack(
                    String.format(
                            "%s/%s?args=%s",
                            UrlHelper.getUrlToCurrentResource(),
                            WarehouseScreen.SUPPLY_RECALCULATION_LOT.getWarehouseScreen(),
                            payload.getHandleSearch()
                    )
            );
        } else {
            screen.setUrlToBack(
                    String.format(
                            "%s/%s",
                            UrlHelper.getUrlToCurrentResource(),
                            WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen()
                    )
            );
        }
        return screen;
    }

    public Screen setChangeQuantityScreenView(SupplyChangeQuantityDataContext payload) {
        Screen screen = null;

        try {
            if (
                    Strings.isNullOrEmpty(payload.getBarcodeBox()) &&
                            Strings.isNullOrEmpty(payload.getIddDocument())
            ) {
                throw new Exception(localeComponent.locale("warehouse.supply.search.message.empty_barcode_box_and_idd_document"));
            } else {
                ProductModel productModel = null;

                if (Strings.isNullOrEmpty(payload.getIdLot())) {
                    productModel = receivingService.getProduct(payload.getSelectedProductId());
                } else {
                    productModel = receivingService.getOpenLot(payload.getSelectedProductId());
                }

                screen = getChangeQuantityScreenView(payload, productModel);
            }
        } catch (Exception exception) {
            screen = getChangeQuantityScreenView(payload, null);
            logger.error(
                    "Supplying product got exception.",
                    exception
            );
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.search.lot.title.error"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();
        }

        return screen;
    }

    public Screen getChangeQuantityScreenView(SupplyChangeQuantityDataContext payload, ProductModel productModel) {
        SupplyChangeQuantityScreenView screen = null;
        payload.setHeaderTitle(localeComponent.locale("warehouse.supply.box.menu.screen.button.label.change_quantity"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setProductNameLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.table.header.goods"));
        payload.setChangeQuantityLabel(localeComponent.locale("warehouse.supply.update.fact.position.screen.label"));
        payload.setProductPlanLabel(localeComponent.locale("warehouse.supply.search.result.screen.table.header.plan"));
        payload.setProductFactLabel(localeComponent.locale("warehouse.supply.search.result.screen.table.header.actual"));
        payload.setSelectedProductName(productModel.getName());
        payload.setSelectedProductCountPlan(productModel.getCountPlan().toString());
        payload.setSelectedProductCountFact(productModel.getCountFact().toString());
        payload.setSaveButtonText(localeComponent.locale("warehouse.supply.popup.menu.goods.button.label.save"));
        payload.setCloseButtonText(localeComponent.locale("warehouse.supply.update.fact.position.screen.close.button.text"));
        String urlToBack;

        if (!Strings.isNullOrEmpty(payload.getIdLot())) {
            urlToBack = String.format(
                    "%s/%s",
                    UrlHelper.getUrlToCurrentResource(),
                    WarehouseScreen.SUPPLY_RECALCULATION_LOT.getWarehouseScreen());
        } else {
            urlToBack = String.format(
                    "%s/%s",
                    UrlHelper.getUrlToCurrentResource(),
                    WarehouseScreen.SUPPLY_RECALCULATION_BOX.getWarehouseScreen());
        }

        screen = new SupplyChangeQuantityScreenView(urlToBack);
        screen.setDataContext(payload);
        return screen;
    }

    public Screen changeQuantityUpdate(SupplyChangeQuantityDataContext payload) {
        Screen screen = null;

        try {
            if (Strings.isNullOrEmpty(payload.getSelectedProductCountFact())) {
                throw new Exception(localeComponent.locale("warehouse.supply.popup.menu.goods.fact.count.null.or.empty.error"));
            }

            if (Integer.parseInt(payload.getSelectedProductCountFact()) < 0) {
                throw new Exception(localeComponent.locale("warehouse.supply.popup.menu.goods.fact.count.less.zero.error"));
            }

            if (
                    Strings.isNullOrEmpty(payload.getBarcodeBox()) &&
                            Strings.isNullOrEmpty(payload.getIddDocument())
            ) {
                throw new Exception(localeComponent.locale("warehouse.supply.search.message.empty_barcode_box_and_idd_document"));
            } else {
                MovingDocumentModel movingDocumentModel = receivingService.updateProductOrLot(payload.getIdLot(), payload.getSelectedProductId(), payload.getSelectedProductCountFact(), payload.getLineNumberLot());

                if (movingDocumentModel.getType() == MovingDocumentModelType.PRODUCT) {
                    payload.setIdLot(null);
                    screen = getRecalculationBoxScreenView(payload, movingDocumentModel, false);
                } else if (movingDocumentModel.getType() == MovingDocumentModelType.LOT) {
                    screen = getRecalculationLotScreenView(payload, movingDocumentModel, false);
                }
            }
        } catch (Exception exception) {
            logger.error(
                    "Updating fact position threw an exception.",
                    exception
            );
            if (Strings.isNullOrEmpty(payload.getIdLot())) {
                screen = setRecalculationBoxScreenView(payload);
            } else {
                screen = setRecalculationLotScreenView(payload);
            }
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.update.fact.position.error"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();
        }

        return screen;
    }

    public Screen clearFactAllPositions(SupplyMenuProductDataContext payload) {
        Screen screen = null;
        MovingDocumentModel movingDocumentModel = null;
        try {
            if (Strings.isNullOrEmpty(payload.getBarcodeBox())) {
                throw new Exception(localeComponent.locale("warehouse.supply.search.message.empty_barcode_box_and_idd_document"));
            }

            movingDocumentModel = receivingService.acceptanceBox(
                    payload.getBarcodeBox(),
                    payload.getIddDocument()
            );
            if (!Strings.isNullOrEmpty(payload.getIdLot())) {
                movingDocumentModel.setLotId(payload.getIdLot());
                movingDocumentModel.setLineNumberLot(payload.getLineNumberLot());
            }

            if (movingDocumentModel.getProductModels() != null && movingDocumentModel.getProductModels().size() > 0) {
                movingDocumentModel = receivingService.clearFactAllProductsOrLots(payload.getBarcodeBox(), movingDocumentModel.getLotId(), payload.getLineNumberLot());
            }

            if (movingDocumentModel.getType() == MovingDocumentModelType.PRODUCT) {
                payload.setIdLot(null);
                screen = getRecalculationBoxScreenView(payload, movingDocumentModel, false);
            } else if (movingDocumentModel.getType() == MovingDocumentModelType.LOT) {
                screen = getRecalculationLotScreenView(payload, movingDocumentModel, false);
            }

        } catch (Exception exception) {
            logger.error(
                    "Clearing all positions threw an exception.",
                    exception
            );
            if (Strings.isNullOrEmpty(payload.getIdLot())) {
                screen = setRecalculationBoxScreenView(payload);
            } else {
                screen = setRecalculationLotScreenView(payload);
            }
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.clear.fact.all.positions.error"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();
        }
        return screen;
    }

    public Screen clearFactPosition(SupplyMenuProductDataContext payload) {
        Screen screen = null;

        try {
            if (Strings.isNullOrEmpty(payload.getBarcodeBox()) &&
                    Strings.isNullOrEmpty(payload.getIddDocument())
            ) {
                throw new Exception(localeComponent.locale("warehouse.supply.search.message.empty_barcode_box_and_idd_document"));
            } else {
                MovingDocumentModel movingDocumentModel = receivingService.updateProductOrLot(payload.getIdLot(), payload.getSelectedProductId(), "0", payload.getLineNumberLot());

                if (movingDocumentModel.getType() == MovingDocumentModelType.PRODUCT) {
                    payload.setIdLot(null);
                    screen = getRecalculationBoxScreenView(payload, movingDocumentModel, false);
                } else if (movingDocumentModel.getType() == MovingDocumentModelType.LOT) {
                    screen = getRecalculationLotScreenView(payload, movingDocumentModel, false);
                }
            }
        } catch (Exception exception) {
            logger.error(
                    "Clearing position threw an exception.",
                    exception
            );
            if (Strings.isNullOrEmpty(payload.getIdLot())) {
                screen = setRecalculationBoxScreenView(payload);
            } else {
                screen = setRecalculationLotScreenView(payload);
            }
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("warehouse.supply.clear.fact.position.error"),
                            exception.getMessage()
                    )
            );
            screen.hideControls();
        }

        return screen;
    }

    public Screen deletePosition(SupplyMenuProductDataContext payload) {
        Screen screen = null;

        try {
            if (Strings.isNullOrEmpty(payload.getSelectedProductId())) {
                throw new Exception(localeComponent.locale("warehouse.supply.popup.menu.goods.fact.count.null.or.empty.error"));
            }

            if (Strings.isNullOrEmpty(payload.getBarcodeBox()) &&
                    Strings.isNullOrEmpty(payload.getIddDocument())
            ) {
                throw new Exception(localeComponent.locale("warehouse.supply.search.message.empty_barcode_box_and_idd_document"));
            } else {
                MovingDocumentModel movingDocumentModel = receivingService.deleteProductOrLot(payload.getIdLot(), payload.getSelectedProductId());
                if (movingDocumentModel == null) {
                    screen = setRecalculationBoxScreenView(payload);
                } else if (movingDocumentModel.getType() == MovingDocumentModelType.PRODUCT) {
                    payload.setIdLot(null);
                    screen = getRecalculationBoxScreenView(payload, movingDocumentModel, false);
                } else if (movingDocumentModel.getType() == MovingDocumentModelType.LOT) {
                    screen = getRecalculationLotScreenView(payload, movingDocumentModel, false);
                }
            }
        } catch (Exception exception) {
            logger.error(
                    "Deleting product threw an exception.",
                    exception
            );
            screen = setRecalculationBoxScreenView(payload);
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

    public Screen getEmployeeList(SupplyConfirmDiscrepancyDataContext payload) {
        SupplyEmployeeListScreenView screen = null;

        try {
            screen = new SupplyEmployeeListScreenView();
            payload.setHeaderTitle(localeComponent.locale("warehouse.supply.employee.list.screen.title"));
            payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
            screen.setDataContext(payload);
            screen.setScanAction(new ScanAction(UrlHelper.getUrlToCurrentScreen()));
            EmployeeListModel employeeListModel = receivingService.getEmployeeList();
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
}
