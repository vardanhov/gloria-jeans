package ru.gloria.aaanet.sduicompose.util;

import android.annotation.SuppressLint;
import android.os.Build;

import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class Device {

    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    String hex = Integer.toHexString(b & 0xFF);
                    if (hex.length() == 1)
                        hex = "0".concat(hex);
                    res1.append(hex.concat(":"));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ignored) {
        }
        return "";
    }

    /**
     * @return The device's serial number, visible to the user in {@code Settings > About phone/tablet/device > Status
     * > Serial number}, or {@code null} if the serial number couldn't be found
     */
    @SuppressLint("HardwareIds")
    public static String getSerialNumber() {
        String serialNumber;
        try {
            @SuppressLint("PrivateApi") Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class);

            // (?) Lenovo Tab (https://stackoverflow.com/a/34819027/1276306)
            serialNumber = (String) get.invoke(c, "gsm.sn1");

            if (serialNumber != null && serialNumber.equals(""))
                // Samsung Galaxy S5 (SM-G900F) : 6.0.1
                // Samsung Galaxy S6 (SM-G920F) : 7.0
                // Samsung Galaxy Tab 4 (SM-T530) : 5.0.2
                // (?) Samsung Galaxy Tab 2 (https://gist.github.com/jgold6/f46b1c049a1ee94fdb52)
                serialNumber = (String) get.invoke(c, "ril.serialnumber");

            // Archos 133 Oxygen : 6.0.1
            // Google Nexus 5 : 6.0.1
            // Hannspree HANNSPAD 13.3" TITAN 2 (HSG1351) : 5.1.1
            // Honor 5C (NEM-L51) : 7.0
            // Honor 5X (KIW-L21) : 6.0.1
            // Huawei M2 (M2-801w) : 5.1.1
            // (?) HTC Nexus One : 2.3.4 (https://gist.github.com/tetsu-koba/992373)
            if (serialNumber != null && serialNumber.equals(""))
                serialNumber = (String) get.invoke(c, "ro.serialno");

            // (?) Samsung Galaxy Tab 3 (https://stackoverflow.com/a/27274950/1276306)
            if (serialNumber != null && serialNumber.equals(""))
                serialNumber = (String) get.invoke(c, "sys.serialnumber");

            // Archos 133 Oxygen : 6.0.1
            // Hannspree HANNSPAD 13.3" TITAN 2 (HSG1351) : 5.1.1
            // Honor 9 Lite (LLD-L31) : 8.0
            // Xiaomi Mi 8 (M1803E1A) : 8.1.0
            if (serialNumber != null && serialNumber.equals("")) serialNumber = Build.SERIAL;

            // If none of the methods above worked
            if (serialNumber != null && serialNumber.equals(Build.UNKNOWN)) serialNumber = "";
        } catch (Exception e) {
            e.printStackTrace();
            serialNumber = "";
        }

        return serialNumber;
    }

    public static String getDeviceModel(){
        return Build.MODEL;
    }

    public static String getDeviceManufacturer(){
        return  Build.MANUFACTURER;
    }
}