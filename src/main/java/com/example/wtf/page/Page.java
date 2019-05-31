package com.example.wtf.page;

import com.example.wtf.util.CharsetDetector;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.UnsupportedEncodingException;

/**
 * @Author: linjinghui
 * @Date: 2019/5/31 15:35
 * @Version 2.8.6
 */
public class Page {
    private byte[] content;
    private String html;
    private Document doc;
    private String charset;
    private String url;
    private String contentType;

    public Page(byte[] content, String url, String contentType) {
        this.content = content;
        this.url = url;
        this.contentType = contentType;

    }

    public String getHtml() {
        if (html != null) {
            return html;
        }
        if (content == null) {
            return null;
        }
        if (charset == null) {
            charset = CharsetDetector.guessEncoding(content);
        }
        try {
            this.html = new String(content, charset);
            return html;
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Document getDoc() {
        if (doc != null) {
            return doc;
        }
        try {
            this.doc = Jsoup.parse(getHtml(), url);
            return doc;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public byte[] getContent() {
        return content;
    }

    public String getCharset() {
        return charset;
    }

    public String getUrl() {
        return url;
    }

    public String getContentType() {
        return contentType;
    }
}
