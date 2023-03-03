#电子书表
drop table if exists `ebook`;
create table `ebook`(
    `id` bigint not null comment 'id',
    `name` varchar(50) comment '名称',
    `category1_id` bigint comment '分类1',
    `category2_id` bigint comment '分类2',
    `description` varchar(200) comment '描述',
    `cover` varchar(200) comment '封面',
    `doc_count` int comment '文档数',
    `view_count` int comment '阅读数',
    `vote_count` int comment '点赞数',
    primary key (`id`)
)engine=innodb default charset=utf8mb4 comment='电子书';

insert into `ebook` (id,name,description) values (1,'C语言编程','大一内容，初学编程');
insert into `ebook` (id,name,description) values (2,'MATLAB与数学建模','大二内容，参加竞赛');
insert into `ebook` (id,name,description) values (3,'C++编程','大三内容，面向对象');
insert into `ebook` (id,name,description) values (4,'Java编程','大四内容，用于毕设');
insert into `ebook` (id,name,description) values (5,'机器学习与深度学习','研究生入学考试需要');

#增加test表
drop table if exists `test`;
create table `test`(
                       `id` bigint not null comment 'id',
                       `name`varchar(50) comment '名称',
                       `password`varchar(50) comment '密码',
                       primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='测试';

insert into `test` (id, name, password) values (1, '测试1', 'password');


#增加demo表
drop table if exists `demo`;
create table `demo`(
    `id` bigint not null comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
) engine =innodb default charset=utf8mb4 comment ='测试';

insert into `demo` (id, name) values (1,'测试');

