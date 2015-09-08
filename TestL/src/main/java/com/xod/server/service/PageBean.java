package com.xod.server.service;

import java.io.IOException;

/**
 * Created by protsenkov on 6/16/2015.
 */
public interface PageBean {

    public Integer analyzePage(String pageUrl) throws IOException;


}
