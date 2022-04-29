DROP TABLE IF EXISTS menu;

CREATE TABLE menu
(
    menu_id BIGINT      NOT NULL AUTO_INCREMENT,
    type    VARCHAR(50) NOT NULL,
    name    VARCHAR(50) NOT NULL,
    price   BIGINT      NOT NULL,
    kcal    BIGINT      NOT NULL,

    primary key (menu_id)
);

INSERT INTO menu(type, name, price, kcal) VALUES ('BUGGER', '불고기 버거', 2300, 430);
INSERT INTO menu(type, name, price, kcal) VALUES ('BUGGER', '빅맥', 4600, 512);

INSERT INTO menu(type, name, price, kcal) VALUES ('BUGGER_COMBO', '불고기 버거 세트', 4300, 980);
INSERT INTO menu(type, name, price, kcal) VALUES ('BUGGER_COMBO', '빅맥 세트', 5900, 1105);

INSERT INTO menu(type, name, price, kcal) VALUES ('SIDE_MENU', '후렌치 후라이 M', 1700, 323);
INSERT INTO menu(type, name, price, kcal) VALUES ('SIDE_MENU', '맥너겟 4조각', 1800, 175);

INSERT INTO menu(type, name, price, kcal) VALUES ('BEVERAGE', '코카 콜라', 1300, 101);
INSERT INTO menu(type, name, price, kcal) VALUES ('BEVERAGE', '코카 콜라 제로', 1300, 0);


DROP TABLE IF EXISTS menu_option;

CREATE TABLE menu_option
(
    menu_option_id        BIGINT      NOT NULL AUTO_INCREMENT,
    menu_type VARCHAR(50) NOT NULL,
    name      VARCHAR(50) NOT NULL,
    price     BIGINT      NOT NULL,

    primary key (menu_option_id)
);

INSERT INTO menu_option(menu_type, name, price) VALUES('BUGGER', '피클을 빼줘', 0);
INSERT INTO menu_option(menu_type, name, price) VALUES('BUGGER_COMBO', '제로 콜라로 바꿔줘', 0);
INSERT INTO menu_option(menu_type, name, price) VALUES('BUGGER_COMBO', '감튀를 맥너겟으로 빠꿔줘', 600);
