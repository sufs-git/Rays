package com.feng.su.entity;

import lombok.Data;

/**
 * 图书分类以及读者圈和内容占比
 */
@Data
public class BookTypeGMV {
    private String book_type;//图书类型
    private String  reader_gmv;//读者圈GMV
    private String reader_gmv_percent;//读者圈GMV占比
    private String content_gmv;//内容GMV
    private String content_gmv_percent;//内容GMV占比
    private Integer book_count;//图书数量
    private Integer print_num;//印册量
}
