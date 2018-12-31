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
		create table SCIT_SURVEY(
            SURVEY_ID NUMBER PRIMARY KEY,
            TITLE varchar2(200) NOT NULL,
            STARTDATE date DEFAULT SYSDATE NOT NULL,
            ENDDATE date NOT NULL
        );

-- (2)	설문 정보 테이블의 일련번호에 사용할 시퀀스명 : SEQ_SURVEY

	-- code here
		create SEQUENCE SEQ_SURVEY
        start with 1
        INCREMENT by 1;		

-- (3)	질문 정보 (테이블명 : SCIT_QUESTION )

	-- code here
		create table SCIT_QUESTION (
            QUESTION_ID NUMBER PRIMARY KEY,
            SURVEY_ID NUMBER,
            QUESTION VARCHAR2(200) NOT NULL,
            ANSWER1 VARCHAR2(100) NOT NULL,
            ANSWER2 VARCHAR2(100) NOT NULL,
            ANSWER3 VARCHAR2(100) NOT NULL,
            ANSWER4 VARCHAR2(100) NOT NULL,
            ANSWER5 VARCHAR2(100) NOT NULL,
            CONSTRAINT SCIT_QUESTION_SURVEY_ID_FK FOREIGN KEY(SURVEY_ID)
            REFERENCES SCIT_SURVEY(SURVEY_ID)
            
        );
-- (4)	질문 정보 테이블의 일련번호에 사용할 시퀀스명 : SEQ_QUESTION

	-- code here
		create SEQUENCE SEQ_QUESTION
        start with 1
        INCREMENT by 1;
        
-- (5)	사용자들의 답변 정보 (테이블명 : SCIT_ANSWER )

	-- code here
		create table SCIT_ANSWER(
            ANSWER_ID NUMBER PRIMARY KEY,
            EMAIL VARCHAR2(20),
            SURVEY_ID NUMBER NOT NULL,
            QUESTION_ID NUMBER NOT NULL,
            ANSWER NUMBER(1) NOT NULL,
            
             CONSTRAINT SCIT_ANSWER_SURVEY_ID_FK FOREIGN KEY(SURVEY_ID)
            REFERENCES SCIT_SURVEY(SURVEY_ID),
            
             CONSTRAINT SCIT_ANSWER_QUESTION_ID_FK FOREIGN KEY(QUESTION_ID)
            REFERENCES SCIT_QUESTION(QUESTION_ID)
        );
        
-- (6)	질문 정보 테이블의 일련번호에 사용할 시퀀스명 : SEQ_ANSWER 

	-- code here
		create SEQUENCE SEQ_ANSWER
        start with 1
        INCREMENT by 1;


	

	



