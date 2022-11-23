package com.myfruits.domain;


import lombok.Data;

@Data
public class Fruit {
    private int fId;
    private String fname;
    private String spc;
    private double up; // 单价
    private String t1; // 简介
    private String t2; // 温馨提示
    private int inum; // 图片数量

}
