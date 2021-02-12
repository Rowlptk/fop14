package com.course.account;

import com.course.database.Database;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        System.out.println("Press:\n1. Add New Course\n2. Add Modules to Course\n3. Cancel Course Temporarily\n4. Delete Course\n5. Edit Course\n" +
                "6. List Active Course \n7. Generate Report\n8. Exit\nSelect: ");
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
            case 6:
                course.listAllCourses();
                break;
            case 7:
                generateReport();
                break;
            case 8:
                System.exit(0);
            default:
                System.out.println("Invalid Input");
                adminMenu();
        }

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

    public void generateReport() {
        StudentAccount stud = new StudentAccount();
        stud.fetchAllRegisteredStudents();
        int id = enterStudentId();
        String student_table = stud.fetchStudentTable(id);
        ArrayList<Integer> module_id = new ArrayList<>();
        ArrayList<String> module_name = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();
        String firstName = "";
        String lastName = "";
        String sql = "Select A.module_id, C.module_name, A.student_id , B.firstname, B.lastname,A.module_marks from \n" +
                student_table +" A \n" +
                "join \n" +
                "StudentAccounts B\n" +
                "on A.student_id = B.id\n" +
                "join\n" +
                "modules C\n" +
                "on A.module_id = C.module_id";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                module_id.add(rs.getInt(1));
                module_name.add(rs.getString(2));
                marks.add(rs.getInt(6));
                firstName = rs.getString(4);
                lastName = rs.getString(5);
            }
            generatePdf(student_table,id,firstName,lastName,module_id,module_name,marks);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void generatePdf(String stud_table,int stud_id,String firstName
            ,String lastName, ArrayList<Integer> module_id, ArrayList<String> module_name
            ,ArrayList<Integer> marks) {
        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(stud_table+".pdf"));
            document.open();
            document.add(new Paragraph(stud_id + " " + firstName + " " +lastName + " \n"));
            for(int i = 0; i < module_id.size(); i++) {
                document.add(new Paragraph(module_id.get(i) + "   " + module_name.get(i) + "                " +marks.get(i) + " \n"));
            }

            document.close();
            writer.close();
        } catch (DocumentException e)
        {
            e.printStackTrace();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private int enterStudentId() {
        int id = 0;
        System.out.println("Enter Student ID : ");
        id = s.nextInt();
        return id;
    }

}
