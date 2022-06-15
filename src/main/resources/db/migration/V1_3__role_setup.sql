Drop table user_kanji;
Drop table user;

create table user
(
    id bigint auto_increment primary key,
    username varchar(32) not null,
    password varchar(100) not null,
    email varchar(32) not null,
    role varchar(20),
    created_at DATETIME,
    updated_at DATETIME
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_kanji
(
    id bigint auto_increment primary key,
    kanji_id bigint not null,
    user_id  bigint not null,
    foreign key (kanji_id) references kanji_symbol (id),
    foreign key (user_id) references user (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table role
(
    id  bigint auto_increment primary key,
    role varchar(20) not null unique
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_role
(
    id bigint auto_increment primary key,
    role_id bigint       not null,
    user_id    bigint       not null,

    foreign key (role_id) references role (id),
    foreign key (user_id) references user (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;