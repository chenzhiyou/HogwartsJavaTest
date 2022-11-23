package com.myfruits.domain;

import lombok.Data;

@Data
public class Shop {
    private int uid; // 用户ID
    private int fid; // 水果ID
    private boolean isStar; // 是否关注
    private boolean isCart; // 是否在购物车中
}
