package ru.gloria_jeans.core.v1.orders.model.request;

import java.util.List;

public class ValidateMarks {
    List<String> marks;
    String currentStoreIdd;
    String firmIdd;
    public List<String> getMarks() {
        return marks;
    }

    public void setMarks(List<String> marks) {
        this.marks = marks;
    }

    public String getCurrentStoreIdd() {
        return currentStoreIdd;
    }

    public void setCurrentStoreIdd(String currentStoreIdd) {
        this.currentStoreIdd = currentStoreIdd;
    }

    public String getFirmIdd() {
        return firmIdd;
    }

    public void setFirmIdd(String firmIdd) {
        this.firmIdd = firmIdd;
    }


}
