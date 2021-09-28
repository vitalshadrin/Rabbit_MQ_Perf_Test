# Rabbit MQ Performance Test

## 1. RabbitMQ PerfTest
RabbitMQ has a throughput testing tool, PerfTest, that is based on the Java client and can be configured to simulate basic workloads and more advanced workloads as well.

To run the **PerfTest**, you need to do the following:

### Running tests by specifying options from console

* navigate to console from the root directory
* execute next command :: **gradle -PrabbitMQTest=RabbitPerfTest -Poptions=="-option1=value -option2=value ..." run**
 
_For example: gradle -PrabbitMQTest=RabbitPerfTest -Poptions="-queue=Test_Queue -time=30" run_

### Running tests by specifying options from config file
* navigate to **src/main/resources/config**
* update or add parameters
* navigate to console from the root directory
* execute next command ::  **gradle -PrabbitMQTest=RabbitPerfTest run**

### Reporting 

After the test is completed, a folder with the test execution report will be created in the folder **result** with name _perfTest_result__(_date of completion)_

## 2. RabbitMQ PerfTestMulti
RabbitMQ created a couple of tools to facilitate benchmarking RabbitMQ in different usage scenarios. One part of these tools is the PerfTest Java class, the other part is a couple of HTML/JS tools that will let you plot the results obtained from the benchmarks into nicely looking graphs.

To get the result of the tests performed in graphs, you need to do the following:

### Running tests by specifying configurations from config file
* navigate to **src/main/resources/config/perfTestMulti.properties**
* for **spec** property enter specification name from **src/main/resources/spec** 
* _For example: spec=one-queue-spec.js_
* navigate to console from the root directory
* execute next command ::  **gradle -PrabbitMQTest=RabbitPerfTestMulti run**

### Running tests by specifying configurations from console

* navigate to **src/main/resources/spec**
* save in clipboard test specification name _(also you can to create you specification here)_
* navigate to console from the root directory
* execute next command :: **gradle -PrabbitMQTest=RabbitPerfTestMulti -Pspec=="specification name" run** 

_For example: gradle -PrabbitMQTest=RabbitPerfTestMulti -Pspec="one-queue-single-active-consumers-spec.js" run_

### Running tests by specifying configurations arguments from console
* navigate to **src/main/resources/spec**
* save in clipboard test specification name _(also you can to create you specification here)_
* navigate to console from the root directory
* execute next command :: **gradle -PrabbitMQTest=RabbitPerfTestMulti -Pspec=="specification name" -PspecArgs="option=value, option=value1;value2, ..." run**

_For example: gradle -PrabbitMQTest=RabbitPerfTestMulti -Pspec="one-queue-single-active-consumers-spec.js" -PspecArgs="time-limit=30, queue-names=B1;B2;B3, auto-delete=true" run_

### Reporting

After the test is completed, a folder with the test execution report will be created in the folder **result** with name _perfTestMulti_result__(_date of completion)_

_To view the report in html format, need to install [NodeJS](https://nodejs.org/en/) and install [http-server](https://www.npmjs.com/package/http-server)_
To open the report, go to the folder with the report, find the html, run next **http-server** command and navigate to http://localhost:8080/html/sample.html

