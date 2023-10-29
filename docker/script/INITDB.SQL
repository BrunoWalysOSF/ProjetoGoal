DROP DATABASE osf;
CREATE DATABASE osf;
USE osf;

create table last_avaliation
(
    id   int auto_increment
        primary key,
    nota varchar(255) null
);

create table priority
(
    id    int auto_increment
        primary key,
    nivel varchar(255) null
);

create table type_study_recomendation
(
    id   int auto_increment
        primary key,
    type varchar(255) not null
);

create table user
(
    id       int auto_increment
        primary key,
    email    varchar(255) not null,
    name     varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null
);

create table assessment
(
    id                 int auto_increment
        primary key,
    dt_next_assessment date null,
    last_avaliation    int  null,
    user_id            int  null,
    constraint FK3ktvh6y5qdyvfwod0dfj8ej0h
        foreign key (last_avaliation) references last_avaliation (id),
    constraint FKi3gskegxme91qm3uf5l2kuyd7
        foreign key (user_id) references user (id)
);

create table goal
(
    id            int auto_increment
        primary key,
    description   varchar(2000) null,
    expired_date  date         not null,
    linked_review bit          null,
    name          varchar(255) not null,
    progress      int          null,
    start_date    date         not null,
    user_id       int          null,
    priority      int          null,
    constraint FKcxjbtjym9cn3ud0exw1qa39lm
        foreign key (user_id) references user (id),
    constraint FKdv26546uwue5r395n2v2vbphp
        foreign key (priority) references priority (id)
);

create table achieve_goal
(
    id          int auto_increment
        primary key,
    description varchar(2000) null,
    name        varchar(255) not null,
    progress    int          null,
    goal_id     int          null,
    constraint FK5e8ug42n2uf7381xpwn0klmre
        foreign key (goal_id) references goal (id)
);

create table study_recomendation
(
    id          int auto_increment
        primary key,
    description varchar(2000) null,
    achieve_id  int          null,
    type_id     int          null,
    constraint FK6bb3dp55feljooh42cky2qp1r
        foreign key (achieve_id) references achieve_goal (id),
    constraint FKlj9reo231h87mddbmpp1bg6ab
        foreign key (type_id) references type_study_recomendation (id)
);

# Tabela "last_avaliation":

INSERT INTO last_avaliation (nota)
VALUES
    ('5 stars - Outstanding'),
    ('4 stars - Excellent'),
    ('3 stars - Satisfactory'),
    ('2 stars - Needs improvement'),
    ('1 star - Unsatisfactory');

# Tabela "priority":

INSERT INTO priority (nivel)
VALUES
    ('High'),
    ('Medium'),
    ('Low');

# Tabela "type_study_recomendation":

INSERT INTO type_study_recomendation (id,type) VALUES (1, 'COURSES');
INSERT INTO type_study_recomendation (id,type) VALUES (2, 'READING');

# Tabela "user":

INSERT INTO user (email, name, password, username) VALUES ('john.wick@example.com', 'John Wick', 'senha123', 'johnwick');
INSERT INTO user (email, name, password, username) VALUES ('chuck.norris@example.com', 'Chuck Norris', 'senha456', 'chucknorris');
INSERT INTO user (email, name, password, username) VALUES ('macgyver@example.com', 'MacGyver', 'senha789', 'macgyver');

-- Inserir registros na tabela goal
-- Person 1
INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Improve react skills', '2023-12-31', false, 'Goal 1', 0, '2023-10-29', 1, 1);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Finish Ux SalesForce project', '2023-11-30', false, 'Goal 2', 0, '2023-10-29', 1, 2);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Complete dev javascript training', '2023-12-15', true, 'Goal 3', 0, '2023-10-29', 1, 3);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Improve communication skills', '2023-12-31', true, 'Goal 4', 0, '2023-10-29', 1, 3);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Finish English courses', '2023-11-30', true , 'Goal 5', 0, '2023-10-29', 1, 2);

-- Person 1

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Desenvolver uma arquitetura escalável e de alto desempenho para o sistema back-end', '2023-12-31', false, 'Goal 1', 0, '2023-10-29', 2, 1);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Implementar boas práticas de codificação e padrões de design para garantir a qualidade do código', '2023-11-30', false, 'Goal 2', 0, '2023-10-29', 2, 2);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Liderar a equipe de desenvolvimento back-end, fornecendo orientação técnica e suporte', '2023-12-15', true, 'Goal 3', 0, '2023-10-29', 2, 3);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Realizar revisões de código e fornecer feedback construtivo para melhorar a qualidade do código produzido pela equipe', '2023-12-31', true, 'Goal 4', 0, '2023-10-29', 2, 3);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Pesquisar e avaliar constantemente novas tecnologias e ferramentas para melhorar a eficiência e a inovação no desenvolvimento back-end', '2023-11-30', true , 'Goal 5', 0, '2023-10-29', 2, 2);

