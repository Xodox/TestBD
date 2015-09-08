package com.xod.server.dao;

import com.xod.server.entity.jpa.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by protsenkov on 6/19/2015.
 */
@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Long>{
}
