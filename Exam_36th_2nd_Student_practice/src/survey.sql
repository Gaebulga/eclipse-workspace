-- ���̺� �� ������ ��ü ����
drop SEQUENCE SEQ_SURVEY;
drop SEQUENCE SEQ_QUESTION;
drop SEQUENCE SEQ_ANSWER;

drop TABLE SCIT_ANSWER;
drop TABLE SCIT_QUESTION;
drop TABLE SCIT_SURVEY ;
drop TABLE SCIT_MEMBER ;

-- �Ʒ� ����ִ� �κп�  ���̺��̳� �������� �� �ۼ��ϴ� ������ �ϼ��Ͻÿ�

CREATE TABLE SCIT_MEMBER 
(
	EMAIL	VARCHAR2(20)	PRIMARY KEY,
	PASSWORD VARCHAR2(30)	NOT NULL
);
	
-- ��� ���� �Է��� ��
INSERT INTO SCIT_MEMBER VALUES ('admin@scit.co.kr', 'aaaa');

COMMIT;

-- (1)	������ ���� ���� (���̺�� : SCIT_SURVEY )

	-- code here

-- (2)	���� ���� ���̺��� �Ϸù�ȣ�� ����� �������� : SEQ_SURVEY

	-- code here
	
-- (3)	���� ���� (���̺�� : SCIT_QUESTION )

	-- code here
	
-- (4)	���� ���� ���̺��� �Ϸù�ȣ�� ����� �������� : SEQ_QUESTION

	-- code here

-- (5)	����ڵ��� �亯 ���� (���̺�� : SCIT_ANSWER )

	-- code here

-- (6)	���� ���� ���̺��� �Ϸù�ȣ�� ����� �������� : SEQ_ANSWER 

	-- code here



	

	


