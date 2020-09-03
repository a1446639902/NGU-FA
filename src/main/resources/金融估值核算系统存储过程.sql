-- 金融估值核算系统的存储过程
create or replace package pkg_tables
is
    --创建查询的存储过程
    -- p_tableName  表名（一张表直接传表名，多张表自己拼接sql）
    -- 括号一定要带 例如：（select * from dept join EMP E on DEPT.DEPTNO = E.DEPTNO）
    -- p_condition  查询的条件（自己拼接过来）
    -- p_pageSize 每页显示的条数
    -- p_page  查询的页面
    -- p_count 总条数（输出参数）
    -- p_cursor 返回的游标 （输出参数）
    procedure sp_select(p_tableName varchar2, p_condition varchar2, p_pageSize number, p_page number,p_count out number,p_cursor out sys_refcursor);

end pkg_tables;


create or replace package body pkg_tables
is
    --创建查询的存储过程
    procedure sp_select(p_tableName varchar2, p_condition varchar2, p_pageSize number, p_page number,p_count out number,p_cursor out sys_refcursor)
    is
        v_sql varchar2(1000):='select * from (select rownum as rn,d.* from(select * from '|| p_tableName || ' where 1=1';
        v_sql2 varchar2(500) := 'select count(*) from (select * from '|| p_tableName || ' where 1=1 ';
    begin
        if p_condition is not null or p_condition !='' then
            v_sql := v_sql || p_condition;
            v_sql2 := v_sql2 || p_condition;
        end if;
        v_sql := v_sql || ') d where rownum<='|| p_page*p_pageSize ||') where rn>'|| (p_page-1)*p_pageSize ;
        v_sql2 := v_sql2 || ')';
        open p_cursor for v_sql;
        EXECUTE IMMEDIATE v_sql2 INTO p_count;
        DBMS_OUTPUT.PUT_LINE(p_count);
        DBMS_OUTPUT.PUT_LINE(v_sql);
        DBMS_OUTPUT.PUT_LINE(v_sql2);
    exception
        when others then
        DBMS_OUTPUT.PUT_LINE(sqlerrm);
    end sp_select;
end pkg_tables;

-- 测试存储过程
declare
    p_tableName varchar2(300) :='(select * from dept join EMP E on DEPT.DEPTNO = E.DEPTNO)';
    p_condition varchar2(300) :=' and eName like ''%S%''';
    p_count number;
    v_cursor sys_refcursor;
    -- 定义显示游标
    cursor v_cursor1 is select ROWNUM rn,d.* from dept d;
    -- 定义行变量
    v_dept v_cursor1%rowtype;
begin
    pkg_tables.sp_select(p_tableName,p_condition,3,1,p_count,v_cursor);
    /*loop
       fetch v_cursor into v_dept;
       exit when v_cursor%notfound;
       DBMS_OUTPUT.PUT_LINE(v_dept.DNAME);
    end loop;*/
    DBMS_OUTPUT.PUT_LINE(p_count);
end;

-- 测试获取的sql 语句
select * from (select rownum as rn,d.* from(select * from (select * from dept join EMP E on DEPT.DEPTNO = E.DEPTNO) where 1=1) d where rownum<=3) where rn>0;

select count(*) from (select * from (select * from dept join EMP E on DEPT.DEPTNO = E.DEPTNO) where 1=1  and ENAME like '%S%');