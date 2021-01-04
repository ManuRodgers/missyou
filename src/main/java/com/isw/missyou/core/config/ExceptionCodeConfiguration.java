package com.isw.missyou.core.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@PropertySource(
    value = "classpath:config/exception-code.yml",
    factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "manu")
@Configuration
@Data
@Slf4j
public class ExceptionCodeConfiguration {
  private Map<Integer, String> codes = new HashMap<>();

  public String getMessage(Integer code) {
    log.info("code={}", code);
    log.info("codes={}", codes);
    return codes.get(code);
  }
}
