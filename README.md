# QA-WebTesting-BDD-Java
Web testing project using Cucumber, Selenium and Java.


## Introduction
This project contains an automated suite for the web application <a href="http://165.227.93.41/lojinha-web/">Lojinha</a> present in the course Teste De Software Para Iniciantes (TSPI) instructed by <a href="https://www.juliodelima.com.br/"> Julio de Lima</a>. 

The framework was developed using Page Object, Maven, BDD, Selenium and Java. The results generates a report in a friendly dashboard through.

The suite will cover the main web application user behavior, including login, product and component features with different scenarios. 

## Environment Setup
**Prerequisites:** 
* Maven 
* Chrome webdriver
* Update the driver in the root folder with the version of the browser on which you want to run the tests.


## How to run?

Issue the below commands in project root directory :
```
mvn tests
```

_A folder target will be created with the results for each scenario and also a link for the dashboard will be available in the console report._




