package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.AppointmentDao;
import com.wzk.dao.BookDao;
import com.wzk.dao.LendDao;
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
 * @date 2020/12/28 21:02
 */
@Service
public class LendServiceImpl implements LendServiceIF {
    @Autowired
    LendDao lendDao;
    @Autowired
    AppointmentDao appointmentDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    ViolateDao violateDao;

    @Override
    @Transactional
    public Result addLend(Lend lend) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        List<Violate> v = violateDao.getViolateList(new Violate(lend.getsID(), 0, null, 4));
        System.out.println(lend);
        System.out.println(v);
        if (v.size() > 0
        ) {
            result.setMessage("存在违规记录！不可借阅。");
            return result;
        } else if (appointmentDao.getAppointment(new Appointment(lend.getsID(), lend.getbID(), "", 2)) == null &&
                bookDao.getBook(new Book(lend.getbID(), 1)) == null
        ) {
            result.setMessage("不可借阅该书");
            return  result;
        }
            bookDao.updateStatus1(new Book(lend.getbID(), 3));
        appointmentDao.updateAppointment(new Appointment(lend.getsID(), lend.getbID(), "", 3));
        lend.setlStatus(3);
        lendDao.addLend(lend);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        return result;
    }

    @Override
    public Result updateLend(Lend lend) {
        return null;
    }

    @Override
    public Result getLendList(Lend lend, Integer pageNum, Integer pageSize) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //查询已借阅集合并放入结果集
        PageHelper.startPage(pageNum, pageSize);
        List<Lend> list = lendDao.getLendList(lend);
        System.out.println(list);
        PageInfo page = new PageInfo(list);
        result.setData(page);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        return result;
    }
}
