DROP TABLE IF EXISTS menu;

CREATE TABLE menu
(
    menu_id BIGINT                                                   NOT NULL AUTO_INCREMENT,
    name    VARCHAR(50)                                              NOT NULL,
    type    enum ('BUGGER', 'BUGGER_COMBO', 'SIDE_MENU', 'BEVERAGE') NOT NULL,
    price   BIGINT                                                   NOT NULL,
    kcal    BIGINT                                                   NOT NULL,

    primary key (menu_id)
);

INSERT INTO menu(name, type, price, kcal) VALUES('불고기 버거', 'BUGGER', 2300, 430);
INSERT INTO menu(name, type, price, kcal) VALUES('빅맥', 'BUGGER', 4600, 512);

INSERT INTO menu(name, type, price, kcal) VALUES('불고기 버거 세트', 'BUGGER_COMBO', 4300, 980);
INSERT INTO menu(name, type, price, kcal) VALUES('빅맥 세트', 'BUGGER_COMBO', 5900, 1105);

INSERT INTO menu(name, type, price, kcal) VALUES('후렌치 후라이 M', 'SIDE_MENU', 1700, 323);
INSERT INTO menu(name, type, price, kcal) VALUES('맥너겟 4조각', 'SIDE_MENU', 1800, 175);

INSERT INTO menu(name, type, price, kcal) VALUES('코카 콜라', 'BEVERAGE', 1300, 101);
INSERT INTO menu(name, type, price, kcal) VALUES('코카 콜라 제로', 'BEVERAGE', 1300, 0);
