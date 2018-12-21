--사원번호를 입력받아 해당 내용을 출력할 수 있도록 하시오.
--CASE 1 -> 사원번호가 존재할 시
-- CASE 1-1 -> 사원번호가 존재하며, MGR 이 없음
-- OUTPUT : 사원번호 XXXX는 ㅁㅁㅁ이며, 메니져는 없습니다.
-- CASE 1-2 -> 사원번호가 존재하며, MGR 이 있을시
-- OUTPUT : 사원번호 XXXX는 ㅁㅁㅁ이며, 메니져는 ㅁㅁㅁ 입니다.
--CASE 2 -> 사원번호가 존재하지 않을 시
-- OUTPUT : 해당 사원번호가 존재하지 않습니다.
-- GETMGR2(NUMBER 4자리);
-- PROCEDURE 생성
-- -> 외부사용자로부터 사원번호 입력 받을 수 있도록 구성
CREATE OR REPLACE PROCEDURE getmgr2(ar_empno IN emp.empno%TYPE)
IS 
-- 변수 선언해서 관리
-- 1. 사원 명수 관련 변수
v_emp_cnt NUMBER := 0;
-- 2. 입력 사원번호 관련 변수
v_empno emp.empno%type := ar_empno;
-- TEST 변수
-- 7. 사원이름, 메니져 이름 입력 관련 변수
v_ename emp.ename%type;
v_mname emp.ename%type;

BEGIN
-- 3. 사원 명수 검색 후 셋팅(v_emp_cnt 결과값 세팅)
SELECT COUNT(*) 
INTO v_emp_cnt
FROM emp
WHERE empno = v_empno;

-- v_emp_cnt 값이 세팅이 된다.
-- v_emp_cnt = 0 -> 검색된 사원이 없다.
-- v_emp_cnt > 0 -> 검색된 사원이 존재한다.
-- 4. 검색 결과 유무에 따라서 사원번호 없을 시 결과 출력
IF v_emp_cnt = 0 THEN
--CASE 2 -> 사원번호가 존재하지 않을 시
-- 5. 출력
    DBMS_OUTPUT.PUT_LINE('해당 사원번호가 존재하지 않습니다.');
--CASE 1 -> 사원번호가 존재할 시
ELSE
-- 6. MGR 여부를 확인할 수 있도록 구성 필요
-- 사원 이름(v_ename)과 메니져 이름(v_mname)을 세팅
    SELECT e.ename, m.ename
    INTO v_ename, v_mname
    FROM emp e, emp m
    WHERE e.mgr = m.empno(+)
    AND e.empno = v_empno;    
-- CASE 1-1 -> 사원번호가 존재하며, MGR 이 없음
-- OUTPUT : 사원번호 XXXX는 ㅁㅁㅁ이며, 메니져는 없습니다.
    IF v_mname IS NULL THEN
    DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_ename || ' 없음');
-- CASE 1-2 -> 사원번호가 존재하며, MGR 이 있을시
-- OUTPUT : 사원번호 XXXX는 ㅁㅁㅁ이며, 메니져는 ㅁㅁㅁ 입니다.
    ELSE
    DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_ename || ' ' || v_mname);
    -- CASE 1 IF (사원번호 조회 될 시 케이스)
    END IF;   
-- CASE 2 IF (사원번호 조회 안될 시 케이스)
END IF;
END;
