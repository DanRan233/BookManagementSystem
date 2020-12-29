package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.BookDao;
import com.wzk.dao.BookRackDao;
import com.wzk.dao.StackRoomDao;
import com.wzk.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 12:02
 */
@Service
public class StackRoomServiceImpl implements StackRoomServiceIF {

    @Autowired
    StackRoomDao stackRoomDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    BookRackDao bookRackDao;

    @Override
    public Result addStackRoom(StackRoom stackRoom) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = stackRoomDao.addStackRoom(stackRoom);
        if (i >= 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result getStackRoom(StackRoom stackRoom) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        StackRoom s = stackRoomDao.getStackRoom(stackRoom);
        if (s != null && s.getSrID() != "null") {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
            result.setData(s);
        } else {
            result.setMessage(ResultEnum.NOT_FOUND.getMessage());
        }
        return result;
    }

    @Override
    public Result getStackRoomList(StackRoom stackRoom, Integer pageNum, Integer pageSize) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        List<StackRoom> list = stackRoomDao.getStackRoomList(stackRoom);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo page = new PageInfo(list);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(page);
        System.err.println(result);
        return result;
    }

    /**
     * description: 更新状态
     * TODO:程序设计严重失误，MySQL数据触发器无法触发，先应付课程设计抽时间需要重构
     * @date         2020/12/28 19:10
     * @author      DanRan233
     * @Param       [stackRoom]
     * @return      com.wzk.entity.Result
     */
    @Override
    @Transactional
    public Result updateStackRoom(StackRoom stackRoom) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        if(stackRoomDao.getStackRoom(stackRoom)!=null) {
            int i = stackRoomDao.updateStackRoom(stackRoom);
            //获取书库下属所有书架
            List<BookRack> bookRacksList = bookRackDao.getBookRackList(new BookRack("", "", stackRoom.getSrID(), 0));
            for (BookRack br : bookRacksList) {
                //将书架状态与书库状态设置一致
                br.setBrStatus(stackRoom.getSrStatus());
                bookRackDao.updateBrStatus(br);
                //获取书架下所属书本
                List<Book> bookList = bookDao.getBookList(new Book(-1, br.getBrID()));
                for (Book b : bookList) {
                    //将书本状态与书架状态设置一致
                    b.setStatus(br.getBrStatus());
                    bookDao.updateStatus(b);
                }
            }
            if (i >= 0) {
                result.setCode(ResultEnum.SUCCESS.getCode());
                result.setMessage(ResultEnum.SUCCESS.getMessage());
            } else {
                result.setMessage(ResultEnum.ERROR.getMessage());
            }
        }else {
            stackRoomDao.addStackRoom(stackRoom);
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        }
        return result;
    }

    @Override
    public Result deleteStackRoom(StackRoom stackRoom) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = 0;
        try {
            i = stackRoomDao.deleteStackRoom(stackRoom);
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
