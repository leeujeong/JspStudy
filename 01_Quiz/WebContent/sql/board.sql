/*table*/
DROP TABLE board;
CREATE TABLE board(
	idx 		NUMBER,
	title 		VARCHAR(20),
	writer		VARCHAR(20),
	content 	VARCHAR(50),
	register	VARCHAR(25),
	PRIMARY KEY(idx)
);
/*sequence*/
DROP SEQUENCE board_seq;
CREATE SEQUENCE board_seq INCREMENT BY 1 START WITH 1000 NOCYCLE NOCACHE;

/*insert*/
INSERT INTO BOARD VALUES (board_seq.nextval, '인사', '이유정','안녕하세요',SYSDATE);