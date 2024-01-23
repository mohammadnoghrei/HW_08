package service;

import model.Category;
import model.Shareholder;
import repository.CategoryReposority;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class CategoryService {
    CategoryReposority categoryReposority;
    Scanner scanner =new Scanner(System.in);

    public CategoryService(CategoryReposority categoryReposority) {
        this.categoryReposority = categoryReposority;
    }

    public void add_category() throws SQLException {
        System.out.println("enter category name:");
        String name = scanner.nextLine();
        System.out.println("enter category description:");
        String description=scanner.nextLine();
        Category category =new Category(name,description);
        int result=categoryReposority.register(category);
        if (result==1)
            System.out.println(name + " add to category successfully :)");
        else System.out.println("something is wrong");
    }

    public void edit_brand() throws SQLException {

        System.out.println("1--> edit name \n2--> description");
        int edit = scanner.nextInt();
        categoryReposority.categorylist();
        switch (edit) {
            case 1 -> {
                System.out.println("please enter id for editing");
                int id = scanner.nextInt();
                System.out.println("please enter new name");
                scanner.nextLine();
                String name = scanner.nextLine();
                int result = categoryReposority.edit_category_name(id, name);
            }

            case 2 -> {
                System.out.println("please enter id for editing");
                int id = scanner.nextInt();
                System.out.println("please enter description");
                scanner.nextLine();
                String description = scanner.nextLine();
                int result = categoryReposority.edit_category_description(id, description);
            }
        }
    }

    public void delete_category() throws SQLException {
        categoryReposority.categorylist();
        System.out.println("please enter id for delete");
        int id = scanner.nextInt();
        int result =categoryReposority.delete(id);
        if (result == 1){
            System.out.println("category deleted");}
        else {
            System.out.println("please enter valid id");
            delete_category();
        }
    }

}
