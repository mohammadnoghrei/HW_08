package model;

public class Shareholder_Brand {
    int shareholder_id;
    int brand_id;

    public Shareholder_Brand() {
    }

    public Shareholder_Brand(int shareholder_id, int brand_id) {
        this.shareholder_id = shareholder_id;
        this.brand_id = brand_id;
    }

    public int getShareholder_id() {
        return shareholder_id;
    }

    public void setShareholder_id(int shareholder_id) {
        this.shareholder_id = shareholder_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    @Override
    public String toString() {
        return "Shareholder_Brand{" +
                "shareholder_id=" + shareholder_id +
                ", brand_id=" + brand_id +
                '}';
    }
}
