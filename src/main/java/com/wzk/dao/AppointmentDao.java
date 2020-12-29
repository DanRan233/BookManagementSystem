package com.wzk.dao;

import com.wzk.entity.Appointment;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 15:27
 */
public interface AppointmentDao {
    int addAppointment(Appointment appointment);

    int updateAppointment(Appointment appointment);

    Appointment getAppointment(Appointment appointment);

    List<Appointment> getAppointmentList(Appointment appointment);
}
