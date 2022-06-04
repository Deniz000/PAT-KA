package com.View;

import com.Helper.Config;
import com.Helper.Helper;

import javax.swing.*;
import java.awt.*;

public class EducatorGui extends JFrame{
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;

    public EducatorGui(){
        add(wrapper);
        setSize(500,500);
        setLocation(Helper.screenCenterLoc("x", getSize()), Helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TİTLE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {

        EducatorGui educatorGui = new EducatorGui();
    }
}
