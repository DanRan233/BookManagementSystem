package com.wzk.service;

import com.wzk.dao.*;
import com.wzk.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author DanRan233
 * @projectName BookManagementSystem
 * @description: TODO
 * @date 2020/12/28 21:03
 */
@Service
public class ReturnServiceImpl  implements ReturnServiceIF{
    @Autowired
    ReturnDao returnDao;
    @Autowired
    LendDao lendDao;
    @Autowired
    BookDao bookDao;
    @Autowired
    ViolateDao violateDao;

    @Override
    @Transactional
    public Result addReturn(Return r) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        Lend l=lendDao.getLend(new Lend(r.getsID(),r.getbID(),"",3));
        if(l==null){
            result.setMessage("该图书并未借出");
            return result;
        }else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = simpleDateFormat.parse(l.getlDate());
                long ts = date.getTime();
                if(ts<System.currentTimeMillis()){
                    violateDao.addViolate(new Violate(l.getsID(),l.getbID(),null,4));
                    bookDao.updateStatus(new Book(r.getbID(),1));
                    lendDao.updateLend(new Lend(r.getsID(),r.getbID(),"",1));
                    r.setrStatus(1);
                    returnDao.addReturn(r);
                    result.setCode(ResultEnum.SUCCESS.getCode());
                    result.setMessage("逾期还书，您已存在违约行为");
                }else {
                    bookDao.updateStatus(new Book(r.getbID(),1));
                    lendDao.updateLend(new Lend(r.getsID(),r.getbID(),"",1));
                    r.setrStatus(1);
                    returnDao.addReturn(r);
                    result.setCode(ResultEnum.SUCCESS.getCode());
                    result.setMessage(ResultEnum.SUCCESS.getMessage());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    @Override
    public Result updateReturn(Return r) {
        return null;
    }

    @Override
    public Result getReturnList(Return r) {
        Result result = new Result(ResultEnum.UNEXECUTED.getCode(), ResultEnum.UNEXECUTED.getMessage());
        return result;
    }
}
