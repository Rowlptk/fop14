package com.course.account;

import com.course.database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modules {
    private int moduleId;
    private String moduleName;
    private int moduleForSemNum;
    private int courseId;

    private PreparedStatement pstmt;

    public Modules() {

    }

    public Modules(String moduleName, int moduleForSemNum, int courseId) {
        this.moduleName = moduleName;
        this.moduleForSemNum = moduleForSemNum;
        this.courseId = courseId;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getModuleForSemNum() {
        return moduleForSemNum;
    }

    public void setModuleForSemNum(int moduleForSemNum) {
        this.moduleForSemNum = moduleForSemNum;
    }

    public void createModuleForCourseForSem() {
        String sql = "insert into modules(course_id,module_sem,module_name) values (?, ?, ?)";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1, this.courseId);
            pstmt.setInt(2, this.moduleForSemNum);
            pstmt.setString(3, this.moduleName);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void changeModuleName(int moduleId, String moduleNewName) {


        String sql = "update modules set module_name = ? where module_id = ?";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setString(1, moduleNewName);
            pstmt.setInt(2, moduleId);
            pstmt.executeUpdate();
            System.out.println("Module Name Changed!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadAllModules(int courseId) {
        String sql = "select A.course_code, B.module_id, B.module_sem, B.module_name  from course A " +
                "join modules B on A.course_id = B.course_id where A.course_id = ?";
        try {
            pstmt = Database.getConnection().prepareStatement(sql);
            pstmt.setInt(1, courseId);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Course Code  Module Id  Module Sem  Module Name");
            while(rs.next()) {
                System.out.println(rs.getString(1)+ "\t\t\t " +rs.getInt(2) + "\t\t\t " + rs.getInt(3) + "\t\t\t " + rs.getString(4) +"");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Modules{" +
                "moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                ", moduleForSemNum=" + moduleForSemNum +
                ", courseId=" + courseId +
                '}';
    }
}
