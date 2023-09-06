package ru.gloria_jeans.onecdbmapper.dao.component;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;
import ru.gloria_jeans.onecdbmapper.dao.enums.BanSaleProduct;
import ru.gloria_jeans.onecdbmapper.dao.model.OnecConstant;
import ru.gloria_jeans.onecdbmapper.dao.model.SalesBanDocument;
import ru.gloria_jeans.onecdbmapper.dao.repository.OnecConstantRepository;
import ru.gloria_jeans.onecdbmapper.dao.repository.SalesBanDocumentRepository;
import ru.gloria_jeans.onecdbmapper.mdparser.metadata.SbNodeField;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class ProductComponent {
    private final OnecConstantRepository onecConstantRepository;
    private final SalesBanDocumentRepository salesBanDocumentRepository;

    @Autowired
    public ProductComponent(OnecConstantRepository onecConstantRepository, SalesBanDocumentRepository salesBanDocumentRepository) {
        this.onecConstantRepository = onecConstantRepository;
        this.salesBanDocumentRepository = salesBanDocumentRepository;
    }

    public Integer getSalesBanValue(String productInfoId, Date date) {
        SalesBanDocument salesBanDocumentList = salesBanDocumentRepository.findFirstByItems_ItemOrderByDateCreatedDesc(productInfoId);

        if (Objects.nonNull(salesBanDocumentList) && salesBanDocumentList.getDestination().equals(BanSaleProduct.BAN.getValue())) {
            return 1;
        }

        String id = OnecDbMapper.getOnecMetadata().Sbs.get("Номенклатура").getFields()
                .parallelStream()
                .filter(x -> x.getIdentity().equals("ЗапретПродаж"))
                .findFirst()
                .map(SbNodeField::getID)
                .orElse(null);

        if (Strings.isNullOrEmpty(id)) {
            return null;
        }

        OnecConstant value = onecConstantRepository
                .findByIdAndObjIdAndDateBeforeOrderByDateDesc(
                        Long.parseLong(id),
                        productInfoId,
                        date
                )
                .parallelStream()
                .findFirst()
                .orElse(null);

        if (Objects.isNull(value) || Strings.isNullOrEmpty(value.getValue())) {
            return 0;
        } else {
            return Integer.parseInt(value.getValue());
        }
    }

    public String getPriceValue(Long id, String objId) {
        List<OnecConstant> onecConstants = onecConstantRepository.findByIdAndObjIdOrderByDateDesc(id, objId);
        if (onecConstants.size() == 0) {
            return null;
        } else {
            return onecConstants.get(0).getValue();
        }
    }

    public Date getPriceDate(Long id, String objId) {
        List<OnecConstant> onecConstants = onecConstantRepository.findByIdAndObjIdOrderByDateDesc(id, objId);
        if (onecConstants.size() == 0) {
            return null;
        } else {
            return onecConstants.get(0).getDate();
        }
    }
}
