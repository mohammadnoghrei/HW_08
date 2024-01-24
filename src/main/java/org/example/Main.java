package org.example;

import connection.Jdbcconnection;
import menu.Menu;
import repository.UserReposority;
import service.Userservice;
import utility.ApplicationContext;
import utility.Validation;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {


//        Menu.menu1();
//        ApplicationContext.getShareholderService().edit_shareholder();
//        System.out.println(Validation.website_vilidation("www.nick.com"));
//        ApplicationContext.getBrandservice().add_brand();
//        ApplicationContext.getBrandservice().delete_brand();
//        ApplicationContext.getShareholderService().delete_shareholder();
//        ApplicationContext.getShareholdeBrandService().setShareholder_brand();

//
    Menu.main_menu();
    }
}