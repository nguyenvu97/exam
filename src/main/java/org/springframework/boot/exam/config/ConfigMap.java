package org.springframework.boot.exam.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
public class ConfigMap {

    @Value("${appConfig.default-page-size}")

    public  int pageSize;
    @Value("${appConfig.default-page-number}")
    public   int pageNumber;
}
