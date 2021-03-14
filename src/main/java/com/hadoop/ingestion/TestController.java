package com.hadoop.ingestion;

import com.hadoop.ingestion.configuration.ProjectConfig;
import com.hadoop.ingestion.hdfs.HdfsFileAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author ankush.nakaskar
 * @version 1.0
 * @date 07/03/21 8:46 PM
 */
@RestController
public class TestController {

    @Autowired
    private ProjectConfig projectConfig;

    @Autowired
    org.apache.hadoop.conf.Configuration hadoopConfiguration;



    @Autowired
    private HdfsFileAccess fileAccess;


    @Autowired
    ConfigurableApplicationContext ctx;


    @GetMapping("/test")
    public ResponseEntity<String> getStatus() throws IOException {
        fileAccess.writeFile("application.properties");
        return new ResponseEntity<>("Success..!!!"+projectConfig.getServiceMapping(), HttpStatus.OK);
    }
}
