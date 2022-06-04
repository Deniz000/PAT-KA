package com.Model;

import com.Helper.DbConnector;
import com.Helper.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Task {
    private int id;
    private String task;
    private int educatorId;

    private User user;

    public Task() {
    }

    public Task(int id, String task, int educatorId) {
        this.id = id;
        this.task = task;
        this.educatorId = educatorId;
    }

    public static ArrayList<Task> getList() {
        ArrayList<Task> tasks = new ArrayList<>();
        Task task;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from tasks");
            while (rs.next()){
                task = new Task();
                task.setId(rs.getInt("id"));
                task.setTask(rs.getString("task"));
                task.setEducatorId(rs.getInt("educator_id"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getEducatorId() {
        return educatorId;
    }

    public void setEducatorId(int educatorId) {
        this.educatorId = educatorId;
    }

    public static boolean add(int eduID, String task){
        String sql = "insert into tasks(id, task, educator_id) values(?,?,?)";
        int id = currentCount();

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,task);
            preparedStatement.setInt(3,eduID);
            return preparedStatement.executeUpdate() !=-1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    private static int currentCount() {
        String sql = "select count(*) as total from tasks";
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
        String sql = "select max(id) from tasks";
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
}
