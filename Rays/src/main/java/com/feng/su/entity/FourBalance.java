package com.feng.su.entity;

import lombok.Data;

/**
 * 编辑四项支出明细
 */
@Data
public class FourBalance {
    private Integer year;//年
    private Integer month;//月
    private Integer adviser_id;//编辑id
    private String adviser_name;//编辑名称
    private Integer adviser_fee;//编辑费用
    private Integer author_fee;//作者费用
    private Integer develop_fee;//研发费用
    private Integer red_fee;//红榜任务
    private Integer total_fee;//费用合计
    private String agent_name;//出版社名称
}
