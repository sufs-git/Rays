package com.feng.su.entity;

import lombok.Data;

/**
 * 做的书
 */
@Data
public class Book {
    private Integer seqId;//序号,用于Excel表排序
    private Integer book_id;//图书id
    private String book_name;//图书名称
    private String book_type;//图书类型
    private Integer print_num;//印册量
    private Integer adviser_id;//编辑ID
    private String adviser_name;//编辑名称
    private String agent_name;//出版社名称
    private String confirm_time;//图书确认时间

    @Override
    public String toString() {
        return "Book{" +
                "seqId=" + seqId +
                ", book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_type='" + book_type + '\'' +
                ", print_num=" + print_num +
                ", adviser_id=" + adviser_id +
                ", adviser_name='" + adviser_name + '\'' +
                ", agent_name='" + agent_name + '\'' +
                ", confirm_time=" + confirm_time +
                '}';
    }
}
