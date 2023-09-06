package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplyScanBlockedMarkLotPopupDataContext extends SupplyRecalculationBoxDataContext {

    private String textLineFirst = Strings.EMPTY;
    private String textLineSecond = Strings.EMPTY;
    private String textButton = Strings.EMPTY;

    public String getTextLineFirst() {
        return textLineFirst;
    }

    public void setTextLineFirst(String textLineFirst) {
        this.textLineFirst = textLineFirst;
    }

    public String getTextLineSecond() {
        return textLineSecond;
    }

    public void setTextLineSecond(String textLineSecond) {
        this.textLineSecond = textLineSecond;
    }

    public String getTextButton() {
        return textButton;
    }

    public void setTextButton(String textButton) {
        this.textButton = textButton;
    }
}
