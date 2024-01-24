package menu;

import utility.ApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
Scanner scanner=new Scanner(System.in);

    public static void main_menu() throws SQLException {
        System.out.println("***welcome***");
        Menu menu =new Menu();
        menu.usermenu();
        boolean end=true;
        while (end){
            System.out.println("1-add:\n2-edit:\n3-delete:\n0-exit");
            Scanner scanner1=new Scanner(System.in);
            int num =scanner1.nextInt();
            scanner1.nextLine();
            switch (num){
                case 0->end=false;
                case 1->{menu.add_menu();break;}
                case 2->{menu.edit_menu();break;}
                case 3->{menu.delete_menu();break;}
                default -> {
                    System.out.println("please enter valid number");
                    continue;
                }
            }
        }

    }

    public boolean usermenu() throws SQLException {
        System.out.println("1--> sing up");
        System.out.println("2--> sing in");
        System.out.println("0--> exit");
        int n1=scanner.nextInt();
        boolean end = true;
        switch (n1){
            case 0:end =false;break;
            case 1: ApplicationContext.getUserService().singUp();break;
            case 2: ApplicationContext.getUserService().signIn();break;
            default: System.out.println("please enter valid num");usermenu();
        }

        return end;
    }

    public boolean add_menu() throws SQLException {
        System.out.println("1-add to Shareholder:\n2-add to Brand:\n3-add to ShareholderBrand:\n4-add to Category:\n5-add to Product:");
        System.out.println("please choose one table for add in that:");
        int num_add=scanner.nextInt();
        scanner.nextLine();
        boolean end =true;
        switch (num_add){
            case 0->{end =false;break;}
            case 1-> {ApplicationContext.getShareholderService().add_shareholder();break;}
            case 2-> {ApplicationContext.getBrandservice().add_brand();break;}
            case 3-> {ApplicationContext.getShareholdeBrandService().setShareholder_brand();break;}
            case 4-> {ApplicationContext.getCategoryService().add_category();break;}
            case 5-> {ApplicationContext.getProductservice().setProduct();break;}
            default -> {System.out.println("please enter valid number"); add_menu();}
        }
        return end;
    }

    public boolean edit_menu() throws SQLException {
        System.out.println("1-edit Shareholder:\n2-edit Brand:\n3-edit Category:\n4-edit Product:");
        System.out.println("please choose one table for edit:");
        int num_add = scanner.nextInt();
        scanner.nextLine();
        boolean end =true;
        switch (num_add){
            case 0->{end =false;break;}
            case 1 -> {ApplicationContext.getShareholderService().edit_shareholder();break;}
            case 2 -> {ApplicationContext.getBrandservice().edit_brand();break;}
            case 3 -> {ApplicationContext.getCategoryService().edit_category();break;}
            case 4 -> {ApplicationContext.getProductservice().edit_product();break;}
            default -> {
                System.out.println("please enter valid number");
                add_menu();
            }
        }return end;
    }

        public boolean delete_menu () throws SQLException {
            System.out.println("1-delete Shareholder:\n2-delete Brand:\n3-delete Category:\n4-delete Product:");
            System.out.println("please choose one table for delete:");
            int num = scanner.nextInt();
            scanner.nextLine();
            boolean end =true;
            switch (num){
                case 0->{end =false;break;}
                case 1 -> ApplicationContext.getShareholderService().delete_shareholder();
                case 2 -> ApplicationContext.getBrandservice().delete_brand();
                case 3 -> ApplicationContext.getCategoryService().delete_category();
                case 4 -> ApplicationContext.getProductservice().delete_product();
                default -> {
                    System.out.println("please enter valid number");
                    add_menu();
                }
            }return end;

        }



}
