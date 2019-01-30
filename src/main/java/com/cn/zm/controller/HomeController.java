package com.cn.zm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String root(){
        return "login";
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginpage(){
        return "login";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        return "login";
    }
    
    @RequestMapping("/home")
    public String home(HttpServletRequest request, HttpServletResponse response){
        return "home";
    }
    
    /**
     * 没有权限返回
     * @param request
     * @param respose
     * @return
     * @throws IOException
     */
    @RequestMapping("/noperi")
    public String nolimit(HttpServletRequest request,HttpServletResponse respose) throws IOException {
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            respose.setContentType("text/html; utf-8");
            respose.getWriter().write("无权限操作");
            return null;
        }else{
            return "error/403";
        }
    }
}
