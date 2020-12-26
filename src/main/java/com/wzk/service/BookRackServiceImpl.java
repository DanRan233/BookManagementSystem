package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.BookRackDao;
import com.wzk.entity.BookRack;
import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 14:07
 */
@Service
public class BookRackServiceImpl implements BookRackServiceIF{

    @Autowired
    BookRackDao bookRackDao;

    @Override
    public Result addBookRack(BookRack bookRack) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
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
        List<BookRack> list = bookRackDao.getBookRackList(bookRack);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo page = new PageInfo(list);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(page);
        return result;
    }

    @Override
    public Result updateBookRack(BookRack bookRack) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = bookRackDao.updateBookRack(bookRack);
        if (i >= 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result deleteBookRack(BookRack bookRack) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
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
