package com.owen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication().withUser("yuwenyun").password("123").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
            // define bunches of matchers to authorize access
            .authorizeRequests()

                // public url for anyone, no need to authenticate
                .antMatchers("/resources**", "/login**").permitAll()

                // only those has role of "ROLE_ADMIN" are allowed to access "/admin"
                .antMatchers("/admin**").hasRole("ADMIN")

                // those has role of "ROLE_ADMIN" and "ROLE_DBA" are allowed to access "/db"
                .antMatchers("/db**").access("hasRole('ADMIN') and hasRole('DBA')")

                // those has role of "ROLE_DBA" or "ROLE_USER" are allowed to access "/db"
                .antMatchers("/db**").hasAnyRole("DBA", "USER")

                // other url request authentication
                .anyRequest().authenticated()
                .and()

            // use a form to login, the params of the form has to be
            // username and password
            .formLogin()
//                // provide the login page
                .loginPage("/login")
//                .defaultSuccessUrl("/index")
//                .failureUrl("/error")
//                .and()
//
//            // define logout
//            .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/index")
            ;
    }
}
