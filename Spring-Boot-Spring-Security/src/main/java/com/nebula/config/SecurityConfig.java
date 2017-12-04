package com.nebula.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security 配置类
 *
 * @author Nebula Unlimited
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /**
                 * 配置安全策略
                 */
                .authorizeRequests()
                .antMatchers("/guest").permitAll()
                /**
                 * 其余的所有请求都需要验证
                 */
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    /**
                     * 不指定登录页面默认使用 Spring Security 自带的登录页面
                     */
                    //.loginPage("/login")
                    .failureUrl("/login?error")
                    .defaultSuccessUrl("/index")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout").permitAll()
                    .logoutSuccessUrl("/guest?logout");
        http
                /**
                 * 关闭 CSRF 否则 logout 必须是 POST 方式请求
                 */
                .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("MANAGE");
    }
}
