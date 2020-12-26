package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.FloorDao;
import com.wzk.entity.Floor;
import com.wzk.entity.Result;
import com.wzk.entity.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/25 23:37
 */
@Service
public class FloorServiceImpl implements FloorServiceIF {

    @Autowired
    FloorDao floorDao;

    /**
     * description:
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/26 12:16
     * @author DanRan233
     * @Param [floor]
     */
    @Override
    public Result addFloor(Floor floor) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = floorDao.addFloor(floor);
        if (i >= 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }

    /**
     * description:
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/26 12:16
     * @author DanRan233
     * @Param [floor]
     */
    @Override
    public Result getFloor(Floor floor) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        Floor f = floorDao.getFloor(floor);
        if (f != null && f.getfID() > 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
            result.setData(f);
        } else {
            result.setMessage(ResultEnum.NOT_FOUND.getMessage());
        }
        return result;
    }

    /**
     * description:
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/26 12:16
     * @author DanRan233
     * @Param [floor, pageNum, pageSize]
     */
    @Override
    public Result getFloorList(Floor floor, Integer pageNum, Integer pageSize) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        List<Floor> list = floorDao.getFloorList(floor);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo page = new PageInfo(list);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(page);
        return result;
    }

    /**
     * description:
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/26 12:16
     * @author DanRan233
     * @Param [floor]
     */
    @Override
    public Result updateFloor(Floor floor) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = floorDao.updateFloor(floor);
        if (i >= 0) {
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        } else {
            result.setMessage(ResultEnum.ERROR.getMessage());
        }
        return result;
    }

    /**
     * description:
     * TODO:
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/26 12:17
     * @author DanRan233
     * @Param [floor]
     */
    @Override
    public Result deleteFloor(Floor floor) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        int i = 0;
        try {
            i = floorDao.deleteFloor(floor);
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
