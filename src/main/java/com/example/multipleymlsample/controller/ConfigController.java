package com.example.multipleymlsample.controller;

import com.example.multipleymlsample.config.AppKeyConfig;
import com.example.multipleymlsample.config.AppApiConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConfigController {
    private final AppKeyConfig appKeyConfig;
    private final AppApiConfig appApiConfig;

    public ConfigController(AppKeyConfig appKeyConfig, AppApiConfig appApiConfig) {
        this.appKeyConfig = appKeyConfig;
        this.appApiConfig = appApiConfig;
    }

    @RequestMapping("/")
    @ResponseBody
    public String getConfig(){
        String response = String.format("response *** app-key-config:key=[%s] key1=[%s] key2=[%s] *** app-api-config:timeout=[%d] retryCount=[%d]"
                ,appKeyConfig.getKey(), appKeyConfig.getKey1(), appKeyConfig.getKey2(), appApiConfig.getTimeout(), appApiConfig.getRetryCount());
        return response;

    }
}
