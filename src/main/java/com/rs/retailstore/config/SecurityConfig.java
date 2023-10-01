package com.rs.retailstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration //de spring scan qua file class va no se define những config trong đây
                // de no biet bean cua chung ta la SecurityConfig, va no se tim trong SecurityConfig nhung cai bean nhu userDetailsService va InMemoryUserDetailsManager
public class SecurityConfig { //spring security se su dung thog tin trong bean de no co the xac thuc cho chung ta
//    @Bean //cho spring biet minh dang khoi tao bean và ta sẽ bỏ dữ liệu vào đây
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        //sử dụng User.builder() để tạo một đối tượng UserDetails.
//        UserDetails user = User.builder()
//                .username("chinhdo1")
//                .password("$2a$10$kS74XMw16EANac6FOVM9GO5ULBANj3fRUVbYEYxskcEeObPj31mW2")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("thaole")
//                .password("$2a$10$kS74XMw16EANac6FOVM9GO5ULBANj3fRUVbYEYxskcEeObPj31mW2")
//                .roles("USER","ADMIN")
//                .build();
//
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        users.createUser(admin);
//        return users;
//    }

    @Bean //bean se biet duoc passwordEncoder la BCrypt
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/v1/register").permitAll()
                .antMatchers("/v1/greeting").authenticated()
                .and().formLogin()
                .and().httpBasic();
        return httpSecurity.build();
    }
}
