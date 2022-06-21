package com.hogwarts.junit5Basics.ch14_csv;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderList {

    @JsonProperty("item")
    private String otherItem;
    @JsonProperty("quantity")
    private int qua;
    @JsonProperty("unitPrice")
    private BigDecimal price;
    @JsonProperty("orderDate")
    private LocalDate date;

    public OrderList(){

    }

    public OrderList(String otherItem, int qua, BigDecimal price, LocalDate date) {
        this.otherItem = otherItem;
        this.qua = qua;
        this.price = price;
        this.date = date;
    }

    public String getOtherItem() {
        return otherItem;
    }

    public void setOtherItem(String otherItem) {
        this.otherItem = otherItem;
    }

    public int getQua() {
        return qua;
    }

    public void setQua(int qua) {
        this.qua = qua;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



    @Override
    public String toString() {
        return "OrderList{" +
                "otherItem='" + otherItem + '\'' +
                ", qua=" + qua +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
