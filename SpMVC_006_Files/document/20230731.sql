
CREATE DATABASE imageDB;
USE IMAGEDB;

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