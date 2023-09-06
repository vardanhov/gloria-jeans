package ru.gloria_jeans.onecdbmapper.dao.component;

import org.springframework.stereotype.Component;
import ru.gloria_jeans.onecdbmapper.dao.model.DnLock;
import ru.gloria_jeans.onecdbmapper.dao.model.DnLockIdentificator;
import ru.gloria_jeans.onecdbmapper.dao.repository.DnLockRepository;

import java.util.List;
import java.util.Objects;

@Component
public class DnLockComponent {
    private final DnLockRepository dnLockRepository;

    public DnLockComponent(DnLockRepository dnLockRepository) {
        this.dnLockRepository = dnLockRepository;
    }

    public DnLock getDnLock(String journalDocNo, String dnprefix) {
        List<DnLock> dnLockList = dnLockRepository.findByDnLockIdentificator_Dnprefix(dnprefix.trim().substring(0, 4));
        return dnLockList.parallelStream()
                .filter(e -> journalDocNo.contains(e.getDnLockIdentificator().getDocno().trim()))
                .findFirst()
                .orElse(null);
    }

    public void deleteDnLock(String journalDocNo, String dnprefix) {
        DnLock dnLock = getDnLock(journalDocNo, dnprefix);

        if (Objects.nonNull(dnLock)) {
            dnLockRepository.delete(dnLock);
        }
    }

    public void saveDnLockDocNo(String dnprefix, String docNo) {
        DnLock dnLock = new DnLock();
        DnLockIdentificator dnLockIdentificator = new DnLockIdentificator();
        dnLockIdentificator.setDnprefix(dnprefix);
        dnLockIdentificator.setDocno(docNo);
        dnLock.setDnLockIdentificator(dnLockIdentificator);
        dnLockRepository.save(dnLock);
    }

    public String formatDnLockDocNo(String prefix, String input) {
        int startIndex = input.indexOf(prefix) + prefix.length();
        String numberString = input.substring(startIndex);
        numberString = numberString.replaceFirst("^0+(?!$)", "");
        return numberString;
    }

}
