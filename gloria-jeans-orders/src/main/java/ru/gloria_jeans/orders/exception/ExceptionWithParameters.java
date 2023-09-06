package ru.gloria_jeans.orders.exception;

import java.util.List;

public class ExceptionWithParameters extends Throwable{
    public String message;
    public List<String> parameters;

    public ExceptionWithParameters(){}
    public ExceptionWithParameters(String message) {
        this.message = message;
    }

    public ExceptionWithParameters(String message, List<String> parameters) {
        super(message);
        this.message = message;
        this.parameters = parameters;
    }

    public ExceptionWithParameters(String message, Throwable cause, List<String> parameters) {
        super(message, cause);
        this.message = message;
        this.parameters = parameters;
    }

    public ExceptionWithParameters(Throwable cause, String message, List<String> parameters) {
        super(cause);
        this.message = message;
        this.parameters = parameters;
    }

    public ExceptionWithParameters(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, List<String> parameters) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message;
        this.parameters = parameters;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }
}
