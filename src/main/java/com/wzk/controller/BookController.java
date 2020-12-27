package com.wzk.controller;

import com.wzk.entity.Book;
import com.wzk.entity.Result;
import com.wzk.service.BookServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@Controller
public class BookController {

    @Autowired
    BookServiceIF bookServiceIF;

    @RequestMapping("/addBook")
    public Result addBook(@RequestBody Book book,@RequestParam Integer number){
        System.out.println(book);
        System.out.println(number);
        List<Book> list=new ArrayList<Book>();
        for (int i=0;i<number;i++){
            list.add(book);
        }
        System.out.println(list);
        return bookServiceIF.addBook(list);
    }
}
