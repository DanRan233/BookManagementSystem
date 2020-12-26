package com.wzk.controller;

import com.wzk.entity.Result;
import com.wzk.entity.BookType;
import com.wzk.service.BookTypeServiceIF;
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
 * @date 2020/12/26 15:40
 */
@RequestMapping("/bookType")
@RestController
@Controller
public class BookTypeController {
    @Autowired
    BookTypeServiceIF bookTypeServiceIF;

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 16:09
     * @author      DanRan233
     * @Param       [bookType]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/addBookType")
    public Result addBookType(@RequestBody BookType bookType) {
        return bookTypeServiceIF.addBookType(bookType);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 15:42
     * @author      DanRan233
     * @Param       [bookType]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getBookType")
    public Result getBookType(@RequestBody BookType bookType) {
        System.out.println(bookType);
        return bookTypeServiceIF.getBookType(bookType);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 15:42
     * @author      DanRan233
     * @Param       [btName, pageNum, pageSize]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/getBookTypeList")
    public Result getBookTypeList(@RequestParam(defaultValue = "null") String btName, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        BookType bookType = new BookType(btName);
        return bookTypeServiceIF.getBookTypeList(bookType, pageNum, pageSize);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 15:42
     * @author      DanRan233
     * @Param       [bookType]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/updateBookType")
    public Result updateBookType(@RequestBody BookType bookType) {
        return bookTypeServiceIF.updateBookType(bookType);
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/26 15:43
     * @author      DanRan233
     * @Param       [bookType]
     * @return      com.wzk.entity.Result
     */
    @RequestMapping("/delBookType")
    public Result delBookType(@RequestBody BookType bookType) {
        return bookTypeServiceIF.deleteBookType(bookType);
    }
}

