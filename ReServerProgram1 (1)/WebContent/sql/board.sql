 DROP TABLE REPLY;
 DROP TABLE BOARD;
 
 CREATE TABLE BOARD
    (

    NO NUMBER, 

    AUTHOR VARCHAR2(50), 

    TITLE VARCHAR2(2000) NOT NULL, 

    CONTENT VARCHAR2(4000), 

    HIT NUMBER,  

    IP VARCHAR2(20),  

    POSTDATE DATE 

    );



    CREATE TABLE REPLY

    (

    NO NUMBER,  -- 댓글번호

    AUTHOR VARCHAR2(50),  -- 작성자

    CONTENT VARCHAR2(4000),  -- 내용

    IP VARCHAR2(20),  -- 작성자IP

    BOARD_NO NUMBER,  -- 원글의 번호

    POSTDATE DATE  -- 작성일 

    );

    -- 기본키

    ALTER TABLE BOARD ADD CONSTRAINT BOARD_PK PRIMARY KEY(NO);

    ALTER TABLE REPLY ADD CONSTRAINT REPLY_PK PRIMARY KEY(NO);

    -- 외래키

    ALTER TABLE REPLY ADD CONSTRAINT REPLY_BOARD_FK FOREIGN KEY(BOARD_NO) REFERENCES BOARD(NO);

    -- 시퀀스

    DROP SEQUENCE BOARD_SEQ;

    DROP SEQUENCE REPLY_SEQ;

    CREATE SEQUENCE BOARD_SEQ INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;

    CREATE SEQUENCE REPLY_SEQ INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;

    -- 데이터

    INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '스미스', '궁금합니다', '등업 기준이 어떻게 되죠?', 5, '127.0.0.1', SYSDATE);

    INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '데이빗', '가입 인사 드려요', '잘 부탁드립니다', 15, '127.0.0.1', SYSDATE);

    INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '제시카', '나눔합니다', '빨리 오는 분 선착순', 3, '127.0.0.1', SYSDATE);

    INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '에밀리', '책 드려요', '책 드림합니다', 10, '127.0.0.1', SYSDATE);

    INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, '엠마', '출석입니다', '출석!', 2, '127.0.0.1', SYSDATE);

    COMMIT