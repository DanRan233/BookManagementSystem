package com.wzk.dao;

import com.wzk.entity.BookRack;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 13:56
 */
public interface BookRackDao {
    
    int addBookRack(BookRack bookRack);

    BookRack getBookRack(BookRack bookRack);

    List<BookRack> getBookRackList(BookRack bookRack);

    int updateBookRack(BookRack bookRack);

    int deleteBookRack(BookRack bookRack);
}
