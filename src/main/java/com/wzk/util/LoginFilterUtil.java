package com.wzk.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: 登录拦截器，保证数据安全性。 TODO
 * @date 2020/12/1 12:56
 */
public class LoginFilterUtil implements Filter {

    // 初始话放行页面，将要放行的文件放入集合中
    static List list = new ArrayList();
    static List list_s = new ArrayList();
    static List list_a = new ArrayList();

    static {
        list.add("/pages/login.html");
        list.add("/stu/login");
        list.add("/adm/login");
        list.add("/user/getCode");
        list.add("/js/easyui/jquery.min.js");
        list.add("/js/easyui/jquery.easyui.min.js");
        list.add("/js/login.js");
        list.add("/favicon.ico");

        list_s.add("/pages/bookInfo.html");
        list_s.add("/pages/index.html");
        list_s.add("/pages/lendInfo.html");
        list_s.add("/pages/appointment.html");

        list_a.add("/pages/adm_a.html");
        list_a.add("/pages/book_a.html");
        list_a.add("/pages/bookRack_a.html");
        list_a.add("/pages/floor_a.html");
        list_a.add("/pages/index_a.html");
        list_a.add("/pages/stackRoom_a.html");
        list_a.add("/pages/student_a.html");
        list_a.add("/pages/vio_a.html");


    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        //获取请求路径
        String path = req.getRequestURI();
        System.err.println(path);
        //判断是否放行页面及
        if (list.contains(path)) {
            filterChain.doFilter(req, res);
            return;
        } else {
            //从session中获取用户ID
            String uId;
            try {
                uId = (String) session.getAttribute("sID");
            } catch (NullPointerException e) {
                uId = "";
            }
            String  aId;
            try {
                aId = (String) session.getAttribute("admID");
            } catch (NullPointerException e) {
                aId = "";
            }
            // 用户ID存在时直接放行，否则返回值登录页面 filterChain.doFilter(req, res);
            if ("".equals(uId) && "".equals(aId)) {
                res.sendRedirect("/pages/login.html");
            } else {
                System.out.println(aId+""+uId);
                if (list_a.contains(path)&&uId==null){
                    filterChain.doFilter(req, res);
                }else if(list_s.contains(path)&&aId==null){
                    filterChain.doFilter(req, res);
                }else {
                    res.sendRedirect("/pages/login.html");
                }
            }
        }


    }

    @Override
    public void destroy() {

    }
}
