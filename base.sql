-- Стили интерьера
INSERT INTO style_tags(tag_name) VALUES ('Современный');
INSERT INTO style_tags(tag_name) VALUES ('Скандинавский');
INSERT INTO style_tags(tag_name) VALUES ('Лофт');
INSERT INTO style_tags(tag_name) VALUES ('Классический');
INSERT INTO style_tags(tag_name) VALUES ('Минимализм');
INSERT INTO style_tags(tag_name) VALUES ('Средиземноморский');
INSERT INTO style_tags(tag_name) VALUES ('Бохо');
INSERT INTO style_tags(tag_name) VALUES ('Рустик');
INSERT INTO style_tags(tag_name) VALUES ('Винтаж');
INSERT INTO style_tags(tag_name) VALUES ('Эклектика');
INSERT INTO style_tags(tag_name) VALUES ('Индастриал');
INSERT INTO style_tags(tag_name) VALUES ('Фьюжн');
INSERT INTO style_tags(tag_name) VALUES ('Традиционный');
INSERT INTO style_tags(tag_name) VALUES ('Тропический');
INSERT INTO style_tags(tag_name) VALUES ('Французский провинциальный');
INSERT INTO style_tags(tag_name) VALUES ('Морской');
INSERT INTO style_tags(tag_name) VALUES ('Арт-деко');
INSERT INTO style_tags(tag_name) VALUES ('Модерн');
INSERT INTO style_tags(tag_name) VALUES ('Голливудский гламур');
INSERT INTO style_tags(tag_name) VALUES ('Колониальный');
INSERT INTO style_tags(tag_name) VALUES ('Шебби-шик');
INSERT INTO style_tags(tag_name) VALUES ('Азиатский');
INSERT INTO style_tags(tag_name) VALUES ('Юго-западный');
INSERT INTO style_tags(tag_name) VALUES ('Готический');
INSERT INTO style_tags(tag_name) VALUES ('Ретро');


-- Категории товаров для ремонта
INSERT INTO category(name) VALUES ('Полы');
INSERT INTO category(name) VALUES ('Потолок');
INSERT INTO category(name) VALUES ('Свет');
INSERT INTO category(name) VALUES ('Обои');
INSERT INTO category(name) VALUES ('Краска');
INSERT INTO category(name) VALUES ('Плитка');
INSERT INTO category(name) VALUES ('Сантехника');
INSERT INTO category(name) VALUES ('Электрика');
INSERT INTO category(name) VALUES ('Двери');
INSERT INTO category(name) VALUES ('Окна');
INSERT INTO category(name) VALUES ('Мебель');
INSERT INTO category(name) VALUES ('Инструменты');
INSERT INTO category(name) VALUES ('Отопление');
INSERT INTO category(name) VALUES ('Вентиляция');
INSERT INTO category(name) VALUES ('Изоляция');
INSERT INTO category(name) VALUES ('Напольные покрытия');
INSERT INTO category(name) VALUES ('Ковры');
INSERT INTO category(name) VALUES ('Лестницы');
INSERT INTO category(name) VALUES ('Фасадные материалы');
INSERT INTO category(name) VALUES ('Декоративные элементы');
INSERT INTO category(name) VALUES ('Клеи и герметики');
INSERT INTO category(name) VALUES ('Строительные материалы');
INSERT INTO category(name) VALUES ('Системы безопасности');
INSERT INTO category(name) VALUES ('Освещение');

-- Компании для каждой категории
INSERT INTO company(name, category_id, site) VALUES ('FloorMaster', 1, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('PerfectFloors', 1, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('CeilingPro', 2, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('SkyCeilings', 2, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('BrightLights', 3, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('Luminous', 3, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('WallArt', 4, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('DecorWalls', 4, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('ColorSplash', 5, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('PaintPro', 5, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('TileWorld', 6, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('CeramicKing', 6, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('PlumbPerfect', 7, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('AquaFlow', 7, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('ElectroTech', 8, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('PowerHouse', 8, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('DoorMasters', 9, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('SecureDoors', 9, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('WindowWorld', 10, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('ClearView', 10, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('FurniCraft', 11, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('HomeComfort', 11, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('ToolTime', 12, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('ProTools', 12, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('HeatWave', 13, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('WarmHome', 13, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('AirFlow', 14, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('VentPro', 14, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('InsulGuard', 15, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('ThermoShield', 15, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('FloorCoverings', 16, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('CoverMaster', 16, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('CarpetKing', 17, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('SoftStep', 17, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('StairCraft', 18, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('StepUp', 18, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('FacadePro', 19, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('ExteriorMaster', 19, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('DecorElements', 20, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('ArtisticDecor', 20, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('GlueTech', 21, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('SealMaster', 21, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('BuildIt', 22, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('ConstructPro', 22, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('SafeHome', 23, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('SecureTech', 23, 'https://polberry.ru/');

INSERT INTO company(name, category_id, site) VALUES ('LightHouse', 24, 'https://polberry.ru/');
INSERT INTO company(name, category_id, site) VALUES ('BrightHome', 24, 'https://polberry.ru/');

--Роли
INSERT INTO roles(role) VALUES ('ADMIN');
INSERT INTO roles(role) VALUES ('USER');
INSERT INTO roles(role) VALUES ('DESIGNER');


--Дизайнеры и пользователи
INSERT INTO designers(login, password, name, surname, telegram, whatsapp, number, email, role_id)
    VALUES ('a','{noop}a','Алексей','Иванов','butterhat','79139484322','+79139484322','surikov96@mail.ru',3);

INSERT INTO designers(login, password, name, surname, telegram, whatsapp, number, email, role_id)
VALUES ('b','{noop}b','Екатерина','Смирнова','butterhat','79139484322','+79139484322','surikov96@mail.ru',3);

INSERT INTO designers(login, password, name, surname, telegram, whatsapp, number, email, role_id)
VALUES ('c','{noop}c','Анна','Петрова','butterhat','79139484322','+79139484322','surikov96@mail.ru',3);

--Пользователи
INSERT INTO user_accounts(login, password, name, surname, email, role_id)
VALUES ('aa','{noop}aa','Петр','Купин','surikov96@mail.ru',2);

INSERT INTO user_accounts(login, password, name, surname, email, role_id)
VALUES ('bb','{noop}bb','Евгений','Суриков','surikov96@mail.ru',2);

INSERT INTO user_accounts(login, password, name, surname, email, role_id)
VALUES ('cc','{noop}cc','Петр','Купин','surikov96@mail.ru',2);



