package com.example.demo.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/login").permitAll()
                .and()
                .authorizeRequests().antMatchers("/addNomenclature","/nomenclaturesList","/addNomenclature","/addProduct","/productList").hasAnyRole( "SELLER")
                .and()
                .authorizeRequests().antMatchers("/docOutList").hasAnyRole( "EMPL")
                .and()
                .authorizeRequests().antMatchers("/addDocOut").hasAnyRole( "ADMIN")
                .and()
                .authorizeRequests().antMatchers("/pvzList").hasAnyRole( "MANAGER")
                .and().formLogin()
                .defaultSuccessUrl("/")
                .and()
                .logout().logoutUrl("/logout");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return charSequence.toString().equals(s);
            }
        };
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN","SELLER","MANAGER","EMPL")
                .and()
                .withUser("seller").password("seller").roles("SELLER") // Продавец
                .and()
                .withUser("manager").password("manager").roles("MANAGER") // Сотрудник ПВЗ
                .and()
                .withUser("empl").password("empl").roles("EMPL"); // Сотрудник склада

    }
}

