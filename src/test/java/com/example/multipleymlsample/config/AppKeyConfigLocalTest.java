package com.example.multipleymlsample.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=local")
public class AppKeyConfigLocalTest {
    @Autowired
    private AppKeyConfig appKeyConfig;

    @Test
    public void keyShouldBeDefaultValue(){
        String key = appKeyConfig.getKey();
        assertThat(key).isEqualTo("val-default");
    }
    @Test
    public void key1ShouleBeLocalValue(){
        String key1 = appKeyConfig.getKey1();
        assertThat(key1).isEqualTo("val1-local");
    }

    @Test
    public void key2ShouldBeDefaultValue(){
        String key2 = appKeyConfig.getKey2();
        assertThat(key2).isEqualTo("val2-default");
    }

}