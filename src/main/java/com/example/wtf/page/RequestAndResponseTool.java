package com.example.wtf.page;


import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

/**
 * @Author: linjinghui
 * @Date: 2019/5/31 15:36
 * @Version 2.8.6
 */
public class RequestAndResponseTool {
    public static Page sendRequestAndGetResponse(String url) {
        Page page = null;
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        GetMethod getMethod = new GetMethod(url);
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Method failed: " + getMethod.getStatusLine());
            }
            byte[] responseBody = getMethod.getResponseBody();
            String contentType = getMethod.getResponseHeader("Content-Type").getValue();
            page = new Page(responseBody, url, contentType);
        } catch (HttpException e) {
            System.out.println("Please check your provided http address!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            getMethod.releaseConnection();
        }
        return page;

    }
}
