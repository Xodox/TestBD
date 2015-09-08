package com.xod.server.dao;

import com.xod.server.entity.jpa.EmployeeCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by protsenkov on 9/8/2015.
 */
public interface EmployeeCommentRepository extends JpaRepository<EmployeeCommentEntity, Long> {

}
