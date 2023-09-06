package ru.gloria_jeans.onecdbmapper.dao.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gloria_jeans.onecdbmapper.OnecDbMapper;
import ru.gloria_jeans.onecdbmapper.dao.model.OnecConstant;
import ru.gloria_jeans.onecdbmapper.dao.repository.OnecConstantRepository;

import java.util.Objects;

@Component
public class LanguageComponent {
    private final OnecConstantRepository onecConstantRepository;

    @Autowired
    public LanguageComponent(OnecConstantRepository onecConstantRepository) {
        this.onecConstantRepository = onecConstantRepository;
    }

    public String getLanguageOfCurrentStore() {
        Long id = Long.parseLong(OnecDbMapper.getOnecMetadata().Constants.get("Язык").getID());
        OnecConstant onecConstant = onecConstantRepository.findOneByIdAndObjId(id, "0");

        if (Objects.isNull(onecConstant)) {
            return "ru";
        }

        switch (onecConstant.getValue()) {
            case "0":
            default:
                return "ru";
            case "1":
                return "uk";
            case "2":
                return "be";
        }
    }
}
