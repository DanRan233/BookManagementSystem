package com.wzk.controller;

import com.wzk.entity.Result;
import com.wzk.entity.BookRack;
import com.wzk.service.BookRackServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 12:31
 */
@RequestMapping("/bookRack")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class BookRackController {
    @Autowired
    BookRackServiceIF bookRackServiceIF;

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 14:16
     * @author      DanRan233
     * @Param       [bookRack]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addBookRack")
    public Result addBookRack(@RequestBody BookRack bookRack) {
        return bookRackServiceIF.addBookRack(bookRack);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 14:16
     * @author      DanRan233
     * @Param       [bookRack]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getBookRack")
    public Result getBookRack(@RequestBody BookRack bookRack) {
        System.out.println(bookRack);
        return bookRackServiceIF.getBookRack(bookRack);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 14:16
     * @author      DanRan233
     * @Param       [brName, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getBookRackList")
    public Result getBookRackList(@RequestParam(defaultValue = "null") String brName, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        BookRack bookRack = new BookRack(brName);
        return bookRackServiceIF.getBookRackList(bookRack, pageNum, pageSize);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 14:16
     * @author      DanRan233
     * @Param       [bookRack]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/updateBookRack")
    public Result updateBookRack(@RequestBody BookRack bookRack) {
        return bookRackServiceIF.updateBookRack(bookRack);
    }
    
    /**
     * description: 
     * TODO:
     * @date         2020/12/26 14:29
     * @author      DanRan233
     * @Param       [bookRack]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/delBookRack")
    public Result delBookRack(@RequestBody BookRack bookRack) {
        return bookRackServiceIF.deleteBookRack(bookRack);
    }
}
