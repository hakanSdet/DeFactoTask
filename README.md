# DeFactoTask

- This is a task prepared by Hakan KAHRAMAN for DeFacto

- On bussines layer, I used gherkin language inside Cucumber BDD

- On implementation layer, Java is my programming language, in some methods used JScript 

- I used maven as my built magement tool which has pom.xml is brain of maven, manage dependecies and plugins

- Resource Directory - Feature Package
  - I used TC with using Gherkin language inside this folder
  - Feature file contains Scenarios or Scenario Outlines.
  - Each Scenario consists of test steps which has Given, When, Then.

- Step Definition Package
  - For each steps, I implemented step definition by using annotations methods so that phrases turned into actions here
  - I also creating one special Hook class which includes @Before @After annotations and runs before or after each features
  - I created one object from that page inside step definitions
  - So that I can be able to use that class features

- Pages

  - To create object form pages, I implemented Page Object Model Design and created classes for each page under pages package.
  - In this pages folder, I am using PageFactory class to create web elements
  - I located elements once and use them all the time
  - I wrote the methods inside by using java and JS 

- Runners

  - I trigger my framework from my runner class
  - When test is failed, FailedTest runner run automatically 
  - By using plugin attribute, I created html report. By using Maven verify can create Cucumber html report.

- Target

  - All default html or maven cucumber reports are stored here.
  - And Screenshots for failed test cases are included automatically in the report.

- Utilites

  - I stored my reusable code here.
  - I have Browser, Driver, Configuration Reader in utilities class
  - I have Configuration.properties file and I wrote some datas like url, browser type inside so that I centralize my datas
  - Beside that I have one Driver class which I created base on singleton design.
  - Driver class choose driver base on this file and use it for each test cases instead of creating new one for each and is designed available for parallel testing.
     

- Tools

 - Java 8, Selenium 4, TestNg 7(For Assertion),Junit 5 Cucumber 5, BDD, Gherkin, Singleton Driver(available parallel testing),Log4j.

- Note : All steps are logged with Log4j.
