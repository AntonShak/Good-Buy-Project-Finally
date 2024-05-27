DROP TABLE product;
DROP TABLE users_marketplace;
DROP TABLE marketplace;
DROP TABLE users;



CREATE TABLE IF NOT EXISTS marketplace
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
    );


CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY ,
    username VARCHAR(64) NOT NULL UNIQUE,
    birth_date DATE NOT NULL,
    firstname VARCHAR(64) NOT NULL,
    lastname VARCHAR(64) NOT NULL,
    phone VARCHAR(32) NOT NULL,
    role VARCHAR(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS product
(
    id BIGSERIAL PRIMARY KEY,
    vendor_code VARCHAR(32) NOT NULL UNIQUE ,
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE ,
    marketplace_id BIGINT REFERENCES marketplace (id) ON DELETE CASCADE,
    name VARCHAR(64) NOT NULL,
    description VARCHAR(255) NOT NULL ,
    image VARCHAR(128),
    price FLOAT(2) NOT NULL,
    discount INT DEFAULT 10
    );



CREATE TABLE IF NOT EXISTS users_marketplace
(
    id BIGSERIAL PRIMARY KEY ,
    user_id BIGINT NOT NULL REFERENCES users (id) ,
    marketplace_id BIGINT NOT NULL REFERENCES marketplace (id) ,
    UNIQUE (user_id, marketplace_id)
);




