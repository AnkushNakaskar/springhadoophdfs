package com.hadoop.ingestion.hdfs;

/**
 * @author ankush.nakaskar
 * @version 1.0
 * @date 14/03/21 6:06 PM
 */
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Progressable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

import static java.io.FileDescriptor.out;

@Service
public class HdfsFileAccess {

    @Autowired
    FileSystem fileSystem;

    public void writeFile(String name) throws IOException {
        System.out.println(fileSystem.getHomeDirectory());
        Path p = new Path("/test/myTemplate.txt");
        FSDataOutputStream fsDataOutputStream = fileSystem.create(p,   new Progressable() {
            public void progress() {

                System.out.println("...bytes written: [ ]");
            } });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream));
        bw.write("hi there");
        bw.close();
        fileSystem.close();
    }

    public InputStream readFile(String name) throws IOException {
        return fileSystem.open(new Path(name));
    }
}
