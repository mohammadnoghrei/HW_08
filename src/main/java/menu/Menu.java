package menu;

import utility.ApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public static void menu1() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****wellcome***");
        System.out.println("1--> sing up");
        System.out.println("2--> sing in");
        int n1=scanner.nextInt();
        switch (n1){
            case 1:
                ApplicationContext.getUserService().singUp();
            case 2: ApplicationContext.getUserService().signIn();
        }


    }

}
