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
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class HdfsFileAccess {

    @Autowired
    FileSystem fileSystem;

    @Autowired
    ResourceLoader resourceLoader;

    public void writeFile(String name) throws IOException {
        System.out.println(fileSystem.getHomeDirectory());

        Resource resource = new ClassPathResource(name);
        InputStream inputStream = resource.getInputStream();

        Path p = new Path("/test/myTemplate2.txt");
        FSDataOutputStream fsDataOutputStream = fileSystem.create(p, new Progressable() {
            public void progress() {

                System.out.println("...bytes written: [ ]");
            }
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream));

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Lines.... "+line);
                bw.write(line);
            }
        }
        bw.close();
    }


    public InputStream readFile(String name) throws IOException {
        return fileSystem.open(new Path(name));
    }
}
