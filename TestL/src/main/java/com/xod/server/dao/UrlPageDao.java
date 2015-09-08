package com.xod.server.dao;

import com.xod.server.entity.jpa.UrlPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

/**
 * Created by protsenkov on 6/16/2015.
 */
@Resource
public interface UrlPageDao extends JpaRepository<UrlPageEntity, Long> {

    public UrlPageEntity findByUrl(String url);
}
