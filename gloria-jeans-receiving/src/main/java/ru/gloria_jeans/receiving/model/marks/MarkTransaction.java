package ru.gloria_jeans.receiving.model.marks;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "MarkTransaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class MarkTransaction implements Serializable {
    @XmlElement(name = "Transaction")
    Transaction transaction;
    @XmlElement(name = "Mark")
    List<Mark> mark;

    public MarkTransaction() {}
    public MarkTransaction(
            String type,
            String subType,
            String date,
            String number,
            String idd,
            String src,
            String dst,
            String storeIdd,
            List<Mark> mark
    ) {
        this.transaction = new Transaction(
                type,
                subType,
                date,
                number,
                idd,
                src,
                dst,
                storeIdd
        );
        this.mark = mark;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<Mark> getMark() {
        return mark;
    }

    public void setMark(List<Mark> mark) {
        this.mark = mark;
    }
}
