DROP TABLE IF EXISTS order_menu;
DROP TABLE IF EXISTS orders;

DROP TABLE IF EXISTS menu_option;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS menu_type;

CREATE TABLE menu_type
(
    menu_type_id   BIGINT      NOT NULL AUTO_INCREMENT,
    menu_type_name VARCHAR(50) NOT NULL,

    primary key (menu_type_id)
);

INSERT INTO menu_type(menu_type_id, menu_type_name) VALUES(1, 'BUGGER');
INSERT INTO menu_type(menu_type_id, menu_type_name) VALUES(2, 'BUGGER_COMBO');
INSERT INTO menu_type(menu_type_id, menu_type_name) VALUES(3, 'SIDE_MENU');
INSERT INTO menu_type(menu_type_id, menu_type_name) VALUES(4, 'BEVERAGE');

CREATE TABLE menu
(
    menu_id BIGINT      NOT NULL AUTO_INCREMENT,
    menu_type_id BIGINT NOT NULL,
    menu_name    VARCHAR(50) NOT NULL,
    menu_price   BIGINT      NOT NULL,
    menu_kcal    BIGINT      NOT NULL,
    menu_image_file_name VARCHAR(255),

    primary key (menu_id),
    CONSTRAINT fk_menu_to_menu_type FOREIGN KEY (menu_type_id) REFERENCES menu_type(menu_type_id)
);

INSERT INTO menu(menu_id, menu_type_id, menu_name, menu_price, menu_kcal, menu_image_file_name)VALUES (1, 1, '불고기 버거', 2300, 430, '1583727805044.png');
INSERT INTO menu(menu_id, menu_type_id, menu_name, menu_price, menu_kcal, menu_image_file_name)VALUES (2, 1, '빅맥', 4600, 512, '1583727855319.png');

INSERT INTO menu(menu_id, menu_type_id, menu_name, menu_price, menu_kcal, menu_image_file_name)VALUES (3, 2, '불고기 버거 세트', 4300, 980, '1583730523630.png');
INSERT INTO menu(menu_id, menu_type_id, menu_name, menu_price, menu_kcal, menu_image_file_name)VALUES (4, 2, '빅맥 세트', 5900, 1105, '1614163187334.png');

INSERT INTO menu(menu_id, menu_type_id, menu_name, menu_price, menu_kcal, menu_image_file_name)VALUES (5, 3, '후렌치 후라이 M', 1700, 323, '1563786079641.png');
INSERT INTO menu(menu_id, menu_type_id, menu_name, menu_price, menu_kcal, menu_image_file_name)VALUES (6, 3, '맥너겟 4조각', 1800, 175, '1612402131024.png');

INSERT INTO menu(menu_id, menu_type_id, menu_name, menu_price, menu_kcal, menu_image_file_name)VALUES (7, 4, '코카 콜라', 1300, 101, '1583889967380.png');
INSERT INTO menu(menu_id, menu_type_id, menu_name, menu_price, menu_kcal, menu_image_file_name)VALUES (8, 4, '코카 콜라 제로', 1300, 0, '1583890021601.png');


CREATE TABLE menu_option
(
    menu_option_id        BIGINT      NOT NULL AUTO_INCREMENT,
    menu_type_id BIGINT NOT NULL,
    menu_option_name      VARCHAR(50) NOT NULL,
    menu_option_price     BIGINT      NOT NULL,

    primary key (menu_option_id),
    CONSTRAINT fk_menu_option_menu_type FOREIGN KEY (menu_type_id) REFERENCES menu_type(menu_type_id)
);

INSERT INTO menu_option(menu_option_id, menu_type_id, menu_option_name, menu_option_price)VALUES (1, 1, '피클을 빼줘', 0);
INSERT INTO menu_option(menu_option_id, menu_type_id, menu_option_name, menu_option_price)VALUES (2, 2, '제로 콜라로 바꿔줘', 0);
INSERT INTO menu_option(menu_option_id, menu_type_id, menu_option_name, menu_option_price)VALUES (3, 2, '감튀를 맥너겟으로 빠꿔줘', 600);


CREATE TABLE orders
(
    order_id    BIGINT      NOT NULL AUTO_INCREMENT,
    order_type  VARCHAR(50) NOT NULL,
    order_price BIGINT      NOT NULL,
    created_at  DATETIME(6) NOT NULL,

    primary key (order_id)
);

CREATE TABLE order_menu
(
    order_menu_id    BIGINT NOT NULL AUTO_INCREMENT,
    order_id         BIGINT NOT NULL,
    menu_id          BIGINT NOT NULL,
    menu_option_id   BIGINT,
    order_menu_price BIGINT NOT NULL,

    primary key (order_menu_id),
    CONSTRAINT fk_order_menu_to_orders FOREIGN KEY (order_id) REFERENCES orders(order_id),
    CONSTRAINT fk_order_menu_to_menu FOREIGN KEY (menu_id) REFERENCES menu(menu_id),
    CONSTRAINT fk_order_menu_to_menu_option FOREIGN KEY (menu_option_id) REFERENCES menu_option(menu_option_id)
);
--

