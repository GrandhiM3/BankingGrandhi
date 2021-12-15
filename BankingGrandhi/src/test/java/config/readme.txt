read me file for frame work


--->for this i used a maven project. i have added required dependencies in pom.XML

--->Used Tools
Selenium
Java
RestAssuered
Extent Reports
JSON simple
TESTNG

--->When ever we run a test case, a extent report will be generated and it will be saved in reports.
we can open that in a browser and check results

--->com.grandhi.banking.PageObjects package contains All pageObjects for different pages. 
each page contains required element declartions and required element functionality methods.
--->com.grandhi.banking.task1 package contains Api Test Cases
--->com.grandhi.banking.task1 package contains UI Test Cases
---> Utilities package contains some required Utils classes.

--->Resources Folder contains TestData.from this folder i have taken the data contains in JSON Object and used in Task2 TestCase 4

Base Class
in Base class i declared Initate and Teardown methods and i have declared a File reader method and method to read property


