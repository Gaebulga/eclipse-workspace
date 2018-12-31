-- 테이블 및 시퀀스 객체 삭제
drop SEQUENCE SEQ_SURVEY;
drop SEQUENCE SEQ_QUESTION;
drop SEQUENCE SEQ_ANSWER;

drop TABLE SCIT_ANSWER;
drop TABLE SCIT_QUESTION;
drop TABLE SCIT_SURVEY ;
drop TABLE SCIT_MEMBER ;

-- 아래 비어있는 부분에  테이블이나 시퀀스를 을 작성하는 쿼리를 완성하시오

CREATE TABLE SCIT_MEMBER 
(
	EMAIL	VARCHAR2(20)	PRIMARY KEY,
	PASSWORD VARCHAR2(30)	NOT NULL
);
	
-- 멤버 정보 입력할 것
INSERT INTO SCIT_MEMBER VALUES ('admin@scit.co.kr', 'aaaa');

COMMIT;

-- (1)	주제별 설문 정보 (테이블명 : SCIT_SURVEY )

	-- code here

-- (2)	설문 정보 테이블의 일련번호에 사용할 시퀀스명 : SEQ_SURVEY

	-- code here
	
-- (3)	질문 정보 (테이블명 : SCIT_QUESTION )

	-- code here
	
-- (4)	질문 정보 테이블의 일련번호에 사용할 시퀀스명 : SEQ_QUESTION

	-- code here

-- (5)	사용자들의 답변 정보 (테이블명 : SCIT_ANSWER )

	-- code here

-- (6)	질문 정보 테이블의 일련번호에 사용할 시퀀스명 : SEQ_ANSWER 

	-- code here



	

	


