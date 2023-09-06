package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderCollectOrdersDataContext extends DataContext {
    private String resultCountText = StringUtils.EMPTY;
    private String documentNumber = StringUtils.EMPTY;
    private String documentIdd = Strings.EMPTY;

    public String getResultCountText() {
        return resultCountText;
    }

    public void setResultCountText(String resultCountText) {
        this.resultCountText = resultCountText;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentIdd() {
        return documentIdd;
    }

    public void setDocumentIdd(String documentIdd) {
        this.documentIdd = documentIdd;
    }
}
