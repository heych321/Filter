package me.gacl.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @ClassName: NoCacheFilter
* @Description: 禁止浏览器缓存所有动态页面
* @author: 孤傲苍狼
* @date: 2014-8-31 下午11:25:40
*
*/ 
public class NoCacheFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        //把ServletRequest强转成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        //把ServletResponse强转成HttpServletResponse
        HttpServletResponse response = (HttpServletResponse) resp;
        //禁止浏览器缓存所有动态页面
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }
    
    public void destroy() {
        
    }
}