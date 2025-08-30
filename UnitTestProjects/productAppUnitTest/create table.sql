Use springdatajpa2;

-- 
drop table `springdatajpa2`.`tbl_product`;

INSERT INTO `springdatajpa2`.`tbl_product`
(`id`,
`description`,
`name`,
`price`)
VALUES
(1,
"ssssssss",
"lllllllllll",
123.00);

delete from springdatajpa2.tbl_product where id>0;
select * from springdatajpa2.tbl_product;



=================  H2  remote mode   (lokalna instalacja H2 w C:\devtools\H2\h2 )
uruchamiamy serwer:
c:\devtools\H2\h2\bin>java -cp h2-2.1.212.jar org.h2.tools.Server -tcp
TCP server running at tcp://192.168.1.102:9092 (only local connections)

odpalamy jara z lokalizacji:  c:\devtools\H2\h2\bin>java -jar h2-2.1.212.jar

drop table tbl_product
Create table tbl_product (id int primary key auto_increment, name varchar(30), description varchar(30), price double );
Insert into tbl_product (name, description, price) values('JACEK', 'asdasda', 900.01);
Insert into tbl_product (name, description, price) values('TOMEK', 'asdada', 111.31);
Insert into tbl_product (name, description, price) values('KAJTEK', 'asdcxzczx', 222.21);