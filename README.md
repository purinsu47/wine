## JavaServer Faces with Spring Boot

Database: H2 In-Memory Database 
The application will insert the following data on boot up.

Wine [id=1, lotCode=11YVCHAR001, volume=1000.0, description=2011 Yarra Valley Chardonnay, tankCode=T25-01, productState=Ready for bottling, ownerName=YV Wines Pty Ltd]

GrapeComponent [id=1, percentage=5.0, year=2011, variety=Pinot Noir, region=Mornington]

GrapeComponent [id=3, percentage=5.0, year=2010, variety=Pinot Noir, region=Macedon]

GrapeComponent [id=2, percentage=80.0, year=2011, variety=Chardonnay, region=Yarra Valley]

GrapeComponent [id=4, percentage=10.0, year=2010, variety=Chardonnay, region=Macedon]

Please see src/main/resources/data.sql

Guide/Steps
1. Pull the project and import to your IDE
2. Clean Build the project
3. Run as a Java Application -> Application.java
4. Enter http://localhost:8080/ to your browser and try the application

Use swagger to insert JSON enter http://localhost:8080/swagger-ui.html# to your browser.

