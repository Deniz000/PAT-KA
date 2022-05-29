package com.Model;

import com.Helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Patika {
    private int id;
    private String name;

    public Patika() {
    }

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static ArrayList<Patika> getList(){
        ArrayList<Patika> patikas = new ArrayList<>();
        Patika obj;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet set = statement.executeQuery("Select * from patika");
            while (set.next()){
                obj = new Patika();
                obj.setId(set.getInt("id"));
                obj.setName(set.getString("name"));
                patikas.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patikas;
    }
    public static int countCurrent(){
        String sql = "select count(*) as total from patika";
        int count = -1;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static boolean add(String name){
        int total = countCurrent() + 1;
        String sql = "insert into patika(id,name) values(?,?)";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1,total);
            preparedStatement.setString(2,name);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
