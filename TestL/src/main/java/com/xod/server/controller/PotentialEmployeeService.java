package com.xod.server.controller;

import com.xod.server.dao.EmployeeCommentRepository;
import com.xod.server.dao.PotentialEmployeeRepository;
import com.xod.server.entity.jpa.EmployeeCommentEntity;
import com.xod.server.entity.jpa.PotentialEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by protsenkov on 8/14/2015.
 */

@RestController
@RequestMapping("/potential")
public class PotentialEmployeeService {

    @Autowired
    PotentialEmployeeRepository employeeDao;

    @Autowired
    EmployeeCommentRepository commentDao;

    @Autowired
    JdbcTemplate jdbc;


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@RequestBody String str){
        return "good";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public PotentialEmployee create(@RequestBody PotentialEmployee pe) {

        PotentialEmployee emp = employeeDao.save(pe);

        return emp;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public PotentialEmployee update( @RequestBody PotentialEmployee pe) {
        return employeeDao.save(pe);
    }

    @RequestMapping(value = "/findById/{id}")
    public PotentialEmployee findById(@PathVariable String id) {
        PotentialEmployee result = employeeDao.findOne(new Long(id));
        jdbc.query("select * from EMPLOYEE_COMMENT",
                (rs, rowNum) -> new EmployeeCommentEntity(rs.getLong("ID"), rs.getString("COMMENT")))
                .forEach(emp -> System.out.println(emp.getEmployeeId() + "==" + emp.getComment()));

        return result;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void removePotential(@PathVariable String id) {
        employeeDao.delete(new Long(id));
    }


    @RequestMapping(value = "/add_comment", method = RequestMethod.POST)
    public EmployeeCommentEntity createComment(@RequestBody EmployeeCommentEntity comment){
        System.out.println("create comment");
        System.out.println(comment.getEmployeeId() + "==--==");

        PotentialEmployee employee = employeeDao.findOne(comment.getEmployeeId());
        if(employee == null){
            throw new RuntimeException("Employee is not found!");
        }
        return commentDao.save(comment);
    }



}
