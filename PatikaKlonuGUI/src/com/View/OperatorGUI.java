package com.View;

import com.Helper.Config;
import com.Helper.DbConnector;
import com.Helper.Helper;
import com.Model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton btnDelete;
    private JTextField txtDeleteId;
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

        mdl_user_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        sort();
        usersTable.setModel(mdl_user_list);
        usersTable.getTableHeader().setReorderingAllowed(false);
        usersTable.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selectedUserId = usersTable.getValueAt(usersTable.getSelectedRow(), 0).toString();
                txtDeleteId.setText(selectedUserId);
            }
            catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        });
        usersTable.getModel().addTableModelListener(e -> {
            if(e.getType() == TableModelEvent.UPDATE){
                int id = Integer.parseInt(usersTable.getValueAt(usersTable.getSelectedRow(),0).toString());
                String name = usersTable.getValueAt(usersTable.getSelectedRow(),1).toString();
                String userName = usersTable.getValueAt(usersTable.getSelectedRow(),2).toString();
                String password = usersTable.getValueAt(usersTable.getSelectedRow(),3).toString();
                String type = usersTable.getValueAt(usersTable.getSelectedRow(),4).toString();

                if(User.update(id,name,userName,password,type)){
                    Helper.showMsg("succed");
                }
                else{
                    Helper.showMsg("error");
                }
            }
        });

        btnAddUser.addActionListener(e -> {
            if (Helper.isFieldEmpty(txtName)||
                    Helper.isFieldEmpty(txtUserName)||
                    Helper.isFieldEmpty(txtPastword) ){
                Helper.showMsg("fill");
            }
            else{
                if(addUser(count)){
                    Helper.showMsg("succed");
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
        btnDelete.addActionListener(e -> {
            if(Helper.isFieldEmpty(txtDeleteId)){
                Helper.showMsg("fill");
            }
            else{
                if(deleteUserByıd()){
                    Helper.showMsg("succed");
                    sort();
                    txtDeleteId.setText("");
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
        Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
        for(User user: User.getList()){
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
    public boolean deleteUserByıd() {
        try {
            int idValue = Integer.parseInt(txtDeleteId.getText());
            if (User.deleteById(idValue)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Helper.showMsg("Var olan id değerlerinden herhangi birini girmelisiniz!");
        }
        return false;
    }

    public static void main(String[] args) {
        OperatorGUI.args = args;
        DbConnector.getInstance();

        OperatorGUI opGUI = new OperatorGUI();
        // proramı çalıştırdığımda direk buradan başalayacak anlamına geliyor.

    }
}
