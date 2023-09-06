package ru.gloria_jeans.onecdbmapper.dao.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.gloria_jeans.onecdbmapper.NamingAssociations;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;
import ru.gloria_jeans.onecdbmapper.Utils;
import ru.gloria_jeans.onecdbmapper.dao.model.*;
import ru.gloria_jeans.onecdbmapper.dao.repository.IddocRepository;
import ru.gloria_jeans.onecdbmapper.dao.repository.JdbcOnecSystemRepository;
import ru.gloria_jeans.onecdbmapper.dao.repository.OnecUserRepository;
import ru.gloria_jeans.onecdbmapper.dao.repository.UiddRepository;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class OnecSystemComponent {
    private final JdbcOnecSystemRepository jdbcOnecSystemRepository;
    private final OnecUserRepository onecUserRepository;
    private final UiddRepository uiddRepository;
    private final IddocRepository iddocRepository;
    private final NamingAssociations namingAssociations;

    @Autowired
    public OnecSystemComponent(
            JdbcOnecSystemRepository jdbcOnecSystemRepository,
            OnecUserRepository onecUserRepository,
            UiddRepository uiddRepository,
            IddocRepository iddocRepository,
            NamingAssociations namingAssociations) {
        this.jdbcOnecSystemRepository = jdbcOnecSystemRepository;
        this.onecUserRepository = onecUserRepository;
        this.uiddRepository = uiddRepository;
        this.iddocRepository = iddocRepository;
        this.namingAssociations = namingAssociations;
    }

    public List<Date> getPeriods(Date documentDate) throws Exception {
        OnecSystem onecSystem = jdbcOnecSystemRepository.getFirstOnecSystem();
        Date period = Utils.getBeginOfPeriod(onecSystem.getCurdate(), onecSystem.getSnapshper());
        List<Date> recalculationPeriods = new ArrayList<>();
        Date currentPeriod = Utils.getBeginOfPeriod(documentDate, onecSystem.getSnapshper());

        while (currentPeriod.compareTo(period) <= 0) {
            recalculationPeriods.add(currentPeriod);
            currentPeriod = Utils.getNextPeriod(currentPeriod, onecSystem.getSnapshper());
        }

        return recalculationPeriods;
    }

    public void movePosition(Journal journal) throws Exception {
        OnecSystem onecSystem = jdbcOnecSystemRepository.getFirstOnecSystem();

        if (Objects.nonNull(onecSystem) && needMoveTA(onecSystem, journal.getDateTimeIdDoc(), journal.getIdoc())) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(journal.getDocDate());
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            int DocTime = Integer.parseInt(Utils.convertToBase10(journal.getDateTimeIdDoc().substring(8, 14)));
            onecSystem.setCurdate(calendar.getTime());
            onecSystem.setCurtime(DocTime + 100);
            onecSystem.setEventidta(journal.getIdoc());
            jdbcOnecSystemRepository.updateOnecSystem(onecSystem);
            OnecUser onecUser = onecUserRepository.findAll().iterator().next();

            if (Objects.nonNull(onecUser)) {
                onecUser.setNetchgcn(onecUser.getNetchgcn()+1);
                onecUserRepository.save(onecUser);
            }
        }
    }

    public boolean needMoveTA(OnecSystem onecSystem, String dateTimeIddoc, String iddoc) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Date docDate =  simpleDateFormat.parse(dateTimeIddoc.substring(0, 8));
        int time = Integer.parseInt(Utils.convertToBase10(dateTimeIddoc.substring(8, 14)));

        if (docDate.compareTo(onecSystem.getCurdate()) < 0) {
            return false;
        }

        if (docDate.compareTo(onecSystem.getCurdate()) == 0 && time < onecSystem.getCurtime()) {
            return false;
        }

        if (
                docDate == onecSystem.getCurdate() &&
                time == onecSystem.getCurtime() &&
                Long.parseLong(Utils.convertToBase10(iddoc)) < Long.parseLong(Utils.convertToBase10(onecSystem.getEventidta()))
        ) {
            return false;
        }

        return true;
    }

    @Transactional
    public String getIddoc() {
        Iddoc iddocDb = iddocRepository.getIddoc();
        String iddoc = Utils.convertToBase10(iddocDb.getIddoc());
        Long base10 = Long.parseLong(iddoc);
        base10++;
        return Utils.convertToBase36(base10.toString());
    }

    @Transactional
    public String getIdd() {
        Uidd uidd = uiddRepository.getUidd();

        if (uidd.getUidd().equals("-1")) {
            String uniqueIdd = OnecDbMapper.getOnecMetadata().Constants.get("УникальныйIDD").getID();
            String idd = OnecDbMapper.getOnecMetadata().Constants.get("IDD").getID();
            uidd = uiddRepository.getIdd(idd, uniqueIdd);
            return uidd.getUidd();
        } else {
            return uidd.getUidd();
        }
    }

    @Transactional
    public Integer getDatabaseTableId(String entityName) {
        return namingAssociations.getTableId(entityName);
    }
}
