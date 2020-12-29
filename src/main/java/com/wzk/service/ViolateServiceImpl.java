package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.ViolateDao;
import com.wzk.entity.Lend;
import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import com.wzk.entity.Violate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 21:03
 */
@Service
public class ViolateServiceImpl implements ViolateServiceIF{
    @Autowired
    ViolateDao violateDao;
    @Override
    public Result addViolate(Violate violate) {
        return null;
    }

    @Override
    public Result updateViolate(Violate violate) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        violateDao.updateViolate(violate);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        return result;
    }

    @Override
    public Result getViolateList(Violate violate,Integer pageNum,Integer pageSize) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //查询已借阅集合并放入结果集
        PageHelper.startPage(pageNum,pageSize);
        List<Violate> list = violateDao.getViolateList(violate);
        System.out.println(list);
        PageInfo page=new PageInfo(list);
        result.setData(page);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        return result;
    }
}
