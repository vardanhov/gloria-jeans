package ru.gloria_jeans.ui.server.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.gloria_jeans.core.v1.common.RestUtils;
import ru.gloria_jeans.core.v1.export.model.ExportMovingDocumentListModel;
import ru.gloria_jeans.core.v1.export.model.ExportMovingDocumentModel;
import ru.gloria_jeans.ui.server.component.LocaleComponent;

import java.util.List;

@Service
public class ExportService {
    public Logger logger = LoggerFactory.getLogger("ExportService");
    private final String exportUrl;
    private final RestUtils restUtils;
    private final LocaleComponent localeComponent;

    @Autowired
    public ExportService(
            @Value("${services.export}") String exportUrl,
            RestUtils restUtils,
            LocaleComponent localeComponent
    ) {
        this.restUtils = restUtils;
        this.exportUrl = exportUrl;
        this.localeComponent = localeComponent;
    }

    public List<ExportMovingDocumentModel> getMovingDocumentList() throws Exception {
        ExportMovingDocumentListModel response = null;

        try {
            response = restUtils.get(
                    String.format(
                            "%s/%s",
                            exportUrl,
                            "collect/moving/list"
                    ),
                    ExportMovingDocumentListModel.class
            );

            if (response.getResponseException()) {
                logger.error(response.getResponseMessage());
                throw new Exception(localeComponent.locale(response.getResponseMessage()));
            }

        } catch (Exception exception) {
            logger.error(exception.getMessage());
            throw new Exception(localeComponent.locale(exception.getMessage()));
        }

        return response.getExportMovingDocumentModelList();
    }
}
