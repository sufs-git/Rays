package com.feng.su.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 产生GMV的书
 */
@Data
public class GMVBook {
    private Integer seqId;//序号
    private Integer book_id;//图书ID
    private String book_name;//图书名称
    private String book_type;//图书类别
    private Integer print_num;//印册量
    private String agent_name;//出版社名称
    private Integer adviser_id;//编辑ID
    private String adviser_name;//编辑名称
    private String gmv;//产生的GMV
}
