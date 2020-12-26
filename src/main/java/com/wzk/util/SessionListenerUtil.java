package com.wzk.util;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: session过滤器
 * @date 2020/12/3 20:02
 */
public class SessionListenerUtil implements HttpSessionListener {

    /**
     * description: session创建时执行方法。
     * TODO:
     * @date         2020/12/4 18:46
     * @author      DanRan233
     * @Param       [event]
     * @return      void
     */
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("session创建");
    }

    /**
     * description: session销毁时执行方法。
     * TODO: session销毁时将用户状态更改为退出,功能未启用。
     * @date         2020/12/4 18:47
     * @author      DanRan233
     * @Param       [event]
     * @return      void
     */
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("session销毁");
        HttpSession session=event.getSession();
        System.out.println(session.getAttribute("uId"));
        if(session.getAttribute("uId")==null){

        }else {
            //userDao.updateUserStateId(new User((int) session.getAttribute("uId"), 1));
        }
    }
}
