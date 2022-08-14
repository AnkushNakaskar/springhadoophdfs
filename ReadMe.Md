#This project is spring hadoop(inserting files into HDFS)
* Learn basics of Hadoop via Tutorials 
    * https://www.youtube.com/watch?v=1vbXmCrkT3Y&t=4828s
    * https://data-flair.training/blogs/hadoop-hdfs-architecture/
    * https://data-flair.training/blogs/hadoop-tutorials-home/
    * https://www.netjstech.com/2018/07/shuffle-and-sort-phases-hadoop-mapreduce.html
      * This link explain the map reduce phases in details.
      * Read(Split) -> Map -> Combine -> Sort-> Partition -> Shuffle -> Sort-> Reduce -> OutPut
      * Reducer instance make Http API calls to get the local disk files from Mapper Instance : this is why Map reduce is not good in performance than spark
* First we should install hadoop on local system
    Hadoop
    1. Installing Hadoop
    	-> https://medium.com/beeranddiapers/installing-hadoop-on-mac-a9a3649dbc4d (OR https://towardsdatascience.com/installing-hadoop-on-a-mac-ec01c67b003c)
    	-> 	alias hstart="/usr/local/cellar/hadoop/3.3.0/sbin/start-all.sh"
    		alias hstop="/usr/local/cellar/hadoop/3.3.0/sbin/stop-all.sh"
    2.	Configuration details 
    	-> https://hadoop.apache.org/docs/r1.2.1/cluster_setup.html
    
    3. Learn from end to end debugging 
    	-> https://docs.deistercloud.com/content/Technology.50/Hadoop/Hadoop%20single.10.xml?embedded=true
    4. Write Files into HDFS 
    	-> https://www.javatpoint.com/mapreduce-word-count-example
*   Used Spring to handle hadoop processing
    * https://docs.spring.io/spring-hadoop/docs/current/reference/html/springandhadoop-config.html
* Follow this 
    * https://github.com/danielyinanc/hdfs-spring-stream/tree/master/src/main/java/com/rainmakeross/tutorial/hdfs/springboot    
       				
* How to execute programe
    * Run cmd      ```mvn clean install -Plocal  -U idea:idea```
    * Run Jar      ``` java -jar target/springhadoopdemo-0.0.1-SNAPSHOT.jar ```
    * Before all this, make sure, you have hadoop running on local system. Follow Medium blog to install and running hadoop.
    * You can test the Application is running using : http://localhost:9098/test
    * This example is for HDFS write file
    * You can browse files here : http://localhost:9870/explorer.html#/
    * You need to use the namenode format if above url is not accessible 
    * Sample log from application running  
    ```
    2021-10-02 13:14:39,077 INFO  [main] web.EndpointLinksResolver (EndpointLinksResolver.java:<init>(58)) - Exposing 4 endpoint(s) beneath base path '/actuator'
    2021-10-02 13:14:39,157 INFO  [main] tomcat.TomcatWebServer (TomcatWebServer.java:start(220)) - Tomcat started on port(s): 9098 (http) with context path ''
    2021-10-02 13:14:39,171 INFO  [main] ingestion.SpringhadoopdemoApplication (StartupInfoLogger.java:logStarted(61)) - Started SpringhadoopdemoApplication in 3.601 seconds (JVM running for 4.023)
    Ankush....
    Oct 02, 2021 1:14:48 PM org.apache.catalina.core.ApplicationContext log
    INFO: Initializing Spring DispatcherServlet 'dispatcherServlet'
    2021-10-02 13:14:48,411 INFO  [http-nio-9098-exec-1] servlet.DispatcherServlet (FrameworkServlet.java:initServletBean(525)) - Initializing Servlet 'dispatcherServlet'
    2021-10-02 13:14:48,412 INFO  [http-nio-9098-exec-1] servlet.DispatcherServlet (FrameworkServlet.java:initServletBean(547)) - Completed initialization in 0 ms
    hdfs://localhost:9000/user/ankush.nakaskar
    Lines.... hd.fs=hdfs://localhost:9000
    Lines.... hd.rm=localhost:8032
    Lines.... hd.jh=localhost:10020
    Lines.... 
    Lines.... wordcount.input.path=/user/gutenberg/input/word/
    Lines.... wordcount.output.path=/user/gutenberg/output/word/
    Lines.... localSourceFile=data/nietzsche-chapter-1.txt
    Lines.... server.port=9098
    Lines.... spring.hadoop.config.fs.defaultFS=hdfs://localhost:9000
    ...bytes written: [ ]
    ...bytes written: [ ]

    ```
    
    
