package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.StackRoomDao;
import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import com.wzk.entity.StackRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return result;
    }

    @Override
    public Result updateStackRoom(StackRoom stackRoom) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = stackRoomDao.updateStackRoom(stackRoom);
        if (i >= 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
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
