package ru.gloria_jeans.onecdbmapper.dao.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;
import ru.gloria_jeans.onecdbmapper.Utils;
import ru.gloria_jeans.onecdbmapper.dao.model.Journal;
import ru.gloria_jeans.onecdbmapper.dao.model.OnecSrcdoc;
import ru.gloria_jeans.onecdbmapper.dao.repository.OnecSrcdocRepository;

@Component
public class OnecSrcdocComponent {
    private final OnecSrcdocRepository onecSrcdocRepository;

    @Autowired
    public OnecSrcdocComponent(OnecSrcdocRepository onecSrcdocRepository) {
        this.onecSrcdocRepository = onecSrcdocRepository;
    }

    public OnecSrcdoc addSrcDoc(Journal childJournal, Integer parentIdDocDef, String parentIdDoc) {
        OnecSrcdoc onecSrcdoc = new OnecSrcdoc();
        onecSrcdoc.setMdId(0);
        onecSrcdoc.setParentVal(Utils.build23Ref("O1", parentIdDocDef, parentIdDoc));
        onecSrcdoc.setChildDateTimeIddoc(childJournal.getDateTimeIdDoc());
        onecSrcdoc.setChildId(childJournal.getIdoc());
        onecSrcdoc.setFlags(1);
        onecSrcdocRepository.save(onecSrcdoc);
        return onecSrcdoc;
    }

    public String getPartOfParentValForMovingDocument() {
        return String.format("O1 %s", Utils.convertToBase36(OnecDbMapper.getOnecMetadata().Documents.get("Возврат").getID()).trim());
    }
}
