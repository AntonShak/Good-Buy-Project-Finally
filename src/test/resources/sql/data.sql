INSERT INTO marketplace (id, name)
VALUES (1, 'Wildberries'),
       (2, 'Ozon'),
       (3, 'Onliner');
SELECT SETVAL('marketplace_id_seq', (SELECT MAX(id) FROM marketplace));

INSERT INTO users (id, username, birth_date, firstname, lastname, phone, role)
VALUES (1, 'shakov@gmail.com', '01-19-1992', 'Anton', 'Shakov', '+375291475900', 'ADMIN'),
       (2, 'shakova@gmail.com', '02-22-1992', 'Tatsiana', 'Shakova', '+375291921614', 'USER');
SELECT SETVAL('users_id_seq', (SELECT MAX(id) FROM users));

INSERT INTO product (id, link, user_id, marketplace_id, name, description, price, discount)
VALUES (1, 'https://www.wildberries.by/product?card=197046833&option=319627874',
        (SELECT id FROM users WHERE firstname = 'Tatsiana'),
        (SELECT id FROM marketplace WHERE name = 'Wildberries'), 'Светильник',
        'Светильник настольный светодиодный, для компьютера', 138.50, 15),
       (2, 'https://www.wildberries.by/product?card=185777425',
        (SELECT id FROM users WHERE firstname = 'Anton'),
        (SELECT id FROM marketplace WHERE name = 'Wildberries'), 'Куртка',
        'Куртка зимняя удлиненная с капюшоном', 93.49, 35),
       (3, 'https://ozon.by/product/sredstvo-dlya-mytya-posudy-detskih-igrushek-i-butylochek-synergetic-gipoallergennoe-bez-zapaha-3-5l-706952699/?asb=5ylpmZ%252F0wIe2ExOVUMvBF5iAsKux%252BEKBOduKnbYnHJI%253D&asb2=fSQ0RXR7AZ_I2fj9LO3DXpzbwhfzTL0gnPhCG9sFF0fhqxfz1oWDrt5mPqZENtCk&avtc=1&avte=4&avts=1717861203&keywords=synergetic+%D0%B4%D0%BB%D1%8F+%D0%B1%D1%83%D1%82%D1%8B%D0%BB%D0%BE%D1%87%D0%B5%D0%BA',
        (SELECT id FROM users WHERE firstname = 'Tatsiana'),
        (SELECT id FROM marketplace WHERE name = 'Ozon'), 'Средство',
        'Средство для мытья посуды, детских игрушек и бутылочек SYNERGETIC гипоаллергенное, без запаха, 3,5л', 22.79, 8),
       (4, 'https://ozon.by/product/shchetka-dlya-plitochnyh-shvov-shcheley-uzkih-trudnodostupnyh-mest-2sht-shchetka-dlya-1158366011/?asb=Rr1uMRgKtCpDuyi7LocD7MFpH0IqEmh1OyBgpE%252F%252Ba8tUC%252FMmGdTi%252FTRWlrxIqh7k&asb2=1dkq5jiPRMXZdWtHpM_ttsukCgZKsOwVQXSt9Q9Cx0T3cyfixagmcECFe7p47dg-ED25WMZP2YJUia4uZxDQGUrspzDgob3GD0wwWmwbjkBVtYmoZSpe6P44HYkYvguqf9wWTU8aGYDQQRQyZJ46jg-3YJ7d5SDBRQ0jQzR58BU&avtc=1&avte=2&avts=1717861100&keywords=1158366011',
        (SELECT id FROM users WHERE firstname = 'Anton'),
        (SELECT id FROM marketplace WHERE name = 'Ozon'), 'Щетка',
        'Щётка для плиточных швов, щелей, узких, труднодоступных мест', 7.89, 9),
       (5, 'https://catalog.onliner.by/robotcleaner/dadget/dbotw200',
        (SELECT id FROM users WHERE firstname = 'Anton'),
        (SELECT id FROM marketplace WHERE name = 'Ozon'), 'Робот',
        'Робот для мытья окон Даджет dBot W200', 369, 11);
SELECT SETVAL('product_id_seq', (SELECT MAX(id) FROM product));


INSERT INTO users_marketplace(user_id, marketplace_id)
VALUES ((SELECT id FROM users WHERE username = 'shakov@gmail.com'), (SELECT id FROM marketplace WHERE name = 'Wildberries')),
       ((SELECT id FROM users WHERE username = 'shakov@gmail.com'), (SELECT id FROM marketplace WHERE name = 'Ozon')),
       ((SELECT id FROM users WHERE username = 'shakov@gmail.com'), (SELECT id FROM marketplace WHERE name = 'Onliner')),
       ((SELECT id FROM users WHERE username = 'shakova@gmail.com'), (SELECT id FROM marketplace WHERE name = 'Wildberries')),
       ((SELECT id FROM users WHERE username = 'shakova@gmail.com'), (SELECT id FROM marketplace WHERE name = 'Ozon'));
SELECT SETVAL('users_marketplace_id_seq', (SELECT MAX(id) FROM users_marketplace));






