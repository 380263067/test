package com.ydgk;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "servlet", urlPatterns = "/servlet")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("name",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
          cookie.setPath("/servlet");//在什么范围有限
            cookie.setMaxAge(60); //存活周期 单位秒 强制清除值设为0（0）
        response.addCookie(cookie);//cookie 写入客户端
        //再次发送请求 得到cookie
        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();
    }
}
