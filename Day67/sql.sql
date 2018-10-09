#学生表
create table student(
id int primary key auto_increment,
name varchar(20) not null,
age int not null,
cid int not null
);

#班级表
create table classtab(
id int primary key auto_increment,
cname varchar(20) not null,
cnumber int not null
)

#课程表
create table course(
id int primary key auto_increment,
coursename varchar(20) not null
)

create table middle_student_course(
sid int,
cid int,
primary key(sid, cid)
)

insert into classtab values(null, '一年一班', 0),(null, '一年二班', 0),(null, '一年三班', 0)
insert into student values(null, '小明', 5, 1),(null, '小红', 5, 1),(null, '小刚', 5, 2)
		,(null, '小白', 5, 3),(null, '小黑', 5, 3)
insert into course values(null, 'Java'),(null, 'mysql'),(null, 'c++')
insert into middle_student_course values(1,1),(1,2),(1,3),(2,2),(2,3),(3,1),(3,3)

#查询所有班级 - 查询所有学生 - 每个学生的选课 - 一条sql语句
		
		
select * from student s join classtab c on s.cid = c.id where s.id = 3
select * from classtab c join student s on s.cid = c.id


select c.id, c.cname, c.cnumber, s.id as sid, s.name, s.age, m.cid, cs.coursename  from classtab c 
	left join student s on s.cid = c.id
	left join middle_student_course m on s.id = m.sid
	left join course cs on cs.id = m.cid

#批量删除 1 2 5 8
delete from xxx where id in (1,2,5,8)


select * from student where 1=1


#存储过程的调用 -- 存储过程
#什么是存储过程？ - 存储过程就是一组sql语句集，存储过程是执行在数据库端
#存储过程的缺点 - 移植性差

#mysql存储过程的写法
#参数：[in|out|inout] 参数名 参数类型

delimiter $$
create procedure myprcedure(in p_id int)
begin
    select * from student where id = p_id;    
end $$
delimiter ;

#存储过程的调用
call myprcedure(6);


#有返回值的存储过程
delimiter $$
create procedure myprcedure2(in p_id int, out p_name varchar(20))
begin
    select name into p_name from student where id = p_id;    
end $$
delimiter ;

#用户变量 - @a @@a
call myprcedure2(6, @a);
select @a;


delimiter $$
create procedure myprcedure3(in p_name varchar(20), in p_age int, in p_cid int)
begin
    insert into student value(null, p_name, p_age, p_cid);
end $$
delimiter ;
















