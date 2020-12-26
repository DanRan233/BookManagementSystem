package com.wzk.controller;

import com.wzk.entity.StackRoom;
import com.wzk.entity.Result;
import com.wzk.service.StackRoomServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 12:31
 */
@RequestMapping("/stackRoom")
@RestController
@Controller
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
    public Result getStackRoomList(@RequestParam(defaultValue = "null") String srName, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        StackRoom stackRoom = new StackRoom(srName);
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
