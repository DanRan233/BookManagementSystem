package com.wzk.util;

import com.wzk.dao.*;
import com.wzk.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO 无法实现，等待解决方案
 * @date 2020/12/29 21:46
 */
public class TimerTask implements ApplicationListener {

//    @Autowired
//    LendDao lendDao;
//    @Autowired
//    AppointmentDao appointmentDao;
//    @Autowired
//    ViolateDao violateDao;
//    @Autowired
//    BookDao bookDao;
//
//    @Transactional
//    public  void test1() throws Exception {
//        for (Appointment a:
//        appointmentDao.getAppointmentList(new Appointment("",0,"",2))) {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = simpleDateFormat.parse(a.getAppDate());
//            long ts = date.getTime();
//            if (ts<System.currentTimeMillis()){
//                System.out.println("违约了");
//                a.setAppStatus(1);
//                appointmentDao.updateAppointment(a);
//                bookDao.updateStatus(new Book(a.getbID(),1));
//                violateDao.addViolate(new Violate(a.getsID(),a.getbID(),null,4));
//            }
//        }
//        for (Lend l:
//        lendDao.getLendList(new Lend("",0,null,3))) {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date date = simpleDateFormat.parse(l.getlDate());
//            long ts = date.getTime();
//            if (ts<System.currentTimeMillis()){
//                System.out.println("违约了");
//                l.setlStatus(1);
//                lendDao.updateLend(l);
//                bookDao.updateStatus(new Book(l.getbID(),1));
//                violateDao.addViolate(new Violate(l.getsID(),l.getbID(),null,4));
//            }
//        }
//
//    }
//
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

    }
}
