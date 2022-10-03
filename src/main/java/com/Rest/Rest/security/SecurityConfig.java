package com.Rest.Rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService; //buscar tipo de objeto ya creado

    @Bean
    public PasswordEncoder getPasswordEncoder(){  //codificar un objeto
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests()
                .antMatchers("/usuario").hasAnyRole("ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/login*").permitAll()

        .and()

                .formLogin().loginPage("/login")
                .usernameParameter("nameUser")
                .passwordParameter("password")
                .defaultSuccessUrl("/welcome")

        .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");

    }
}
