INSERT INTO style_tags(tag_name) VALUES ('Минимализм');
INSERT INTO style_tags(tag_name) VALUES ('Лофт');

INSERT INTO roles(role) VALUES ('ADMIN');
INSERT INTO roles(role) VALUES ('USER');
INSERT INTO roles(role) VALUES ('DESIGNER');

/*
INSERT INTO user_accounts(login, password, name, surname, email, number, role_id)
VALUES('Test','Test','Name','Surname','test@test.ru','899999999999', 2);

INSERT INTO user_accounts(login, password, name, surname, email, number, role_id)
VALUES('Test1','Test1','Name1','Surname1','test1@test.ru','899999999998', 2);

INSERT INTO designers(login, password, name, surname, number, email, telegram, whatsapp, role_id)
VALUES ('TestDis', 'testdis', 'Алина', 'Кузьмина', '87777777777', 'testdis@test.ru', 'telegram', 'whatsapp', 3);

INSERT INTO projects(header, short_description, description, tag_id, designer_id)
VALUES ('Интерьер в скандинавском стиле','Просто тестовое описание интерьера', 'Test Description', 1, 1);

INSERT INTO projects(header, short_description, description, tag_id, designer_id)
VALUES ('Интерьер в минималистике','Ну в кратце сказать о нем', 'Test Description 1', 1, 1);

INSERT INTO comments(project_id, user_account_id, text) VALUES (1,1,'Test Text');*/