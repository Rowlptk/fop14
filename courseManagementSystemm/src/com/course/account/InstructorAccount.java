package com.course.account;

import com.course.database.Database;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InstructorAccount extends Account {

    private Scanner s = new Scanner(System.in);

    public InstructorAccount() {

    }

    public void setLoginInfo(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean isInDatabase() {
        boolean ret = false;

        String sql = "select id, lastname, firstname from InstructorAccounts where username = ? and password = ?";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setString(1, this.username);
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

    public void instructorMenu() {
        System.out.println("Press: \n1.Assign Module to Teach\n2. List student assigned\n3. Add marks to Students\n4. Exit");
        int opt = s.nextInt();
        switch(opt) {
            case 1:
                instructorForModule();
                break;
            case 2:
                listAllStudentWithModules();
                break;
            case 3:
                listAllStudentWithModules();
                assignMarksToStudent(enterStudentId(),enterModuleID(),enterMarks());
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Invalid Option");
                instructorMenu();
        }
    }


    public void instructorForModule() {
        Course course = new Course();
        Modules module = new Modules();
        int ins_id = Integer.parseInt(this.id);
        course.listAllCourses();
        int course_id = enterCourseID();
        module.loadAllModules(course_id);
        int module_id = enterModuleID();
        String sql = "insert into instuctor_module(instructor_id, course_id, module_id) values (?, ?, ?)";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1,ins_id);
            pstmt.setInt(2, course_id);
            pstmt.setInt(3, module_id);
            pstmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

    }

    public int enterCourseID() {
        int courseId = 0;
        System.out.println("Enter Course Id : ");
        courseId = s.nextInt();
        return courseId;
    }

    public int enterModuleID() {
        int moduleId = 0;
        System.out.println("Enter Module Id : ");
        moduleId = s.nextInt();
        return moduleId;
    }

    public void listAllStudentWithModules() {
        StudentAccount stud = new StudentAccount();
        int ins_id = Integer.parseInt(this.id);
        for(String table : stud.fetchAllStudentTable()) {
            listAllStudentAssigned(table);
        }
//        assignMarksToStudent(enterStudentId(),enterModuleID(),enterMarks());
    }

    public int enterStudentId() {
        int stud_id = 0;
        System.out.println("Enter Student Id : ");
        stud_id = s.nextInt();
        return stud_id;
    }

    public int enterMarks() {
        int marks = 0;
        System.out.println("Enter Mark : ");
        marks = s.nextInt();
        return marks;
    }

    public void listAllStudentAssigned(String table_name) {
        int ins_id = Integer.parseInt(this.id);
        String sql = "Select A.module_id, C.module_name, A.student_id , B.firstname, B.lastname from \n" +
                table_name +" A \n" +
                "join \n" +
                "StudentAccounts B\n" +
                "on A.student_id = B.id\n" +
                "join\n" +
                "modules C\n" +
                "on A.module_id = C.module_id\n" +
                "where teacher_id = ?;";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1,ins_id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println("Moduleid==>"+ rs.getInt(1) + " ModuleName==>" + rs.getString(2) + " StudentId==>"
                        +rs.getInt(3) + " StudentName==> " + rs.getString(4) + " " +rs.getString(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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

    public void loadAllInstructor() {
        String sql = "select id, lastname, firstname from InstructorAccounts";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(3) + " " + rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void assignMarksToStudent(int studentId, int module_id, int marks) {
        StudentAccount stud = new StudentAccount();
        String stud_table = stud.fetchStudentTable(studentId);
        String sql = "update " + stud_table + " set module_marks = ? where module_id = ?";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1, marks);
            pstmt.setInt(2, module_id);
            pstmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
