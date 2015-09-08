package com.xod.server.dao;

import com.xod.server.entity.jpa.PotentialEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by protsenkov on 8/14/2015.
 */
public interface PotentialEmployeeRepository extends JpaRepository<PotentialEmployee, Long> {
}
