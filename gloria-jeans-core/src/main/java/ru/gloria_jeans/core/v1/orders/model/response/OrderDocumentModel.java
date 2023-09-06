package ru.gloria_jeans.core.v1.orders.model.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;
import ru.gloria_jeans.core.v1.receiving.enums.MovingDocumentModelType;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDocumentModel extends BaseResponse {
    private String idd;
    private String dk;
    private String orderNumber;
    private String id;
    private String number;
    private String orderStatus;
    private Date createdDate;
    private String barcode;
    private MovingDocumentModelType type;
    private String lineNumberLot;
    private String currentEmployeeId;
    private Date openDocumentDate;
    private String buyer;
    private String warehouse;
    private String collectorName;
    private String shippingType;
    private String statusOrder;
    private String payType;
    private String warehouseSender;
    private String warehouseTransit;
    private String bayerAddress;
    private String shippingMethod;
    private String orderId;
    private String dop;
    private Integer pmm;
    private Date documentDate;
    private List<OrderDocumentItemModel> orderDocumentItemModels = new ArrayList<>();
    private String currentUserId;

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getDk() {
        return dk;
    }

    public void setDk(String dk) {
        this.dk = dk;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public MovingDocumentModelType getType() {
        return type;
    }

    public void setType(MovingDocumentModelType type) {
        this.type = type;
    }

    public String getLineNumberLot() {
        return lineNumberLot;
    }

    public void setLineNumberLot(String lineNumberLot) {
        this.lineNumberLot = lineNumberLot;
    }

    public String getCurrentEmployeeId() {
        return currentEmployeeId;
    }

    public void setCurrentEmployeeId(String currentEmployeeId) {
        this.currentEmployeeId = currentEmployeeId;
    }

    public Date getOpenDocumentDate() {
        return openDocumentDate;
    }

    public void setOpenDocumentDate(Date openDocumentDate) {
        this.openDocumentDate = openDocumentDate;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getWarehouseSender() {
        return warehouseSender;
    }

    public void setWarehouseSender(String warehouseSender) {
        this.warehouseSender = warehouseSender;
    }

    public String getWarehouseTransit() {
        return warehouseTransit;
    }

    public void setWarehouseTransit(String warehouseTransit) {
        this.warehouseTransit = warehouseTransit;
    }

    public String getBayerAddress() {
        return bayerAddress;
    }

    public void setBayerAddress(String bayerAddress) {
        this.bayerAddress = bayerAddress;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDop() {
        return dop;
    }

    public void setDop(String dop) {
        this.dop = dop;
    }

    public Integer getPmm() {
        return pmm;
    }

    public void setPmm(Integer pmm) {
        this.pmm = pmm;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public List<OrderDocumentItemModel> getOrderDocumentItemModels() {
        return orderDocumentItemModels;
    }

    public void setOrderDocumentItemModels(List<OrderDocumentItemModel> orderDocumentItemModels) {
        this.orderDocumentItemModels = orderDocumentItemModels;
    }

    public String getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(String currentUserId) {
        this.currentUserId = currentUserId;
    }
}
