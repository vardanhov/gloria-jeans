package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.logging.log4j.util.Strings;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderCollectOrdersConfirmAssemblyOrderDataContext extends InternetOrderCollectOrdersMenuOrderDataContext {
    private String nomenclatureLabel = Strings.EMPTY;
    private String nomenclature = Strings.EMPTY;
    private String reasonForAbsenceLabel = Strings.EMPTY;
    private String reasonForAbsence = Strings.EMPTY;
    private String confirmButton = Strings.EMPTY;
    private String cancelButton = Strings.EMPTY;

    public String getNomenclatureLabel() {
        return nomenclatureLabel;
    }

    public void setNomenclatureLabel(String nomenclatureLabel) {
        this.nomenclatureLabel = nomenclatureLabel;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public String getReasonForAbsenceLabel() {
        return reasonForAbsenceLabel;
    }

    public void setReasonForAbsenceLabel(String reasonForAbsenceLabel) {
        this.reasonForAbsenceLabel = reasonForAbsenceLabel;
    }

    public String getReasonForAbsence() {
        return reasonForAbsence;
    }

    public void setReasonForAbsence(String reasonForAbsence) {
        this.reasonForAbsence = reasonForAbsence;
    }

    public String getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(String confirmButton) {
        this.confirmButton = confirmButton;
    }

    public String getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(String cancelButton) {
        this.cancelButton = cancelButton;
    }
}
