package ru.gloria_jeans.ui.server.jetpackcompose.datacontext.internet_orders;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternetOrderCollectOrdersViewPositionDataContext extends InternetOrderCollectOrdersContentOrderDataContext {
    private String nomenclatureLabel = StringUtils.EMPTY;
    private String nomenclature = StringUtils.EMPTY;
    private String productFullName = StringUtils.EMPTY;
    private String productPlanLabel = StringUtils.EMPTY;
    private String productFactLabel = StringUtils.EMPTY;
    private String productDiffLabel = StringUtils.EMPTY;
    private String productPlan = StringUtils.EMPTY;
    private String productFact = StringUtils.EMPTY;
    private String productDiff = StringUtils.EMPTY;
    private String absenceReasonButtonText = StringUtils.EMPTY;
    private String imageUrl = StringUtils.EMPTY;
    private String linkBack = StringUtils.EMPTY;
    private String linkForward = StringUtils.EMPTY;
    private String clearFactPositionButton = StringUtils.EMPTY;
    private String productId = Strings.EMPTY;

    public String getNomenclatureLabel() {
        return nomenclatureLabel;
    }

    public void setNomenclatureLabel(String nomenclatureLabel) {
        this.nomenclatureLabel = nomenclatureLabel;
    }

    public String getAbsenceReasonButtonText() {
        return absenceReasonButtonText;
    }

    public void setAbsenceReasonButtonText(String absenceReasonButtonText) {
        this.absenceReasonButtonText = absenceReasonButtonText;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public String getProductFullName() {
        return productFullName;
    }

    public void setProductFullName(String productFullName) {
        this.productFullName = productFullName;
    }

    public String getProductPlanLabel() {
        return productPlanLabel;
    }

    public void setProductPlanLabel(String productPlanLabel) {
        this.productPlanLabel = productPlanLabel;
    }

    public String getProductFactLabel() {
        return productFactLabel;
    }

    public void setProductFactLabel(String productFactLabel) {
        this.productFactLabel = productFactLabel;
    }

    public String getProductDiffLabel() {
        return productDiffLabel;
    }

    public void setProductDiffLabel(String productDiffLabel) {
        this.productDiffLabel = productDiffLabel;
    }

    public String getProductPlan() {
        return productPlan;
    }

    public void setProductPlan(String productPlan) {
        this.productPlan = productPlan;
    }

    public String getProductFact() {
        return productFact;
    }

    public void setProductFact(String productFact) {
        this.productFact = productFact;
    }

    public String getProductDiff() {
        return productDiff;
    }

    public void setProductDiff(String productDiff) {
        this.productDiff = productDiff;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLinkBack() {
        return linkBack;
    }

    public void setLinkBack(String linkBack) {
        this.linkBack = linkBack;
    }

    public String getLinkForward() {
        return linkForward;
    }

    public void setLinkForward(String linkForward) {
        this.linkForward = linkForward;
    }

    public String getClearFactPositionButton() {
        return clearFactPositionButton;
    }

    public void setClearFactPositionButton(String clearFactPositionButton) {
        this.clearFactPositionButton = clearFactPositionButton;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
