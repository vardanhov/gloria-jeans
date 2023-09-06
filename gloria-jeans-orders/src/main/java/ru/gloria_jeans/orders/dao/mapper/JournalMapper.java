package ru.gloria_jeans.orders.dao.mapper;

import ru.gloria_jeans.onecdbmapper.Utils;
import ru.gloria_jeans.onecdbmapper.dao.model.Journal;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JournalMapper {
    public static Journal map(String idd, String iddoc, String firm, int tmc) {
        Journal journal = new Journal();
        journal.setIdd(idd);
        journal.setIdoc(iddoc);
        journal.setActcnt(0);
        journal.setAppcode((short) 1);
        journal.setAuthor("     0   ");
        journal.setAvailability(0);
        journal.setBank(0);
        journal.setCash(0);
        journal.setCashbox(0);
        journal.setClosed(0);
        journal.setDelivered(0);
        journal.setEditDate(Date.valueOf(LocalDate.now()));
        journal.setFirm(firm);
        journal.setIsmark(0);
        journal.setOrders(0);
        journal.setOrdersRequests(0);
        journal.setProject("     0   ");
        journal.setJurPerson("     0   ");
        journal.setMainSequenceDs(0);
        journal.setRealized(0);
        journal.setRequests(0);
        journal.setReserves(0);
        journal.setSales(0);
        journal.setSubcontacts(0);
        journal.setSuppliers(0);
        journal.setTmc(tmc);
        journal.setVerstamp(0);
        journal.setPmm(0);
        journal.setPurchasesBook(0);
        journal.setPurchasesBookDs(0);
        journal.setSalesBook(0);
        journal.setSalesBookDs(0);
        journal.setDateTimeIdDoc(
                String.format(
                        "%s%s%s",
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")),
                        Utils.getOnecTime(LocalDateTime.now()),
                        iddoc
                )
        );
        return journal;
    }

    public static Journal map(String idd, String iddoc, String firm) {
        return JournalMapper.map(idd, iddoc, firm, 0);
    }
}
