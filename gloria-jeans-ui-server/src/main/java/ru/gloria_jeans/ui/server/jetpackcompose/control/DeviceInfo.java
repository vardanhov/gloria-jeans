package ru.gloria_jeans.ui.server.jetpackcompose.control;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceInfo {
    private String serialNumber = StringUtils.EMPTY;
    private String deviceName = StringUtils.EMPTY;
    private String vendorName = StringUtils.EMPTY;

    public DeviceInfo(String serialNumber, String deviceName, String vendorName) {
        this.serialNumber = serialNumber;
        this.deviceName = deviceName;
        this.vendorName = vendorName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}
