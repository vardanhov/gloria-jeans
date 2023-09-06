package ru.gloria_jeans.onecdbmapper.dao.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;
import ru.gloria_jeans.onecdbmapper.dao.model.Firm;
import ru.gloria_jeans.onecdbmapper.dao.model.Warehouse;
import ru.gloria_jeans.onecdbmapper.dao.repository.FirmRepository;
import ru.gloria_jeans.onecdbmapper.dao.repository.OnecConstantRepository;
import ru.gloria_jeans.onecdbmapper.dao.repository.WarehouseRepository;

@Component
public class StoreComponent {
    private final OnecConstantRepository onecConstantRepository;
    private final WarehouseRepository warehouseRepository;
    private final FirmRepository firmRepository;

    @Autowired
    public StoreComponent(
            OnecConstantRepository onecConstantRepository,
            WarehouseRepository warehouseRepository,
            FirmRepository firmRepository
    ) {
        this.onecConstantRepository = onecConstantRepository;
        this.warehouseRepository = warehouseRepository;
        this.firmRepository = firmRepository;
    }

    public Warehouse getCurrentStore() {
        return warehouseRepository.findOneByDbIdd(
                onecConstantRepository.findOneByIdAndObjId(
                                Long.parseLong(OnecDbMapper.getOnecMetadata().Constants.get("IDD").getID()),
                                "     0   "
                        )
                        .getValue()
        );
    }

    public String getStoreIdd() {
        return getCurrentStore().getIdd();
    }

    public Firm getFirmForCurrentStore() {
        return firmRepository.findOneById(
                warehouseRepository.findOneByDbIdd(
                        onecConstantRepository.findOneByIdAndObjId(
                                        Long.parseLong(OnecDbMapper.getOnecMetadata().Constants.get("IDD").getID()),
                                        "     0   "
                                )
                                .getValue()
                ).getBranch()
        );
    }
}
