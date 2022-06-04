package com.View;

import com.Helper.Config;
import com.Helper.Helper;

import javax.swing.*;
import java.awt.*;

public class StudentGui extends JFrame{
    private JPanel wrapper;

    public StudentGui() {
        add(wrapper);
        setSize(500,500);
        setLocation(Helper.screenCenterLoc("x", getSize()), Helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TİTLE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        StudentGui studentGui = new StudentGui();
    }
}
