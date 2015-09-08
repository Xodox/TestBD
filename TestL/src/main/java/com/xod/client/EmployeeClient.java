package com.xod.client;

import com.xod.server.entity.jpa.EmployeeCommentEntity;
import com.xod.server.entity.jpa.PotentialEmployee;
import org.springframework.web.client.RestTemplate;

/**
 * Created by protsenkov on 8/14/2015.
 */
public class EmployeeClient {

    public static void main(String[] args) {
        System.out.println("==start==");
        RestTemplate rt = new RestTemplate();

//        pe = rt.postForObject("http://localhost:8080/potential/create", pe, PotentialEmployee.class);
//        PotentialEmployee pe = new PotentialEmployee("name_1", "externalSystem_id");
//        PotentialEmployee pe = new PotentialEmployee("name_1111111111122222212", "externalSystem_id");
//        pe.setId(new Long("2"));

//        System.out.println(pe);
//        pe = rt.postForObject("http://localhost:8080/potential/update", pe, PotentialEmployee.class);
//        System.out.println(pe);

//        EmployeeCommentEntity ec = new EmployeeCommentEntity();
//        ec.setComment("comment1");
//        ec.setEmployeeId(Long.valueOf("2"));
//        ec = rt.postForObject("http://localhost:8080/potential/add_comment", ec, EmployeeCommentEntity.class);
//        System.out.println(ec);

        PotentialEmployee pe = new PotentialEmployee("potential name", "external_id_dummy");
        pe.addEmployeeComment(new EmployeeCommentEntity(null, "comment1"));

        pe = rt.postForObject("http://localhost:8080/potential/create", pe, PotentialEmployee.class);
        System.out.println(pe);

        PotentialEmployee employee = rt.getForObject("http://localhost:8080/potential/findById/2", PotentialEmployee.class);
        System.out.println(employee);
        System.out.println(employee.getCommentList());

//        rt.delete("http://localhost:8080/potential/delete/1");
//        PotentialEmployee pe = rt.getForObject("http://localhost:8080/potential/findById/4", PotentialEmployee.class);
//        System.out.println(pe);


    }
}
