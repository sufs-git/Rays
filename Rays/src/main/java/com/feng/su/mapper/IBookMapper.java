package com.feng.su.mapper;

import com.feng.su.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBookMapper {
    /**
     * 获取新增书籍信息
     * @return
     */
    public List<Book> getAllBook();

    /**
     * 获取订单金额信息
     * @return
     */
    public List<ItemMoney> getOrderByYear();

    /**
     * 按月编辑四项支出明细
     * @return
     */
    public List<FourBalance> getBalance();

    /**
     * 图书分类以及读者圈和内容占比
     * @return
     */
    public List<BookTypeGMV> getBookTypeGMV();

    /**
     * 产生GMV的书
     */
    public List<GMVBook> getGMVBook();

    /**
     * 商品类型gmv占比排行
     * @return
     */
    public List<ProductGMV> getProGMV();

    /**
     * 产生GMV的书-包括读者圈和内容GMV明细表
     * @return
     */
    public List<ReaderContentGMV> getRcGMV();
}
