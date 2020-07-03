package com.feng.su.controller;

import com.feng.su.entity.*;
import com.feng.su.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private IBookService bookService;

    /**
     * 查询做的书籍信息
     * @param response
     */
    @RequestMapping("/getBook")
    public void getAllBook(HttpServletResponse response){
       bookService.getAllBook(response);
    }

    /**
     * 查询订单金额表
     * @param response
     */
    @RequestMapping("/getItem")
    public void getItemByYear(HttpServletResponse response){
        bookService.getOrderByYear(response);
    }

    /**
     * 编辑支出四项明细
     * @param response
     */
    @RequestMapping("/getBalance")
    public void getBalance(HttpServletResponse response){
        bookService.getBalance(response);
    }

    /**
     * 图书分类以及读者圈和内容占比
     * @param response
     */
    @RequestMapping("/getGMVPercent")
    public void getBookTypeGMV(HttpServletResponse response){
        bookService.getBookTypeGMV(response);
    }

    /**
     * 产生GMV的书
     * @param response
     */
    @RequestMapping("/getGMVBook")
    public void getGMVBook(HttpServletResponse response){
        bookService.getGMVBook(response);
    }

    /**
     * 商品类型gmv占比排行
     * @param response
     */
    @RequestMapping("/getProductGMV")
    public void getProGMV(HttpServletResponse response){
       bookService.getProGMV(response);
    }

    /**
     * 读者圈和内容GMV明细表
     * @param response
     * @return
     */
    @RequestMapping("/getRcGMV")
    public void getRcGMV(HttpServletResponse response){
        bookService.getRcGMV(response);
    }
}
