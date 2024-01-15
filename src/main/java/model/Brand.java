package model;

public class Brand {
   private int brand_id;
    private String brand_name;
   private String website;
   private String description;

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

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id=" + brand_id +
                ", brand_name='" + brand_name + '\'' +
                ", website='" + website + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
