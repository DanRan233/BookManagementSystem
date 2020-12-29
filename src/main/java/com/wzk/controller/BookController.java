package com.wzk.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.entity.Book;
import com.wzk.entity.Result;
import com.wzk.service.BookServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/27 9:46
 */
@RequestMapping("/book")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class BookController {

    @Autowired
    BookServiceIF bookServiceIF;

    /**
     * description: 添加图书，前端传入新建的书籍信息及书本数量数据库会自动生成书本编号并插入传入数量的书本
     * TODO:应当不允许创建书籍编号存在但书本名与存在信息不一致的数据
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 8:29
     * @author DanRan233
     * @Param [book, number]
     */
    @RequestMapping("/addBook")
    public Result addBook(@RequestBody Book book, @RequestParam Integer number) {
        System.out.println(book);
        System.out.println(number);
        List<Book> list = new ArrayList<Book>();
        for (int i = 0; i < number; i++) {
            list.add(book);
        }
        System.out.println(list);
        return bookServiceIF.addBook(list);
    }

    /**
     * description: 获取单个图书信息
     * TODO:目前根据仅根据bID来获取单个图书信息
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 9:11
     * @author DanRan233
     * @Param [book]
     */
    @RequestMapping("/getBook")
    public Result getBook(@RequestBody Book book) {
        System.out.println(book);
        return bookServiceIF.getBook(book);
    }

    /**
     * description: 接收前端传值并对条件模糊查询模糊查询,status值为-1时查询所有状态下的图书，不为-1时则查询状态为其他的值
     * TODO:目前仅支持书名和书籍编号的模糊查询
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 8:48
     * @author DanRan233
     * @Param [book]
     */
    @RequestMapping("/getBookList")
    public Result getBookList(@RequestBody Book book,
                              @RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "5") Integer pageSize) {
        System.out.println(book);
        return bookServiceIF.getBookList(book, pageNum, pageSize);
    }


    /**
     * description: 根据bID或bNumber来对图书信息进行修改
     * TODO:未对传参做非空判断，更新数据时不应允许有属性为空
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 11:35
     * @author DanRan233
     * @Param [book]
     */
    @RequestMapping("/updateBook")
    public Result updateBook(@RequestBody Book book) {
        System.out.println(book);
        return bookServiceIF.updateBook(book);
    }

    /**
     * description: 根据bID或bName来对图书进行删除
     * TODO: 应在service层或controller层对以上两个属性进行一个非空判断与互斥处理
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 13:55
     * @author DanRan233
     * @Param [book]
     */
    @RequestMapping("/delBook")
    public Result delBook(@RequestBody Book book) {
        System.out.println(book);
        return bookServiceIF.delBook(book);
    }

}
