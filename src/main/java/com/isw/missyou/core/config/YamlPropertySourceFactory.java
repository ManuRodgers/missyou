package com.isw.missyou.core.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

// for reading yaml config
public class YamlPropertySourceFactory implements PropertySourceFactory {
  @Override
  public PropertySource<?> createPropertySource(String s, EncodedResource encodedResource)
      throws IOException {
    YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
    yamlPropertiesFactoryBean.setResources(encodedResource.getResource());
    Properties properties = yamlPropertiesFactoryBean.getObject();
    return new PropertiesPropertySource(
        Objects.requireNonNull(encodedResource.getResource().getFilename()),
        Objects.requireNonNull(properties));
  }
}
