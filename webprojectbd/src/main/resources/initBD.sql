CREATE TABLE product
(
    id          INTEGER,
    category    VARCHAR(255)     NOT NULL,
    name        VARCHAR(255)     NOT NULL,
    price       DOUBLE DEFAULT 0 NOT NULL,
    discount    DOUBLE DEFAULT 0 NOT NULL,
    actualPrice DOUBLE           NOT NULL
);

CREATE TABLE person
(
    id       INTEGER,
    login    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);