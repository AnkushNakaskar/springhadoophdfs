package com.hadoop.ingestion;

import com.hadoop.ingestion.configuration.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/test")
    public ResponseEntity<String> getStatus() {

        return new ResponseEntity<>("Success..!!!"+projectConfig.getServiceMapping(), HttpStatus.OK);
    }
}
