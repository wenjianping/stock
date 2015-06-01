create table if not exists t_stock(
    code varchar(16) not null,
    name varchar(64) not null,
    industry varchar(64) ,
    ratio varchar(64) ,
    price varchar(64) ,
    totalStock varchar(64),
    marketValue varchar(64) ,    
    circulationStock varchar(64),
    circulationValue varchar(64) , 
    updateTime timestamp default 0, 
    `desc` varchar(1024),
    PRIMARY KEY (code)
)ENGINE=InnoDB default character set utf8 comment="stock";

create table if not exists t_stock_extends(
    code varchar(16) not null,
    name varchar(64) not null,
    day  varchar(64) not null,
    price varchar(16) ,
    netWorth varchar(16) ,
    PRIMARY KEY (code,day)
)ENGINE=InnoDB default character set utf8 comment="stock extends info";