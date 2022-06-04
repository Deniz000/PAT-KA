package com.Model;

import com.Helper.DbConnector;
import com.Helper.Helper;

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
        int count = 0;

        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs3 = st.executeQuery(query);
            while (rs3.next()) {
                count = rs3.getInt(1);

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
        String sql = "select max(id) from users";
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
    public static int switchControl(String type) {
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

        int total = countCurrent();
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
        System.out.println("A1");
        String sql = "delete from users where id = ?";
        int type = getFetch(idValue).getType_id();
        try {
            System.out.println("A2");
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, idValue);
            if(type == 2){
                Course.deleteByUserId(idValue);
                Helper.showMsg("Bu eğitmene ait tüm kurslar silindi");
            }
            System.out.println("A3");
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean update(int id, String name, String userName, String password, String type) {
        int typeValue = switchControl(type);
        String query = "Update users set name = ?, user_name =?, password=?, type_id = ? where id = ?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, typeValue);
            preparedStatement.setInt(5, id);

            return (preparedStatement.executeUpdate() != -1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static ArrayList<User> userArrayList(String query) {
        ArrayList<User> users = new ArrayList<>();
        User obj;
        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("user_name"));
                obj.setPassword(rs.getString("password"));
                obj.setType_id(rs.getInt("type_id"));
                users.add(obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static String searchQuery(String name, String userName) {
        String sql = "select * from users where name like '%{{name}}%' and user_name like '%{{user_name}}%'";
        sql = sql.replace("{{name}}", name);
        sql = sql.replace("{{user_name}}", userName);

        return sql;
    }

    public static String controlFirstLetter(String value) {
        String deger = (value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase()).trim();
        return deger;
    }

    public static User getFetch(String name) {
        User user = null;
        String sql = "select * from users where name = ?";
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(sql);
            pr.setString(1, name);
            ResultSet set = pr.executeQuery();
            while (set.next()) {
                user = new User(set.getInt("id"), set.getString("name"), set.getString("user_name"), set.getString("password"), set.getInt("type_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User getFetch(int id) {
        User user = null;
        String sql = "select * from users where id = ?";
        try {
            PreparedStatement pr = DbConnector.getInstance().prepareStatement(sql);
            pr.setInt(1, id);
            ResultSet set = pr.executeQuery();
            while (set.next()) {
                user = new User(set.getInt("id"), set.getString("name"), set.getString("user_name"), set.getString("password"), set.getInt("type_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
