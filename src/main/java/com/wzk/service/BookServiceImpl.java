package com.wzk.service;

import com.wzk.dao.BookDao;
import com.wzk.entity.Book;
import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/27 9:49
 */
@Service
public class BookServiceImpl implements BookServiceIF{

    @Autowired
    BookDao bookDao;

    @Override
    public Result addBook(List<Book> list) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i=bookDao.addBook(list);
        if(i>0){
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        }else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }
}
