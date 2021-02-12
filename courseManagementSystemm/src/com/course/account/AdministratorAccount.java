package com.course.account;

import com.course.database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdministratorAccount {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String id;
    private PreparedStatement pstmt;

    public Scanner s = new Scanner(System.in);
    public AdministratorAccount() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean validateAdministrator() {
        String ret = "";
        boolean isValid = false;
        if(userName.equals("") || password.equals("")) {
            ret ="username or password must have values";
        } else {
            if(isInDatabase()) {
                ret = "Administrator Validated!";
                isValid = true;
            } else {
                ret = "username or password is incorrect!";
            }
        }
        System.out.println(ret);
        return isValid;
    }


    public boolean isInDatabase() {
        boolean ret = false;

        String sql = "select id, lastname, firstname from AdministratorAccounts where username = ? and password = ?";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setString(1, this.userName);
            pstmt.setString(2, this.password);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                initializeAccount(rs);
                ret = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    private void initializeAccount(ResultSet rs) {
        try {
            this.id = rs.getString(1);
            this.lastName = rs.getString(2);
            this.firstName = rs.getString(3);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void adminMenu() {
        Course course = new Course();
        System.out.println("Press:\n1. Add New Course\n2. Add Modules to Course\n3. Cancel Course Temporarily\n4. Delete Course\n5. Edit Course");
        int opt = s.nextInt();
        s.nextLine();
        switch (opt) {
            case 1:
                course.setCourseCode(enterCourseCode());
                course.setCourseName(enterCourseName());
                course.setNumOfSem(enterCourseNumOfSem());
                course.createCourse();
                break;
            case 2:
                course.listAllCourses();
                course.createModuleForCourse(enterCourseCode());
                break;
            case 3:
                course.listAllCourses();
                course.cancelCourseTemporarily(enterCourseCode());
                break;
            case 4:
                course.listAllCourses();
                course.deleteCourse(enterCourseCode());
                break;
            case 5:
                course.editCourse();
                break;
            default:
                System.out.println("Invalid Input");
        }
        proceed();
    }

    private String enterCourseCode() {
        System.out.println("Enter Course Code : ");
        String courseCode = s.nextLine();
        return courseCode;
    }

    private String enterCourseName() {
        System.out.println("Enter Course Name : ");
        String courseName = s.nextLine();
        return courseName;
    }

    private int enterCourseNumOfSem() {
        System.out.println("Enter Number Of Semester : ");
        int courseNumOfSem = s.nextInt();
        return courseNumOfSem;
    }

    private void proceed() {
        System.out.println("Press Y to continue : ");
        String opt = s.nextLine();
        if(opt.equals("Y") || opt.equals("y")) {
            adminMenu();
        }
    }


}
