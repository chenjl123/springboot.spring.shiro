package com.cn.zm.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class ZekeAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	
 
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    	 response.setContentType("application/json;charset=UTF-8");
         response.getWriter().write("用户名或者密码错误");
    }
}
