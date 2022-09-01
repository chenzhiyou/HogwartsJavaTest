package com.hogwarts.interfaceTest.ch09_litemall.model;

// 如果数据模型需要初始值，可以给一个默认值
public class CartModel {
    private Integer goodsId;
    private Integer number;
    private Integer productId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }


}
