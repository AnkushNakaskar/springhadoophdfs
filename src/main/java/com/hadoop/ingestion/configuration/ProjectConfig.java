package com.hadoop.ingestion.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ankush.nakaskar
 * @version 1.0
 * @date 07/03/21 9:10 PM
 */
@Component
@ConfigurationProperties(prefix = "project")
@Data
public class ProjectConfig {


    private Map<String, String> serviceMapping;


}