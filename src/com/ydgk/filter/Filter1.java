package com.ydgk.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter1",urlPatterns = "/login.jsp")
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies
             ) {
            if (cookie.getName().equalsIgnoreCase("token")){
                String token = cookie.getValue();
                String[] tokens= token.split("#");
                if (tokens[0].equalsIgnoreCase("abc")&&tokens[1].equalsIgnoreCase("123")) {
                    request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request,response);
                    return;
                }
                }
            }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
