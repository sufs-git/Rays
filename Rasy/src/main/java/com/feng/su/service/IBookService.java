package com.feng.su.service;
import javax.servlet.http.HttpServletResponse;

public interface IBookService {
     void getAllBook(HttpServletResponse response) throws Exception;
     void getOrderByYear(HttpServletResponse response)throws Exception;
     void getBalance(HttpServletResponse response)throws Exception;
     void getBookTypeGMV(HttpServletResponse response)throws Exception;
     void getGMVBook(HttpServletResponse response)throws Exception;
     void getProGMV(HttpServletResponse response)throws Exception;
     void getRcGMV(HttpServletResponse response)throws Exception;
     void getOrderDetail(HttpServletResponse response)throws Exception;
}
