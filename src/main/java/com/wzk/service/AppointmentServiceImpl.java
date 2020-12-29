package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.AppointmentDao;
import com.wzk.dao.BookDao;
import com.wzk.dao.ViolateDao;
import com.wzk.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 19:51
 */
@Service
public class AppointmentServiceImpl implements AppointmentServiceIF {
    @Autowired
    AppointmentDao appointmentDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    ViolateDao violateDao;

    /**
     * description: 添加预约信息
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 19:55
     * @author DanRan233
     * @Param [appointment]
     */
    @Override
    @Transactional
    public Result addAppointment(Appointment appointment) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        List<Violate> v=violateDao.getViolateList(new Violate(appointment.getsID(),0, null, 4));
        if (v.size() > 0
        )  {
            result.setMessage("存在违规记录！不可预约。");
            return result;
        } else if (bookDao.getBook(new Book(appointment.getbID(), 1)) == null) {//查看书本是否属于可预约状态
            result.setMessage("书本不可被预约");
            return result;
        }
        //获取已预约信息，如果超过三本则禁止预约
        if (appointmentDao.getAppointmentList(new Appointment(appointment.getsID(), 0, "", 2)).size() <= 2) {
            //将用户已预约的书更新为预约状态
            appointment.setAppStatus(2);
            System.err.println(appointment);
            bookDao.updateStatus1(new Book(appointment.getbID(), 2));
            //添加预约信息
            appointmentDao.addAppointment(appointment);
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage("可预约数量已达到上限！");
        }
        return result;
    }

    /**
     * description: 更新预约信息
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 19:58
     * @author DanRan233
     * @Param [appointment]
     */
    @Override
    @Transactional
    public Result updateAppointment(Appointment appointment) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //修改预约记录状态
        appointmentDao.updateAppointment(appointment);
        //同步修改图书状态
        bookDao.updateStatus(new Book(appointment.getbID(), appointment.getAppStatus()));
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        return result;
    }

    /**
     * description:
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 19:58
     * @author DanRan233
     * @Param [appointment]
     */
    @Override
    public Result getAppointment(Appointment appointment) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        result.setData(appointmentDao.getAppointment(appointment));
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        return result;
    }

    /**
     * description: 获取预约信息集合
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 20:00
     * @author DanRan233
     * @Param [appointment]
     */
    @Override
    public Result getAppointmentList(Appointment appointment, Integer pageNum, Integer pageSize) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //查询预约集合并放入结果集
        PageHelper.startPage(pageNum, pageSize);
        List<Appointment> list = appointmentDao.getAppointmentList(appointment);
        System.out.println(list);
        PageInfo page = new PageInfo(list);
        result.setData(page);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        return result;
    }
}
