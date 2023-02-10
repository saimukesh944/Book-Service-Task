package com.Library.BookService.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	 
//	  auth.inMemoryAuthentication()
//	  .withUser("surendra")
//	  .password("123456")
//	  .roles("ADMIN");
//	 
//	  
//  } 
//
//	  @Bean
//	 public PasswordEncoder getPasswordEncoder() {
//		 return NoOpPasswordEncoder.getInstance();
//	 
//	  }
//	   
////	  
////	    @Override
////	    protected void configure(HttpSecurity http) throws Exception {
////	       http.authorizeRequests()
////	       .antMatchers("/books/list").permitAll()
////	       .antMatchers("/**").hasRole("ADMIN").and().formLogin();
////	    }
//	  
//	       
//  
//}
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication()
		      .withUser("Surendra")
		      .password("123456")
		      .roles("ADMIN");
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	   http.authorizeRequests()
	   .antMatchers("/books/list").permitAll()
	   .antMatchers("/**").hasRole("ADMIN").and().formLogin();
	}
	
	
	

}