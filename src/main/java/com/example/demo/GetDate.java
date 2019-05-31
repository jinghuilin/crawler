package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: linjinghui
 * @Date: 2019/5/27 10:17
 * @Version 2.8.6
 */
public class GetDate {
    public static void main(String[] args) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            Date date = formatter.parse("2099-01-01 23:59:59");
            Long longDate = date.getTime();
            System.out.print(longDate);
            Date d = new Date(4070966399000L);
        } catch (ParseException e) {

        }
    }
}
