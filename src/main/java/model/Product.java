package model;

import java.util.Date;

public class Product {
    private  int product_id ;

    private String product_name;
    private Date crate_date;
    private int category_id;
    private int brand_id;

    public Product() {
    }

    public Product(int product_id, String product_name, Date crate_date, int category_id, int brand_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.crate_date = crate_date;
        this.category_id = category_id;
        this.brand_id = brand_id;
    }

    public Product(String product_name, Date crate_date, int category_id, int brand_id) {
        this.product_name = product_name;
        this.crate_date = crate_date;
        this.category_id = category_id;
        this.brand_id = brand_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Date getCrate_date() {
        return crate_date;
    }

    public void setCrate_date(Date crate_date) {
        this.crate_date = crate_date;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", crate_date=" + crate_date +
                ", category_id=" + category_id +
                ", brand_id=" + brand_id +
                '}';
    }
}
