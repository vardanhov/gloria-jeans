package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.core.v1.orders.enums.ReasonAbsence;

public class InternetOrderCausesOfNotAssemblyDataContext extends InternetOrderCollectOrdersViewPositionDataContext{
    private ReasonAbsence reason = null;
    private String defectCause = Strings.EMPTY;
    private String productNotFoundCause = Strings.EMPTY;
    private String badMarkCause = Strings.EMPTY;
    private String lastUrl = Strings.EMPTY;

    public String getDefectCause() {
        return defectCause;
    }

    public void setDefectCause(String defectCause) {
        this.defectCause = defectCause;
    }

    public String getProductNotFoundCause() {
        return productNotFoundCause;
    }

    public void setProductNotFoundCause(String productNotFoundCause) {
        this.productNotFoundCause = productNotFoundCause;
    }

    public String getBadMarkCause() {
        return badMarkCause;
    }

    public void setBadMarkCause(String badMarkCause) {
        this.badMarkCause = badMarkCause;
    }

    public ReasonAbsence getReason() {
        return reason;
    }

    public void setReason(ReasonAbsence reason) {
        this.reason = reason;
    }

    public String getLastUrl() {
        return lastUrl;
    }

    public void setLastUrl(String lastUrl) {
        this.lastUrl = lastUrl;
    }
}
