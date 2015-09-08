package com.xod.server.entity.jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by protsenkov on 8/14/2015.
 */
@Entity
@Table(name = "POTENTIAL_EMPLOYEE")
public class PotentialEmployee {

    @Id
    @GeneratedValue
    Long id;

    String name;

    @Column(name="EXTERNAL_ID")
    String externalId;

    @OneToMany(targetEntity = EmployeeCommentEntity.class, mappedBy = "employeeId",
            fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    List<EmployeeCommentEntity> commentList;

    public List<EmployeeCommentEntity> getCommentList() {
        return commentList;
    }

    public PotentialEmployee() {
    }


    public void addEmployeeComment(EmployeeCommentEntity comment){
        if(commentList == null ) commentList = new ArrayList<>();
        commentList.add(comment);
    }
    public PotentialEmployee(String name, String externalId) {
        this.name = name;
        this.externalId = externalId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }


    @Override
    public String toString() {
        return "PotentialEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", externalId='" + externalId + '\'' +
                '}';
    }
}


