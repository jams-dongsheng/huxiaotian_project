package com.huxiaotian.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.huxiaotian.pojo.HxtUser;
import com.huxiaotian.pojo.entity.Result;
import com.huxiaotian.pojo.group.Room;
import com.huxiaotian.service.RoomService;
import com.huxiaotian.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @Reference
    private RoomService roomService;


    @RequestMapping("findByNameOrId")
    public Room findByNameOrId(String search){
        return userService.findByNameOrId(search);
    }

    @RequestMapping("/add")
    public Result add(HxtUser user){
        try {
            userService.add(user);
            roomService.updateStatusByIn(user.getUserRoomId());
            return new Result(true,"入住成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"入住失败");
        }
    }
}
