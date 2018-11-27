create table batch (
	id int ,
	customer_id int ,
	type varchar(15) ,
	received_date date ,
	status varchar(15) ,
	completed_date date ,
	PRIMARY KEY (id)
);

insert into batch (id, customer_id, type, received_date, status, completed_date) 
values
('1','1','EYE','2015-06-03','IN_PROCESS',NULL),
('2','1','EDUCATION','2015-06-04','IN_PROCESS',NULL),
('3','2','DENTAL','2015-06-04','IN_PROCESS',NULL),
('4','1','EYE','2015-06-05','IN_PROCESS',NULL),
('5','2','EDUCATION','2015-06-06','COMPLETED','2015-06-09'),
('6','1','DENTAL','2015-06-07','IN_PROCESS',NULL),
('7','3','REALSTATE','2015-06-09','IN_PROCESS',NULL),
('8','1','NOSE','2015-06-04','COMPLETED','2015-06-24'),
('9','1','VEHICLE','2015-06-09','COMPLETED','2015-06-16'),
('10','1','REALSTATE','2015-06-10','IN_PROCESS',NULL),
('11','3','EDUCATION','2015-06-10','IN_PROCESS',NULL),
('12','1','EYE','2015-06-11','COMPLETED','2015-06-23'),
('13','4','DENTAL','2015-06-11','IN_PROCESS',NULL),
('14','1','EDUCATION','2015-06-11','IN_PROCESS',NULL);


create table document (
	id int ,
	batch_id int ,
	status varchar(15) ,
	insured_name varchar(30) ,
	insured_address varchar(30) ,
	claimed_charge double ,
	PRIMARY KEY (id),
 	KEY batch_id (batch_id),
  	CONSTRAINT document_ibfk_1 FOREIGN KEY (batch_id) REFERENCES batch (id)
);

insert into document (id, batch_id, status, insured_name, insured_address, claimed_charge) 
values
('1','1','DATA_ENTRY',NULL,NULL,NULL),
('2','1','TO_REPRICE','Geeta','KTM','11100'),
('3','1','EXPORTED','Shyam','NGT','100'),
('4','3','EXPORTED','Roman','KTM','550'),
('5','1','TO_REPRICE','Shankar','KTM','500'),
('6','2','TO_REPRICE','Ujjwal','NGT','80000'),
('7','2','TO_REPRICE','Bishwo','LALIT','600'),
('8','2','DATA_ENTRY',NULL,NULL,NULL),
('9','3','DATA_ENTRY',NULL,NULL,NULL),
('10','3','DATA_ENTRY',NULL,NULL,NULL),
('11','5','EXPORTED','Suraj','NGT','200'),
('12','4','DATA_ENTRY',NULL,NULL,NULL),
('13','4','DATA_ENTRY',NULL,NULL,NULL),
('14','3','DATA_ENTRY',NULL,NULL,NULL),
('15','4','DATA_ENTRY',NULL,NULL,NULL),
('16','2','DATA_ENTRY',NULL,NULL,NULL),
('17','2','DATA_ENTRY',NULL,NULL,NULL),
('18','6','DATA_ENTRY',NULL,NULL,NULL),
('19','3','DATA_ENTRY',NULL,NULL,NULL),
('20','2','DATA_ENTRY',NULL,NULL,NULL),
('21','6','TO_REPRICE','Krishna','KTM','110'),
('22','7','DATA_ENTRY',NULL,NULL,NULL),
('23','1','TO_REPRICE','Shyam','NGT','100'),
('24','1','TO_REPRICE','Biraj','KTM','510'),
('25','14','DATA_ENTRY',NULL,NULL,NULL),
('26','13','DATA_ENTRY',NULL,NULL,NULL),
('27','12','EXPORTED','Neeta','BRT','50'),
('28','3','TO_REPRICE','Ram','KTM','100'),
('29','11','DATA_ENTRY',NULL,NULL,NULL),
('30','10','DATA_ENTRY',NULL,NULL,NULL),
('31','9','EXPORTED','Leonardo','NPJ','800'),
('32','8','EXPORTED','Aman','POKH','900'),
('33','7','DATA_ENTRY',NULL,NULL,NULL),
('34','6','DATA_ENTRY',NULL,NULL,NULL),
('35','2','DATA_ENTRY',NULL,NULL,NULL),
('36','14','DATA_ENTRY',NULL,NULL,NULL),
('37','10','DATA_ENTRY',NULL,NULL,NULL),
('38','14','DATA_ENTRY',NULL,NULL,NULL),
('39','11','DATA_ENTRY',NULL,NULL,NULL),
('40','8','EXPORTED','Rabin','POKH','300'),
('41','9','EXPORTED','Sita','NPJ','400'),
('42','12','EXPORTED','Akash','BRT','150'),
('43','1','TO_REPRICE','Shankar','NGT','1500');


--SELECT insured_name, insured_address and claimed_charge 
--FROM document
--WHERE status IN (TO_REPRICE)
--id IN (1,2);
--


SELECT SUM(claimed_charge) AS Total FROM document;

SELECT
     insured_name,
     insured_address,
     claimed_charge
FROM
     document
WHERE
     status = "TO_REPRICE"
AND
	customer_id = '1' AND '2';
     







