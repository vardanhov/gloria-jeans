package ru.gloria_jeans.onecdbmapper.dao.component;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;
import ru.gloria_jeans.onecdbmapper.dao.model.OnecConstant;
import ru.gloria_jeans.onecdbmapper.dao.model.Price;
import ru.gloria_jeans.onecdbmapper.dao.repository.OnecConstantRepository;
import ru.gloria_jeans.onecdbmapper.dao.repository.PriceRepository;
import ru.gloria_jeans.onecdbmapper.mdparser.metadata.SbNodeField;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Component
public class PriceComponent {
    private final PriceRepository priceRepository;
    private final OnecConstantRepository onecConstantRepository;
    private String typeOfDiscountPrice = null;

    @Autowired
    public PriceComponent(
            PriceRepository priceRepository,
            OnecConstantRepository onecConstantRepository
    ) {
        this.priceRepository = priceRepository;
        this.onecConstantRepository = onecConstantRepository;
    }

    public String getTypeOfDiscountPrice() {
        if (Strings.isNullOrEmpty(typeOfDiscountPrice)) {
            long id = Long.parseLong(
                    typeOfDiscountPrice = OnecDbMapper.getOnecMetadata().Constants.get("УчетныйТипЦен").getID()
            );
            typeOfDiscountPrice = onecConstantRepository.findOneByIdAndObjId(id, "     0   ").getValue();
        }

        return typeOfDiscountPrice;
    }

    public BigDecimal getPrice(String productInfoId, Date date) {
        Price price = priceRepository.findByParentextAndAndPriceType(productInfoId, getTypeOfDiscountPrice());
        String id = OnecDbMapper.getOnecMetadata().Sbs.get("Цены").getFields()
                .parallelStream()
                .filter(x -> x.getIdentity().equals("Цена"))
                .findFirst()
                .map(SbNodeField::getID)
                .orElse(null);

        if (Strings.isNullOrEmpty(id)) {
            return null;
        }

        OnecConstant value = onecConstantRepository
                .findByIdAndObjIdAndDateBeforeOrderByDateDesc(
                        Long.parseLong(id),
                        price.getId(),
                        date
                )
                .parallelStream()
                .findFirst()
                .orElse(null);

        if (Objects.isNull(value) || Strings.isNullOrEmpty(value.getValue())) {
            return null;
        } else {
            return new BigDecimal(value.getValue().replace(',', '.'));
        }
    }
}
