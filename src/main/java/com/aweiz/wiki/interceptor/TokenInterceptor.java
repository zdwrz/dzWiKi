package com.aweiz.wiki.interceptor;

import com.aweiz.wiki.utility.TokenRepository;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by daweizhuang on 5/4/16.
 */
public class TokenInterceptor implements HandlerInterceptor {
    private static Logger LOGGER = Logger.getLogger(TokenInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(!TokenRepository.getInstance().validateToken(httpServletRequest.getParameter("token"))){
            httpServletResponse.setStatus(333);
            LOGGER.warn("////////////security interceptor//////////in-Valid Token: " + httpServletRequest.getParameter("token"));
            return false;
        }
        LOGGER.info("////////////security interceptor//////////Valid Token: " + httpServletRequest.getParameter("token"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
