package com.wzk.controller;

import com.wzk.entity.Appointment;
import com.wzk.entity.Result;
import com.wzk.service.AppointmentServiceIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 19:59
 */
@RequestMapping("/app")
@RestController
@CrossOrigin//spring4.2以上支持，解决跨域问题
public class AppointmentController {
    @Autowired
    AppointmentServiceIF appointmentServiceIF;

    /**
     * description: 添加预约信息，暂定每人最多预约两本
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 20:03
     * @author DanRan233
     * @Param [appointment]
     */
    @RequestMapping("/addAppointment")
    public Result addAppointment(@RequestBody Appointment appointment, HttpSession session) {
        appointment.setsID(session.getAttribute("sID").toString());
        appointment.setAppStatus(2);
        System.out.println(appointment.toString());
        return appointmentServiceIF.addAppointment(appointment);
    }

    /**
     * description: 更新预约信息
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 20:04
     * @author DanRan233
     * @Param [appointment]
     */
    @RequestMapping("/updateAppointment")
    public Result updateAppointment(@RequestBody Appointment appointment,HttpSession session) {
        appointment.setsID(session.getAttribute("sID").toString());
        System.out.println(appointment);
        return appointmentServiceIF.updateAppointment(appointment);
    }

    /**
     * description: 获取单个预约信息
     * TODO:　时间太近接口取消，有机会再写。
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 20:04
     * @author DanRan233
     * @Param [appointment]
     */
//    @RequestMapping("/getAppointment")
//    public Result getAppointment(@RequestBody Appointment appointment) {
//        System.out.println(appointment);
//        return appointmentServiceIF.getAppointment(appointment);
//    }

    /**
     * description:　获取预约信息集合
     * TODO: 功能仅支持学生查看
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 20:04
     * @author DanRan233
     * @Param [appointment]
     */
    @RequestMapping("/getAppointmentList")
    public Result getAppointmentList(@RequestBody Appointment appointment, HttpSession session,
                                     @RequestParam(defaultValue = "1") Integer pageNum,
                                     @RequestParam(defaultValue = "5") Integer pageSize){
        appointment.setsID(session.getAttribute("sID").toString());
        System.out.println(appointment);
        return appointmentServiceIF.getAppointmentList(appointment, pageNum, pageSize);
    }

}
