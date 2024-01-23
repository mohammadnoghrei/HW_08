package service;

import model.Shareholder_Brand;
import repository.Brandrepository;
import repository.ShareholderRepository;
import repository.Shareholder_Brand_repository;

import java.sql.SQLException;
import java.util.Scanner;

public class Shareholde_Brand_service {
    Shareholder_Brand_repository shareholder_brand_repository;
    ShareholderRepository shareholderRepository;
    Brandrepository brandrepository;
    Scanner scanner=new Scanner(System.in);

    public Shareholde_Brand_service(Shareholder_Brand_repository shareholder_brand_repository, ShareholderRepository shareholderRepository, Brandrepository brandrepository) {
        this.shareholder_brand_repository = shareholder_brand_repository;
        this.shareholderRepository = shareholderRepository;
        this.brandrepository = brandrepository;
    }

    public void setShareholder_brand() throws SQLException {
        shareholderRepository.shareholderlist();
        System.out.println("please enter share holder id:");
        int shareholder_id =scanner.nextInt();
        brandrepository.brandlist();
        System.out.println("please enter brand id:");
        int brand_id = scanner.nextInt();
        Shareholder_Brand shareholder_brand=new Shareholder_Brand(shareholder_id,brand_id);
        int result =shareholder_brand_repository.register(shareholder_brand);
        if (result==1)
            System.out.println("shareholder and brand added to table");
        else {System.out.println("something is wrong try again");
            setShareholder_brand();}

    }

}
