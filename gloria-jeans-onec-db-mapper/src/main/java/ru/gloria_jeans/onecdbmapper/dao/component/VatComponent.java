package ru.gloria_jeans.onecdbmapper.dao.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;
import ru.gloria_jeans.onecdbmapper.dao.model.OnecConstant;
import ru.gloria_jeans.onecdbmapper.dao.repository.OnecConstantRepository;
import ru.gloria_jeans.onecdbmapper.mdparser.metadata.SbNodeField;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Component
public class VatComponent {
    private final OnecConstantRepository onecConstantRepository;

    @Autowired
    public VatComponent(OnecConstantRepository onecConstantRepository) {
        this.onecConstantRepository = onecConstantRepository;
    }

    public BigDecimal getVat(String productInfoId, Date date) {
        String id = OnecDbMapper.getOnecMetadata().Sbs.get("Номенклатура").getFields()
                .parallelStream()
                .filter(x -> x.getIdentity().equals(("НДС")))
                .map(SbNodeField::getID)
                .findFirst()
                .orElse(null);
        OnecConstant value = onecConstantRepository.findByIdAndObjIdAndDateBeforeOrderByDateDesc(
                Long.parseLong(id),
                productInfoId,
                date
        )
                .parallelStream()
                .findFirst()
                .orElse(null);;

        if (Objects.nonNull(value)) {
            return BigDecimal.valueOf(Double.parseDouble(value.getValue()));
        } else {
            return BigDecimal.ZERO;
        }
    }
}
