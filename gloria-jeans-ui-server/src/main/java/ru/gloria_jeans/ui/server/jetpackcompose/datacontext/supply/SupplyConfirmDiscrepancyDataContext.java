package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.supply;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplyConfirmDiscrepancyDataContext extends SupplyViewDocumentDataContext {
    private String further = StringUtils.EMPTY;
    private String acceptedLabel = StringUtils.EMPTY;
    private String confirmedLabel = StringUtils.EMPTY;
    private String commentLabel = StringUtils.EMPTY;
    private String receivingPerson = StringUtils.EMPTY;
    private String confirmingPerson = StringUtils.EMPTY;
    private String selectedTextField = StringUtils.EMPTY;
    private String id = StringUtils.EMPTY;
    private String idd = StringUtils.EMPTY;
    private String receivingPersonId = StringUtils.EMPTY;
    private String confirmingPersonId = StringUtils.EMPTY;
    private String fullName = StringUtils.EMPTY;
    private String position = StringUtils.EMPTY;

    public String getFurther() {
        return further;
    }

    public void setFurther(String further) {
        this.further = further;
    }

    public String getAcceptedLabel() {
        return acceptedLabel;
    }

    public void setAcceptedLabel(String acceptedLabel) {
        this.acceptedLabel = acceptedLabel;
    }

    public String getConfirmedLabel() {
        return confirmedLabel;
    }

    public void setConfirmedLabel(String confirmedLabel) {
        this.confirmedLabel = confirmedLabel;
    }

    public String getCommentLabel() {
        return commentLabel;
    }

    public void setCommentLabel(String commentLabel) {
        this.commentLabel = commentLabel;
    }

    public String getReceivingPerson() {
        return receivingPerson;
    }

    public void setReceivingPerson(String receivingPerson) {
        this.receivingPerson = receivingPerson;
    }

    public String getConfirmingPerson() {
        return confirmingPerson;
    }

    public void setConfirmingPerson(String confirmingPerson) {
        this.confirmingPerson = confirmingPerson;
    }

    public String getSelectedTextField() {
        return selectedTextField;
    }

    public void setSelectedTextField(String selectedTextField) {
        this.selectedTextField = selectedTextField;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdd() {
        return idd;
    }

    public void setIdd(String idd) {
        this.idd = idd;
    }

    public String getReceivingPersonId() {
        return receivingPersonId;
    }

    public void setReceivingPersonId(String receivingPersonId) {
        this.receivingPersonId = receivingPersonId;
    }

    public String getConfirmingPersonId() {
        return confirmingPersonId;
    }

    public void setConfirmingPersonId(String confirmingPersonId) {
        this.confirmingPersonId = confirmingPersonId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
