package service;

import model.Shareholder;
import repository.ShareholderRepository;
import repository.Shareholder_Brand_repository;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class ShareholderService {
    ShareholderRepository shareholderRepository;
    Shareholder_Brand_repository shareholder_brand_repository;
    Scanner scanner =new Scanner(System.in);

    public ShareholderService(ShareholderRepository shareholderRepository, Shareholder_Brand_repository shareholder_brand_repository) {
        this.shareholderRepository = shareholderRepository;
        this.shareholder_brand_repository = shareholder_brand_repository;
    }

    public void add_shareholder() throws SQLException {
        System.out.println("enter shareholder name:");
        String name = scanner.nextLine();
        System.out.println("enter shareholder phoneNumber:");
        String phoneNumber ;
        while (true){
            phoneNumber=scanner.nextLine();
            if (Validation.phonenumbervalidation(phoneNumber))
                break;
            else System.out.println("please enter a valid number");
        }
        System.out.println("enter shareholder nationalcode:");
        String nationalCode;
        while (true) {
            nationalCode = scanner.nextLine();
            if (Validation.validateMelliCode(nationalCode)){
                break;
            }else {
                System.out.println("please enter a valid national code");
            }
        }
        Shareholder shareholder=new Shareholder(name,phoneNumber,nationalCode);
        int result=shareholderRepository.register(shareholder);
        if (result==1)
            System.out.println(name + " add to shareholder successfully :)");
        else System.out.println("something is wrong");
    }

    public void delete_shareholder() throws SQLException {
        shareholderRepository.shareholderlist();
        System.out.println("please select id for delete");
        int id =scanner.nextInt();
//        shareholder_brand_repository.delete_shareholder(id);

        int result= shareholderRepository.delete(id);
        if (result==1){
            shareholder_brand_repository.delete_shareholder(id);
            System.out.println("shareholder deleted");}
        else {
            System.out.println("please enter valid id");
            delete_shareholder();
        }

    }
    public void edit_shareholder() throws SQLException {

        System.out.println("1--> edit name \n 2--> edit phonenumber \n 3--> edit nationalcode");
        int edit = scanner.nextInt();
        shareholderRepository.shareholderlist();
        switch (edit){
            case 1 -> {
                System.out.println("please enter id for editing");
                int id= scanner.nextInt();
                scanner.nextLine();
                System.out.println("please enter new name");
                String name =scanner.nextLine();
                 int result=  shareholderRepository.edit_shareholder_name(id,name);break;}

        case 2 ->{
                System.out.println("please enter id for editing");
                int id= scanner.nextInt();
            scanner.nextLine();
                System.out.println("please enter new phone number");
            String phoneNumber ;
            while (true){
                phoneNumber=scanner.nextLine();
                if (Validation.phonenumbervalidation(phoneNumber))
                    break;
                else System.out.println("please enter a valid number");
            }
                int result=  shareholderRepository.edit_shareholder_phonenumber(id,phoneNumber);break;}

            case 3 ->{
                System.out.println("please enter id for editing");
                int id= scanner.nextInt();
                scanner.nextLine();
                System.out.println("please enter new phone nationalcode");
                String nationalCode;
                while (true) {
                    nationalCode = scanner.nextLine();
                    if (Validation.validateMelliCode(nationalCode)){
                        break;
                    }else {
                        System.out.println("please enter a valid national code");
                    }
                int result=  shareholderRepository.edit_shareholder_nationalCode(id,nationalCode);break;}
        }
        }


    }
}
