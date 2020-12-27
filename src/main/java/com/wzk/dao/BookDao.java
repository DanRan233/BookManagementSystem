package com.wzk.dao;

import com.wzk.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/27 9:48
 */
@Mapper
public interface BookDao {
    /**
     * description: 批量添加书本信息
     * TODO:
     * @date         2020/12/27 9:56
     * @author      DanRan233
     * @Param       [book]
     * @return      int
     */
    int addBook(List<Book> list);
}
