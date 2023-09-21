package com.rs.retailstore.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration//chủ yếu để đánh dấu một lớp Java là một lớp cấu hình Spring
//Điều này có nghĩa rằng Spring Container (ApplicationContext) sẽ quét lớp này để tìm các phương thức và các bean cần được quản lý.
public class DataSourceConfig {
    //chua thong tin ve config
    @Bean
    public DataSource dataSource(){ //DataSource này thường được sử dụng để thiết lập kết nối đến cơ sở dữ liệu.
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:");
        dataSourceBuilder.username("");
        dataSourceBuilder.password("");

        return dataSourceBuilder.build();

    }
}
