insert into Course(id, name,created_Date, updated_Date,is_deleted) values(10001,'jpa in 50 steps',sysdate(),sysdate(),false);
insert into Course(id, name,created_Date, updated_Date,is_deleted) values(10002,'spring in 50 steps',sysdate(),sysdate(),false);
insert into Course(id, name,created_Date, updated_Date,is_deleted) values(10003,'backbone in 50 steps',sysdate(),sysdate(),false);
insert into Course(id, name,created_Date, updated_Date,is_deleted) values(10004,'finance in 50 steps',sysdate(),sysdate(),false);

insert into passport(id, number) values(30001,'E12345');
insert into passport(id, number) values(30002,'S34678');
insert into passport(id, number) values(30003,'N67865');

insert into Student(id, name,passport_Id) values(20001,'Snehal',30003);
insert into Student(id, name,passport_Id) values(20002,'Sanket',30001);
insert into Student(id, name, passport_Id) values(20003,'Vaidehi',30002);



insert into review(id, rating,description,course_Id,student_id) values(40001,'FIVE','wonderful',10001,20001);
insert into review(id, rating,description,course_Id,student_id) values(40002,'FOUR','Awesome',10001,20003);
insert into review(id, rating,description,course_Id,student_id) values(40003,'THREE','Good',10003,20001);

insert into student_course(student_Id,course_Id) values(20001,10001);
insert into student_course(student_Id,course_Id) values(20002,10001);
insert into student_course(student_Id,course_Id) values(20003,10001);
insert into student_course(student_Id,course_Id) values(20001,10003);

