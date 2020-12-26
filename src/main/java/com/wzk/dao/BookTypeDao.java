package com.wzk.dao;

import com.wzk.entity.BookType;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 15:29
 */
public interface BookTypeDao {
    int addBookType(BookType bookType);

    BookType getBookType(BookType bookType);

    List<BookType> getBookTypeList(BookType bookType);

    int updateBookType(BookType bookType);

    int deleteBookType(BookType bookType);
}
