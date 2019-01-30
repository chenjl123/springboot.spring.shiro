package com.cn.zm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zm.domain.UserInfo;
import com.cn.zm.service.UserInfoService;

/**
 * 
 * @author Administrator
 *
 */
@Controller
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @PreAuthorize("hasAuthority('/user/list')")
    @RequestMapping(value="/user/list",method = RequestMethod.GET)
    public String list(ModelMap model){
        List<UserInfo> results = userInfoService.findAll();
        model.addAttribute("results",results);
        model.addAttribute("msg", "hahhaha");
        return "user/list";
    }
    //@PreAuthorize("hasAuthority('/user/list/rest')")
    @PreAuthorize("hasRole('2') AND hasRole('3')")  
    @RequestMapping(value="/user/list/rest",method = RequestMethod.GET)
    public @ResponseBody List<UserInfo> listRest(){
        List<UserInfo> results = userInfoService.findAll();
        return results;
    }
    
    @PreAuthorize("hasAuthority('/user/add')")
    @RequestMapping(value = "/user/add",method = RequestMethod.GET)
    public String add(){
        return "user/add";
    }
    
    @PreAuthorize("hasAuthority('/user/mod')")
    @RequestMapping(value = "/user/mod",method = RequestMethod.GET)
    public String mod(Integer userid,ModelMap model){
        //UserInfo user = userInfoService.findById(userid);
        //model.addAttribute("user",user);
        return "user/mod";
    }
    
    @PreAuthorize("hasAuthority('/user/del')")
    @RequestMapping(value = "/user/del",method = RequestMethod.POST)
    public @ResponseBody String del(Integer userid){
        userInfoService.delById(userid);
        return "";
    }
    
    @PreAuthorize("hasAuthority('/user/mod')")
    @RequestMapping(value = "/user/mod",method = RequestMethod.POST)
    public String formMod(UserInfo user,Integer userid){
        UserInfo dbInfo = userInfoService.findById(userid);
        dbInfo.setIsadmin(user.getIsadmin());
        dbInfo.setUsername(user.getUsername());
        dbInfo.setTelephone(user.getTelephone());
        userInfoService.updateUser(dbInfo);
        return "redirect:/user/list";
    }
}
