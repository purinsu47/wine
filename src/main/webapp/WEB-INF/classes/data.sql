DROP TABLE IF EXISTS WINE CASCADE;

CREATE TABLE WINE (
  wine_id INT AUTO_INCREMENT  PRIMARY KEY,
  lot_code VARCHAR(250) NOT NULL,
  volume DOUBLE NOT NULL,
  description VARCHAR(250) DEFAULT NULL,
  tank_code VARCHAR(250) DEFAULT NULL,
  product_state VARCHAR(250) DEFAULT NULL,
  owner_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS GRAPECOMPONENT;
  
CREATE TABLE GRAPECOMPONENT (
  component_id INT AUTO_INCREMENT  PRIMARY KEY,
  wine_id INT NOT NULL,
  CONSTRAINT component_wine FOREIGN KEY (wine_id) REFERENCES WINE (wine_id) ON UPDATE CASCADE ON DELETE CASCADE,
  year INT NOT NULL,
  percentage DOUBLE NOT NULL,
  variety VARCHAR(250) DEFAULT NULL,
  region VARCHAR(250) DEFAULT NULL
);

INSERT INTO WINE (lot_code,volume,description,tank_code,product_state,owner_name) 
values ('11YVCHAR001',1000.0,'2011 Yarra Valley Chardonnay','T25-01','Ready for bottling','YV Wines Pty Ltd');

INSERT INTO GRAPECOMPONENT (wine_id,year,percentage,variety,region) 
values (1,2011,5.0,'Pinot Noir','Mornington');
INSERT INTO GRAPECOMPONENT (wine_id,year,percentage,variety,region) 
values (1,2011,80.0,'Chardonnay','Yarra Valley');
INSERT INTO GRAPECOMPONENT (wine_id,year,percentage,variety,region) 
values (1,2010,5.0,'Pinot Noir','Macedon');
INSERT INTO GRAPECOMPONENT (wine_id,year,percentage,variety,region) 
values (1,2010,10.0,'Chardonnay','Macedon');



