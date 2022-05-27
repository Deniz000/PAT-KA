package com.View;

import com.Helper.Config;
import com.Helper.DbConnector;
import com.Helper.Helper;
import com.Model.Operator;
import com.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OperatorGUI extends JFrame {

    private static String[] args;
    private User user;
    private JPanel mainWrapper;
    private JTabbedPane tabb_operator;
    private JPanel tab_panel;
    private JButton exitButton;
    private JLabel lblWelcome;
    private JScrollPane scrollPanel;
    private JTable usersTable;
    private JPanel user_form;
    private JTextField txtName;
    private JTextField txtUserName;
    private JTextField txtPastword;
    private JComboBox comboBox1;
    private JButton btnAddUser;
    private DefaultTableModel mdl_user_list; //vektor tipli iki değişkeni biri başşlık tutar diğeri satırları
    private Object[] row_user_list;
    int count = 7;
    public OperatorGUI(){
        Helper.setLayout();
        add(mainWrapper);
        setSize(1000,1000);
        setLocation(Helper.screenCenterLoc("x",getSize()),Helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// proje kapatılınca aynı zamanda dursun
        setTitle(Config.PROJECT_TİTLE);
        setVisible(true);
        setResizable(false);
        // Object[] firstRow = {"1","Deniz Ozdemir","Deniz","123","1"};
        //mdl_user_list.addRow(firstRow);

        mdl_user_list = new DefaultTableModel();
        sort();
        usersTable.setModel(mdl_user_list);
        usersTable.getTableHeader().setReorderingAllowed(false);

        btnAddUser.addActionListener(e -> {
            if (Helper.isFieldEmpty(txtName)||
                    Helper.isFieldEmpty(txtUserName)||
                    Helper.isFieldEmpty(txtPastword) ){
                JOptionPane.showConfirmDialog(null,"lütfen tüm alanları doldurun", "Hata",JOptionPane.CLOSED_OPTION);
            }
            else{
                if(addUser(count)){
                    JOptionPane.showConfirmDialog(null,txtName.getName() + " Başarıyla Eklendi!", "Bilgi",JOptionPane.CLOSED_OPTION);
                    sort();
                    txtName.setText("");
                    txtUserName.setText("");
                    txtPastword.setText("");
                    return;
                }
                else{
                    System.out.println("Üzgünüz. Bir aksilik oldu!");
                    return;
                }

            }
        });
    }
    public void sort(){
        DefaultTableModel clearModel = (DefaultTableModel) usersTable.getModel();
        clearModel.setRowCount(0);
        for(User user: User.getList()){
            Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
            mdl_user_list.setColumnIdentifiers(col_user_list);
            Object[] row = new Object[col_user_list.length];
            row[0] = user.getId();
            row[1] = user.getName();
            row[2] = user.getUserName();
            row[3] = user.getPassword();
            row[4] = user.getType_id();
            mdl_user_list.addRow(row);
        }
        User.countCurrent();
    }

    public boolean addUser(int id){
        String name = txtName.getText();
        String userName = txtUserName.getText();
        String password = txtPastword.getText();
        String type = comboBox1.getSelectedItem().toString();
       boolean result = User.add(name, userName, password,type);

       if (result){
           return true;
       }
       else{
           return false;
       }
    }

    public static void main(String[] args) {
        OperatorGUI.args = args;
        DbConnector.getInstance();

        OperatorGUI opGUI = new OperatorGUI();
        // proramı çalıştırdığımda direk buradan başalayacak anlamına geliyor.

    }
}
