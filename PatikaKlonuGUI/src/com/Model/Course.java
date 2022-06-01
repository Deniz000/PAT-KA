package com.Model;

import com.Helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int id;
    private int educatorId;
    private int patikaId;
    private String name;
    private String language;
    private Patika patika;
    private User educator;

    public Course() {
    }

    public Course(int id, int educatorId, int patikaId, String name, String language) {
        this.id = id;
        this.educatorId = educatorId;
        this.patikaId = patikaId;
        this.name = name;
        this.language = language;
        this.patika = Patika.getFetch(getPatikaId());
        this.educator = User.getFetch(getEducatorId());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEducatorId() {
        return educatorId;
    }

    public void setEducatorId(int educatorId) {
        this.educatorId = educatorId;
    }

    public int getPatikaId() {
        return patikaId;
    }

    public void setPatikaId(int patikaId) {
        this.patikaId = patikaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public static ArrayList<Course> getList(){
        ArrayList<Course> courses = new ArrayList<>();
        Course obj;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from courses");
            while (resultSet.next()){
                obj = new Course();
                obj.setId(resultSet.getInt("id"));
                obj.setName(resultSet.getString("name"));
                obj.setLanguage(resultSet.getString("language"));
                obj.setPatikaId(resultSet.getInt("patika_id"));
                obj.setEducatorId(resultSet.getInt("user_type"));
                courses.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }


    public static boolean deleteById(int idValue) {
        String sql = "delete from course where id = ?";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1,idValue);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<Course> getListByUserId(int userId){
        ArrayList<Course> courses = new ArrayList<>();
        Course obj;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from courses where user_type =" + userId);
            while (resultSet.next()){
                obj = new Course();
                obj.setId(resultSet.getInt("id"));
                obj.setName(resultSet.getString("name"));
                obj.setLanguage(resultSet.getString("language"));
                obj.setPatikaId(resultSet.getInt("patika_id"));
                obj.setEducatorId(resultSet.getInt("user_type"));
                courses.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    public static int currentTotal(){
        String sql = "select id from courses where id >= (select count(*) from courses)";
        int total = -1;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()){
                total = set.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;

    }
    public static boolean add(String userType, int patika, String name, String language){
       int user_type = User.switchControl(userType);
        int total = currentTotal() + 1;
        String sql = "insert into courses (id, user_type, patika_id, name,language) values(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, total);
            preparedStatement.setInt(2, user_type);
            preparedStatement.setInt(3,patika);
            preparedStatement.setString(4,name);
            preparedStatement.setString(5,language);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
