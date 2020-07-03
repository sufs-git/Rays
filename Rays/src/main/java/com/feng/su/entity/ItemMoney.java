package com.feng.su.entity;

import org.apache.poi.hpsf.Decimal;

public class ItemMoney {
    private Integer year;
    private Integer month;
    private String gmv;
    private Integer count;
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getGmv() {
        return gmv;
    }

    public void setGmv(String gmv) {
        this.gmv = gmv;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ItemMoney{" +
                "year=" + year +
                ", month=" + month +
                ", gmv=" + gmv +
                ", count=" + count +
                '}';
    }
}
