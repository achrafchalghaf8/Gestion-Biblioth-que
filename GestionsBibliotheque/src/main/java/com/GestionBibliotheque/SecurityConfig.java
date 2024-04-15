package com.GestionBibliotheque;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

@Autowired
public void globalConfig(AuthenticationManagerBuilder auth, DataSource datasource) throws Exception
{
	
auth.inMemoryAuthentication().withUser("admin").password("{noop}aaa").roles("RESP");
auth.inMemoryAuthentication().withUser("cl1").password("{noop}111").roles("ECRIAN");
}

@Autowired
protected void configure(HttpSecurity http) throws Exception
{
http
 .csrf().disable()
 .authorizeRequests()
.anyRequest().authenticated() //toutes les requêtes
	//doivent être authent
	 .and()
	 .formLogin().loginPage("/login")//page d'auth voir diap10
	 .permitAll() //autoriser l'accée à la page d’auth
	 .defaultSuccessUrl("/menu");//url qui s’affiche après l’auth
 
}}