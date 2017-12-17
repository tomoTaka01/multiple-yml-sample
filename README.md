# Spring Boot Sample
  * As of Spring Boot version 2.0.0.M7(2017-12-17)
  * multiple config files for each environment

  * config files

## app-key-{environment}.yml

|environment|  default | local | prod |
|:---|:---|:---|:---|
|key|val-default| | |
|key1|val1-default|val1-local| |
|key2|val2-default| | val2-prod|

## app-api-{environment}.yml

|environment|  default | local | prod |
|:---|:---|:---|:---|
|timeout|3| | |
|retry-count|1|5|3|

If you use the below parameter
```
--spring.profiles.active=local
```

then you can get value from config file , depends on envisonment
```
*** app-key-config:key=[val-default] key1=[val1-local] key2=[val2-default] *** app-api-config:timeout=[3] retryCount=[5]
```

If you use the prod parameter
```
--spring.profiles.active=prod
```

```
*** app-key-config:key=[val-default] key1=[val1-default] key2=[val2-prod] *** app-api-config:timeout=[3] retryCount=[3]
```

There are config files like below

```
└── resources
├── application.yml
└── config
  ├── app-api-local.yml
  ├── app-api-prod.yml
  ├── app-api.yml
  ├── app-key-local.yml
  ├── app-key-prod.yml
  └── app-key.yml
```

I use @PropertySource to each config file
  * AppKeyConfig.java
```
@Configuration
@EnableConfigurationProperties
@PropertySource({"classpath:/config/app-key.yml","classpath:/config/app-key-${spring.profiles.active}.yml"})
@ConfigurationProperties
public class AppKeyConfig {
  private String key;
  private String key1;
  private String key2;
...
```

  * AppApiConfig.java
```
@Configuration
@PropertySource({"classpath:/config/app-api.yml","classpath:/config/app-api-${spring.profiles.active}.yml"})
@ConfigurationProperties
public class AppApiConfig {
  private int timeout;
  private int retryCount;
...
```

