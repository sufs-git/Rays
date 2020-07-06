package com.feng.su.util;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
@Component
public class ExcelUtil <T>{
    /**
     * 将bean属性封装到每一行
     * @param headers 表头
     * @param t
     * @param row 当前行对象
     * @param rowNumber 当前行数
     * @throws Exception
     */
    public  void convertBean(String[]headers, T t, SXSSFRow row,Integer rowNumber)throws Exception{
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
                textValue=String.valueOf(rowNumber);
            }
            if (textValue != null) {
                XSSFRichTextString richString = new XSSFRichTextString(textValue);
                cell.setCellValue(richString);
            }
        }
    }
}
