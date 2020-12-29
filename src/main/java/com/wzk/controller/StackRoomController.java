package com.wzk.controller;

import com.wzk.entity.StackRoom;
import com.wzk.entity.Result;
import com.wzk.service.StackRoomServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 12:31
 */
@RequestMapping("/stackRoom")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class StackRoomController {
    @Autowired
    StackRoomServiceIF stackRoomServiceIF;

    @RequestMapping("/addStackRoom")
    public Result addStackRoom(@RequestBody StackRoom stackRoom) {
        return stackRoomServiceIF.addStackRoom(stackRoom);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 12:36
     * @author      DanRan233
     * @Param       [stackRoom]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getStackRoom")
    public Result getStackRoom(@RequestBody StackRoom stackRoom) {
        System.out.println(stackRoom);
        return stackRoomServiceIF.getStackRoom(stackRoom);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 12:37
     * @author      DanRan233
     * @Param       [srName, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getStackRoomList")
    public Result getStackRoomList(@RequestBody StackRoom stackRoom, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "100") Integer pageSize) {
        System.out.println(stackRoom);
        return stackRoomServiceIF.getStackRoomList(stackRoom, pageNum, pageSize);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 12:37
     * @author      DanRan233
     * @Param       [stackRoom]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/updateStackRoom")
    public Result updateStackRoom(@RequestBody StackRoom stackRoom) {
        return stackRoomServiceIF.updateStackRoom(stackRoom);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 12:37
     * @author      DanRan233
     * @Param       [stackRoom]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/delStackRoom")
    public Result delStackRoom(@RequestBody StackRoom stackRoom) {
        return stackRoomServiceIF.deleteStackRoom(stackRoom);
    }
}
