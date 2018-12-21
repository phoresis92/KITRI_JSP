CREATE OR REPLACE FUNCTION fn_getrank(ar_sal emp.sal%TYPE, ar_comm emp.comm%TYPE)
RETURN salgrade.grade%TYPE
IS
-- sal, comm 더한 값 -> WHERE 조건 합계 금액
v_sum emp.sal%TYPE := NVL(ar_sal,0) + NVL(ar_comm,0);
-- 등급을 반환할 수 있도록 등급 변수 생성
v_rank salgrade.grade%TYPE;

BEGIN
SELECT grade
INTO v_rank
FROM salgrade
WHERE v_sum BETWEEN losal AND hisal;

RETURN v_rank;

END;

