package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.PressDao;
import com.wzk.entity.Press;
import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import com.wzk.entity.Press;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 14:47
 */
@Service
public class PressServiceImpl implements PressServiceIF{

    @Autowired
    PressDao pressDao;

    @Override
    public Result addPress(Press press) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = pressDao.addPress(press);
        if (i >= 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result getPress(Press press) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        Press s = pressDao.getPress(press);
        if (s != null && s.getPrID() != "null") {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
            result.setData(s);
        } else {
            result.setMessage(ResultEnum.NOT_FOUND.getMessage());
        }
        return result;
    }

    @Override
    public Result getPressList(Press press, Integer pageNum, Integer pageSize) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        List<Press> list = pressDao.getPressList(press);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo page = new PageInfo(list);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(page);
        return result;
    }

    @Override
    public Result updatePress(Press press) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = pressDao.updatePress(press);
        if (i >= 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result deletePress(Press press) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = 0;
        try {
            i = pressDao.deletePress(press);
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
