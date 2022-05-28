package com.Model;

import com.Helper.DbConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String userName;
    private String password;
    private int type_id;


    public User() {
    }

    public User(int id, String name, String userName, String password, int type_id) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.type_id = type_id;

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

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public static ArrayList<User> getList() {
        ArrayList<User> arrayList = new ArrayList<>();
        String quarry = "Select * From users";
        User obj;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet rs = statement.executeQuery(quarry);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("user_name"));
                obj.setPassword(rs.getString("password"));
                obj.setType_id(rs.getInt("type_id"));
                arrayList.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static int countCurrent() {
        String query = "Select count(*) as total From users";
        int count = -1;
        int a = -1;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs3 = st.executeQuery(query);
            while (rs3.next()) {
                count = rs3.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public static int switchControl(String type){
        int typeValue;
        switch (type) {
            case "Operator":
                typeValue = 1;
                break;
            case "Educator":
                typeValue = 2;
                break;
            case "Student":
                typeValue = 3;
                break;
            default:
                typeValue = 1;
                break;
        }
        return typeValue;
    }
    public static boolean add(String name, String userName, String password, String type) {
        int typeValue = switchControl(type);

        int total = countCurrent() + 1;
        String querry = "INSERT INTO users(id,name,user_name,password,type_id) values (?,?,?,?,?) ";
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(querry);
            pr.setInt(1, total);
            pr.setString(2, name);
            pr.setString(3, userName);
            pr.setString(4, password);
            pr.setInt(5, typeValue);
            return pr.executeUpdate() != -1;  // ekler, true döner çalışmazsa aşağıda false dönecektir
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean deleteById(int idValue) {
        String sql = "delete from users where id = ?";
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

    public static boolean update(int id, String name, String userName, String password, String type){
        int typeValue = switchControl(type);
        String query = "Update users set name = ?, user_name =?, password=?, type_id = ? where id = ?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,userName);
            preparedStatement.setString(3,password);
            preparedStatement.setInt(4,typeValue);
            preparedStatement.setInt(5, id);

            return (preparedStatement.executeUpdate() != -1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}
