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
    
    /**
     * description: 根据书架编号更新书本状态
     * TODO:
     * @date         2020/12/28 16:57
     * @author      DanRan233
     * @Param       [book]
     * @return      int
     */
    int updateStatus(Book book);

    int updateStatus1(Book book);
    /**
     * description: 根据bID或bNumber来对图书信息进行更新操作，bID是根据书本编号更新单个、bNumber是根据书籍编号更新多个
     * TODO:
     * @date         2020/12/28 11:24
     * @author      DanRan233
     * @Param       [book]
     * @return      int
     */
    int updateBook(Book book);

    /**
     * description: 根据bID或bNumber对图书进行删除操作，绝不允许两个属性都不存在的情况执行删除操作！
     * TODO: service层应对传入的bID和bNumber进行处理，二者只允许存在一个
     * @date         2020/12/28 13:48
     * @author      DanRan233
     * @Param       [book]
     * @return      int
     */
    int delBook(Book book);
}
