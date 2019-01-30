package com.cn.zm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.cn.zm.handler.ZekeAuthenticationFailureHandler;

/**
 * 配置类
 * @author Administrator
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)//开启@PreAuthorize注解
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	  
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider()); // 添加自定义的认证逻辑
    }
    @Autowired
    private UserDetailsService customUserService; //注册UserDetailsService 的bean
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider()  throws Exception {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserService);
        authenticationProvider.setPasswordEncoder(new Md5PasswordEncoder()); //使用springSecurity提供的密码加密匹配类  BCryptPasswordEncoder()
        return authenticationProvider;
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    	super.configure(web);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/js/**","/css/**","/images/**","/layui/**").permitAll()
                    .antMatchers("/logout").permitAll()
                    .anyRequest().authenticated()   //需要登录验证
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/auth/form") //登录地址
                    //.successForwardUrl("/home") 
                    .failureHandler(new ZekeAuthenticationFailureHandler())
                    .defaultSuccessUrl("/user/list")
                    .permitAll()
                .and()
                    .exceptionHandling().accessDeniedPage("/noperi")   //没权限路径
                .and()
                .httpBasic();
        		http.csrf().disable();   //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉,不然一直不会跳到登录后台方法
    }
}
