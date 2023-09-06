package ru.gloria_jeans.receiving.model.marks;

import java.io.Serializable;

public class ValidationMarkItem implements Serializable {
    private Boolean in_box;
    private Boolean in_lot;
    private Boolean in_circulation;
    private Boolean in_store;
    private Boolean is_out;
    private Boolean is_lock;
    private Boolean is_collect;
    private String store_idd;
    private Boolean is_agent;
    private Boolean is_ecomm;
    private String inn;
    private String km;

    public Boolean getIn_box() {
        return in_box;
    }

    public void setIn_box(Boolean in_box) {
        this.in_box = in_box;
    }

    public Boolean getIn_lot() {
        return in_lot;
    }

    public void setIn_lot(Boolean in_lot) {
        this.in_lot = in_lot;
    }

    public Boolean getIn_circulation() {
        return in_circulation;
    }

    public void setIn_circulation(Boolean in_circulation) {
        this.in_circulation = in_circulation;
    }

    public Boolean getIn_store() {
        return in_store;
    }

    public void setIn_store(Boolean in_store) {
        this.in_store = in_store;
    }

    public Boolean getIs_out() {
        return is_out;
    }

    public void setIs_out(Boolean is_out) {
        this.is_out = is_out;
    }

    public Boolean getIs_lock() {
        return is_lock;
    }

    public void setIs_lock(Boolean is_lock) {
        this.is_lock = is_lock;
    }

    public Boolean getIs_collect() {
        return is_collect;
    }

    public void setIs_collect(Boolean is_collect) {
        this.is_collect = is_collect;
    }

    public String getStore_idd() {
        return store_idd;
    }

    public void setStore_idd(String store_idd) {
        this.store_idd = store_idd;
    }

    public Boolean getIs_agent() {
        return is_agent;
    }

    public void setIs_agent(Boolean is_agent) {
        this.is_agent = is_agent;
    }

    public Boolean getIs_ecomm() {
        return is_ecomm;
    }

    public void setIs_ecomm(Boolean is_ecomm) {
        this.is_ecomm = is_ecomm;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }
}
