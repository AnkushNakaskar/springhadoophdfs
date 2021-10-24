package com.hadoop.ingestion.configuration;

import org.apache.hadoop.fs.FileSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author ankush.nakaskar
 * @version 1.0
 * @date 07/03/21 9:14 PM
 */

@Configuration
public class HadoopConfig {

    @Bean
    public FileSystem createFileSystem() throws IOException {
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
//        conf.set("fs.default.name", "hdfs://localhost:9000");
        conf.set("fs.defaultFS", "hdfs://localhost:9000");
        conf.set("dfs.permissions", "false");
        conf.set("user","ankush.nakaskar");
        conf.set("mapreduce.jobtracker.address", "localhost:54311");
        conf.set("mapreduce.framework.name", "yarn");
        conf.set("yarn.resourcemanager.address", "localhost:8032");
        return FileSystem.get(conf);
    }

}
