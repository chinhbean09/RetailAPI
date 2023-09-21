package com.rs.retailstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration //de spring paste qua file class va no se define những config trong đây
                // de no biet bean cua chung ta la SecurityConfig, va no se tim trong SecurityConfig nhung cai bean nhu userDetailsService va InMemoryUserDetailsManager
public class SecurityConfig { //spring security se su dung thog tin trong bean de no co the xac thuc cho chung ta
    @Bean //cho spring biet minh dang khoi tao bean và ta sẽ bỏ dữ liệu vào đây
    public UserDetailsService userDetailsService(DataSource dataSource){
        //sử dụng User.builder() để tạo một đối tượng UserDetails.
        UserDetails user = User.builder()
                .username("chinhdo1")
                .password("{bcrypt}$2a$10$UHU/QY3Fi0Fl/nivEGMlJeq021R5Xg0qoYWJjea4Ho69c6fcH3rRC")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("thaole")
                .password("{bcrypt}$2a$10$kkzxjEKmD9exPtbBtlYInO..CBQWigRb.wlEvd2TAfYQ8Xj0zDQxK")
                .roles("USER","ADMIN")
                .build();

        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        return users;
    }

    @Bean //bean se biet duoc passwordEncoder la BCrypt
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
