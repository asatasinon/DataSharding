package com.sinon.datasharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sinon.datasharding")
@MapperScan("com.sinon.datasharding.mapper")
public class DataShardingApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataShardingApplication.class, args);
    }

}
