package com.feng.su.entity;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String order_num;
    private String openid;
    private String pro_name;
    private Integer pro_type_id;
    private Integer adviser_id;
    private Integer agent_id;
    private String price;
    private Integer count;
    private String wx_pay_num;
    private String pay_time;
    private String submit_time;
    private Integer book_id;
    private Integer pro_id;
    private Integer is_fund;
    private Integer data_source;
    private Integer main_adviser_id;
    private Integer specification_id;
    private Integer pay_time_m;
}
