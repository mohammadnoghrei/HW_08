package service;

import model.Product;
import model.Shareholder_Brand;
import repository.Brandrepository;
import repository.CategoryReposority;
import repository.Productrepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Productservice {
    Productrepository productrepository;
    CategoryReposority categoryReposority;
    Brandrepository brandrepository;
    Scanner scanner = new Scanner(System.in);

    public Productservice(Productrepository productrepository, CategoryReposority categoryReposority, Brandrepository brandrepository) {
        this.productrepository = productrepository;
        this.categoryReposority = categoryReposority;
        this.brandrepository = brandrepository;
    }

    public void setProduct() throws SQLException {
        System.out.println("please enter product name");
        String name =scanner.nextLine();
        scanner.nextLine();
        System.out.println("please enter create date:");
        String createdate =scanner.nextLine();
        Date date = Date.valueOf(createdate);
        categoryReposority.categorylist();
        System.out.println("please enter category id:");
        int category_id =scanner.nextInt();
        brandrepository.brandlist();
        System.out.println("please enter brand id:");
        int brand_id = scanner.nextInt();
        Product product = new Product(name,date,category_id,brand_id);
        int result =productrepository.register(product);
        if (result==1)
            System.out.println("product added");
        else {System.out.println("something is wrong try again");
            setProduct();}

    }
}
