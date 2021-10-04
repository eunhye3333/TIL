ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER SQLD IDENTIFIED BY 1234;
ALTER USER SQLD ACCOUNT UNLOCK;
GRANT RESOURCE, DBA, CONNECT TO SQLD;

CREATE TABLESPACE SQLD_DATA
DATAFILE 'C:\app\na\product\18.0.0\oradata\XE\SQLD_DATA.dbf' SIZE 4G
AUTOEXTEND ON NEXT 512M MAXSIZE UNLIMITED
LOGGING
ONLINE
PERMANENT
EXTENT MANAGEMENT LOCAL AUTOALLOCATE
BLOCKSIZE 8K
SEGMENT SPACE MANAGEMENT AUTO
FLASHBACK ON;

CREATE TEMPORARY TABLESPACE SQLD_TEMP
TEMPFILE 'C:\app\na\product\18.0.0\oradata\XE\SQLD_TEMP.dbf' SIZE 1G
AUTOEXTEND ON NEXT 100M MAXSIZE UNLIMITED;

ALTER USER SQLD DEFAULT TABLESPACE SQLD_DATA; -- SQLD 계정으로 접속하여 생성하는 테이블이 SQLD_DATA 내에 생성됨
ALTER USER SQLD TEMPORARY TABLESPACE SQLD_TEMP; -- SQLD 계정이 SQL 작업을 할 때 SQLD_TEMP를 이용
