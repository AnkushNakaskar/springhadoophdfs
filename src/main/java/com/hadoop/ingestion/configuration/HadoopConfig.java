package com.hadoop.ingestion.configuration;

/**
 * @author ankush.nakaskar
 * @version 1.0
 * @date 07/03/21 9:14 PM
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.hadoop.config.annotation.EnableHadoop;
import org.springframework.data.hadoop.config.annotation.SpringHadoopConfigurerAdapter;
import org.springframework.data.hadoop.config.annotation.builders.HadoopConfigConfigurer;

import java.io.IOException;
/*
Dont use this class for processing the hadoop, it was leading to problem with 'Invalid hadoopConfiguration' bean
 */
//@Configuration
//@EnableHadoop
public class HadoopConfig extends SpringHadoopConfigurerAdapter {

    @Autowired
    private ResourceLoader resourceLoader;


//    @Override
//    public void configure(HadoopConfigConfigurer config) throws Exception {
//        config
//                .fileSystemUri("hdfs://localhost:8021");
//    }

    @Override
    public void configure(HadoopConfigConfigurer config) throws Exception {

        org.apache.hadoop.conf.Configuration conf = getHadoopConfig("/usr/local/cellar/hadoop/3.3.0/libexec/etc/hadoop/mapred-site.xml");

        config
                .withResources()
                .resource("/usr/local/cellar/hadoop/3.3.0/libexec/etc/hadoop/yarn-site.xml")
                .resource("/usr/local/cellar/hadoop/3.3.0/libexec/etc/hadoop/mapred-site.xml")
                .and()
                .withProperties()
                .property("mapreduce.app-submission.cross-platform", "true")
                .property("mapreduce.framework.name", "yarn")
                .property("mapreduce.application.framework.path", "")
                .property("mapreduce.map.log.level", "INFO")
                .property("mapreduce.reduce.log.level", "INFO")
                .property("hbase.client.scanner.caching", "1")
                .property("hbase.client.scanner.timeout.period", "300000")
                .property("hbase.rpc.timeout", "300000");

    }

    private org.apache.hadoop.conf.Configuration getHadoopConfig(String mrSiteFile) throws IOException {
        Resource mapRedSite = resourceLoader.getResource(mrSiteFile);
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.addResource(mapRedSite.getInputStream());
        return conf;
    }
}
