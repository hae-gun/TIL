drop table Market_user;
create table Market_user(
    id VARCHAR2(10) PRIMARY key,
    pw VARCHAR2(10) not null,
    roll VARCHAR2(10) not null,
    point NUMBER default 0
);

drop table Product_Type;
create table Product_Type(
    TYPE_NO NUMBER PRIMARY KEY,
    TYPE VARCHAR2(10)
);

drop table product;
CREATE TABLE PRODUCT(
    NSN VARCHAR(10) PRIMARY key,
    TYPE_NO REFERENCES product_type(TYPE_NO),
    NAME VARCHAR2(10),
    PRICE NUMBER,
    AMOUNT NUMBER
);

drop SEQUENCE BUY_SEQ;
CREATE SEQUENCE BUY_SEQ;

DROP TABLE ORDER_LIST;
CREATE TABLE ORDER_LIST(
    ORDER_ID NUMBER PRIMARY KEY,
    NSN REFERENCES PRODUCT(NSN),
    ID REFERENCES MARKET_USER(ID),
     amount number,
    ORDER_DATE DATE DEFAULT sysdate
   
);

-- product type insert
insert into product_type values(10,'FOOD');
insert into product_type values(20,'FURNITURE');
insert into product_type values(30,'MACHINE');

-- user info insert
insert into market_user(id,pw,roll) values('chkchk610','1208skg','seller');
insert into market_user(id,pw,roll) values('user01','1234','customer');


-- product info insert
insert into product values('000001',10,'Rice',30000,30);
insert into product values('000002',20,'Desk',50000,10);
insert into product values('000003',30,'Computer',800000,5);

commit;