package com.wzk.service;

import com.wzk.entity.Appointment;
import com.wzk.entity.Result;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 19:51
 */
public interface AppointmentServiceIF {
    Result addAppointment(Appointment appointment);

    Result updateAppointment(Appointment appointment);

    Result getAppointment(Appointment appointment);

    Result getAppointmentList(Appointment appointment,Integer pageNum,Integer pageSize);
}