-- Person 3
INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Facilitar as reuniões diárias de stand-up', '2023-12-31', false, 'Goal 1', 0, '2023-10-29', 3, 1);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Remover obstáculos e impedimentos', '2023-11-30', false, 'Goal 2', 0, '2023-10-29', 3, 2);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Promover a colaboração e a comunicação eficaz', '2023-12-15', true, 'Goal 3', 0, '2023-10-29', 3, 3);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Garantir a adesão aos princípios e práticas ágeis', '2023-12-31', true, 'Goal 4', 0, '2023-10-29', 3, 3);

INSERT INTO goal (description, expired_date, linked_review, name, progress, start_date, user_id, priority)
VALUES ('Ajudar a equipe a definir e atingir metas realistas', '2023-11-30', true , 'Goal 5', 0, '2023-10-29', 3, 2);


-- Inserir registros na tabela achieve_goal
INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 1 description', 'Achieve 1', FLOOR(RAND() * 101), 1);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 2 description', 'Achieve 2', FLOOR(RAND() * 101), 2);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 3 description', 'Achieve 3', FLOOR(RAND() * 101), 2);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 4 description', 'Achieve 4', FLOOR(RAND() * 101), 2);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 5 description', 'Achieve 5', FLOOR(RAND() * 101), 2);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 6 description', 'Achieve 6', FLOOR(RAND() * 101), 2);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 7 description', 'Achieve 7', FLOOR(RAND() * 101), 3);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 8 description', 'Achieve 8', FLOOR(RAND() * 101), 3);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 9 description', 'Achieve 9', FLOOR(RAND() * 101), 3);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 10 description', 'Achieve 10', FLOOR(RAND() * 101), 4);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 11 description', 'Achieve 11', FLOOR(RAND() * 101), 5);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 12 description', 'Achieve 12', FLOOR(RAND() * 101), 5);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 13 description', 'Achieve 13', FLOOR(RAND() * 101), 5);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 14 description', 'Achieve 14', FLOOR(RAND() * 101), 5);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 15 description', 'Achieve 15', FLOOR(RAND() * 101), 5);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 16 description', 'Achieve 16', FLOOR(RAND() * 101), 6);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 17 description', 'Achieve 17', FLOOR(RAND() * 101), 6);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 18 description', 'Achieve 18', FLOOR(RAND() * 101), 7);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 19 description', 'Achieve 19', FLOOR(RAND() * 101), 8);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 20 description', 'Achieve 20', FLOOR(RAND() * 101), 8);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 21 description', 'Achieve 21', FLOOR(RAND() * 101), 8);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 22 description', 'Achieve 22', FLOOR(RAND() * 101), 8);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 23 description', 'Achieve 23', FLOOR(RAND() * 101), 9);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 24 description', 'Achieve 24', FLOOR(RAND() * 101), 9);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 25 description', 'Achieve 25', FLOOR(RAND() * 101), 10);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 26 description', 'Achieve 26', FLOOR(RAND() * 101), 10);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 27 description', 'Achieve 27', FLOOR(RAND() * 101), 11);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 28 description', 'Achieve 28', FLOOR(RAND() * 101), 11);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 29 description', 'Achieve 29', FLOOR(RAND() * 101), 11);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 30 description', 'Achieve 30', FLOOR(RAND() * 101), 12);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 31 description', 'Achieve 31', FLOOR(RAND() * 101), 12);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 32 description', 'Achieve 32', FLOOR(RAND() * 101), 13);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 33 description', 'Achieve 33', FLOOR(RAND() * 101), 14);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 34 description', 'Achieve 34', FLOOR(RAND() * 101), 15);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 35 description', 'Achieve 35', FLOOR(RAND() * 101), 15);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 36 description', 'Achieve 36', FLOOR(RAND() * 101), 15);

INSERT INTO achieve_goal (description, name, progress, goal_id)
VALUES ('Achieve 37 description', 'Achieve 37', FLOOR(RAND() * 101), 15);



-- Inserir registros na tabela study_recomendation
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 1', 1, 1);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 13', 1, 1);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 14', 2, 1);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 2', 2, 2);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 3', 3, 2);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 15', 6, 1);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 16', 6, 1);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 4', 4, 1);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 5', 5, 2);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 6', 6, 2);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 7', 7, 1);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 8', 8, 2);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 9', 9, 2);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 10', 10, 1);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 11', 11, 2);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 12', 12, 1);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 17', 11, 1);
INSERT INTO study_recomendation (description, achieve_id, type_id) VALUES ('Study Recomendation 18', 11, 1);

-- Inserir registros na tabela assessment
INSERT INTO assessment (dt_next_assessment, last_avaliation, user_id) VALUES ('2023-11-30', 1, 1);
INSERT INTO assessment (dt_next_assessment, last_avaliation, user_id) VALUES ('2023-12-15', 2, 2);
INSERT INTO assessment (dt_next_assessment, last_avaliation, user_id) VALUES ('2023-12-31', 3, 3);


