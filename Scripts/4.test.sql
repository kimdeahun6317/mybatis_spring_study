SELECT DEPTNO,DEPTNAME,FLOOR FROM DEPARTMENT;
SELECT * FROM EMPLOYEE;

SELECT USER FROM dual;

UPDATE DEPARTMENT 
	SET DEPTNAME = '마케팅2'
	 	FLOOR = 10
	WHERE DEPTNO =5;
	
DELETE FROM DEPARTMENT
	WHERE DEPTNO =5;
	
SELECT DEPTNO,DEPTNAME,FLOOR FROM DEPARTMENT WHERE DEPTNO =1;