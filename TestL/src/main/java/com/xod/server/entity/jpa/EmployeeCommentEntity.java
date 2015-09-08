package com.xod.server.entity.jpa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by protsenkov on 9/8/2015.
 */

@Entity
@Table(name = "EMPLOYEE_COMMENT")
public class EmployeeCommentEntity {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "EMPLOYEE_ID")
    Long employeeId;

    String comment;

    public EmployeeCommentEntity() {

    }

    public EmployeeCommentEntity(Long employeeId, String comment){
        this.employeeId = employeeId;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "EmployeeCommentEntity{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
