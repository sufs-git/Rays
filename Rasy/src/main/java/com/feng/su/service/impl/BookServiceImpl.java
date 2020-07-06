package com.feng.su.service.impl;

import com.feng.su.entity.*;
import com.feng.su.mapper.IBookMapper;
import com.feng.su.service.IBookService;
import com.feng.su.util.*;
import com.github.pagehelper.PageHelper;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    private final static Logger logger = LoggerFactory.getLogger(PoiUtil.class);
    @Autowired
    private IBookMapper bookMapper;
    @Autowired
    private ExcelUtil excelUtil;
    /**
     * 获取做的书籍信息
     * @param response
     * @return
     */
    @Override
    public void getAllBook(HttpServletResponse response) throws Exception{
        //总记录数
        Integer totalRowCount=this.bookMapper.getBookCount();
        //导出EXCEL文件名称
        String fileName="2020年做的书籍信息";

        //标题
        String[] titiles={"序号","图书ID","图书名称","图书类型","印册量","编辑ID","编辑名称","出版社名称","图书确认时间"};

        //开始导入
        PoiUtil.exportExcelToWebsite(response, totalRowCount, fileName, titiles, new WriteExcelDataDelegated() {
            @Override
            public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {
                List<Book> bookList=bookMapper.getAllBook(startRowCount-1,pageSize);
                if(!CollectionUtils.isEmpty(bookList)){
                    for (int i = startRowCount; i <= endRowCount; i++) {
                        SXSSFRow eachDataRow = eachSheet.createRow(i);
                        if ((i - startRowCount) < bookList.size()) {
                            Book book = bookList.get(i - startRowCount);
                            // --------- 将每一条记录写入excel -----------------------
                            excelUtil.convertBean(titiles,book,eachDataRow,i);
                        }
                    }
                }
                bookList.clear();
            }
        });
    }

    /**
     * 获取订单金额信息
     * @param response
     * @return
     */
    @Override
    public void getOrderByYear(HttpServletResponse response) throws Exception{
        //总记录数
        Integer totalRowCount=this.bookMapper.getBookCount();
        //导出EXCEL文件名称
        String fileName="订单金额信息";

        //标题
        String[] titiles={"年(订单生成年份)","月","gmv","订单量"};

        //开始导入
        PoiUtil.exportExcelToWebsite(response, totalRowCount, fileName, titiles, new WriteExcelDataDelegated() {
            @Override
            public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {
                List<ItemMoney> itemMoneyList=bookMapper.getOrderByYear(startRowCount-1,pageSize);
                if(!CollectionUtils.isEmpty(itemMoneyList)){
                    for (int i = startRowCount; i <= endRowCount; i++) {
                        SXSSFRow eachDataRow = eachSheet.createRow(i);
                        if ((i - startRowCount) < itemMoneyList.size()) {
                            ItemMoney itemMoney = itemMoneyList.get(i - startRowCount);
                            // --------- 将每一条记录写入excel -----------------------
                            excelUtil.convertBean(titiles,itemMoney,eachDataRow,i);
                        }
                    }
                    itemMoneyList.clear();
                }
            }
        });

    }

    @Override
    public void getBalance(HttpServletResponse response) throws Exception{
        //总记录数
        Integer totalRowCount=this.bookMapper.getBalanceCount();
        //导出EXCEL文件名称
        String fileName="编辑四项费用明细";

        //标题
        String[] titiles={"年","月","编辑ID","编辑名称","编辑费用","作者费用","研发费用","红榜任务","费用合计","出版社名称"};

        //开始导入
        PoiUtil.exportExcelToWebsite(response, totalRowCount, fileName, titiles, new WriteExcelDataDelegated() {
            @Override
            public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {
                List<FourBalance> fourBalanceList=bookMapper.getBalance(startRowCount-1,pageSize);
                if(!CollectionUtils.isEmpty(fourBalanceList)){
                    for (int i = startRowCount; i <= endRowCount; i++) {
                        SXSSFRow eachDataRow = eachSheet.createRow(i);
                        if ((i - startRowCount) < fourBalanceList.size()) {
                            FourBalance fourBalance = fourBalanceList.get(i - startRowCount);
                            // --------- 将每一条记录写入excel -----------------------
                            excelUtil.convertBean(titiles,fourBalance,eachDataRow,i);
                        }
                    }
                    fourBalanceList.clear();
                }
            }
        });
    }

    @Override
    public void getBookTypeGMV(HttpServletResponse response) throws Exception{
        //总记录数
        Integer totalRowCount=this.bookMapper.getBookTypeGMVCount();
        //导出EXCEL文件名称
        String fileName="图书类型GMV";

        //标题
        String[] titiles={"图书类型","读者圈GMV","读者圈GMV占比","内容GMV","内容GMV占比","图书数量","印册量"};

        //开始导入
        PoiUtil.exportExcelToWebsite(response, totalRowCount, fileName, titiles, new WriteExcelDataDelegated() {
            @Override
            public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {
                 List<BookTypeGMV> bookTypeGMVList=bookMapper.getBookTypeGMV(startRowCount-1,pageSize);
                if(!CollectionUtils.isEmpty(bookTypeGMVList)){
                    for (int i = startRowCount; i <= endRowCount; i++) {
                        SXSSFRow eachDataRow = eachSheet.createRow(i);
                        if ((i - startRowCount) < bookTypeGMVList.size()) {
                            BookTypeGMV bookTypeGMV = bookTypeGMVList.get(i - startRowCount);
                            // --------- 将每一条记录写入excel -----------------------
                            excelUtil.convertBean(titiles,bookTypeGMV,eachDataRow,i);
                        }
                    }
                    bookTypeGMVList.clear();
                }
            }
        });
    }

    /**
     * 产生GMV的书
     * @param response
     * @return
     */
    @Override
    public void getGMVBook(HttpServletResponse response) throws Exception{
        //总记录数
        Integer totalRowCount=this.bookMapper.getGMVBookCount();
        //导出EXCEL文件名称
        String fileName="2020年产生GMV的书(到202004)";

        //标题
        String[] titiles={"序号","图书ID","图书名称","图书类别","印册量","出版社","编辑ID","编辑名称","产生的GMV"};

        //开始导入
        PoiUtil.exportExcelToWebsite(response, totalRowCount, fileName, titiles, new WriteExcelDataDelegated() {
            @Override
            public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {
                List<GMVBook> gmvBookList=bookMapper.getGMVBook(startRowCount-1,pageSize);
                if(!CollectionUtils.isEmpty(gmvBookList)){
                    for (int i = startRowCount; i <= endRowCount; i++) {
                        SXSSFRow eachDataRow = eachSheet.createRow(i);
                        if ((i - startRowCount) < gmvBookList.size()) {
                            GMVBook gMVBook = gmvBookList.get(i - startRowCount);
                            // --------- 将每一条记录写入excel -----------------------
                            excelUtil.convertBean(titiles,gMVBook,eachDataRow,i);
                        }
                    }
                    gmvBookList.clear();
                }
            }
        });
    }

    @Override
    public void getProGMV(HttpServletResponse response) throws Exception{
        //总记录数
        Integer totalRowCount=this.bookMapper.getProGMVCount();
        //导出EXCEL文件名称
        String fileName="2020年商品类型gmv占比排行（到202004）";

        //标题
        String[] titiles={"序号","商品类型ID","商品类型名称","占比(%)","最低价格（元）","最高价格（元）"};

        //开始导入
        PoiUtil.exportExcelToWebsite(response, totalRowCount, fileName, titiles, new WriteExcelDataDelegated() {
            @Override
            public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {
                List<ProductGMV> productGMVList=bookMapper.getProGMV(startRowCount-1,pageSize);
                if(!CollectionUtils.isEmpty(productGMVList)){
                    for (int i = startRowCount; i <= endRowCount; i++) {
                        SXSSFRow eachDataRow = eachSheet.createRow(i);
                        if ((i - startRowCount) < productGMVList.size()) {
                            ProductGMV productGMV = productGMVList.get(i - startRowCount);
                            // --------- 将每一条记录写入excel -----------------------
                            excelUtil.convertBean(titiles,productGMV,eachDataRow,i);
                        }
                    }
                    productGMVList.clear();
                }
            }
        });
    }

    @Override
    public void getRcGMV(HttpServletResponse response) throws Exception{
        //总记录数
        Integer totalRowCount=this.bookMapper.getRcGMVCount();
        //导出EXCEL文件名称
        String fileName="2020年产生GMV的书（到202004）-包括读者圈和内容GMV明细表";

        //标题
        String[] titiles={"序号","图书ID","图书名称","图书类别","出版社","编辑ID","编辑名称","读者圈GMV","读者圈GMV占比","读者圈GMV/印册量","内容GMV","内容GMV占比","内容GMV/印册量","印册量","产生的GMV","产生的GMV/印册量"};

        //开始导入
        PoiUtil.exportExcelToWebsite(response, totalRowCount, fileName, titiles, new WriteExcelDataDelegated() {
            @Override
            public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {
                List<ReaderContentGMV> readerContentGMVList=bookMapper.getRcGMV(startRowCount-1,pageSize);
                if(!CollectionUtils.isEmpty(readerContentGMVList)){
                    for (int i = startRowCount; i <= endRowCount; i++) {
                        SXSSFRow eachDataRow = eachSheet.createRow(i);
                        if ((i - startRowCount) < readerContentGMVList.size()) {
                            ReaderContentGMV readerContentGMV = readerContentGMVList.get(i - startRowCount);
                            // --------- 将每一条记录写入excel -----------------------
                            excelUtil.convertBean(titiles,readerContentGMV,eachDataRow,i);
                        }
                    }
                    readerContentGMVList.clear();
                }
            }
        });
    }

    @Override
    public void getOrderDetail(HttpServletResponse response) throws Exception{
        //总记录数
        Integer totalRowCount=this.bookMapper.getOrderDetailCount();
        logger.info("订单总数：" + totalRowCount+" "+DateUtil.formatDate(new Date(), DateUtil.YYYY_MM_DD_HH_MM_SS));
        //导出EXCEL文件名称
        String fileName="订单详情表";

        //标题
        String[] titiles={"id","order_num","openid","pro_name","pro_type_id","adviser_id","agent_id","price","count","wx_pay_num","pay_time","submit_time","book_id","pro_id","id_fund","data_source","main_adviser_id","specification_id","pay_time_m"};

        //开始导入
        PoiUtil.exportExcelToWebsite(response, totalRowCount, fileName, titiles, new WriteExcelDataDelegated() {
            @Override
            public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {
                List<Order> orderList=bookMapper.getOrderDetail(startRowCount-1,pageSize);
                logger.info("每次查询的数量：" + orderList.size()+" "+DateUtil.formatDate(new Date(), DateUtil.YYYY_MM_DD_HH_MM_SS));
                if(!CollectionUtils.isEmpty(orderList)){
                    for (int i = startRowCount; i <= endRowCount; i++) {
                        SXSSFRow eachDataRow = eachSheet.createRow(i);
                        if ((i - startRowCount) < orderList.size()) {
                            Order order = orderList.get(i - startRowCount);
                            // --------- 将每一条记录写入excel -----------------------
                            excelUtil.convertBean(titiles,order,eachDataRow,i);
                        }
                    }
                    orderList.clear();
                }
            }
        });

    }
}
