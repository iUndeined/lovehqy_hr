drop table if exists T_EMPLOYEE;

drop table if exists T_JUDGEMENT;

drop table if exists T_LEAVE;

drop table if exists T_WORK_SCHEDULING;

/*==============================================================*/
/* Table: T_EMPLOYEE                                            */
/*==============================================================*/
create table T_EMPLOYEE
(
   id                   int not null auto_increment,
   name                 varchar(8),
   join_date            datetime,
   created_date         datetime,
   status               int default 1 comment '{1: 在职, 0: 离职}',
   primary key (id)
);

alter table T_EMPLOYEE comment '员工/雇员表';

/*==============================================================*/
/* Table: T_JUDGEMENT                                           */
/*==============================================================*/
create table T_JUDGEMENT
(
   id                   int not null auto_increment,
   jug_date             datetime,
   jug_status           int comment '{正常: 0, 迟到: 1, 早退: 2, 旷工: 3, 请假: 4, 调班: 5}',
   jug_man_id           int,
   jug_man_name         varchar(8),
   jug_value            double comment '除了请假其它事件单位都为分钟
            {迟到: 多少分钟, 早退: 多少分,旷工: 多少分钟, 请假: 多少小时0就是全天}',
   remark               varchar(1024) comment '事由/说明/备注',
   creaed_date          datetime,
   primary key (id)
);

alter table T_JUDGEMENT comment '考勤表';

/*==============================================================*/
/* Table: T_LEAVE                                               */
/*==============================================================*/
create table T_LEAVE
(
   id                   int not null auto_increment,
   leave_man_id         int,
   leave_man_name       varchar(8),
   leave_days           int,
   leave_hours          int,
   created_date         datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: T_WORK_SCHEDULING                                     */
/*==============================================================*/
create table T_WORK_SCHEDULING
(
   id                   int not null auto_increment,
   work_man             int,
   work_man_name        varchar(8),
   work_date            date,
   created_date         datetime,
   primary key (id)
);
