package service;

import model.User;
import repository.UserReposority;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class Userservice {
    Scanner scanner =new Scanner(System.in);
    private final UserReposority userReposority;

    public Userservice(UserReposority userReposority) {
        this.userReposority = userReposority;
    }
    public void singUp() throws SQLException {
        System.out.println("Please enter your name:");
        Scanner scanner =new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your email:");
        String email;
        while (true) {
            email = scanner.nextLine();
            if (Validation.emailvalidation(email)){
                break;
            }else {
                System.out.println("please enter a valid email");
            }
        }

        System.out.println("Please enter your password:");
        String password;
        while (true) {
            password = scanner.nextLine();
            if (Validation.passwordvalidation(password)){
                break;
            }else {
                System.out.println("please enter a valid password");
            }
        }

        User user = new User(name, username,email, password);

        int result = userReposority.registerUser(user);
        if (result == 1)
            System.out.println(name + " you successfully register :)");
        else
            System.out.println("something is wrong :|");
    }

    public void signIn() throws SQLException {
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password");
        String password = scanner.nextLine();

        User user = userReposority.find(username,password);
        if (user == null){
            System.out.println("Please register first");
            singUp();}
        else if (!user.getPassword().equals(password)){
            System.out.println("Please enter correct password");
        signIn();}
        else
            System.out.println("WELCOME " + user.getUsername());
    }

}
