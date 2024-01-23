package service;

import model.Brand;
import repository.Brandrepository;
import repository.Shareholder_Brand_repository;
import utility.ApplicationContext;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class Brandservice {
    Brandrepository brandrepository;
    Shareholder_Brand_repository shareholder_brand_repository;
    Scanner scanner = new Scanner(System.in);

    public Brandservice(Brandrepository brandrepository, Shareholder_Brand_repository shareholder_brand_repository) {
        this.brandrepository = brandrepository;
        this.shareholder_brand_repository = shareholder_brand_repository;
    }

    public void add_brand() throws SQLException {
        System.out.println("please enter brand name :");
        String name = scanner.nextLine();
        System.out.println("please enter brand website:");
        String website;
        while (true) {
            website = scanner.nextLine();
            if (Validation.website_vilidation(website))
                break;
            else System.out.println("please enter a valid website");
        }
        System.out.println("please enter description");
        String description = scanner.nextLine();
        Brand brand = new Brand(name, website, description);
        int result = brandrepository.register(brand);
        if (result == 1)
            System.out.println(name + " add to brand successfully :)");
        else System.out.println("something is wrong");
    }

    public void delete_brand() throws SQLException {
        brandrepository.brandlist();
        System.out.println("please enter id for delete");
        int id = scanner.nextInt();

        int result =brandrepository.delete(id);
        if (result == 1){
            System.out.println("brand deleted");}
        else {
            System.out.println("please enter valid id");
            delete_brand();
        }shareholder_brand_repository.delete_brand(id);

    }

    public void edit_brand() throws SQLException {

        System.out.println("1--> edit name \n 2--> edit website \n 3--> edit description");
        int edit = scanner.nextInt();
        brandrepository.brandlist();
        switch (edit) {
            case 1 -> {
                System.out.println("please enter id for editing");
                int id = scanner.nextInt();
                System.out.println("please enter new name");
                scanner.nextLine();
                String name = scanner.nextLine();
                int result = brandrepository.edit_brand_name(id, name);
            }

            case 2 -> {
                System.out.println("please enter id for editing");
                int id = scanner.nextInt();
                System.out.println("please enter new website");
                scanner.nextLine();
                String website;
                while (true) {
                    website = scanner.nextLine();
                    if (Validation.website_vilidation(website))
                        break;
                    else System.out.println("please enter a valid website");
                }
                int result = brandrepository.edit_brand_wbsite(id, website);
            }

            case 3 -> {
                System.out.println("please enter id for editing");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("please enter new name");
                String description = scanner.nextLine();
                int result = brandrepository.edit_brand_description(id, description);
            }
        }
    }
}
