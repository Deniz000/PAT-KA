package com.View;

import com.Helper.Config;
import com.Helper.Helper;
import com.Model.User;

import javax.swing.*;

public class LoginGui extends JFrame{
    private JPanel wrapper;
    private JPanel wrapperTop;
    private JPanel wrapperBottom;
    private JPanel wrapper3;
    private JTextField fieldUserUName;
    private JPasswordField fieldUserPassword;
    private JLabel sifreLabel;
    private JButton btnLogin;

    public LoginGui(){
        add(wrapper);
        setSize(500,500);
        setLocation(Helper.screenCenterLoc("x", getSize()), Helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TİTLE);
        setResizable(false);
        setVisible(true);

        btnLogin.addActionListener(e -> {
            if(Helper.isFieldEmpty(fieldUserUName) ||
            Helper.isFieldEmpty(fieldUserPassword)){
                Helper.showMsg("fill");
            }else{
                User user = User.getFetch(fieldUserUName.getText(), fieldUserPassword.getText());
                        if(user == null){
                            Helper.showMsg("Kullanıcı bulunumadı");
                        }else{
                            switch (user.getType_id()){
                                case 1:
                                    OperatorGUI operatorGUI = new OperatorGUI();
                                    break;
                                case 2:
                                    EducatorGui educatorGui = new EducatorGui();
                                    break;
                                case 3:
                                    StudentGui studentGui = new StudentGui();
                                    break;
                            }
                            dispose();
                        }
            }
        });
    }

    public static void main(String[] args) {
        Helper.setLayout();
        LoginGui loginGui = new LoginGui();
    }
}
