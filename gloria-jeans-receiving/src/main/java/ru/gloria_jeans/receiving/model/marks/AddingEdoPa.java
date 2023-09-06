package ru.gloria_jeans.receiving.model.marks;

import java.io.Serializable;

public class AddingEdoPa implements Serializable {
    private String edo_type;
    private String src_inn;
    private String src_kpp;
    private String dst_inn;
    private String dst_kpp;
    private String doc_idd;
    private String doc_num;
    private String type;
    private String store_idd;
    private String mark_list;
    private String is_collect;
    private String xml;
    private String file_name;

    public AddingEdoPa() {
    }

    public AddingEdoPa(String edo_type, String src_inn, String src_kpp, String dst_inn, String dst_kpp, String doc_idd, String doc_num, String type, String store_idd, String mark_list, String is_collect, String xml, String file_name) {
        this.edo_type = edo_type;
        this.src_inn = src_inn;
        this.src_kpp = src_kpp;
        this.dst_inn = dst_inn;
        this.dst_kpp = dst_kpp;
        this.doc_idd = doc_idd;
        this.doc_num = doc_num;
        this.type = type;
        this.store_idd = store_idd;
        this.mark_list = mark_list;
        this.is_collect = is_collect;
        this.xml = xml;
        this.file_name = file_name;
    }

    public String getEdo_type() {
        return edo_type;
    }

    public void setEdo_type(String edo_type) {
        this.edo_type = edo_type;
    }

    public String getSrc_inn() {
        return src_inn;
    }

    public void setSrc_inn(String src_inn) {
        this.src_inn = src_inn;
    }

    public String getSrc_kpp() {
        return src_kpp;
    }

    public void setSrc_kpp(String src_kpp) {
        this.src_kpp = src_kpp;
    }

    public String getDst_inn() {
        return dst_inn;
    }

    public void setDst_inn(String dst_inn) {
        this.dst_inn = dst_inn;
    }

    public String getDst_kpp() {
        return dst_kpp;
    }

    public void setDst_kpp(String dst_kpp) {
        this.dst_kpp = dst_kpp;
    }

    public String getDoc_idd() {
        return doc_idd;
    }

    public void setDoc_idd(String doc_idd) {
        this.doc_idd = doc_idd;
    }

    public String getDoc_num() {
        return doc_num;
    }

    public void setDoc_num(String doc_num) {
        this.doc_num = doc_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStore_idd() {
        return store_idd;
    }

    public void setStore_idd(String store_idd) {
        this.store_idd = store_idd;
    }

    public String getMark_list() {
        return mark_list;
    }

    public void setMark_list(String mark_list) {
        this.mark_list = mark_list;
    }

    public String getIs_collect() {
        return is_collect;
    }

    public void setIs_collect(String is_collect) {
        this.is_collect = is_collect;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }
}
