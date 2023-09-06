package ru.gloria_jeans.orders.services;

import com.google.common.base.Strings;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.core.v1.orders.enums.OrderType;
import ru.gloria_jeans.core.v1.orders.model.response.PackingListModel;
import ru.gloria_jeans.core.v1.orders.model.response.StickerModel;
import ru.gloria_jeans.orders.dao.enums.FileType;
import ru.gloria_jeans.orders.dao.enums.PrintFormType;
import ru.gloria_jeans.orders.dao.model.BuyerInlayModel;
import ru.gloria_jeans.orders.dao.model.ReceiptOrdersModel;
import ru.gloria_jeans.orders.utils.FileNameHelper;

import javax.sql.DataSource;
import java.io.File;
import java.util.*;


@Service
public class PrintService {
    public Logger logger = LoggerFactory.getLogger("OrdersService");
    private final String directoryPrintedFile;
    private final DataSource dataSource;

    @Autowired
    public PrintService(
            @Value("${directory.printed.file}") String directoryPrintedFile,
            @Qualifier("internalServiceDataSource") DataSource dataSource
    ){
        this.directoryPrintedFile =  directoryPrintedFile;
        this.dataSource = dataSource;
    }

    public void createSticker(StickerModel stickerModel) throws Exception {
        logger.info("Start creating pdf file for sticker with parameters: stickerFileDirectory:'{}'", directoryPrintedFile);
        List<String> fileFolders = new ArrayList<>();
        fileFolders.add(directoryPrintedFile);
        fileFolders.add(OrderType.SFS.value);
        fileFolders.add(PrintFormType.STICKER.value);
        File file = FileNameHelper.setFileName(fileFolders, stickerModel.getOrderNumber(), FileType.STICKER.value);
        logger.info("File name was generated:'{}'", file.getPath());

        Map<String, Object> param = new HashMap<>();
        param.put("transportCompany", stickerModel.getTransportCompany());
        param.put("carrierBarcode", stickerModel.getCarrierBarcode());
        param.put("orderNumber", stickerModel.getOrderNumber());
        param.put("customerFullName", stickerModel.getBayerFullName());
        param.put("customerPhone", stickerModel.getBayerPhoneNumber());
        param.put("customerAddress", stickerModel.getBayerAddress());
        param.put("weight", stickerModel.getWeight());
        param.put("place", stickerModel.getPlace());
        param.put("fromPlace", stickerModel.getFromPlace());
        param.put("shopFullName", stickerModel.getShopFullName());


        logger.info("Checking sticker file directory");

        if (!new File(directoryPrintedFile).isDirectory()) {
            logger.info(
                    "Service cannot find sticker file directory"
            );
            throw new Exception("warehouse.internet.order.collect.orders.content.packing.list.pdf.directory.error");
        }

        logger.info("Trying to load sticker jasper file");
        JasperReport jasperReport;

        try {
            jasperReport = (JasperReport) JRLoader.loadObject(
                    getClass()
                            .getClassLoader()
                            .getResourceAsStream("reports/sticker.jasper")
            );
        } catch (Exception exception) {
            logger.error("Service cannot load sticker jasper file.", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.load.file.error", exception);
        }

        logger.info("Trying fill JasperReport in JasperPrint");
        JasperPrint jasperPrint;

        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JREmptyDataSource());
        } catch (JRException exception) {
            logger.error("Service cannot fill JasperReport", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.fill.report.error", exception);
        }

        logger.info("Trying create and export sticker pdf file");

        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());
        } catch (JRException exception) {
            logger.error("Service cannot create and export sticker file", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.export.file.error", exception);
        }

        logger.info("Sticker file created successfully");
    }
    public void createPackingList(PackingListModel packingListModel) throws Exception {
        logger.info("Start creating pdf file for packing list with parameters: packingListFileDirectory:'{}'", directoryPrintedFile);
        List<String> fileFolders = new ArrayList<>();
        fileFolders.add(directoryPrintedFile);
        fileFolders.add(OrderType.CR.value);
        fileFolders.add(PrintFormType.ISSUING_RECEIPTS.value);
        File file = FileNameHelper.setFileName(fileFolders, packingListModel.getOrderNumber(), FileType.PACKING_LIST.value);
        logger.info("Was generated filename:'{}'", file.getPath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(packingListModel.getItemModelList());

        Map<String, Object> param = new HashMap<>();
        param.put("orderNumber", packingListModel.getOrderNumber());
        param.put("orderDate", packingListModel.getOrderDate());
        param.put("collectDateTime", packingListModel.getCollectDateTime());
        param.put("orderBarcode", packingListModel.getOrderBarcode());
        param.put("bayerFullName", packingListModel.getBayerFullName());
        param.put("bayerPhoneNumber", packingListModel.getBayerPhoneNumber());
        param.put("bayerEmail", packingListModel.getBayerEmail());
        param.put("storeName", packingListModel.getStoreName());
        param.put("storeAddress", packingListModel.getStoreAddress());
        param.put("collectorFullName", packingListModel.getCollectorFullName());

        logger.info("Checking packing list file directory");
        if (!new File(directoryPrintedFile).isDirectory()) {
            logger.info(
                    "Service cannot find  pdf file directory"
            );
            throw new Exception("warehouse.internet.order.collect.orders.content.packing.list.pdf.directory.error");
        }

        logger.info("Trying to load packing list jasper file");
        JasperReport jasperReport;
        try {
            jasperReport = (JasperReport) JRLoader.loadObject(
                    getClass()
                            .getClassLoader()
                            .getResourceAsStream("reports/packing_list.jasper")
            );
        } catch (Exception exception) {
            logger.error("Service cannot load packing list jasper file", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.load.file.error", exception);
        }

        logger.info("Trying fill JasperReport in JasperPrint");
        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
        } catch (JRException exception) {
            logger.error("Service cannot fill JasperReport", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.fill.report.error", exception);
        }

        logger.info("Trying create and export packing list pdf file");
        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());
        } catch (JRException exception) {
            logger.error("Service cannot create and export packing list file", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.export.file.error", exception);
        }

        logger.info("Packing list file created successfully");
    }
    public void createBuyerInlay(BuyerInlayModel buyerInlayModel) throws Exception {
        logger.info("Start creating Buyer inlay pdf file");
        List<String> fileFolders = new ArrayList<>();
        fileFolders.add(directoryPrintedFile);
        fileFolders.add(OrderType.SFS.value);
        fileFolders.add(PrintFormType.BUYER_INLAY.value);
        File file = FileNameHelper.setFileName(fileFolders, buyerInlayModel.getOrderNumber(), FileType.INLAY.value);
        logger.info("File name was generated:'{}'", file.getPath());

        Map<String, Object> param = new HashMap<>();
        param.put("orderNumber", buyerInlayModel.getOrderNumber());
        param.put("orderDate", buyerInlayModel.getOrderDate());
        param.put("buyerEmail", buyerInlayModel.getBuyerEmail());
        param.put("buyerFullName", buyerInlayModel.getBuyerFullName());
        param.put("buyerPhoneNumber", buyerInlayModel.getBuyerPhoneNumber());
        param.put("deliveryAddress", buyerInlayModel.getDeliveryAddress());
        param.put("documentIdd", buyerInlayModel.getDocumentIdd());

        logger.info("Checking buyer inlay file directory");

        if (!new File(directoryPrintedFile).isDirectory()) {
            logger.info(
                    "Service cannot find buyer inlay file directory"
            );
            throw new Exception("warehouse.internet.order.collect.orders.content.buyer.inlay.pdf.directory.error");
        }

        logger.info("Trying to load buyer inlay jasper file");

        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(
                    getClass()
                            .getClassLoader()
                            .getResourceAsStream("reports/buyer_inlay.jasper")
            );

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource.getConnection());
            logger.info("JasperFillManager.fillReport for Buyer Inlay finish");
            JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());
            logger.info("JasperExportManager.exportReportToPdfFile for Buyer Inlay finish");
        } catch (Exception exception) {
            logger.error("Exception create pdf file for Buyer Inlay", exception);
            throw new Exception(exception.getMessage());
        }
    }

    public void createReceiptIssuingOrders(ReceiptOrdersModel receiptOrdersModel) throws Exception {
        logger.info("Start creating pdf file for 'Receipt Issuing Orders'");

        if (Strings.isNullOrEmpty(receiptOrdersModel.getTransportCompany())) {
            logger.error("Transport company is null or empty");
            throw new Exception("warehouse.internet.order.collect.orders.content.receipt.issues.order.empty.transport.company");
        }

        List<String> fileFolders = new ArrayList<>();
        fileFolders.add(directoryPrintedFile);
        fileFolders.add(OrderType.SFS.value);
        fileFolders.add(PrintFormType.ISSUING_RECEIPTS.value);

        File file = FileNameHelper.setFileName(
                fileFolders,
                String.format(
                        "%s_%s",
                        receiptOrdersModel.getCurrentTime().replace(":", "-"),
                        receiptOrdersModel.getTransportCompany()
                ),
                FileType.RECEIPT.value);
        logger.info("File name was generated:'{}'", file.getPath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(receiptOrdersModel.getOrderNumbers());

        Map<String, Object> param = new HashMap<>();
        param.put("orderCount", String.valueOf(receiptOrdersModel.getOrderNumbers().size()));
        param.put("transportCompany", receiptOrdersModel.getTransportCompany());
        param.put("shopFullName", receiptOrdersModel.getStoreFullName());
        param.put("currentDate", receiptOrdersModel.getCurrentDate());
        param.put("currentTime", receiptOrdersModel.getCurrentTime());

        logger.info("Checking 'Receipt Issuing Orders' file directory");

        if (!new File(directoryPrintedFile).isDirectory()) {
            logger.info("Service cannot find pdf file directory");
            throw new Exception("warehouse.internet.order.collect.orders.content.receipt.issues.order");
        }

        logger.info("Trying to load receipt_issuing_orders.jasper file");
        JasperReport jasperReport;

        try {
            jasperReport = (JasperReport) JRLoader.loadObject(
                    getClass()
                            .getClassLoader()
                            .getResourceAsStream("reports/receipt_issuing_orders.jasper")
            );
        } catch (Exception exception) {
            logger.error("Service cannot load 'Receipt Issuing Orders' jasper file", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.receipt.issues.order.load.file.error", exception);
        }

        logger.info("Trying fill JasperReport in JasperPrint");
        JasperPrint jasperPrint;

        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
        } catch (JRException exception) {
            logger.error("Service cannot fill JasperReport", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.fill.report.error", exception);
        }

        logger.info("Trying create and export 'Receipt Issuing Orders' pdf file");

        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());
        } catch (JRException exception) {
            logger.error("Service cannot create and export 'Receipt Issuing Orders' file", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.export.file.error", exception);
        }

        logger.info("'Receipt Issuing Orders' file created successfully");
    }
    public void createReceiptReturnOrders(ReceiptOrdersModel receiptOrdersModel) throws Exception {
        logger.info("Start creating pdf file for 'Receipt Issuing Orders'");

        if (Strings.isNullOrEmpty(receiptOrdersModel.getTransportCompany())) {
            logger.error("Transport company is null or empty");
            throw new Exception("warehouse.internet.order.collect.orders.content.receipt.issues.order.empty.transport.company");
        }

        List<String> fileFolders = new ArrayList<>();
        fileFolders.add(directoryPrintedFile);
        fileFolders.add(OrderType.SFS.value);
        fileFolders.add(PrintFormType.RETURN_RECEIPTS.value);

        File file = FileNameHelper.setFileName(
                fileFolders,
                String.format(
                        "%s_%s",
                        receiptOrdersModel.getCurrentTime().replace(":", "-"),
                        receiptOrdersModel.getTransportCompany()
                ),
                FileType.RECEIPT.value);
        logger.info("File name was generated:'{}'", file.getPath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(receiptOrdersModel.getOrderNumbers());

        Map<String, Object> param = new HashMap<>();
        param.put("orderCount", String.valueOf(receiptOrdersModel.getOrderNumbers().size()));
        param.put("transportCompany", receiptOrdersModel.getTransportCompany());
        param.put("shopFullName", receiptOrdersModel.getStoreFullName());
        param.put("currentDate", receiptOrdersModel.getCurrentDate());
        param.put("currentTime", receiptOrdersModel.getCurrentTime());

        logger.info("Checking 'Receipt return Orders' file directory");

        if (!new File(directoryPrintedFile).isDirectory()) {
            logger.info("Service cannot find pdf file directory");
            throw new Exception("warehouse.internet.order.collect.orders.content.receipt.issues.order");
        }

        logger.info("Trying to load receipt_return_orders.jasper file");
        JasperReport jasperReport;

        try {
            jasperReport = (JasperReport) JRLoader.loadObject(
                    getClass()
                            .getClassLoader()
                            .getResourceAsStream("reports/receipt_return_orders.jasper")
            );
        } catch (Exception exception) {
            logger.error("Service cannot load 'Receipt return Orders' jasper file", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.receipt.issues.order.load.file.error", exception);
        }

        logger.info("Trying fill JasperReport in JasperPrint");
        JasperPrint jasperPrint;

        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
        } catch (JRException exception) {
            logger.error("Service cannot fill JasperReport", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.fill.report.error", exception);
        }

        logger.info("Trying create and export 'Receipt return Orders' pdf file");

        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, file.getAbsolutePath());
        } catch (JRException exception) {
            logger.error("Service cannot create and export 'Receipt return Orders' file", exception);
            throw new Exception("warehouse.internet.order.collect.orders.content.export.file.error", exception);
        }

        logger.info("'Receipt return Orders' file created successfully");
    }
}
