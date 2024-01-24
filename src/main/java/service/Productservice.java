package service;

import model.Product;
import model.Shareholder_Brand;
import repository.Brandrepository;
import repository.CategoryReposority;
import repository.Productrepository;
import utility.Validation;

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
    public void edit_product() throws SQLException {

        System.out.println("1--> edit name \n 2--> edit date \n 3--> edit category id:\n4--> edit brand id:");
        int edit = scanner.nextInt();
        productrepository.productlist();
        switch (edit){
            case 1 -> {
                System.out.println("please enter id for editing");
                int id= scanner.nextInt();
                scanner.nextLine();
                System.out.println("please enter new name");
                String name =scanner.nextLine();
                int result=  productrepository.edit_product_name(id,name);}

            case 2 ->{
                System.out.println("please enter id for editing");
                int id= scanner.nextInt();
                scanner.nextLine();
                System.out.println("please enter create date:");
                String createdate =scanner.nextLine();
                Date date = Date.valueOf(createdate);
                int result=  productrepository.edit_createDate(id,date);}

            case 3 ->{
                System.out.println("please enter id for editing");
                int id= scanner.nextInt();
                scanner.nextLine();
                categoryReposority.categorylist();
                System.out.println("please enter new category id");
                int categoryid= scanner.nextInt();
                scanner.nextLine();
                int result=  productrepository.edit_categoryId(id,categoryid);}
            case 4 ->{
                System.out.println("please enter id for editing");
                int id= scanner.nextInt();
                scanner.nextLine();
                brandrepository.brandlist();
                System.out.println("please enter new brand id");
                int brandid= scanner.nextInt();
                scanner.nextLine();
                int result=  productrepository.edit_categoryId(id,brandid);}
            }

        }




    public void delete_product() throws SQLException {
            productrepository.productlist();
            System.out.println("please select id for delete");
            int id =scanner.nextInt();
            int result= brandrepository.delete(id);
            if (result==1){
                System.out.println("product deleted");}
            else {
                System.out.println("please enter valid id");
            }
    }
}
