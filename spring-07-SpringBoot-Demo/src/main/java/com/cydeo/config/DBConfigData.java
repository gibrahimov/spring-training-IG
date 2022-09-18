package com.cydeo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Data
@ConfigurationProperties(prefix = "db")
public class DBConfigData {

    private String username;
    private String password;
    private List<String> type; // type is more than 1 so we used List


}
