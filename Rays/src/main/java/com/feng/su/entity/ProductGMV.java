package com.feng.su.entity;

import lombok.Data;

/**
 * 商品类型gmv占比排行
 */
@Data
public class ProductGMV {
    private Integer seqId;//序号
    private Integer pro_type_id;//商品类型ID
    private String type_name;//商品类型名称
    private String rate;//占比
    private String min_price;//最低价格
    private String max_price;//最高价格
}
