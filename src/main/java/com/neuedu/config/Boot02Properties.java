package com.neuedu.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "project")
@Component
@Data
public class Boot02Properties {

    private String url;
    private String img;



}
