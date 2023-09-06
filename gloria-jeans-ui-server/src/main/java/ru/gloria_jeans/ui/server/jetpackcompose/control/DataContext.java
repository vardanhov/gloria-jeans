package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import ru.gloria_jeans.ui.server.jetpackcompose.enums.BeepType;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataContext {
    private String entryPointUrl = StringUtils.EMPTY;
    private DeviceInfo deviceInfo;
    private UserInfo userInfo;
    private String headerTitle = StringUtils.EMPTY;
    private String headerRefreshAction = StringUtils.EMPTY;
    private String footerText = StringUtils.EMPTY;
    private String message = StringUtils.EMPTY;
    private List<ActionData> footerButtons = new ArrayList<>();
    private List<ActionData> bottomButtons = new ArrayList<>();
    private ModalView modal;
    private BeepType beepType;
    private ArrayList<String> lastURLs = new ArrayList<>();

    @JsonIgnore
    private String scanType;
    @JsonIgnore
    private String scanData;

    public String getEntryPointUrl() {
        return entryPointUrl;
    }

    public void setEntryPointUrl(String entryPointUrl) {
        this.entryPointUrl = entryPointUrl;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getHeaderRefreshAction() {
        return headerRefreshAction;
    }

    public void setHeaderRefreshAction(String headerRefreshAction) {
        this.headerRefreshAction = headerRefreshAction;
    }

    public String getFooterText() {
        return footerText;
    }

    public void setFooterText(String footerText) {
        this.footerText = footerText;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ActionData> getFooterButtons() {
        return footerButtons;
    }

    public void setFooterButtons(List<ActionData> footerButtons) {
        this.footerButtons = footerButtons;
    }

    public List<ActionData> getBottomButtons() {
        return bottomButtons;
    }

    public void setBottomButtons(List<ActionData> bottomButtons) {
        this.bottomButtons = bottomButtons;
    }

    public ModalView getModal() {
        return modal;
    }

    public void setModal(ModalView modal) {
        this.modal = modal;
    }

    public BeepType getBeepType() {
        return beepType;
    }

    public void setBeepType(BeepType beepType) {
        this.beepType = beepType;
    }

    public String getScanType() {
        return scanType;
    }

    public void setScanType(String scanType) {
        this.scanType = scanType;
    }

    public String getScanData() {
        return scanData;
    }

    public void setScanData(String scanData) {
        this.scanData = scanData;
    }

    public ArrayList<String> getLastURLs() {
        return lastURLs;
    }

    public void setLastURLs(ArrayList<String> lastURLs) {
        this.lastURLs = lastURLs;
    }
}
