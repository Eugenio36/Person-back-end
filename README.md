## Implement simple REST service based on spring-boot framework 
a. Service input personal id; date of birth 

b. Service output Person object with following properties:

- Personal id 
- First name, last name
- Gender: male, female 
- Date of birth

c. Data need to be located in a database, e.g. H2 

d. Dependency manager: maven 

e. Log some service activities to log file and in database

f. Implement unit tests and integration test 

## Instructions

1. Open the project

2. Run -> PersonmanagerApplication.

3. At this moment server is being launched and 2 tables (Person table and Log table) have been created in H2 database. (these tables have been created automatically, and located in project src -> main -> resources -> db -> changelog -> changes.

4. Open link in browser http://localhost:8080/h2-console

5. Test connection with data below and then click Connect.

![h2 console start up](https://user-images.githubusercontent.com/94042617/170658978-da1410cb-bb32-4584-837c-0a162cf5c52c.jpg)

6. Now you can check Person table. Write this SQL statement: SELECT * FROM PERSON and click RUN SELECTED.
 
![person_table](https://user-images.githubusercontent.com/94042617/170659123-886743c9-660e-4ad2-98a7-eeb3a76b8ac8.jpg)

7. To check whether the program is working correctly (the main goal was to input person`s personal ID and date of birth and receive full information such as personalId, firstName, lastName, Gender, dateOfBirth) you can use POSTMAN.

8. Open Postman and enter this link, for example:

http://localhost:8080/person/search

Enter all values as shown on screen below. 

![postman_02](https://user-images.githubusercontent.com/94042617/170671388-6afa40ca-fce8-4088-ae76-4aa604e70735.jpg)

After that you can send GET request and if data entered correctly you will receive 200OK response and all information about the person in JSON format. (You can send GET reqest several times in order to check logs).

9. Now you can check some logs.

10. In IntelliJ logs are shown in "RUN" window (examples below). All application logs and request logs can be check in myapp.log file, which is located in project (personmanager -> myapp.log).

![Logs_IntelliJ](https://user-images.githubusercontent.com/94042617/170671482-eed8517e-5cf2-456c-9fc6-a1756eab30f9.jpg)

11. If you wish to check logs in database go to http://localhost:8080/h2-console and run this SQL script: SELECT * FROM AUDIT_LOG.

![audit_log](https://user-images.githubusercontent.com/94042617/170671643-d3ae540c-eca3-4e5a-b8ba-2fa1558157cb.jpg)

12. Unit and integration tests are also available in map "test".

13. How to check front-end please use this link -> https://github.com/Eugenio36/Person-front-end
