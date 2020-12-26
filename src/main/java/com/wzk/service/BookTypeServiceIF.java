package com.wzk.service;

import com.wzk.entity.BookType;
import com.wzk.entity.Result;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 15:35
 */
public interface BookTypeServiceIF {
    Result addBookType(BookType bookType);

    Result getBookType(BookType bookType);

    Result getBookTypeList(BookType bookType, Integer pageNum, Integer pageSize);

    Result updateBookType(BookType bookType);

    Result deleteBookType(BookType bookType);
}
