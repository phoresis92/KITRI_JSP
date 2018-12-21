--�����ȣ�� �Է¹޾� �ش� ������ ����� �� �ֵ��� �Ͻÿ�.
--CASE 1 -> �����ȣ�� ������ ��
-- CASE 1-1 -> �����ȣ�� �����ϸ�, MGR �� ����
-- OUTPUT : �����ȣ XXXX�� �������̸�, �޴����� �����ϴ�.
-- CASE 1-2 -> �����ȣ�� �����ϸ�, MGR �� ������
-- OUTPUT : �����ȣ XXXX�� �������̸�, �޴����� ������ �Դϴ�.
--CASE 2 -> �����ȣ�� �������� ���� ��
-- OUTPUT : �ش� �����ȣ�� �������� �ʽ��ϴ�.
-- GETMGR2(NUMBER 4�ڸ�);
-- PROCEDURE ����
-- -> �ܺλ���ڷκ��� �����ȣ �Է� ���� �� �ֵ��� ����
CREATE OR REPLACE PROCEDURE getmgr2(ar_empno IN emp.empno%TYPE)
IS 
-- ���� �����ؼ� ����
-- 1. ��� ��� ���� ����
v_emp_cnt NUMBER := 0;
-- 2. �Է� �����ȣ ���� ����
v_empno emp.empno%type := ar_empno;
-- TEST ����
-- 7. ����̸�, �޴��� �̸� �Է� ���� ����
v_ename emp.ename%type;
v_mname emp.ename%type;

BEGIN
-- 3. ��� ��� �˻� �� ����(v_emp_cnt ����� ����)
SELECT COUNT(*) 
INTO v_emp_cnt
FROM emp
WHERE empno = v_empno;

-- v_emp_cnt ���� ������ �ȴ�.
-- v_emp_cnt = 0 -> �˻��� ����� ����.
-- v_emp_cnt > 0 -> �˻��� ����� �����Ѵ�.
-- 4. �˻� ��� ������ ���� �����ȣ ���� �� ��� ���
IF v_emp_cnt = 0 THEN
--CASE 2 -> �����ȣ�� �������� ���� ��
-- 5. ���
    DBMS_OUTPUT.PUT_LINE('�ش� �����ȣ�� �������� �ʽ��ϴ�.');
--CASE 1 -> �����ȣ�� ������ ��
ELSE
-- 6. MGR ���θ� Ȯ���� �� �ֵ��� ���� �ʿ�
-- ��� �̸�(v_ename)�� �޴��� �̸�(v_mname)�� ����
    SELECT e.ename, m.ename
    INTO v_ename, v_mname
    FROM emp e, emp m
    WHERE e.mgr = m.empno(+)
    AND e.empno = v_empno;    
-- CASE 1-1 -> �����ȣ�� �����ϸ�, MGR �� ����
-- OUTPUT : �����ȣ XXXX�� �������̸�, �޴����� �����ϴ�.
    IF v_mname IS NULL THEN
    DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_ename || ' ����');
-- CASE 1-2 -> �����ȣ�� �����ϸ�, MGR �� ������
-- OUTPUT : �����ȣ XXXX�� �������̸�, �޴����� ������ �Դϴ�.
    ELSE
    DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_ename || ' ' || v_mname);
    -- CASE 1 IF (�����ȣ ��ȸ �� �� ���̽�)
    END IF;   
-- CASE 2 IF (�����ȣ ��ȸ �ȵ� �� ���̽�)
END IF;
END;
