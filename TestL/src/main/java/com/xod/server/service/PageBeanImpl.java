package com.xod.server.service;

import com.xod.server.TestLApplication;
import com.xod.server.dao.UrlPageDao;
import com.xod.server.entity.jpa.UrlPageEntity;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import sun.misc.Regexp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by protsenkov on 6/16/2015.
 */

@Component
public class PageBeanImpl implements PageBean {


    @Autowired
    UrlPageDao urlPageDao;


    @Override
    public Integer analyzePage(String pageUrl) throws IOException {
        System.out.println("analyze page=" + pageUrl);
        return analyzePage(pageUrl, 1);

    }

    public Integer analyzePage(String pageUrl, Integer counter) {

        System.out.println("root page = " + pageUrl);

        Document page = null;
        try {
            page = Jsoup.connect(pageUrl).get();
            Elements bodyElements = page.getElementsByTag("body");
            Element bodyElement = bodyElements.get(0);
            if(bodyElement != null) {
                Elements elements = bodyElement.select("a");
                for (int i = 0; i < elements.size(); i++) {
                    String hrefValue = elements.get(i).attr("href");
                    if (hrefValue.length() > 1) {
                        if(!pageUrl.equals(hrefValue) && !pageUrl.endsWith(hrefValue)){
                            System.out.println(pageUrl + "===" + hrefValue);
                            if (!isValidUrl(hrefValue)) {
                                if(hrefValue.startsWith("/")){
                                    System.out.println(StringUtils.substringBefore(pageUrl, "://") + "--");
                                    System.out.println(StringUtils.substringBetween(pageUrl, "://", "/") +"---");

                                    if(StringUtils.substringBetween(pageUrl, "://", "/") != null){
                                        hrefValue = StringUtils.substringBefore(pageUrl, "://") +"://" + StringUtils.substringBetween(pageUrl, "://", "/") + hrefValue;
                                    }
                                }
                                hrefValue = pageUrl + hrefValue;
                            }

                            System.out.println("counter = " + counter + "==" + hrefValue);
                            if (counter < 1000) {
                                counter++;
                                UrlPageEntity pageByUrl = urlPageDao.findByUrl(hrefValue);
                                if(pageByUrl == null){
                                    analyzePage(hrefValue, counter);
                                    pageByUrl = new UrlPageEntity(hrefValue, new Timestamp(System.currentTimeMillis()));
                                    urlPageDao.save(pageByUrl);
                                } else {
                                    System.out.println("page in repository=" + pageByUrl);
//                                    return counter;
                                }
                            }
                        }
                    }
                }
            }

            return counter;

        } catch (IOException e) {
            e.printStackTrace();
            return counter;
        }
    };

    private boolean isValidUrl(String url){
        return url.contains("://");
    }


    public static void main(String[] args) throws IOException {

        ApplicationContext apContext = new AnnotationConfigApplicationContext(TestLApplication.class);
        PageBean p = apContext.getBean(PageBean.class);

        p.analyzePage("http://spring.io");
    }





}
