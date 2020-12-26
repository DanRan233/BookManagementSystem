package com.wzk.service;

import com.wzk.dao.StudentDao;
import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import com.wzk.entity.Student;
import com.wzk.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 20:18
 */
@Service
public class StudentServiceImpl implements StudentServiceIF {

    @Autowired
    StudentDao studentDao;

    //  获取SHA加密工具类对象
    private SHA sha=new SHA();
    /**
     * description: 判断用户密码是否正确
     * TODO:应将用户sID存放至session中以便后期增加对用户登录判断
     * @date         2020/12/25 21:57
     * @author      DanRan233
     * @Param       [student]
     * @return      com.wzk.entity.Result
     */
    @Override
    public Result login(Student student) {
        Result result=new Result(ResultEnum.UNEXECUTED.getCode(),ResultEnum.UNEXECUTED.getMessage());
        //将用户密码进行SHA加密转码
        student.setPassword(sha.encode(student.getPassword()));
        Student s=studentDao.login(student);
        System.out.println(student);
        System.out.println(s);
        if(s!=null&&s.getsID()!="null"){
            result.setCode(ResultEnum.LOGIN_SUCCESS.getCode());
            result.setMessage(ResultEnum.LOGIN_SUCCESS.getMessage());
        }else {
            result.setMessage(ResultEnum.LOGIN_FAILED.getMessage());
        }
        return result;
    }

    @Override
    public Result addStuInfo(Student student) {
        Result result=new Result(ResultEnum.UNEXECUTED.getCode(),ResultEnum.UNEXECUTED.getMessage());
        student.setPassword(sha.encode(student.getPassword()));
        System.out.println(student);
        int i=studentDao.addStuInfo(student);
        if(i>=1){
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        }else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }
}
