create table kanji_symbol
(
    id  bigint auto_increment primary key,
    symbol varchar(16) not null,
    reading_on varchar(64) not null,
    reading_kun varchar(64) not null,
    meaning varchar(64) not null,
    example_sentence varchar(128) not null,
    example_sentence_translation varchar(128) not null,
    jlpt_level int not null,
    created_at DATETIME,
    updated_at DATETIME
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table user
(
    id bigint auto_increment primary key,
    username varchar(32) not null,
    password varchar(32) not null,
    email varchar(32) not null,
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
