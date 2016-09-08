package com.yiheidaodi.gims.filter;

import com.yiheidaodi.gims.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * gims ${PACKAGE_NAME}
 * 描述：
 * 作者：王豫宁
 * 时间：2016-9-8 10:51.
 */

public class VerifyFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        User user = (User)request.getSession().getAttribute("user");
        String url = request.getServletPath();
        if( !url.startsWith("/login.html") && user == null) {
            response.sendRedirect("/login.html");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
