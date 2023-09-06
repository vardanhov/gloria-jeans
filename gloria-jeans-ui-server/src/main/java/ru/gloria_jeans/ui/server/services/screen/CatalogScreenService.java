package ru.gloria_jeans.ui.server.services.screen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.core.v1.catalog.models.response.CityBalance;
import ru.gloria_jeans.core.v1.catalog.models.response.ProductInformationListModel;
import ru.gloria_jeans.core.v1.catalog.models.response.ProductInformationModel;
import ru.gloria_jeans.ui.server.component.LocaleComponent;
import ru.gloria_jeans.ui.server.jetpackcompose.control.*;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.product_information.ProductInformationCityBalanceDataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.product_information.ProductInformationDataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.datacontext.product_information.ProductInformationSearchDataContext;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.WarehouseScreen;
import ru.gloria_jeans.ui.server.jetpackcompose.helper.ModalDialogHelper;
import ru.gloria_jeans.ui.server.jetpackcompose.view.wirehouse.product_information.*;
import ru.gloria_jeans.ui.server.services.CatalogService;
import ru.gloria_jeans.ui.server.utils.UrlHelper;

import java.text.DateFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CatalogScreenService extends BaseScreenService {
    private final CatalogService catalogService;
    private final LocaleComponent localeComponent;
    private DateFormat dateFormat;


    @Value("${receiving.image}")
    String getImageUrl;
    @Value("${receiving.attribute}")
    String getImageAttribute;

    @Autowired
    public CatalogScreenService(
            @Value("${base-server-url}") String baseServerUrl,
            CatalogService catalogService,
            Locale locale,
            LocaleComponent localeComponent
    ) {
        super(baseServerUrl);
        this.catalogService = catalogService;
        this.localeComponent = localeComponent;

        this.dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
    }

    @Override
    public Screen getScreen(Object payload, DeviceInfo deviceInfo, UserInfo userInfo) {
        Screen screen = null;

        switch (WarehouseScreen.valueOf(UrlHelper.getCurrentScreen().toUpperCase())) {
            case CATALOG_SEARCH_PRODUCT: {
                screen = new ProductInformationSearchScreenView();
                ProductInformationSearchDataContext productInformationSearchDataContext = new ProductInformationSearchDataContext();
                productInformationSearchDataContext.setHeaderTitle(localeComponent.locale("product.information.title"));
                productInformationSearchDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                productInformationSearchDataContext.setLabel(localeComponent.locale("warehouse.supply.search.box.screen.barcode.label"));
                productInformationSearchDataContext.setLabelUnderLabel(localeComponent.locale("product.information.input.product.number.manually.label"));
                productInformationSearchDataContext.setBarcodeLabel(localeComponent.locale("warehouse.supply.recalculation.box.screen.code_number"));
                productInformationSearchDataContext.setSearchButtonText(localeComponent.locale("warehouse.supply.search.screen.button"));
                productInformationSearchDataContext.setButtonSearchProductByVendorCode(localeComponent.locale("product.button.find_product_by_vendor_code"));
                productInformationSearchDataContext.setScanData(((DataContext) payload).getScanData());
                screen.setDataContext(productInformationSearchDataContext);
                screen.setScanAction(new ScanAction(String.format("%s/%s",
                        UrlHelper.getUrlToCurrentResource(),
                        WarehouseScreen.CATALOG_PRODUCT_INFORMATION_RESULT.getWarehouseScreen())));
                break;
            }

            case CATALOG_PRODUCT_INFORMATION_RESULT: {
                screen = getProductInformationScreen((ProductInformationDataContext) payload);
                break;
            }

            case CATALOG_ENLARGE_PRODUCT_IMAGE: {
                screen = new ProductInformationEnlargedScreenView();
                ProductInformationDataContext productInformationDataContext = (ProductInformationDataContext) payload;
                productInformationDataContext.setHeaderTitle(localeComponent.locale("product.information.title"));
                productInformationDataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                screen.setDataContext(productInformationDataContext);
                break;
            }

            case CATALOG_PRODUCT_GET_MODELS_BALANCE: {
                ProductInformationDataContext dataContext = (ProductInformationDataContext) payload;
                screen = new ProductInformationModelsBalanceScreenView();
                ((ProductInformationModelsBalanceScreenView) screen).setTable(
                        dataContext.getModelsBalanceList()
                                .parallelStream()
                                .map(x -> {
                                    String[] row = new String[3];
                                    row[0] = x.getItemName();
                                    row[1] = x.getCount().toString();
                                    row[2] = x.getPrice();
                                    return row;
                                })
                                .collect(Collectors.toList())
                                .toArray(String[][]::new));
                screen.setDataContext(payload);
                break;
            }

            case CATALOG_PRODUCT_CITY_BALANCE: {
                screen = getCityBalanceScreen((ProductInformationCityBalanceDataContext) payload); new ProductInformationCityBalanceScreenView();
                break;
            }
        }
        if (Objects.nonNull(screen)) {
            screen.initHeader();
            screen.initFooter();
        }
        return screen;
    }

    public Screen getProductInformationScreen(ProductInformationDataContext payload) {
        Screen screen = new ProductInformationScreenView();
        payload.setHeaderTitle(localeComponent.locale("product.information.title"));
        payload.setExpandedHeader(localeComponent.locale("product.information.expanded.header.without.diff.price"));
        payload.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
        payload.setPriceName(localeComponent.locale("product.information.price.name"));
        payload.setRemainsName(localeComponent.locale("product.information.remains.name"));
        payload.setTotalBalanceLabel(localeComponent.locale("product.information.total.balance.label"));
        payload.setCityBalance(localeComponent.locale("product.information.city.balance.label"));
        screen.setScanAction(new ScanAction(String.format("%s/%s",
                UrlHelper.getUrlToCurrentResource(),
                WarehouseScreen.CATALOG_PRODUCT_INFORMATION_RESULT.getWarehouseScreen())));

        try {
            ProductInformationListModel productInformationListModel = catalogService.searchProduct(payload.getHandleSearch());

            if (productInformationListModel.getProductInformationModels().size() == 1) {
                ProductInformationModel productInformationModel = productInformationListModel.getProductInformationModels().get(0);
                ((ProductInformationScreenView) screen).setMark(
                        productInformationModel.getHasMarks(),
                        productInformationModel.getValidMark(),
                        productInformationModel.getSerialNumberOfMark(),
                        localeComponent.locale(productInformationModel.getStatusOfMark())
                );

                payload.setModelsBalanceList(productInformationModel.getModelsBalanceList());
                payload.setProductName(productInformationModel.getProductName());
                payload.setMarkdown(localeComponent.locale(productInformationModel.getPriceType()));
                payload.setPriceLabel(localeComponent.locale("product.information.price.label"));
                payload.setPrice(productInformationModel.getPrice());
                payload.setSelectedProductIdd(productInformationModel.getIdd());

                if (productInformationModel.getDate() != null) {
                    payload.setDate(dateFormat.format(productInformationModel.getDate()));
                }

                payload.setBalanceLabel(localeComponent.locale("product.information.remaining.goods.label"));
                payload.setBalance(productInformationModel.getRemainingGoods());
                payload.setTotalBalance(productInformationModel.getTotalQuantity());
                payload.setBarcode(productInformationModel.getBarCode());
                payload.setImageUrl(
                        String.format(
                                "%s/%s%s",
                                getImageUrl,
                                payload.getBarcode(),
                                getImageAttribute
                        )
                );
                String collapseTextButton;

                if (productInformationListModel.getProductInformationModels().get(0).getSizeRange()
                        .parallelStream()
                        .anyMatch(e -> !e.getPrice().equals(productInformationModel.getPrice()))) {
                    collapseTextButton = localeComponent.locale("product.information.expanded.header.with.diff.price");
                } else {
                    collapseTextButton = localeComponent.locale("product.information.expanded.header.without.diff.price");
                }

                ((ProductInformationScreenView) screen).setTable(
                        productInformationListModel.getProductInformationModels().get(0).getSizeRange()
                                .parallelStream()
                                .map(x -> {
                                    String[] row = new String[3];
                                    row[0] = x.getItemName();
                                    row[1] = x.getCount().toString();
                                    row[2] = x.getPrice();
                                    return row;
                                })
                                .collect(Collectors.toList())
                                .toArray(String[][]::new),
                        collapseTextButton,
                        productInformationModel.getPrice());
                screen.setDataContext(payload);
            } else {
                screen = new ProductInformationTableScreenView(productInformationListModel.getProductInformationModels());
                ProductInformationSearchDataContext productInformationSearchDataContext1 = new ProductInformationSearchDataContext();
                productInformationSearchDataContext1.setHeaderTitle(localeComponent.locale("product.information.title"));
                productInformationSearchDataContext1.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());
                screen.setDataContext(productInformationSearchDataContext1);
            }
        } catch (Exception exception) {
            logger.error(
                    "Getting product information threw an exception.",
                    exception
            );
            screen = new ProductInformationScreenView();
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("product.information.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.CATALOG_SEARCH_PRODUCT.getWarehouseScreen()
                            )
                    )
            );
            screen.setDataContext(payload);
            screen.hideControls();
        }
        
        return screen;
    }

    private Screen getCityBalanceScreen(ProductInformationCityBalanceDataContext dataContext) {
        ProductInformationCityBalanceScreenView screen = new ProductInformationCityBalanceScreenView();
        dataContext.setHeaderTitle(localeComponent.locale("product.information.city.balance.label"));
        dataContext.setCityBalanceQuantity(localeComponent.locale("product.information.city_balance_quantity"));
        dataContext.setHeaderRefreshAction(UrlHelper.getUrlToCurrentScreen());

        try {
            CityBalance cityBalance = catalogService.getCityBalance(dataContext.getSelectedProductIdd());
            screen.setTable(cityBalance.getShopQuantities());
            screen.setDataContext(dataContext);
        } catch (Exception exception) {
            logger.error(
                    "Getting city balance threw an exception.",
                    exception
            );
            screen.setSignal(Signal.error());
            screen.setModalDialog(
                    ModalDialogHelper.getModalDialogOk(
                            localeComponent.locale("product.information.error"),
                            exception.getMessage(),
                            String.format(
                                    "%s/%s",
                                    UrlHelper.getUrlToCurrentResource(),
                                    WarehouseScreen.CATALOG_PRODUCT_INFORMATION_RESULT.getWarehouseScreen()
                            )
                    )
            );
            screen.setDataContext(dataContext);
            screen.hideControls();
        }

        return screen;
    }
}
