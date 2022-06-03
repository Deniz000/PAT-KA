package com.Model;

import com.Helper.DbConnector;

import java.awt.image.DataBuffer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int id;
    private int user_id;
    private int patika_id;
    private String name;
    private String language;

    private Patika patika;
    private User user;

    public Course() {
    }

    public Course(int id, int user_id, int patika_id, String name, String language, Patika patika, User user) {
        this.id = id;
        this.user_id = user_id;
        this.patika_id = patika_id;
        this.name = name;
        this.language = language;
        this.patika = patika;
        this.user = user;
    }

    public static ArrayList<Course> getlist(){
        ArrayList<Course> courses = new ArrayList<>();
        Course obj;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet set = statement.executeQuery("select * from courses");
            while(set.next()){
                obj = new Course();
                obj.setId(set.getInt("id"));
                obj.setUser_id(set.getInt("user_id"));
                obj.setPatika_id(set.getInt("patika_id"));
                obj.setName(set.getString("name"));
                obj.setLanguage(set.getString("language"));
                courses.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static int currentTotal(){
        int total = 0;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet set = statement.executeQuery("select count(*) from courses");
            while (set.next()){
                total = set.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    public static boolean add(String cName, String cLanguage, String patika, String educator) {
        String sql = "insert into courses(id, user_id, patika_id, name, language) values(?,?,?,?,?)";

        int userId = User.getFetch(educator).getId();
        int patikaId = Patika.getFetch(patika).getId();
        int total = currentTotal() + 1;
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(sql);
            pr.setInt(1,total);
            pr.setInt(2,userId);
            pr.setInt(3,patikaId);
            pr.setString(4,cName);
            pr.setString(5,cLanguage);
            return pr.executeUpdate()!=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteById(int idValue) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPatika_id() {
        return patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
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
}
