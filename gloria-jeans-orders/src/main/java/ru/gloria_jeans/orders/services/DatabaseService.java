package ru.gloria_jeans.orders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gloria_jeans.onecdbmapper.dao.component.CurrencyComponent;
import ru.gloria_jeans.onecdbmapper.dao.model.Currency;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderItemListing;
import ru.gloria_jeans.orders.dao.enums.OrderStatus;
import ru.gloria_jeans.orders.dao.model.*;
import ru.gloria_jeans.orders.dao.repository.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class DatabaseService {
    private final OrderDocumentISRepository orderDocumentISRepository;
    private final OrderItemISRepository orderItemISRepository;
    private final ScannedMarkRepository scannedMarkRepository;
    private final ReturnedOrderDocumentRepository returnedOrderDocumentRepository;
    private final OrderScannedDocumentsRepository orderScannedDocumentsRepository;
    private final CurrencyComponent currencyComponent;
    private final PackageRepository packageRepository;

    @Autowired
    public DatabaseService(
            OrderDocumentISRepository orderDocumentISRepository,
            OrderItemISRepository orderItemISRepository,
            ScannedMarkRepository scannedMarkRepository,
            ReturnedOrderDocumentRepository returnedOrderDocumentRepository,
            OrderScannedDocumentsRepository orderScannedDocumentsRepository, CurrencyComponent currencyComponent, PackageRepository packageRepository) {
        this.orderDocumentISRepository = orderDocumentISRepository;
        this.orderItemISRepository = orderItemISRepository;
        this.scannedMarkRepository = scannedMarkRepository;
        this.returnedOrderDocumentRepository = returnedOrderDocumentRepository;
        this.orderScannedDocumentsRepository = orderScannedDocumentsRepository;
        this.currencyComponent = currencyComponent;
        this.packageRepository = packageRepository;
    }

    public void addDocument(OrderLocalDocument orderLocalDocument) {
        orderDocumentISRepository.save(orderLocalDocument);
    }

    public OrderLocalDocument findOrderDocumentByOrderNumber(String orderNumber) {
        return orderDocumentISRepository.findByOrderNumber(orderNumber);
    }

    public List<OrderItem> getOrderItemsByIdDoc(String idDoc) {
        return orderItemISRepository.findByIdDoc(idDoc);
    }

    public void saveOrderItemsList(List<OrderItem> orderItems) {
        orderItemISRepository.saveAll(orderItems);
    }

    public void updateOrderItem(OrderItem orderItem) {
        orderItem.setSum(BigDecimal.valueOf(orderItem.getQuantityFact()).multiply(orderItem.getPrice()));
        orderItemISRepository.save(orderItem);
    }

    public List<OrderItem> searchProductsInOrder(String documentIdd, String search) {
        return orderItemISRepository.findByDocumentIddAndIddOrDocumentIddAndBarcodeOrDocumentIddAndVendorCode(
                documentIdd,
                search,
                documentIdd,
                search,
                documentIdd,
                search
        );
    }

    public OrderItem findOrderItemById(UUID id) {
        return orderItemISRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deleteOrderItem(UUID id) {
        orderItemISRepository.deleteById(id);
    }

    public boolean isExistScannedMark(String scannedMark) {
        return scannedMarkRepository.countByScannedMarkAndIsValidMark(scannedMark, true) > 0;
    }

    public void updateScannedMark(ScannedMark scannedMark) {
        scannedMarkRepository.save(scannedMark);
    }

    public ScannedMark findMarkByOrderItemId(UUID uuid, String dataMatrix) {
        return scannedMarkRepository.findByOrderItemIdAndDataMatrix(uuid, dataMatrix);
    }

    public List<OrderItem> getProductsByMark(String mark) {
        return orderItemISRepository.findByMarksLike(mark);
    }

    public void saveScannedDocument(ScannedDocument scannedDocument) {
        orderScannedDocumentsRepository.save(scannedDocument);
    }

    public List<ScannedDocument> findAllScannedDocumentsInStatus(String status) {
        return orderScannedDocumentsRepository.findAllByOrderStatusIs(status);
    }

    public List<ScannedDocument> findAllScannedDocumentsInStatusAndTk(String status, String tk) {
        return orderScannedDocumentsRepository.findAllByOrderStatusIsAndTk(status, tk);
    }

    public Currency getCurrency() {
        return currencyComponent.getCurrentCurrency();
    }

    public List<ReturnedOrderLocalDocument> getAllReturnedOrders() {
        return returnedOrderDocumentRepository.findAll();
    }

    public ReturnedOrderLocalDocument findByOrderNumber(String orderNumber) {
        return returnedOrderDocumentRepository.findByOrderNumber(orderNumber);
    }

    public void saveReturnOrder(ReturnedOrderLocalDocument returnedOrderLocalDocument) {
        returnedOrderDocumentRepository.save(returnedOrderLocalDocument);
    }

    public void clearAllReturn() {
        returnedOrderDocumentRepository.deleteAll();
    }

    public List<OrderPackage> findAllPackageByOrderNumber(String orderNumber) {
        return packageRepository.findAllByOrderNumber(orderNumber);
    }

    public void saveAllPackage(List<OrderPackage> orderPackage) {
        packageRepository.saveAll(orderPackage);
    }
    public void savePackage(OrderPackage orderPackage) {
        packageRepository.save(orderPackage);
    }


    public List<ScannedDocument> findAllScannedDocument(String scanStatus) {
        return orderScannedDocumentsRepository.findAllByOrderStatusIs(scanStatus);
    }

    public OrderPackage findByOrderNumberAndIdd(String orderNumber, String idd) {
        return packageRepository.findByOrderNumberAndPackageIdd(orderNumber, idd);
    }

    @Transactional
    public void deletePackages(String orderNumber) {
        packageRepository.deleteAllByOrderNumber(orderNumber);
    }

    @Transactional
    public void deleteMark(String scannedMark) {
        scannedMarkRepository.deleteByScannedMark(scannedMark);
    }

    public OrderItem findOrderItemByIdAndDocumentIdd(UUID orderItemId, String documentIdd) {
        return orderItemISRepository.findByIdAndDocumentIdd(orderItemId, documentIdd);
    }

    public OrderItem getOrderItem(String documentIdd, String productIdd) {
        return orderItemISRepository.findByDocumentIddAndIdd(documentIdd, productIdd);
    }

    public List<OrderItemListing> getItemsInOrder(String documentIdd) {
        return orderItemISRepository.findOrderItemByDocumentIdd(documentIdd);
    }

    public OrderLocalDocument getDocumentByIdd(String documentIdd) {
        return orderDocumentISRepository.findByIdd(documentIdd);
    }

    public List<OrderLocalDocument> getOrdersForDeliveryByStatusOrder(OrderStatus status) {
        return orderDocumentISRepository.findOrderLocalDocumentsByStatusOrder(status);
    }

    public List<OrderLocalDocument> getOrdersForDeliveryByStatusOrderAndTk(OrderStatus status, String tk) {
        return orderDocumentISRepository.findOrderLocalDocumentsByStatusOrderAndTk(status, tk);
    }

    public ScannedDocument findScannedDocumentByOrderNumber(String orderNumber) {
        return orderScannedDocumentsRepository.findByOrderNumber(orderNumber);
    }

    public List<OrderItem> getOrderItemsByDocumentIdd(String documentIdd) {
        return orderItemISRepository.findAllByDocumentIdd(documentIdd);
    }
}
