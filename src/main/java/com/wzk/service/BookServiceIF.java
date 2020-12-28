package com.wzk.service;

import com.wzk.entity.Book;
import com.wzk.entity.Result;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/27 9:49
 */
public interface BookServiceIF {
    Result addBook(List<Book> list);

    Result getBookList(Book book);

    Result getBook(Book book);

    Result updateBook(Book book);

    Result delBook(Book book);
}
