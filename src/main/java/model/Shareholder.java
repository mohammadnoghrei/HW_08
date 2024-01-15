package model;

public class Shareholder {
   private int shareholder_id;
   private String shareholder_name;
   private String phonenumber;
   private String nationalcode;

    public Shareholder() {
    }

    public Shareholder(int shareholder_id, String shareholder_name, String phonenumber, String nationalcode) {
        this.shareholder_id = shareholder_id;
        this.shareholder_name = shareholder_name;
        this.phonenumber = phonenumber;
        this.nationalcode = nationalcode;
    }

    public Shareholder(String shareholder_name, String phonenumber, String nationalcode) {
        this.shareholder_name = shareholder_name;
        this.phonenumber = phonenumber;
        this.nationalcode = nationalcode;
    }

    public int getShareholder_id() {
        return shareholder_id;
    }

    public void setShareholder_id(int shareholder_id) {
        this.shareholder_id = shareholder_id;
    }

    public String getShareholder_name() {
        return shareholder_name;
    }

    public void setShareholder_name(String shareholder_name) {
        this.shareholder_name = shareholder_name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getNationalcode() {
        return nationalcode;
    }

    public void setNationalcode(String nationalcode) {
        this.nationalcode = nationalcode;
    }

    @Override
    public String toString() {
        return "Shareholder{" +
                "shareholder_id=" + shareholder_id +
                ", shareholder_name='" + shareholder_name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", nationalcode='" + nationalcode + '\'' +
                '}';
    }
}
