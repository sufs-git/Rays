package com.feng.su.service;
import javax.servlet.http.HttpServletResponse;

public interface IBookService {
     void getAllBook(HttpServletResponse response);
     void getOrderByYear(HttpServletResponse response);
     void getBalance(HttpServletResponse response);
     void getBookTypeGMV(HttpServletResponse response);
     void getGMVBook(HttpServletResponse response);
     void getProGMV(HttpServletResponse response);
     void getRcGMV(HttpServletResponse response);
}
