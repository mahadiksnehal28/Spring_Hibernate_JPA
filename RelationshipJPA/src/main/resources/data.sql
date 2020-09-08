insert into Course(id, name,created_Date, updated_Date) values(10001,'jpa in 50 steps',sysdate(),sysdate());
insert into Course(id, name,created_Date, updated_Date) values(10002,'spring in 50 steps',sysdate(),sysdate());
insert into Course(id, name,created_Date, updated_Date) values(10003,'backbone in 50 steps',sysdate(),sysdate());

insert into passport(id, number) values(30001,'E12345');
insert into passport(id, number) values(30002,'S34678');
insert into passport(id, number) values(30003,'N89665');

insert into Student(id, name,passport_Id) values(20001,'Snehal',30003);
insert into Student(id, name,passport_Id) values(20002,'Sanket',30001);
insert into Student(id, name, passport_Id) values(20003,'Vaidehi',30002);



insert into review(id, rating,description) values(40001,5,'wonderful');
insert into review(id, rating,description) values(40002,4,'Awesome');
insert into review(id, rating,description) values(40003,3.5,'Good');

