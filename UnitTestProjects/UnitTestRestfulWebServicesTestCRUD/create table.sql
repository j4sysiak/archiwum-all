Use springdatajpa3; 

drop table if exists tbl_countries CASCADE ;
drop table if exists tbl_states CASCADE ;
   
create table springdatajpa3.tbl_countries (
       `id` bigint NOT NULL AUTO_INCREMENT,
        `name` varchar(64) NOT NULL
) ;

    
create table springdatajpa3.tbl_states (
       `id` bigint NOT NULL AUTO_INCREMENT,
        `name` varchar(64) NOT NULL
) ;


select * from tbl_countries ;
select * from tbl_states;
