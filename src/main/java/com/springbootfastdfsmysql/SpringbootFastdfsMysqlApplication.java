package com.springbootfastdfsmysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.springbootfastdfsmysql.mysql.Dao")
public class SpringbootFastdfsMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFastdfsMysqlApplication.class, args);
    }

}
