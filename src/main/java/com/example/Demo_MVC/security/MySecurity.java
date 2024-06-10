package com.example.Demo_MVC.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MySecurity {

    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select id, pw, active from accounts where id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select id, role from role where id=?");
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers("/students/list").permitAll()
                        .requestMatchers("/students/create").hasAnyRole("ADMIN", "TEACHER")
                        .requestMatchers("/students/update").hasAnyRole("ADMIN", "TEACHER")
                        .requestMatchers("/students/delete").hasRole("ADMIN")
                        .requestMatchers("/search").hasAnyRole("ADMIN","TEACHER","STUDENT")
                        .requestMatchers("/courses/list").permitAll()
                        .requestMatchers("/courses/create").hasAnyRole("ADMIN", "TEACHER")
                        .requestMatchers("/courses/update").hasAnyRole("ADMIN", "TEACHER")
                        .requestMatchers("/courses/delete").hasRole("ADMIN")
                        .anyRequest().permitAll()
        ).formLogin(
                form->form.loginPage("/loginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
        ).logout(
                logout->logout.permitAll()
        ).exceptionHandling(
                configurer->configurer.accessDeniedPage("/page403")
        );
        return http.build();
    }
}
