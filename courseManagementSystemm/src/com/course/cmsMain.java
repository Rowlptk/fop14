package com.course;

import com.course.account.Account;
import com.course.account.AdministratorAccount;
import com.course.account.InstructorAccount;
import com.course.account.StudentAccount;

import java.util.Scanner;

public class cmsMain {
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("Login:\n1. Administrator Account\n2. Instructor Account\n3. Student Account\n4. Exit\n   Select : ");
        int opt = s.nextInt();
        s.nextLine();
        switch(opt) {
            case 1:
                AdministratorAccount admin = new AdministratorAccount();
                admin.setUserName(getStaticUsername());
                admin.setPassword(getStaticPassword());
                if(admin.validateAdministrator()) {
                    System.out.println("Welcome " + admin.getFirstName() + " " + admin.getLastName());
                    admin.adminMenu();
                } else {
                    mainMenu();
                }
                break;
            case 2:
                InstructorAccount ins = new InstructorAccount();
                ins.setLoginInfo(getStaticUsername(), getStaticPassword());
                if(ins.isInDatabase()) {
                    System.out.println("Welcome " + ins.getFirstName() + " " + ins.getLastName());
                    ins.instructorMenu();
                } else {
                    System.out.println("username or password is incorrect!");
                    mainMenu();
                }
                break;
            case 3:
                StudentAccount stud = new StudentAccount();
                stud.setLoginInfo(getStaticUsername(), getStaticPassword());
                if(stud.isInDatabase()) {
                    System.out.println("Welcome " + stud.getFirstName() + " " + stud.getLastName());
                    stud.studentMenu();
                } else {
                    System.out.println("username or password is incorrect!");
                    mainMenu();
                }
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid Input!");
                mainMenu();
        }
    }

    public static String getStaticUsername() {
        System.out.println("Enter username : ");
        String username = s.nextLine();
        return username;
    }

    public static String getStaticPassword() {
        System.out.println("Enter password : ");
        String password = s.nextLine();
        return password;
    }
}
