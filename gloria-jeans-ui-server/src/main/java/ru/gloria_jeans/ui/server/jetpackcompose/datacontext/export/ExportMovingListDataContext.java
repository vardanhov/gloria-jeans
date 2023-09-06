package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.export;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExportMovingListDataContext extends ExportDataContext {
    private String movingListCountLabel;
    private String from;

    public String getMovingListCountLabel() {
        return movingListCountLabel;
    }

    public void setMovingListCountLabel(String movingListCountLabel) {
        this.movingListCountLabel = movingListCountLabel;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
