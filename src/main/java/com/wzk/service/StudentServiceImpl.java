package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.StudentDao;
import com.wzk.entity.Department;
import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import com.wzk.entity.Student;
import com.wzk.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    private SHA sha = new SHA();

    /**
     * description: 判断用户密码是否正确
     * TODO:应将用户sID存放至session中以便后期增加对用户登录判断
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/25 21:57
     * @author DanRan233
     * @Param [student]
     */
    @Override
    public Result login(Student student, HttpSession session) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        //将用户密码进行SHA加密转码
        student.setPassword(sha.encode(student.getPassword()));
        Student s = studentDao.login(student);
        System.out.println(student);
        System.out.println(s);
        if (s != null && s.getsID() != "null") {
            result.setCode(ResultEnum.LOGIN_SUCCESS.getCode());
            result.setMessage(ResultEnum.LOGIN_SUCCESS.getMessage());
            session.setAttribute("sID", s.getsID());
            result.setData(s);
        } else {
            result.setMessage(ResultEnum.LOGIN_FAILED.getMessage());
        }
        return result;
    }

    /**
     * description: 添加单个用户信息
     * TODO:时间允许可增加批量导入与创建
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/28 15:35
     * @author DanRan233
     * @Param [student]
     */
    @Override
    public Result addStuInfo(Student student) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        student.setPassword(sha.encode(student.getPassword()));
        System.out.println(student);
        int i = studentDao.addStuInfo(student);
        if (i >= 1) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result getStudent(Student student) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        Student s=studentDao.getStudent(student);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(s);
        return result;
    }

    @Override
    public Result getStudentList(Student student, Integer pageNum, Integer pageSize) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        List<Student> list = studentDao.getStudentList(student);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo page = new PageInfo(list);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(page);
        return result;
    }

    @Override
    public Result updateStudent(Student student) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());

        if (studentDao.getStudent(student) != null) {
            student.setPassword(sha.encode(student.getPassword()));
            int i = studentDao.updateStudent(student);
            if (i >= 0) {
                result.setCode(ResultEnum.SUCCESS.getCode());
                result.setMessage(ResultEnum.SUCCESS.getMessage());
            } else {
                result.setMessage(ResultEnum.ERROR.getMessage());
            }
        }else {
            if ("".equals(student.getPassword()) || student.getPassword()==null){
                result.setMessage("密码不能为空");
            }else {
                student.setPassword(sha.encode(student.getPassword()));
                studentDao.addStuInfo(student);
                result.setCode(ResultEnum.SUCCESS.getCode());
                result.setMessage(ResultEnum.SUCCESS.getMessage());
            }
        }
        return result;
    }

    @Override
    public Result delStudent(Student student) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = 0;
        try {
            i = studentDao.delStudent(student);
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
