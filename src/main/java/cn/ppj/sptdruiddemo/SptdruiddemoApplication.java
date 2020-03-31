package cn.ppj.sptdruiddemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"cn.ppj.sptdruiddemo.dao"})
public class SptdruiddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SptdruiddemoApplication.class, args);
    }

}
