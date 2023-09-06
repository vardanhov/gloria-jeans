package ru.gloria_jeans.core.v1.receiving.models.response;

import ru.gloria_jeans.core.v1.common.BaseResponse;

public class ExistBox extends BaseResponse {
    private Boolean existBox;

    public Boolean getExistBox() {
        return existBox;
    }

    public void setExistBox(Boolean existBox) {
        this.existBox = existBox;
    }
}
