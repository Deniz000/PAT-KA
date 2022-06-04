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
        int count = 0;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        count++;

        if(count == lastId()){
            count++;
        }
        return count;
    }

    public static int lastId(){
        String sql = "select max(id) from patika";
        int id = 0;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static boolean add(String name){
        int total = countCurrent();
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
    public static boolean update(int id, String name){
        String sql = "update patika set name = ? where id = ?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2,id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public static Patika getFetch(int id){
        Patika obj = null;
        String sql = "select * from patika where id = ?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet set = preparedStatement.executeQuery();
            while(set.next()){
                obj = new Patika(set.getInt("id"),set.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public static Patika getFetch(String name){
        Patika obj = null;
        String sql = "select * from patika where name = ?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet set = preparedStatement.executeQuery();
            while(set.next()){
                obj = new Patika(set.getInt("id"),set.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static boolean delete(int id){
        String sql = "delete from patika where id = ?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
