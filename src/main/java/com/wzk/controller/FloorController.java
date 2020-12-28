package com.wzk.controller;

import com.wzk.entity.Floor;
import com.wzk.entity.Result;
import com.wzk.service.FloorServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 23:39
 */
@RequestMapping("/floor")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class FloorController {

    @Autowired
    FloorServiceIF floorServiceIF;

    /**
     * description: 添加楼层信息
     * TODO:
     * @date         2020/12/26 10:19
     * @author      DanRan233
     * @Param       [floor]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addFloor")
    public Result addFloor(@RequestBody Floor floor){
        return floorServiceIF.addFloor(floor);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 10:43
     * @author      DanRan233
     * @Param       [floor]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getFloor")
    public Result getFloor(@RequestBody Floor floor){
        System.out.println(floor);
        return floorServiceIF.getFloor(floor);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 11:11
     * @author      DanRan233
     * @Param       [fName, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getFloorList")
    public Result getFloorList(@RequestParam(defaultValue = "null") String fName,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
        Floor floor=new Floor(fName);
        return floorServiceIF.getFloorList(floor,pageNum,pageSize);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 10:44
     * @author      DanRan233
     * @Param       [floor]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/updateFloor")
    public Result updateFloor(@RequestBody Floor floor){
        return floorServiceIF.updateFloor(floor);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 11:01
     * @author      DanRan233
     * @Param       [floor]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/delFloor")
    public Result delFloor(@RequestBody  Floor floor){
        return floorServiceIF.deleteFloor(floor);
    }
}
