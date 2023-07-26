use rentbookdb;

create table tbl_members(
M_CODE	VARCHAR(6)	NOT NULL	PRIMARY KEY,
M_NAME	VARCHAR(125)	NOT NULL,	
M_TEL	VARCHAR(15)	NOT NULL,	
M_ADDR	VARCHAR(125)		
);

DROP TABLE tbl_members;

SELECT * from tbl_members;
SELECT max(m_code) from tbl_members;
DESC tbl_members;

insert into tbl_members(M_CODE, M_NAME, M_TEL, M_ADDR) VALUES('0001','홍길동','010-1111-1111','서울');


drop table tbl_rent_book;
create table tbl_rent_book(
RENT_SEQ	BIGINT	NOT NULL	PRIMARY KEY AUTO_INCREMENT,
RENT_DATE	VARCHAR(10)	NOT NULL,	
RENT_RETURN_DATE	VARCHAR(10)	NOT NULL,	
RENT_BCODE	VARCHAR(13)	NOT NULL,	
RENT_MCODE	VARCHAR(6)	NOT NULL,	
RENT_RETURN_YN	VARCHAR(1),		
RENT_POINT	INT,		
RENT_PRICE	INT		
);
