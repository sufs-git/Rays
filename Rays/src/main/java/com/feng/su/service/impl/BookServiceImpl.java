package com.feng.su.service.impl;

import com.feng.su.entity.*;
import com.feng.su.mapper.IBookMapper;
import com.feng.su.service.IBookService;
import com.feng.su.utils.ExportExcelXSSFUtils;
import com.feng.su.utils.MarkUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookMapper bookMapper;
    @Autowired
    private ExportExcelXSSFUtils exportExcel;

    /**
     * 获取做的书籍信息
     * @param response
     * @return
     */
    @Override
    public void getAllBook(HttpServletResponse response) {

        List<Book> bookList= bookMapper.getAllBook();
        //生成Excel
        exportExcel.exportExcel(new String[]{"序号","图书ID","图书名称","图书类型","印册量","编辑ID","编辑名称","出版社名称","图书确认时间"},bookList,"2020年新增的书籍",response);
    }

    /**
     * 获取订单金额信息
     * @param response
     * @return
     */
    @Override
    public void getOrderByYear(HttpServletResponse response) {
        List<ItemMoney> bookList= bookMapper.getOrderByYear();
        //生成Excel
        exportExcel.exportExcel(new String[]{"年(订单生成年份)","月","gmv","订单量"},bookList,"2020年订单金额表",response);
    }

    @Override
    public void getBalance(HttpServletResponse response) {
        List<FourBalance> fourBalanceList=bookMapper.getBalance();
        //生成Excel
        exportExcel.exportExcel(new String[]{"年","月","编辑ID","编辑名称","编辑费用","作者费用","研发费用","红榜任务","费用合计","出版社名称"},fourBalanceList,"2020年按月编辑四项支出明细",response);
    }

    @Override
    public void getBookTypeGMV(HttpServletResponse response) {
        List<BookTypeGMV> bookTypeGMVList=bookMapper.getBookTypeGMV();
        //生成Excel
        exportExcel.exportExcel(new String[]{"图书类型","读者圈GMV","读者圈GMV占比","内容GMV","内容GMV占比","图书数量","印册量"},bookTypeGMVList,"2020年产生GMV的书(到202004)-图书分类以及读者圈和内容占比",response);
    }

    /**
     * 产生GMV的书
     * @param response
     * @return
     */
    @Override
    public void getGMVBook(HttpServletResponse response) {
        List<GMVBook> gmvBookList=bookMapper.getGMVBook();
        //生成Excel
        exportExcel.exportExcel(new String[]{"序号","图书ID","图书名称","图书类别","印册量","出版社","编辑ID","编辑名称","产生的GMV"},gmvBookList,"2020年产生GMV的书(到202004)",response);
    }

    @Override
    public void getProGMV(HttpServletResponse response) {
        List<ProductGMV> productGMVList=bookMapper.getProGMV();
        //生成Excel
        exportExcel.exportExcel(new String[]{"序号","商品类型ID","商品类型名称","占比(%)","最低价格（元）","最高价格（元）"},productGMVList,"2020年商品类型gmv占比排行（到202004）",response);
    }

    @Override
    public void getRcGMV(HttpServletResponse response) {
        List<ReaderContentGMV> readerContentGMVList=bookMapper.getRcGMV();

        //生成Excel
        exportExcel.exportExcel(new String[]{"序号","图书ID","图书名称","图书类别","出版社","编辑ID","编辑名称","读者圈GMV","读者圈GMV占比","读者圈GMV/印册量","内容GMV","内容GMV占比","内容GMV/印册量","印册量","产生的GMV","产生的GMV/印册量"},
                readerContentGMVList,"2020年产生GMV的书（到202004）-包括读者圈和内容GMV明细表",response);
    }
}
