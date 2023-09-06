package ru.gloria_jeans.onecdbmapper.dao.component;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.gloria_jeans.onecdbmapper.Utils;
import ru.gloria_jeans.onecdbmapper.dao.model.Journal;
import ru.gloria_jeans.onecdbmapper.dao.model.JournalListing;
import ru.gloria_jeans.onecdbmapper.dao.repository.DnLockRepository;
import ru.gloria_jeans.onecdbmapper.dao.repository.JournalRepository;

import javax.persistence.LockModeType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class JournalComponent {
    private final DnLockRepository dnLockRepository;
    private final JournalRepository journalRepository;
    private final StoreComponent storeComponent;
    private final OnecSystemComponent onecSystemComponent;
    private final DnLockComponent dnLockComponent;

    @Autowired
    public JournalComponent(
            DnLockRepository dnLockRepository,
            JournalRepository journalRepository,
            StoreComponent storeComponent,
            OnecSystemComponent onecSystemComponent,
            DnLockComponent dnLockComponent
    ) {
        this.dnLockRepository = dnLockRepository;
        this.journalRepository = journalRepository;
        this.storeComponent = storeComponent;
        this.onecSystemComponent = onecSystemComponent;
        this.dnLockComponent = dnLockComponent;
    }

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Transactional
    public Journal setReferences(Journal journal, String documentType) {
        journalRepository.lockJournal();
        journal.setIdocdef(Utils.getDef(documentType));
        journal.setIdjournal(Utils.getJournalId(journal.getIdocdef()));
        journal.setDnprefix(Utils.getPrefix(journal.getIdocdef()));
        journal.setDocno(getDocNo(documentType, journal.getDnprefix()));
        journal.setId(journalRepository.getRowIdMax() + 1);
        journal.setDateTimeIdDoc(
                String.format(
                        "%s%s%s",
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")),
                        Utils.getOnecTime(LocalDateTime.now()),
                        journal.getIdoc()
                )
        );
        journal.setIdoc(onecSystemComponent.getIddoc());
        journalRepository.save(journal);
        dnLockComponent.deleteDnLock(journal.getDocno(), journal.getDnprefix());
        return journal;
    }

    public String getDocNo(String documentType, String dnprefix) {
        String prefix = "";
        String oldNumber;

        if (
                documentType.equals("ПеремещениеДенегБанк") ||
                        documentType.equals("Возврат") ||
                        documentType.equals("ПриемныйАкт") ||
                        documentType.equals("АктНесоответствия") ||
                        documentType.equals("Списание") ||
                        documentType.equals("ОшибкиКомплектации")
        ) {
            prefix = "РМ";
        } else if (
                documentType.equals("МаршрутныйЛист")
        ) {
            prefix = "РММЛ";
        }

        //К префиксу подставляем idd базы (удаляя из него 3 лишних ноля вначале)
        String finalPrefix = String.format(
                "%s%s",
                prefix,
                storeComponent.getCurrentStore().getDbIdd().substring(3)
        );

        //ТК для корректного номера документа мы добавили фильтрацию по магазину нужно ее
        // отключать в тех документах, где в формировании docno не участвует префикс и номер магазина
        if (Strings.isNullOrEmpty(prefix)) {
            oldNumber = journalRepository.findByDnprefix(dnprefix)
                    .parallelStream()
                    .max(Comparator.comparing(JournalListing::getDocno))
                    .map(JournalListing::getDocno)
                    .orElse(StringUtils.EMPTY)
                    .trim();
        } else {
            oldNumber = journalRepository.findByDnprefix(dnprefix)
                    .parallelStream()
                    .filter(x -> x.getDocno().startsWith(finalPrefix))
                    .max(Comparator.comparing(JournalListing::getDocno))
                    .map(JournalListing::getDocno)
                    .orElse(StringUtils.EMPTY)
                    .trim();
        }

        // Дописываем ноли, чтобы длинна oldNumber была равна 10 символам
        if (Strings.isNullOrEmpty(oldNumber)) {
            oldNumber = StringUtils.rightPad(
                    finalPrefix,
                    10,
                    "0"
            );
        }

        String docNo = getNewNum(
                finalPrefix,
                oldNumber,
                dnLockRepository.findByDnLockIdentificator_Dnprefix(dnprefix.trim().substring(0, 4))
                        .parallelStream()
                        .filter(x -> Objects.nonNull(x.getDnLockIdentificator()) && Objects.nonNull(x.getDnLockIdentificator().getDocno()))
                        .map(x -> x.getDnLockIdentificator().getDocno().trim())
                        .collect(Collectors.toList())
        );

        Integer tableId = onecSystemComponent.getDatabaseTableId(
                String.format(
                        "%s.%s",
                        "Документ",
                        documentType
                )
        );
        String clearDocNo = dnLockComponent.formatDnLockDocNo(finalPrefix, docNo);
        dnLockComponent.saveDnLockDocNo(String.valueOf(tableId), clearDocNo);
        return docNo;
    }

    public String getNewNum(String prefix, String pre, List<String> lockedNums) {
        char[] docNo = pre.toCharArray();
        int cc = docNo.length - 1;

        while (true) {
            char OldChar = docNo[cc];

            if (OldChar == '9') {
                docNo[cc] = '0';
            } else {
                docNo[cc] = (char) (((byte) docNo[cc]) + 1);
                break;
            }

            cc--;
        }

        String rezult = new String(docNo);

        if (lockedNums.contains(dnLockComponent.formatDnLockDocNo(prefix, rezult))) {
            return getNewNum(prefix, rezult, lockedNums);
        }

        return rezult;
    }

    public Date getDateTimeFromDateTimeIdDoc(String dateTimeIdDoc) throws Exception {
        return Utils.convertDateTimeIdDocToDate(dateTimeIdDoc);
    }
}
