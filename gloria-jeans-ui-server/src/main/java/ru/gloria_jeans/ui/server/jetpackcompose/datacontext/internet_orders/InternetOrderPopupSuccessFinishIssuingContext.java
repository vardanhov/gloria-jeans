package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;
import ru.gloria_jeans.ui.server.jetpackcompose.control.DataContext;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderPopupSuccessFinishIssuingContext extends DataContext {
    private String header = Strings.EMPTY;
    private String footer = Strings.EMPTY;
    private String button = Strings.EMPTY;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
