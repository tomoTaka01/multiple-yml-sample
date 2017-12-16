package com.example.multipleymlsample.config;

//@Configuration

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties
@PropertySource({"classpath:/config/app-key.yml","classpath:/config/app-key-${spring.profiles.active}.yml"})
@ConfigurationProperties
public class AppKeyConfig {
    private String key;
    private String key1;
    private String key2;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }
}
