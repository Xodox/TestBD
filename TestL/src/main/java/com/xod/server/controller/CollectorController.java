package com.xod.server.controller;


import com.xod.server.dao.UserEntityDao;
import com.xod.server.entity.jpa.RoomEntity;
import com.xod.server.entity.jpa.UrlPageEntity;
import com.xod.server.entity.jpa.UserEntity;
import com.xod.server.service.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/collector")
public class CollectorController {


    @Autowired
    PageBean pageService;

    @Autowired
    UserEntityDao userEntityDao;

    @RequestMapping(value = "/processPage", params = {"protocol", "page"})
    public Integer processPage(@RequestParam("protocol")String protocol, @RequestParam("page")String page) throws IOException {
        return pageService.analyzePage(protocol + "://" + page);
    }



    @Transactional
    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public UserEntity createUser(@RequestBody UserEntity userEntity){
//        System.out.println(userEntity);

        UserEntity ue = new UserEntity("user name", null);
        RoomEntity room = new RoomEntity("room name", ue);
        ue.setRoom(room);
        userEntityDao.save(ue);
        return ue;
    }


}
