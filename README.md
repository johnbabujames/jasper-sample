Basics on JasperReports 

1.	Open Source Java Reporting Engine
2.	Can export to PDF, HTML, XLS, RTF, ODT, CSV, TXT, and XML files.
3.	.jrxml is the design xml for Jasper Reports
4.	.jasper is the executable to run the report.

Creating Data Adapter:
Data Adapter is the data source connection that we will have to establish to run the report.
![1](https://user-images.githubusercontent.com/32309517/54247173-4ae6a900-450e-11e9-9482-4c7368a85dd3.jpg)
 

Data Adapter Options:
There are several options to connect to various type of datasources.
I have selected JDBC.
![2](https://user-images.githubusercontent.com/32309517/54247239-9436f880-450e-11e9-9577-6e51f9823931.jpg)

Connection Details
Provide the Connection details as listed below.
1.	JDBC Driver
2.	JDBC Url
3.	Username
4.	Password
![3](https://user-images.githubusercontent.com/32309517/54247243-99944300-450e-11e9-9377-aa11b39cc43c.jpg)
 

Driver Classpath:
Browse and select the appropriate driver jar for your database connection.
I have selected postgres jar as I am going to connect to Postgress
![4](https://user-images.githubusercontent.com/32309517/54247248-a153e780-450e-11e9-91cc-c1d9564ea11e.jpg)

Test the Connection:
Test the connection and on success click Finish. You are all set with your Data Adaper.
![5](https://user-images.githubusercontent.com/32309517/54247252-a7e25f00-450e-11e9-85c0-76c2cbdae4e1.jpg)



Creating New Report:
![6](https://user-images.githubusercontent.com/32309517/54247253-a7e25f00-450e-11e9-8df5-6f730d760e7a.jpg)

Select the Page from the predefined templates.
![7](https://user-images.githubusercontent.com/32309517/54247254-a87af580-450e-11e9-989a-a1ea5b6f2d11.jpg)

Name the report like “MyFirstReport.jrxml”
![8](https://user-images.githubusercontent.com/32309517/54247255-a87af580-450e-11e9-88b3-8337288f2cd1.jpg)

Create the query that you are going to use to fetch the data
![9](https://user-images.githubusercontent.com/32309517/54247256-a87af580-450e-11e9-85e2-1dcfd5b36204.jpg) 

Add the Query by selecting the right Data Adapter 
![10](https://user-images.githubusercontent.com/32309517/54247257-a87af580-450e-11e9-8036-cca2cbf81271.jpg)

Select all the fields you want to use in the report.
![11](https://user-images.githubusercontent.com/32309517/54247258-a87af580-450e-11e9-805d-d2e6e8a4ffaa.jpg)


Report Bands:
1.	Title contains the 'Title' of the report. It appears only once at the very beginning of the report.
2.	Page Header may contain date and time information and/or organization name. This appears at the top of each page.
3.	Column Header lists the names of those specific fields, which you want to display in the report
4.	Detail is the part where entries of the specific fields (listed in Column Header) are shown
5.	Column Footer may display summation of any of the field
6.	Page Footer may contain page count information. It appears at the bottom of each page
7.	Summary contains information inferred from "detail" part, for example, after listing the number of hours, worked by each author, total hours worked by each author can be put in visual chart like pie chart, graph, etc. for better comparison
![12](https://user-images.githubusercontent.com/32309517/54247259-a87af580-450e-11e9-8c68-17f531a3046f.jpg) 

Fields:
Report fields are elements, which represent mapping of data between datasource and report template. Fields can be combined in the report expressions to obtain the desired output. A report template can contain zero or more <field> elements. When declaring report fields, the data source should supply data corresponding to all the fields defined in the report template.
Example.
<field name = "emp_name" class = "java.lang.String">
   <fieldDescription><![CDATA[emp_name]]></fieldDescription>
</field>

Parameters:
Report Parameters are the object references, those are passed during report-filling operations to the report engine. The data which cannot be passed through the data source, can be passed by using parameters. Data like emp_id can be passed through parameters. A JasperReports template or JRXML template can have zero or more parameter elements.
Example.
<parameter name = "emp_id" class = "java.lang.String" />

Variables:
Report variables simplify the following tasks −
1.	Report expressions, which are heavily used throughout the report template. These expressions can be declared only once by using the report variables.
2.	Report variables can perform various calculations based on the corresponding expressions values such as count, sum, average, lowest, highest, variance, etc.
If variables are defined in a report design, then these can be referenced by new variables in the expressions. Hence, the order in which the variables are declared in a report design is important.
Examples: Average, Count, First, Highest, Lowest and Sum, etc.
<variable name = "emp_salary" class = "java.lang.Integer" incrementType = "Group"
   incrementGroup = "EmpGroup" calculation = "Sum">
   <variableExpression>
      <![CDATA[Boolean.TRUE]]>
   </variableExpression>
</variable>

You can drag and drop the components you want.
1.	Add the fields in the Detail Band. 
2.	Add the static text in the Page Header Band.
3.	Add a static tex in the Title Band.
![13](https://user-images.githubusercontent.com/32309517/54247260-a9138c00-450e-11e9-9adb-2188c2e8d031.jpg)

Output Generated As below.
![14](https://user-images.githubusercontent.com/32309517/54247261-a9138c00-450e-11e9-9828-788bd452db0f.jpg)

 Notes: 
 1.	You need to place the MyFirstReport.jrxml into your local repository which available under resources/templates
 2.	Update the your local path in ReportingServiceImpl.java
 
Resources:
https://www.tutorialspoint.com/jasper_reports/
https://o7planning.org/en/10271/jasperreport-tutorial-for-beginners
https://o7planning.org/en/10293/calling-jasper-report-from-java-application
