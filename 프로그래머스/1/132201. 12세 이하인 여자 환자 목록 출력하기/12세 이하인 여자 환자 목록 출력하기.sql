-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') AS TLNO# AS TLNO는 IFNULL(TLNO, 'NONE')결과의 별칭. 이 상황에서는 없어도 된다.
FROM PATIENT#어느 테이블로부터
WHERE AGE <= 12 AND GEND_CD = 'W'#조건문
ORDER BY AGE DESC, PT_NAME# 결과를 나이의 내침차순으로. 이후 
