package com.hadoop.ingestion;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ankush.nakaskar
 * @version 1.0
 * @date 29/03/21 4:09 PM
 */

public class TestFileStatus {

    private MiniDFSCluster miniDFSCluster;
    private FileSystem fs;


    @Before
    public void setup() throws IOException {
        Configuration conf = new Configuration();
        System.setProperty("test.build.data", "/tmp");
        miniDFSCluster = new MiniDFSCluster.Builder(conf).build();
        fs = miniDFSCluster.getFileSystem();
        OutputStream out = fs.create(new Path("/dir/file"));
        out.write("content".getBytes("UTF-8"));
        out.close();
    }

    @Test
    public void test() {

    }

    @After
    public void tearDown() throws IOException {
        if (fs != null) {
            fs.close();
        }
        if (miniDFSCluster != null) {
            miniDFSCluster.shutdown();
        }
    }


}
