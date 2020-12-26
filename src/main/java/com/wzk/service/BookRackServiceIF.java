package com.wzk.service;

import com.wzk.entity.Result;
import com.wzk.entity.BookRack;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 14:07
 */
public interface BookRackServiceIF {
    Result addBookRack(BookRack bookRack);

    Result getBookRack(BookRack bookRack);

    Result getBookRackList(BookRack bookRack, Integer pageNum, Integer pageSize);

    Result updateBookRack(BookRack bookRack);

    Result deleteBookRack(BookRack bookRack);
}
