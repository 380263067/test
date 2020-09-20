package com.ydgk;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Servlet3",urlPatterns = "/servlet3")
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pas = request.getParameter("pas");
        if (username.equalsIgnoreCase("abc")&&pas.equalsIgnoreCase("123")){
/*            Cookie cookie = new Cookie("token",username+"#"+pas);
            cookie.setPath("/");
            cookie.setMaxAge(60*30);
            response.addCookie(cookie);*/
            HttpSession session = request.getSession();
               session.setAttribute("name",username);
            //通过
            request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request,response);
        }else {
            response.sendRedirect("login.jsp");
        }

    }
    }
