package cn.edu.aufe.guixiaorun.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by guixiaorun on 15-4-7.
 */
public class SafeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest ;
        HttpServletResponse res = (HttpServletResponse)servletResponse ;
        HttpSession session = req.getSession() ;
        if("key".equals(session.getAttribute("key")+"")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            res.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {
    }
}
