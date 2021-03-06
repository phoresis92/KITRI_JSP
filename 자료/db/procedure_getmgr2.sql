--紫据腰硲研 脊径閤焼 背雁 鎧遂聖 窒径拝 呪 赤亀系 馬獣神.
--CASE 1 -> 紫据腰硲亜 糎仙拝 獣
-- CASE 1-1 -> 紫据腰硲亜 糎仙馬悟, MGR 戚 蒸製
-- OUTPUT : 紫据腰硲 XXXX澗 けけけ戚悟, 五艦閃澗 蒸柔艦陥.
-- CASE 1-2 -> 紫据腰硲亜 糎仙馬悟, MGR 戚 赤聖獣
-- OUTPUT : 紫据腰硲 XXXX澗 けけけ戚悟, 五艦閃澗 けけけ 脊艦陥.
--CASE 2 -> 紫据腰硲亜 糎仙馬走 省聖 獣
-- OUTPUT : 背雁 紫据腰硲亜 糎仙馬走 省柔艦陥.
-- GETMGR2(NUMBER 4切軒);
-- PROCEDURE 持失
-- -> 須採紫遂切稽採斗 紫据腰硲 脊径 閤聖 呪 赤亀系 姥失
CREATE OR REPLACE PROCEDURE getmgr2(ar_empno IN emp.empno%TYPE)
IS 
-- 痕呪 識情背辞 淫軒
-- 1. 紫据 誤呪 淫恵 痕呪
v_emp_cnt NUMBER := 0;
-- 2. 脊径 紫据腰硲 淫恵 痕呪
v_empno emp.empno%type := ar_empno;
-- TEST 痕呪
-- 7. 紫据戚硯, 五艦閃 戚硯 脊径 淫恵 痕呪
v_ename emp.ename%type;
v_mname emp.ename%type;

BEGIN
-- 3. 紫据 誤呪 伊事 板 実特(v_emp_cnt 衣引葵 室特)
SELECT COUNT(*) 
INTO v_emp_cnt
FROM emp
WHERE empno = v_empno;

-- v_emp_cnt 葵戚 室特戚 吉陥.
-- v_emp_cnt = 0 -> 伊事吉 紫据戚 蒸陥.
-- v_emp_cnt > 0 -> 伊事吉 紫据戚 糎仙廃陥.
-- 4. 伊事 衣引 政巷拭 魚虞辞 紫据腰硲 蒸聖 獣 衣引 窒径
IF v_emp_cnt = 0 THEN
--CASE 2 -> 紫据腰硲亜 糎仙馬走 省聖 獣
-- 5. 窒径
    DBMS_OUTPUT.PUT_LINE('背雁 紫据腰硲亜 糎仙馬走 省柔艦陥.');
--CASE 1 -> 紫据腰硲亜 糎仙拝 獣
ELSE
-- 6. MGR 食採研 溌昔拝 呪 赤亀系 姥失 琶推
-- 紫据 戚硯(v_ename)引 五艦閃 戚硯(v_mname)聖 室特
    SELECT e.ename, m.ename
    INTO v_ename, v_mname
    FROM emp e, emp m
    WHERE e.mgr = m.empno(+)
    AND e.empno = v_empno;    
-- CASE 1-1 -> 紫据腰硲亜 糎仙馬悟, MGR 戚 蒸製
-- OUTPUT : 紫据腰硲 XXXX澗 けけけ戚悟, 五艦閃澗 蒸柔艦陥.
    IF v_mname IS NULL THEN
    DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_ename || ' 蒸製');
-- CASE 1-2 -> 紫据腰硲亜 糎仙馬悟, MGR 戚 赤聖獣
-- OUTPUT : 紫据腰硲 XXXX澗 けけけ戚悟, 五艦閃澗 けけけ 脊艦陥.
    ELSE
    DBMS_OUTPUT.PUT_LINE(v_empno || ' ' || v_ename || ' ' || v_mname);
    -- CASE 1 IF (紫据腰硲 繕噺 吃 獣 追戚什)
    END IF;   
-- CASE 2 IF (紫据腰硲 繕噺 照吃 獣 追戚什)
END IF;
END;
