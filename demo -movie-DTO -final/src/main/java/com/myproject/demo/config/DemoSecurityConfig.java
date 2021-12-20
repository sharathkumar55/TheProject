package com.myproject.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception
    {
        User.UserBuilder users= User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(users.username("admin1").password("test123").roles("ADMIN","USER"))
                .withUser(users.username("user1").password("test123").roles("USER"))
                .withUser(users.username("user2").password("test123").roles("USER"))
                .withUser(users.username("admin2").password("test123").roles("ADMIN"));


    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("ADMIN","USER")
                .antMatchers("/movies/showFormForAdd").hasRole("ADMIN")
                .antMatchers("/movies/showFormForUpdateMovie").hasRole("ADMIN")
                .antMatchers("/movies/delete").hasRole("ADMIN")
                .antMatchers("/ratings/list").hasAnyRole("USER","ADMIN")
                .antMatchers("/ratings/showFormForUpdate").hasRole("ADMIN")
                .antMatchers("/ratings/delete").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessdenied");;
    }

}
