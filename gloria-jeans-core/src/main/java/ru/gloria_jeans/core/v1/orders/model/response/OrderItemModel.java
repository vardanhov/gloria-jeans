package ru.gloria_jeans.core.v1.orders.model.response;

public class OrderItemModel {
    private String fullName;
    private String count;
    private String price;
    private String sum;

    public OrderItemModel(String fullName, String count, String price, String sum) {
        this.fullName = fullName;
        this.count = count;
        this.price = price;
        this.sum = sum;
    }

    public OrderItemModel(String fullName, String count, String sum) {
        this.fullName = fullName;
        this.count = count;
        this.sum = sum;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
