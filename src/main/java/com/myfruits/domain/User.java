package com.myfruits.domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private String email;
    private String phone;
    private String pwd;
    private String uname;

    public User() {
    }

    public User(int id, String email, String phone, String pwd, String uname) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.pwd = pwd;
        this.uname = uname;
    }
}
