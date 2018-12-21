create table memtest(
name varchar2(20),
birth varchar2(15),
gender varchar2(3) constraint memtest_gender_ck check(gender='M' or gender='F'),
front_num varchar2(5) constraint memtest_fn_nn not null,
mid_num varchar2(10) constraint memtest_mn_nn not null,
last_num varchar2(10) constraint memtest_ln_nn not null,
phone varchar2(20) constraint memtest_phone_pk primary key,
indate date default sysdate
);