package com.feng.su.mapper;

import com.feng.su.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookMapper {
    /**
     * 获取新增书籍信息
     * @return
     */
    public List<Book> getAllBook(@Param(value="startIndex")Integer startIndex,@Param(value="pageSize") Integer pageSize);

    /**
     * 获取做书的数量
     * @return
     */
    public Integer getBookCount();
    /**
     * 获取订单金额信息
     * @return
     */
    public List<ItemMoney> getOrderByYear(@Param(value="startIndex")Integer startIndex,@Param(value="pageSize") Integer pageSize);

    /**
     * 获取订单金额信息数量
     * @return
     */
    public Integer getOrderByYearCount();
    /**
     * 按月编辑四项支出明细
     * @return
     */
    public List<FourBalance> getBalance(@Param(value="startIndex")Integer startIndex,@Param(value="pageSize") Integer pageSize);
    /**
     * 按月编辑四项支出明细数量
     * @return
     */
    public Integer getBalanceCount();
    /**
     * 图书分类以及读者圈和内容占比
     * @return
     */
    public List<BookTypeGMV> getBookTypeGMV(@Param(value="startIndex")Integer startIndex,@Param(value="pageSize") Integer pageSize);

    /**
     * 图书分类以及读者圈和内容占比数量
     * @return
     */
    public Integer getBookTypeGMVCount();
    /**
     * 产生GMV的书
     */
    public List<GMVBook> getGMVBook(@Param(value="startIndex")Integer startIndex,@Param(value="pageSize") Integer pageSize);

    /**
     * 产生GMV的书的数量
     */
    public Integer getGMVBookCount();

    /**
     * 商品类型gmv占比排行
     * @return
     */
    public List<ProductGMV> getProGMV(@Param(value="startIndex")Integer startIndex,@Param(value="pageSize") Integer pageSize);

    /**
     * 商品类型gmv占比排行的数量
     * @return
     */
    public Integer getProGMVCount();
    /**
     * 产生GMV的书-包括读者圈和内容GMV明细表
     * @return
     */
    public List<ReaderContentGMV> getRcGMV(@Param(value="startIndex")Integer startIndex,@Param(value="pageSize") Integer pageSize);

    /**
     * 产生GMV的书-包括读者圈和内容GMV明细表的数量
     * @return
     */
    public Integer getRcGMVCount();
    /**
     * 查询订单详情
     * @return
     */
    public List<Order> getOrderDetail(@Param(value="startIndex")Integer startIndex,@Param(value="pageSize") Integer pageSize);
    /**
     * 查询订单详情数量
     * @return
     */
    public Integer getOrderDetailCount();
}
