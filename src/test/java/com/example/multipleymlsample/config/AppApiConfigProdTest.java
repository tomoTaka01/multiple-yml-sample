package com.example.multipleymlsample.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=prod")
public class AppApiConfigProdTest {
    @Autowired
    private AppApiConfig appApiConfig;

    @Test
    public void timeoutShouleBeDefaultValue(){
        int timeout = appApiConfig.getTimeout();
        assertThat(timeout).isEqualTo(3);
    }
    @Test
    public void retryCountShoulBeProdValue(){
        int retryCount = appApiConfig.getRetryCount();
        assertThat(retryCount).isEqualTo(3);
    }

}