package ru.gloria_jeans.onecdbmapper.dao.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;
import ru.gloria_jeans.onecdbmapper.dao.model.Currency;
import ru.gloria_jeans.onecdbmapper.dao.repository.CurrencyRepository;
import ru.gloria_jeans.onecdbmapper.dao.repository.OnecConstantRepository;
import ru.gloria_jeans.onecdbmapper.mdparser.metadata.SbNodeField;

import java.util.List;
import java.util.Objects;

@Component
public class CurrencyComponent {
    private final CurrencyRepository currencyRepository;
    private final OnecConstantRepository onecConstantRepository;

    @Autowired
    public CurrencyComponent(
            CurrencyRepository currencyRepository,
            OnecConstantRepository onecConstantRepository
    ) {
        this.currencyRepository = currencyRepository;
        this.onecConstantRepository = onecConstantRepository;
    }

    public void add(Currency currency) {
        currencyRepository.save(currency);
    }

    public Currency getById(String id) {
        Currency currency = currencyRepository.findOneById(id);

        if (Objects.isNull(currency)) {
            return null;
        } else {
            return init(currency);
        }
    }

    public List<Currency> getAll() {
        List<Currency> currencies = currencyRepository.findAll();

        if (!currencies.isEmpty()) {
            for (Currency currency : currencies) {
                init(currency);
            }
        }

        return currencies;
    }

    public Currency getCurrentCurrency() {
        Currency currency = currencyRepository.findOneById(
                onecConstantRepository
                        .findOneByIdAndObjIdOrderByDateDesc(
                                Long.parseLong(OnecDbMapper.getOnecMetadata().Constants.get("ВалютаУпрУчета").getID()),
                                "     0   "
                        )
                        .getValue()
        );
        return this.init(currency);
    }

    private Currency init(Currency currency) {
        currency.setRate(getReferenceConstant("Курс", currency.getId()));
        currency.setMultiplicity(getReferenceConstant("Кратность", currency.getId()));
        return currency;
    }

    private String getReferenceConstant(String identity, String objectId) {
        String id = OnecDbMapper.getOnecMetadata().Sbs.get("Валюты").getFields()
                .parallelStream()
                .filter(x -> x.getIdentity().equals(identity))
                .findFirst()
                .map(SbNodeField::getID)
                .orElse(null);
        return onecConstantRepository
                .findByIdAndObjIdOrderByDateDesc(
                        Long.parseLong(id),
                        objectId
                )
                .get(0)
                .getValue();
    }
}
