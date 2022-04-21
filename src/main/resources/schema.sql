CREATE SEQUENCE IF NOT EXISTS region_seq
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;
CREATE TABLE IF NOT EXISTS `REGIONS`(
                                        `id`             LONG DEFAULT region_seq.NEXTVAL,
                                        `name`           VARCHAR(100) NOT NULL UNIQUE ,
                                        `shortName`      VARCHAR(10) NOT NULL UNIQUE
    );