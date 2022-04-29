CREATE TABLE menu
(
    menu_id LONG                                                   NOT NULL AUTO_INCREMENT,
    name    VARCHAR(50)                                            NOT NULL,
    type    enum ('Bugger', 'BuggerCombo', 'SideMenu', 'Beverage') NOT NULL,
    price   NUMERIC(6)                                             NOT NULL,
    kcal    NUMERIC(4)                                             NOT NULL,

    primary key (menu_id)
)