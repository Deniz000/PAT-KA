package com.View;

import com.Helper.Config;
import com.Helper.DbConnector;
import com.Helper.Helper;
import com.Model.Patika;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePatikaGui extends JFrame {
    private JPanel mainPanel;
    private JTextField txtPatikaName;
    private JButton updateButton;
    private Patika patika;

    public UpdatePatikaGui() {

    }

    public UpdatePatikaGui(Patika patika){
        this.patika = patika;
        add(mainPanel);
        setSize(300,150);
        setLocation(Helper.screenCenterLoc("x",getSize()), Helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);;
        setTitle(Config.PROJECT_TİTLE);
        setVisible(true);

        txtPatikaName.setText(patika.getName());

        updateButton.addActionListener(e -> {
            if (Helper.isFieldEmpty(txtPatikaName)){
                Helper.showMsg("fill");
            }
            else{
                if(Patika.update(patika.getId(),txtPatikaName.getText())){
                    Helper.showMsg("succed");
                }
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        Patika p = new Patika(1,"Frontend");
        UpdatePatikaGui updatePatikaGui = new UpdatePatikaGui(p);

    }
}
