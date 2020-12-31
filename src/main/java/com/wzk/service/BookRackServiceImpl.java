package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.BookDao;
import com.wzk.dao.BookRackDao;
import com.wzk.entity.Book;
import com.wzk.entity.BookRack;
import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 14:07
 */
@Service
public class BookRackServiceImpl implements BookRackServiceIF {

    @Autowired
    BookRackDao bookRackDao;
    @Autowired
    BookDao bookDao;

    @Override
    public Result addBookRack(BookRack bookRack) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //添加用户
        int i = bookRackDao.addBookRack(bookRack);
        if (i >= 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result getBookRack(BookRack bookRack) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //查询用户，用户不存在则返回不存在报文
        BookRack s = bookRackDao.getBookRack(bookRack);
        if (s != null && s.getBrID() != "null") {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
            result.setData(s);
        } else {
            result.setMessage(ResultEnum.NOT_FOUND.getMessage());
        }
        return result;
    }

    @Override
    public Result getBookRackList(BookRack bookRack, Integer pageNum, Integer pageSize) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //获取书架集合信息并显示
        List<BookRack> list = bookRackDao.getBookRackList(bookRack);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo page = new PageInfo(list);
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
     * @date 2020/12/28 17:19
     * @author DanRan233
     * @Param [bookRack]
     */
    @Override
    @Transactional
    public Result updateBookRack(BookRack bookRack) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //判断书架是否存在，存在则更新信息不存在则添加
        if (bookRackDao.getBookRack(bookRack) != null) {
            System.out.println(bookRack);
            int i = bookRackDao.updateBookRack(bookRack);
            int j = bookDao.updateStatus(new Book(bookRack.getBrStatus(), bookRack.getBrID()));
            if (i > 0 && j >= 0) {
                result.setCode(ResultEnum.SUCCESS.getCode());
                result.setMessage(ResultEnum.SUCCESS.getMessage());
            } else {
                result.setMessage(ResultEnum.ERROR.getMessage());
            }
            return result;
        } else {
            bookRackDao.addBookRack(bookRack);
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        }
        return result;
    }

    @Override
    public Result deleteBookRack(BookRack bookRack) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //删除书架信息 如果书架被引用会出现异常返回被引用报文
        int i = 0;
        try {
            i = bookRackDao.deleteBookRack(bookRack);
            if (i >= 0) {
                result.setCode(ResultEnum.SUCCESS.getCode());
                result.setMessage(ResultEnum.SUCCESS.getMessage());
            } else {
                result.setMessage(ResultEnum.ERROR.getMessage());
            }
        } catch (Exception e) {
            result.setMessage(ResultEnum.CASCADE_ERROR.getMessage());
        }
        return result;
    }
}
