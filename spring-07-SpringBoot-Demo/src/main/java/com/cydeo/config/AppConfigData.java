package com.cydeo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration// instead of @Component
public class AppConfigData {

    // if you see ${} it means you are binging this data from somewhere. Although I am not referencing
    //anywhere Spring knows to look for inside application.properties file
    @Value("${username}")
    private String userName;
    @Value("${password}")
    private String password;
    @Value("${url}")
    private String url;



}
