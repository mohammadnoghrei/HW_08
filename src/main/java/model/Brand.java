package model;

public class Brand {
    int brand_id;
    String brand_name;
    String website;
    String description;

    public Brand() {
    }

    public Brand(int brand_id, String brand_name, String website, String description) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.website = website;
        this.description = description;
    }

    public Brand(String brand_name, String website, String description) {
        this.brand_name = brand_name;
        this.website = website;
        this.description = description;
    }

}
