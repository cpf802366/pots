package com.reco.cn.Filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpf on 2018/4/22.
 */
public class AuthorFilter  implements Filter {
    public static List<String> passUrlList = new ArrayList<String>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        passUrlList.add("index.jsp");
        passUrlList.add("login.jsp");
        passUrlList.add("sylist.html");
        passUrlList.add("server");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String url = request.getServletPath();



            if (url.endsWith("jsp") || url.endsWith("html")) {
                boolean isPass = false;
                isPass = true;
                if (isPass){
                    chain.doFilter(request, response);
                } else {
                }
            } else {
                chain.doFilter(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        passUrlList = null;
    }
}
