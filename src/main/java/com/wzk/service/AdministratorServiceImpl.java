package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.AdministratorDao;
import com.wzk.entity.*;
import com.wzk.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/26 17:14
 */
@Service
public class AdministratorServiceImpl implements AdministratorServiceIF {

    @Autowired
    AdministratorDao administratorDao;
    //  获取SHA加密工具类对象
    private SHA sha = new SHA();

    /**
     * description: 添加管理员方法
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/29 8:30
     * @author DanRan233
     * @Param [appointment]
     */
    @Override
    public Result addAdm(Administrator administrator) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //对密码进行加密处理
        administrator.setPassword(sha.encode(administrator.getPassword()));
        administratorDao.addAdm(administrator);
        //成功则会返回成功执行码 出现异常会被顶层捕获
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setCode(ResultEnum.SUCCESS.getCode());
        return result;
    }

    @Override
    public Result login(Administrator administrator, HttpSession session) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //对密码进行加密处理
        administrator.setPassword(sha.encode(administrator.getPassword()));
        Administrator a = administratorDao.login(administrator);
        //判断对象是否为空，为空则登录失败
        if (a == null || "".equals(a.getAdmID()) || a.getAdmID() == null) {
            result.setMessage(ResultEnum.LOGIN_FAILED.getMessage());
        } else {
            result.setMessage(ResultEnum.LOGIN_SUCCESS.getMessage());
            result.setCode(ResultEnum.LOGIN_SUCCESS.getCode());
            session.setAttribute("admID", a.getAdmID());
            session.setAttribute("pID", a.getpID());
            result.setData(a);
        }
        return result;
    }

    @Override
    public Result getAdmList(Administrator administrator, Integer pageNum, Integer pageSize) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //获取管理员集合并分页 无密码
        List<Administrator> list = administratorDao.getAdmList(administrator);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo page = new PageInfo(list);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(page);
        return result;
    }

    @Override
    public Result getAdm(Administrator administrator) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //获取单个管理员信息 无密码
        Administrator a = administratorDao.getAdm(administrator);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(a);
        return result;
    }

    @Override
    public Result updateAdm(Administrator administrator) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //判断管理员是否存在 不存在则添加管理员，存在则更新信息
        if (administratorDao.getAdm(administrator) != null) {
            administrator.setPassword(sha.encode(administrator.getPassword()));
            int i = administratorDao.updateAdm(administrator);
            if (i >= 0) {
                result.setCode(ResultEnum.SUCCESS.getCode());
                result.setMessage(ResultEnum.SUCCESS.getMessage());
            } else {
                result.setMessage(ResultEnum.ERROR.getMessage());
            }
        } else {
            if ("".equals(administrator.getPassword()) || administrator.getPassword() == null) {
                result.setMessage("密码不能为空");
            } else {
                administrator.setPassword(sha.encode(administrator.getPassword()));
                administratorDao.addAdm(administrator);
                result.setCode(ResultEnum.SUCCESS.getCode());
                result.setMessage(ResultEnum.SUCCESS.getMessage());
            }
        }
        return result;
    }

    @Override
    public Result delAdm(Administrator administrator) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //删除管理员 root用户不可删除
        if ("root".equals(administrator.getAdmID())) {
            result.setMessage("超级管理员不能删除");
            return result;
        }
        int i = 0;
        i = administratorDao.delAdm(administrator);
        if (i >= 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }

        return result;
    }
}
