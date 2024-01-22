create table if not exists shareholders(
                                           shareholderId serial primary key ,
                                           shareholderName varchar(255),
    phoneNumber varchar(13),
    nationalCode varchar(20)
    );
create table if not exists brand(
                                    brandId serial primary key ,
                                    brandName varchar(255),
    website varchar(255),
    description varchar(255)
    );
create  table if not exists shareholder_brand(
    shareholderId int references shareholders(shareholderId),
    brandId int references brand(brandId)
    );
create table if not exists category(
                                       categoryId serial primary key ,
                                       categoryName varchar(255),
    description varchar(255)
    );
create table if not exists product(
                                      productId serial primary key ,
                                      productName varchar(255),
    createDate DATE,
    categoryId int references category(categoryId),
    brandId int references brand(brandId)
    );


create table if not exists users(
                                    userID serial primary key ,
                                    name varchar(255),
    username varchar(255),
    email varchar(255),
    password varchar(255)
    );