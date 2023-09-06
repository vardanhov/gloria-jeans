package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.onecdbmapper.dao.enums.OperationTypeReceiptKKM;
import ru.gloria_jeans.onecdbmapper.dao.enums.PaymentType;
import ru.gloria_jeans.onecdbmapper.dao.model.Currency;
import ru.gloria_jeans.onecdbmapper.dao.model.Journal;
import ru.gloria_jeans.onecdbmapper.dao.model.OrderDocument;
import ru.gloria_jeans.onecdbmapper.dao.model.Receipt;
import ru.gloria_jeans.orders.dao.model.OrderLocalDocument;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ReceiptMapped {

    public static Receipt map(OrderDocument orderDocument, OrderLocalDocument document, Journal journal, Currency currency, String iddBaseDocument) {
        Receipt receipt = new Receipt();

        receipt.setIdDoc(journal.getIdoc());
        receipt.setOrderNumber(orderDocument.getOrderNumber());
        receipt.setCardName("");
        receipt.setCardType(BigDecimal.ONE);
        receipt.setCash(document.getSum());
        receipt.setCashbox("E");
        receipt.setCheckNumberInChange(BigDecimal.valueOf(1));
        receipt.setCheckNumberKKM(BigDecimal.ZERO);
        receipt.setCheckPunchedKKM(BigDecimal.valueOf(1));
        receipt.setCheckType("");
        receipt.setCourse(BigDecimal.valueOf(32.00));
        receipt.setCreditKaspi(BigDecimal.ZERO);
        receipt.setCurrency(currency.getId());
        receipt.setDateCreated(Date.from(Instant.now()));
        receipt.setDeliveryMethod(orderDocument.getShippingMethod());
        receipt.setDiscount("");
        receipt.setDk(orderDocument.getDk());
        //todo ReceiptByDocBasis
        receipt.setDocBasis(
                String.format(
                        "%s%s",
                        orderDocument.getJournal().getIdocdef(),
                        orderDocument.getIdDoc()
                )
        );
        receipt.setDocumentTime(String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)));
        receipt.setDop1("");
        receipt.setDop2("");
        receipt.setEmployee("  2CN6   ");
        receipt.setExternalCredit(orderDocument.getExternalCredit());
        receipt.setFp("");
        receipt.setGiftCertificate("");
        receipt.setIdTransaction("");
        receipt.setIddBaseDocument(iddBaseDocument);
        receipt.setInternalCredit(BigDecimal.valueOf(0.00));
        receipt.setLoyaltySystem("0");
        receipt.setManualInput(BigDecimal.valueOf(1));
        receipt.setMerchant("");
        receipt.setModified(BigDecimal.valueOf(0));
        receipt.setOperationType(OperationTypeReceiptKKM.getValue("Чек"));
        receipt.setPaymentType(PaymentType.getValue("КредитВнешний"));
        receipt.setPpn("");
        receipt.setPriceDate(Date.from(Instant.now()));
        receipt.setQuantity(document.getQuantityFact());
        receipt.setReasonReturn("     0   ");
        receipt.setReceived(document.getSum());
        receipt.setRetailClient("9000525888757");
        receipt.setSerialNumberFN("");
        receipt.setSerialNumberKKM("");
        receipt.setShiftNumber(BigDecimal.valueOf(121));
        receipt.setShippingMethod(orderDocument.getShippingMethod());
        receipt.setStatus(BigDecimal.ONE);
        receipt.setSum(document.getSum());
        receipt.setTerminal("00276075");
        receipt.setTimeEdited(String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.SECONDS)));
        receipt.setWarehouse(orderDocument.getWarehouse());
        receipt.setComment(orderDocument.getComment());

        return receipt;
    }
}
