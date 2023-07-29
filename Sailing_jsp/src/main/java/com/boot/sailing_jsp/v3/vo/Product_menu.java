package com.boot.sailing_jsp.v3.vo;

import lombok.Data;

//외부에서 접근하지못하도록 private 객체를 사용
@Data
public class Product_menu {

    private String no;

    private String product;

    private String kind;

    private String price;

    private String reg_day;

    private String mod_day;


    }

