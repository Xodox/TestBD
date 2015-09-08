package com.xod.server.entity.jpa;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by protsenkov on 6/16/2015.
 */

@Entity
@Table(name ="URL_PAGE")
public class UrlPageEntity {

    @Id
    @GeneratedValue
    Long id;

    String url;

    @Column(name = "CREATE_DATE")
    Timestamp createDate;

    public UrlPageEntity(String url, Timestamp createDate) {
        this.url = url;
        this.createDate = createDate;
    }

    public UrlPageEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "UrlPageEntity{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
