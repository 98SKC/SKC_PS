-- 코드를 입력하세요
SELECT MEMBER_ID,MEMBER_NAME,GENDER,DATE_FORMAT(DATE_OF_BIRTH,"%Y-%m-%d")
FROM MEMBER_PROFILE
WHERE MONTH(DATE_OF_BIRTH)=3 AND GENDER='W' AND NOT TLNO IS NULL
ORDER BY MEMBER_ID