use mycardb;

show tables;

create table tbl_users(
username	VARCHAR(15)		PRIMARY KEY,
password	VARCHAR(255)	NOT NULL,	
u_name	VARCHAR(20)	NOT NULL,	
u_nickname	VARCHAR(20),		
u_tel	VARCHAR(15),		
u_role	VARCHAR(15)	NOT NULL	
);

drop table tbl_carmanager;
drop table tbl_users;
show tables;

select * from tbl_carmanager;
select * from tbl_users;

insert into tbl_users
(username, password, u_name, u_nickname, u_tel, u_role)
values
('callor','12341234','홍길동','길동아','','ADMIN');
Update tbl_users set password = '12341234' where username = callor;

