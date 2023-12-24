package com.hogwarts.learn.ch19_json;

import com.hogwarts.learn.ch16_yaml.OrderLine;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private String orderNo;
    private LocalDate date;
    private String customerName;
    private List<OrderLine> orderLines;

    public Order(){

    }

    public Order(String orderNo, LocalDate date, String customerName, List<OrderLine> orderLines) {
        this.orderNo = orderNo;
        this.date = date;
        this.customerName = customerName;
        this.orderLines = orderLines;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", date=" + date +
                ", customerName='" + customerName + '\'' +
                ", orderLines=" + orderLines +
                '}';
    }
}
