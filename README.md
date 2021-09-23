# Rabbit MQ Perf Test

##RabbitMQ PerfTest
RabbitMQ has a throughput testing tool, PerfTest, that is based on the Java client and can be configured to simulate basic workloads and more advanced workloads as well.

To run the **PerfTest**, you need to do the following: 
* navigate to **src/main/resources/config**
* update or add parameters
* navigate to console from the root directory
* execute next command ::  **gradle -PmainClass=rabbit_perf/RabbitPerfTest run**

After the test is completed, a folder with the test execution report will be created in the folder **result** with name _perfTest_result__(_date of completion)_

##RabbitMQ PerfTestMulti
RabbitMQ created a couple of tools to facilitate benchmarking RabbitMQ in different usage scenarios. One part of these tools is the PerfTest Java class, the other part is a couple of HTML/JS tools that will let you plot the results obtained from the benchmarks into nicely looking graphs.

To get the result of the tests performed in graphs, you need to do the following: 
* navigate to **src/main/resources/config**
* for **spec** property enter specification name from **src/main/resources/spec** (For example: spec=one-queue-spec.js)
* navigate to console from the root directory
* execute next command ::  **gradle -PmainClass=rabbit_perf/RabbitPerfTestMulti run**
* **gradle -PmainClass=rabbit_perf/RabbitPerfTestMulti -Pargs="one-queue-spec.js" run**

After the test is completed, a folder with the test execution report will be created in the folder **result** with name _perfTestMulti_result__(_date of completion)_

To open the report, go to the folder with the report, find the html folder there and open _sample.html_




