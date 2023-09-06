package ru.gloria_jeans.receiving.model.marks;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class Mark implements Serializable {
    @XmlAttribute(name = "Price")
    private BigDecimal price;
    @XmlAttribute(name = "Tax")
    private BigDecimal tax;
    @XmlValue
    private String value;

    public Mark(){}
    public Mark(BigDecimal price, BigDecimal tax, String mark) {
        this.price = price;
        this.tax = tax;
        this.value = mark;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
