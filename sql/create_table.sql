-- auto-generated definition
create table user
(
    id           bigint                             not null comment '用户'
        primary key,
    username     varchar(256)                       null,
    userAccount  varchar(256)                       null comment '用户账号',
    userPassword varchar(512)                       not null comment '用户密码',
    avatarUrl    varchar(1024)                      null comment '头像',
    gender       tinyint                            null comment '性别',
    phone        varchar(128)                       null comment '电话',
    email        varchar(512)                       null comment '邮箱',
    userStatus   int      default 0                 null comment '用户状态 0-正常',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null comment '更新时间',
    isDelete     tinyint  default 0                 not null comment '是否删除',
    userRole     int      default 0                 not null comment '角色 0-普通用户 1-管理员'
);
