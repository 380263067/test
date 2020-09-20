package com.ydgk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ydgk.user.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet4")
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        String id = request.getParameter("id");
        System.out.println("id = " + id);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("来自服务器的数据"+id);*/
        //有个得到对象的方法
        Person person = new Person();
        person.setName("刘德华");
        person.setAge(12);
        ObjectMapper object = new ObjectMapper();
       //转化为json字符串
        String jsonStr= object.writeValueAsString(person);
        response.setContentType("text/html:charset=UTF-8");
          response.getWriter().print(jsonStr);
    }
}
