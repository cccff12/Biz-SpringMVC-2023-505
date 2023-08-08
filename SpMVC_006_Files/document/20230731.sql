
CREATE DATABASE imageDB;
USE IMAGEDB;

DROP table tbl_bbs;
CREATE TABLE tbl_bbs(
b_seq BIGINT PRIMARY key AUTO_INCREMENT,
	b_title varchar(125),
	b_content varchar(1000),
	b_nickname varchar(125),
	b_password varchar(125),
	b_ccode varchar(6),
	b_date varchar(10),
	b_viewcount long,
	b_image VARCHAR(255),
	b_origin_image VARCHAR(255)
);


show tables;

DESC tbl_bbs;

select * from tbl_bbs;


TRUNCATE tbl_bbs;

use imagedb;
show tables;
desc tbl_files;
desc tbl_bbs;

-- tbl_bbs.b_seq, tbl_files.f_bseq를 연결
alter table tbl_files
ADD CONSTRAINT F_BBS FOREIGN KEY (f_bseq)
REFERENCES tbl_bbs(b_seq);




