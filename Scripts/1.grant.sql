SELECT USER FROM dual;

CREATE USER spring_mybatis IDENTIFIED BY rootroot;

GRANT CONNECT, resource, CREATE synonym, CREATE VIEW TO spring_mybatis;

SELECT * FROM DBA_USERS WHERE username='spring_mybatis';