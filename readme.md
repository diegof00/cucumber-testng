##Cucumber - testng - selenium

* testng version = 7.1.0
* cucumber version 5.6.0
* selenium version 3.141.59
* log4j version 2.13.1

#### Features

    src/test/resources/features
    
#### Test Suite

    src/test/resources/test-suite.xml
    
#### Web Driver
    
Download chromedriver according your google chrome version
    
[https://chromedriver.chromium.org/](https://chromedriver.chromium.org/)

Copy chromedriver in
    
    /src/test/resources/webdrivers/    
    
#### Run
        
        mvn clean install
        
#### Reports

    ${projectDir}/target/reports/index.html
    
