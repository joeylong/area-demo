package com.area.areademo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "mybatis")
@Component
public class MybatisConfig {

    private String mapperPath;

    private String entityPackage;

    private String mybatisConfigFilePath;

    public String getMapperPath() {
        return mapperPath;
    }

    public void setMapperPath(String mapperPath) {
        this.mapperPath = mapperPath;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getMybatisConfigFilePath() {
        return mybatisConfigFilePath;
    }

    public void setMybatisConfigFilePath(String mybatisConfigFilePath) {
        this.mybatisConfigFilePath = mybatisConfigFilePath;
    }
}
