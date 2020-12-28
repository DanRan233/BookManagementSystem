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

    /**
     * description: 获取图书信息集合，判断传入bName、bNumber的值来进行动态sql的拼接以获取不同的数据
     * TODO:
     * @date         2020/12/28 8:43
     * @author      DanRan233
     * @Param       [book]
     * @return      java.util.List<com.wzk.entity.Book>
     */
    List<Book> getBookList(Book book);

    /**
     * description: 获取单个图书信息
     * TODO: 目前仅根据bID获取图书信息，但保留传值为Book以便后期改动
     * @date         2020/12/28 9:06
     * @author      DanRan233
     * @Param       [book]
     * @return      com.wzk.entity.Book
     */
    Book getBook(Book book);
}
