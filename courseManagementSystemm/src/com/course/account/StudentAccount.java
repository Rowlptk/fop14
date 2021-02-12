package com.course.account;

import com.course.database.Database;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentAccount extends Account{
    private long studentContactNumber;
    private String studentAddress;

    private Scanner s = new Scanner(System.in);

    public StudentAccount() {

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

        String sql = "select id, lastname, firstname from StudentAccounts where username = ? and password = ?";
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

    private void initializeAccount(ResultSet rs) {
        try {
            this.id = rs.getString(1);
            this.lastName = rs.getString(2);
            this.firstName = rs.getString(3);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void studentRegisterForCourse() {
        String table_name;
        Course course = new Course();
        int id = Integer.parseInt(this.id);
        if(course.checkCourseCodeInDB("BEX")) {
            table_name = "Stud"+"BEX"+this.id;
            String sql = "insert into studentRegisterForCourse(student_id,course_id,student_contact,student_address,student_table_name)" +
                        "values(?, ?, ?, ?, ?)";
            try {
                pstmt = Database.getConnection().prepareStatement(sql);
                pstmt.setInt(1, id);
                pstmt.setInt(2, course.getCourseId());
                pstmt.setLong(3, 9801200115L);
                pstmt.setString(4,"Baneswor,Kathmandu");
                pstmt.setString(5, table_name);
                pstmt.executeUpdate();
                createStudentTable(table_name);
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void enrollModule() {
        int stud_id = Integer.parseInt(this.id);
        int course_id = fetchRegisteredCourseId();
        int sem = fetchCurrentSem();
        for (Integer module_id : fetchModuleIDForSem(course_id)) {
            System.out.println(stud_id + " " + course_id + " " + sem + " " + module_id);
            insertModulesIntoStudentTables(stud_id, module_id, sem);
        }
        System.out.println("All Modules for Semester " + sem + " are enrolled");
    }

    public void chooseTeacherForCurrentModules() {
        InstructorAccount inst = new InstructorAccount();
        int stud_id = Integer.parseInt(this.id);
        String my_table = fetchStudentTable(stud_id);
        String sql = "select B.module_name,A.module_id from " + my_table + " A join modules B on A.module_id = B.module_id";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString(1) + "\nChoose Teacher ID:\n" );
                inst.loadAllInstructor();
                int teacher_id = s.nextInt();
                updateStudentTableWithInstructorID(rs.getInt(2),teacher_id);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateStudentTableWithInstructorID(int module_id, int teacher_id) {
        int stud_id = Integer.parseInt(this.id);
        String table_name = fetchStudentTable(stud_id);
        String sql = "update " + table_name + " set teacher_id = ? where module_id = ?";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1, teacher_id);
            pstmt.setInt(2, module_id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void createStudentTable(String table_name) {
            String sql = "create table " + table_name  + " ( student_id int, module_id int, teacher_id varchar(20), module_sem int, module_marks int)";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.execute();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int fetchCurrentSem() {
        int id = Integer.parseInt(this.id);
        int sem = 0;
        String sql = "select current_sem from studentRegisterForCourse where student_id = ?";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                sem = rs.getInt(1);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return sem;
    }


    public ArrayList<Integer> fetchModuleIDForSem(int courseId) {
        ArrayList<Integer> module_list = new ArrayList<>();
        String sql = "select module_id from modules where course_id = ?";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1, courseId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                module_list.add(rs.getInt(1));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return module_list;
    }

    public String fetchStudentTable(int studentId) {
        String sql = "select student_table_name from studentRegisterForCourse where student_id = ?";
        String table_name = "";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                table_name = rs.getString(1);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return table_name;
    }

    public ArrayList<String> fetchAllStudentTable() {
        ArrayList<String> stud_table = new ArrayList<>();
        String sql = "select student_table_name from studentRegisterForCourse";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                stud_table.add(rs.getString(1));
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return stud_table;
    }


    public void insertModulesIntoStudentTables(int studentId, int module_id, int module_sem) {
        String table_name = fetchStudentTable(studentId);
        String sql = "insert into "+ table_name +" (student_id, module_id, module_sem) values(?, ?, ?)";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, module_id);
            pstmt.setInt(3, module_sem);
            pstmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int fetchRegisteredCourseId() {
        int id = Integer.parseInt(this.id);
        int course_id = 0;
        String sql = "select course_id from studentRegisterForCourse where student_id = ?";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                course_id = rs.getInt(1);
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return course_id;
    }
}
