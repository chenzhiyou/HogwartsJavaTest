package com.hogwarts.appium.ch07_po.entity;

public class SearchDto {
    private String text;
    private int priceEnd;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(int priceEnd) {
        this.priceEnd = priceEnd;
    }
}
