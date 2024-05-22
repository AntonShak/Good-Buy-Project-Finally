INSERT INTO marketplace (name)
VALUES ('Wildberries'),
       ('Ozon'),
       ('Onliner');

INSERT INTO users (username, birth_date, firstname, lastname, phone, role)
VALUES ('shakov@gmail.com', '01-19-1992', 'Anton', 'Shakov', '+375291475900', 'ADMIN'),
       ('shakova@gmail.com', '02-22-1992', 'Tatsiana', 'Shakova', '+375291921614', 'USER');

INSERT INTO product (vendor_code, user_id, marketplace_id, name, description, price, discount)
VALUES ('197046833', (SELECT id FROM users WHERE firstname = 'Tatsiana'),
        (SELECT id FROM marketplace WHERE name = 'Wildberries'), 'Светильник',
        'Светильник настольный светодиодный, для компьютера', 138.50, 15),
       ('185777425', (SELECT id FROM users WHERE firstname = 'Anton'),
        (SELECT id FROM marketplace WHERE name = 'Wildberries'), 'Куртка',
        'Куртка зимняя удлиненная с капюшоном', 93.49, 35),
       ('268172649', (SELECT id FROM users WHERE firstname = 'Tatsiana'),
        (SELECT id FROM marketplace WHERE name = 'Ozon'), 'Synergetic',
        'Synergetic Средство для мытья детской посуды, игрушек, сосок и бутылочек 3.5 л', 22.79, 8),
       ('1158366011', (SELECT id FROM users WHERE firstname = 'Anton'),
        (SELECT id FROM marketplace WHERE name = 'Ozon'), 'Щетка',
        'Щётка для плиточных швов, щелей, узких, труднодоступных мест', 7.89, 9),
       ('KIT FB0319', (SELECT id FROM users WHERE firstname = 'Anton'),
        (SELECT id FROM marketplace WHERE name = 'Ozon'), 'Робот',
        'Робот для мытья окон Даджет dBot W200', 369, 11);

INSERT INTO users_marketplace(user_id, marketplace_id)
VALUES ((SELECT id FROM users WHERE username = 'shakov@gmail.com'), (SELECT id FROM marketplace WHERE name = 'Wildberries')),
       ((SELECT id FROM users WHERE username = 'shakov@gmail.com'), (SELECT id FROM marketplace WHERE name = 'Ozon')),
       ((SELECT id FROM users WHERE username = 'shakov@gmail.com'), (SELECT id FROM marketplace WHERE name = 'Onliner')),
       ((SELECT id FROM users WHERE username = 'shakova@gmail.com'), (SELECT id FROM marketplace WHERE name = 'Wildberries')),
       ((SELECT id FROM users WHERE username = 'shakova@gmail.com'), (SELECT id FROM marketplace WHERE name = 'Ozon'));






