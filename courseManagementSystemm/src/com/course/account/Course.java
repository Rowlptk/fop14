package com.course.account;

import com.course.database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Course {
    private int courseId;
    private String courseCode;
    private String courseName;
    private int numOfSem;
    private PreparedStatement pstmt;


    private Scanner s = new Scanner(System.in);

    public Course() {

    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumOfSem() {
        return numOfSem;
    }

    public void setNumOfSem(int numOfSem) {
        this.numOfSem = numOfSem;
    }

    public void createCourse() {
        String sql = "insert into course(course_code,course_name,course_sem) values (?, ?, ?)";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setString(1, this.courseCode);
            pstmt.setString(2, this.courseName);
            pstmt.setInt(3, this.numOfSem);
            pstmt.executeUpdate();
            System.out.println("Course " + this.courseCode + " created successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void createModuleForCourse(String courseCode) {
        String proceed = "";
        if(checkCourseCodeInDB(courseCode)) {
            System.out.println("Enter Semester : ");
            int sem = s.nextInt();
            s.nextLine();
            do {
                System.out.println("Enter Module Name : ");
                String moduleName = s.nextLine();
                Modules module = new Modules(moduleName, sem, this.courseId);
                module.createModuleForCourseForSem();
                System.out.println("Press Y to add more : ");
                proceed = s.nextLine();
            } while (proceed.equals("Y"));
        } else {
            System.out.println("Course Code " + courseCode + " doesnot exist!");
        }
    }

    public boolean checkCourseCodeInDB(String courseCode) {
        boolean ret = false;

        String sql = "select * from course where course_code = ?";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setString(1, courseCode);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                ret = true;
                initializeCourseId(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ret;
    }

    private void initializeCourseId(ResultSet rs) {
        try {
            this.courseId = rs.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void cancelCourseTemporarily(String courseCode) {
        if (checkCourseCodeInDB(courseCode)) {
            String sql = "update course set is_active = 0 where course_id = ?";
            try {
                pstmt = Database.getConnection().prepareStatement(sql);
                pstmt.setInt(1, this.courseId);

                pstmt.executeUpdate();

                System.out.println("Course " + courseCode + " Cancelled Temporarily!");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Course Not Found!");
        }
    }

    public void deleteCourse(String courseCode) {
        if(checkCourseCodeInDB(courseCode)) {
            String sql = "delete C from course C inner join modules M on C.course_id = M.course_id where C.course_id = ?";
            try {
                pstmt = Database.getConnection().prepareStatement(sql);
                pstmt.setInt(1, this.courseId);

                pstmt.executeUpdate();

                System.out.println("Course " + courseCode + " deleted Successfully!");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("Course Not Found!");
        }
    }

    public void editCourse() {
        System.out.println("Press:\n1. Edit Course Name\n2. Edit Module Name\n3. Exit\n Select: ");
        int opt = s.nextInt();
        s.nextLine();
        switch(opt) {
            case 1:
                listAllCourses();
                editCourseName(enterCourseCode(), enterNewName());
                break;
            case 2:
                if(checkCourseCodeInDB(enterCourseCode())) {
                    Modules module = new Modules();
                    module.loadAllModules(this.courseId);
                    module.changeModuleName(enterId(),enterNewName());
                } else {
                    System.out.println("Course Not Found!");
                }
                break;
            case 3:
                System.exit(0);
            default:
                editCourse();
        }
    }

    public void editCourseName(String courseCode, String courseNewName) {
        if(checkCourseCodeInDB(courseCode)) {
            String sql = "update course set course_name = ? where course_id = ?";
            try {
                pstmt = Database.getConnection().prepareStatement(sql);
                pstmt.setString(1, courseNewName);
                pstmt.setInt(2, this.courseId);

                pstmt.executeUpdate();

                System.out.println("Course " + courseCode + " updated Successfully");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Course Not Found!");
        }


    }

    public void listAllCourses() {
        String sql = "select * from course";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Course ID  Course Code  Course Name");
            while(rs.next()) {
                System.out.println(rs.getInt(1)+ "\t\t\t " +rs.getString(2) + "\t\t\t " + rs.getString(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private String enterCourseCode() {
        System.out.println("Enter Course Code : ");
        String courseCode = s.nextLine();
        return courseCode;
    }

    private String enterNewName() {
        System.out.println("Enter New Name : ");
        String courseNewName = s.nextLine();
        return courseNewName;
    }

    private int enterId() {
        System.out.println("Enter Module Id : ");
        int moduleId = s.nextInt();
        return moduleId;
    }
}
