package com.feng.su.utils;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

/**
 * 生成Excel工具类
 * headers:表头
 * dataset:javabean集合
 * fileName:生成的Excel名称
 * response:将excel表以字节流的形式返回给前端
 * @param <T>
 */
@Component("exportExcel")
public class ExportExcelXSSFUtils<T> {
    public void exportExcel(String[] headers, Collection<T> dataset, String fileName, HttpServletResponse response) {
        // 声明一个工作薄
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        // 生成一个表格
        SXSSFSheet sheet = workbook.createSheet(fileName);
        //样式对象
        CellStyle style=workbook.createCellStyle();
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        // 产生表格标题行
        SXSSFRow row = sheet.createRow(0);
        row.setHeightInPoints(30);//设置行高

        for (int i = 0; i < headers.length; i++) {
            SXSSFCell cell=row.createCell(i);
            //设置背景
            style.setFillBackgroundColor((short)13);
           // style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
            //设置字体
            //XSSFFont font2 = workbook.createFont();
            //font2.setFontName("仿宋_GB2312");
           // font2.setBoldweight(XSSFFont.);//粗体显示
            //font2.setFontHeightInPoints((short) 12);  //字体大小
            //font2.setColor(XSSFColor.toXSSFColor(c).index);//设置字体颜色
            //style.setFont(font2);//选择需要用到的字体格式
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellStyle(style);
            cell.setCellValue(text);
        }
        try {
            // 遍历集合数据，产生数据行
            Iterator<T> it = dataset.iterator();
            int index = 0;
            while (it.hasNext()) {
                index++;
                row = sheet.createRow(index);
                T t = (T) it.next();
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                for (int i = 0; i < headers.length; i++) {
                    SXSSFCell cell = row.createCell(i);
                    Field field = fields[i];
                    String fieldName = field.getName();
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    // 其它数据类型都当作字符串简单处理
                    if(value != null && value != ""){
                        textValue = value.toString();
                    }else{
                        textValue=String.valueOf(index);
                    }
                    if (textValue != null) {
                        XSSFRichTextString richString = new XSSFRichTextString(textValue);
                        cell.setCellValue(richString);
                    }
                }
            }
            getExportedFile(workbook, fileName,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
     *
     * 方法说明: 指定路径下生成EXCEL文件
     * @return
     */

    public void getExportedFile(SXSSFWorkbook workbook, String name, HttpServletResponse response) throws Exception {
        System.out.println("name:"+name);
        BufferedOutputStream fos = null;
        try {
            String fileName = name + ".xlsx";
            response.setContentType("application/msdownload");
            response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"),"ISO8859-1"));
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                System.out.println("ok");
        }
    }
}
