package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.BookDao;
import com.wzk.entity.Book;
import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/27 9:49
 */
@Service
public class BookServiceImpl implements BookServiceIF {

    @Autowired
    BookDao bookDao;

    /**
     * description:
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 9:09
     * @author DanRan233
     * @Param [list]
     */
    @Override
    public Result addBook(List<Book> list) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //添加图书信息
        int i = bookDao.addBook(list);
        if (i > 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }

    /**
     * description:
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 8:53
     * @author DanRan233
     * @Param [book]
     */
    @Override
    public Result getBookList(Book book,Integer pageNum,Integer pageSize) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //获取图书信息并分页
        PageHelper.startPage(pageNum,pageSize);
        List<Book> list = bookDao.getBookList(book);
        System.out.println(list);
        PageInfo page=new PageInfo(list);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(page);
        return result;
    }

    /**
     * description:
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 9:08
     * @author DanRan233
     * @Param [book]
     */
    @Override
    public Result getBook(Book book) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //获取单个图书信息
        Book b = bookDao.getBook(book);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(b);
        return result;
    }

    /**
     * description:
     * TODO:
     * @date         2020/12/28 11:31
     * @author      DanRan233
     * @Param       [book]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result updateBook(Book book) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //图书信息存在则更新，不存在则添加
        if(book.getbID()!=0) {

            int i = bookDao.updateBook(book);
            if (i > 0) {
                result.setCode(ResultEnum.SUCCESS.getCode());
                result.setMessage(ResultEnum.SUCCESS.getMessage());
            } else {
                result.setMessage(ResultEnum.UNEXECUTED.getMessage());
            }
        }else {
            List<Book> l =new ArrayList<>();
            l.add(book);
            bookDao.addBook(l);
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        }
        return result;
    }

    /**
     * description: 
     * TODO:
     * @date         2020/12/28 13:52
     * @author      DanRan233
     * @Param       [book]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result delBook(Book book) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        System.err.println(book);
        //删除书本信息
        int i = bookDao.delBook(book);
        if(i>0){
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        }else{
            result.setMessage(ResultEnum.UNEXECUTED.getMessage());
        }
        return result;
    }
}
