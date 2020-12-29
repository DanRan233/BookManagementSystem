package com.wzk.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzk.dao.BookDao;
import com.wzk.dao.BookRackDao;
import com.wzk.dao.FloorDao;
import com.wzk.dao.StackRoomDao;
import com.wzk.entity.*;
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
    @Autowired
    StackRoomDao stackRoomDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    BookRackDao bookRackDao;

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
     * TODO:程序设计严重失误，MySQL数据触发器无法触发，先应付课程设计抽时间需要重构
     *
     * @return com.wzk.entity.Result
     * @date 2020/12/26 12:16
     * @author DanRan233
     * @Param [floor]
     */
    @Override
    public Result updateFloor(Floor floor) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        if(floorDao.getFloor(floor)!=null) {
            int i = floorDao.updateFloor(floor);
            //获取楼层下属所有书库
            List<StackRoom> stackRoomsList = stackRoomDao.getStackRoomList(new StackRoom("", "", 0, floor.getfID()));
            for (StackRoom stackRoom : stackRoomsList) {
                //将书库状态与楼层状态设置一致
                stackRoom.setSrStatus(floor.getfStatus());
                stackRoomDao.updateSrStatus(stackRoom);
                //获取书库下属所有书架
                List<BookRack> bookRacksList = bookRackDao.getBookRackList(new BookRack("", "", stackRoom.getSrID(), 0));
                for (BookRack br : bookRacksList) {
                    //将书架状态与书库状态设置一致
                    br.setBrStatus(stackRoom.getSrStatus());
                    bookRackDao.updateBrStatus(br);
                    //获取书架下所属书本
                    List<Book> bookList = bookDao.getBookList(new Book(-1, br.getBrID()));
                    for (Book b : bookList) {
                        //将书本状态与书架状态设置一致
                        b.setStatus(br.getBrStatus());
                        bookDao.updateStatus(b);
                    }
                }
            }
            if (i >= 0) {
                result.setCode(ResultEnum.SUCCESS.getCode());
                result.setMessage(ResultEnum.SUCCESS.getMessage());
            } else {
                result.setMessage(ResultEnum.ERROR.getMessage());
            }
        }else {
            floorDao.addFloor(floor);
            result.setCode(ResultEnum.SUCCESS.getCode());
            result.setMessage(ResultEnum.SUCCESS.getMessage());
        }
        return result;
    }

    /**
     * description:
     * TODO:
     *
     * @return com.wzk.entit y.Result
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
