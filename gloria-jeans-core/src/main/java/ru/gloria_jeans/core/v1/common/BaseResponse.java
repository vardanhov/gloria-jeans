package ru.gloria_jeans.core.v1.common;

import java.io.Serializable;
import java.util.List;

public class BaseResponse implements Serializable {
    private String responseMessage;
    private Boolean responseException;

    private List<String> exceptionParameters;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Boolean getResponseException() {
        return responseException;
    }

    public void setResponseException(Boolean responseException) {
        this.responseException = responseException;
    }

    public List<String> getExceptionParameters() {
        return exceptionParameters;
    }

    public void setExceptionParameters(List<String> exceptionParameters) {
        this.exceptionParameters = exceptionParameters;
    }
}

