package com.feng.su.entity;

import lombok.Data;

@Data
public class ReaderContentGMV {
    private Integer seqId;//序号
    private Integer book_id;//图书ID
    private String book_name;//图书名称
    private String book_type;//图书类别
    private String agent_name;//出版社
    private Integer adviser_id;//编辑ID
    private String adviser_name;//编辑名称
    private String reader_gmv;//读者圈GMV
    private String reader_gmv_rate;//读者圈GMV占比
    private String reader_gmv_print_num;//读者圈GMV/印册量
    private String content_gmv;//内容GMV
    private String content_gmv_rate;//内容GMV占比
    private String content_gmv_print_num;//内容GMV/印册量
    private Integer print_num;//印册量
    private String gmv;//产生的gmv
    private String gmv_print_num;//产生的GMV/印册量
}
