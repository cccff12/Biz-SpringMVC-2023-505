use rentbookdb;

-- 전체 데이터 중에서 1페이지에서 10개 : 0~9번까지
-- 전체 데이터 중에서 2페이지에서 10개 : 10~19번까지
-- 1페이지 일 경우 시작값 1이 될려면 (page - 1) * 10 


-- 전체 데이터 중에서 2페이지 에서 10개: 10~19번까지
-- 2페이지 일 경우 시작값이 10이 되려면 (page -1) *10

-- 전체 데이터 중에서 3페이지 에서 10개: 20~29번까지
-- 2페이지 일 경우 시작값이 10이 되려면 (page -1) *10


-- 처음 시작에서 10개를 건너 뛰고 : OFFSET 10
-- 그 위치부터 10개를 SELECT 하라
SELECT * FROM tbl_books
ORDER BY B_CODE
limit 10 OFFSET 1;




