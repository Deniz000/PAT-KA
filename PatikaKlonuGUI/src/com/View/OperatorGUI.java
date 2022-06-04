package com.View;

import com.Helper.Config;
import com.Helper.DbConnector;
import com.Helper.Helper;
import com.Helper.Item;
import com.Model.Course;
import com.Model.Patika;
import com.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    private JTextField txtNameSrc;
    private JTextField txtUserNameSrc;
    private JComboBox comboSearch;
    private JButton btnSrc;
    private JButton btnListele;
    private JPanel panelPatikaList;
    private JScrollPane scrollPane;
    private JTable patikasTable;
    private JTextField txtAddPatikaName;
    private JButton btnAddPatika;
    private JTable tableCourse;
    private JPanel pnlAddCourse;
    private JTextField txtCourseName;
    private JTextField txtCourseLanguage;
    private JComboBox cmbPatika;
    private JComboBox cmbEducator;
    private JButton btnAddCourse;
    private JTextField txtDeletedCourseId;
    private JButton btnDeleteCourse;
    private DefaultTableModel mdl_patika_list;
    private Object[] colm_patika_list = {"ID", "Patika Adı"};
    private Object[] row_patika_list = new Object[colm_patika_list.length];
    private JPopupMenu  patikaMenu;


    private DefaultTableModel mdl_user_list; //vektor tipli iki değişkeni biri başlık tutar diğeri satırları
    private Object[] col_user_list = {"ID", "Ad Soyad", "Kullanıcı Adı", "Şifre", "Üyelik Tipi"};
    private Object[] row_user_list =  new Object[col_user_list.length];

    private DefaultTableModel mdl_course_list;
    private Object[] col_course_list = {"ID", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen"};
    private Object[] row_course_list = new Object[col_course_list.length];




    public OperatorGUI(){
        Helper.setLayout();
        add(mainWrapper);
        setSize(1000,600);
        setLocation(Helper.screenCenterLoc("x",getSize()),Helper.screenCenterLoc("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// proje kapatılınca aynı zamanda dursun
        setTitle(Config.PROJECT_TİTLE);
        setVisible(true);
        setResizable(false);
        // Object[] firstRow = {"1","Deniz Ozdemir","Deniz","123","1"};
        //mdl_user_list.addRow(firstRow);
        // # Patika Codes

        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Güncelle");
        JMenuItem deleteMenu = new JMenuItem("Sil");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        updateMenu.addActionListener(e -> {
            int selectId= Integer.parseInt(patikasTable.getValueAt(patikasTable.getSelectedRow(),0).toString());
            UpdatePatikaGui updatePatikaGui = new UpdatePatikaGui(Patika.getFetch(selectId));
            updatePatikaGui.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    sortPatika();
                    comboSortPatika();
                }
            });
        });
        deleteMenu.addActionListener(e ->{
            if(Helper.confirm("sure")) {
                int selectedId = Integer.parseInt(patikasTable.getValueAt(patikasTable.getSelectedRow(), 0).toString());
                if(Patika.delete(selectedId)){
                    Helper.showMsg("succed");
                    sortPatika();
                    comboSortPatika();
                }
            }
        });
        mdl_patika_list = new DefaultTableModel();
        mdl_patika_list.setColumnIdentifiers(colm_patika_list);
        patikasTable.setModel(mdl_patika_list);
        patikasTable.setComponentPopupMenu(patikaMenu);
        patikasTable.getTableHeader().setReorderingAllowed(false);
        patikasTable.getColumnModel().getColumn(0).setMaxWidth(100);


        patikasTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow = patikasTable.rowAtPoint(point);
                patikasTable.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });
        sortPatika();
        btnAddPatika.addActionListener(e -> {
            if(Helper.isFieldEmpty(txtAddPatikaName)){
                Helper.showMsg("fill");
            }
            else{
                if(addPatika()){
                    Helper.showMsg("succed");
                    txtAddPatikaName.setText("");
                    sortPatika();
                    comboSortPatika();
                    return;
                }
                else{
                    System.out.println("Üzgünüz. Bir aksilik oldu!");
                    return;
                }
            }
        });


        //  #User codes
        mdl_user_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        mdl_user_list.setColumnIdentifiers(col_user_list);
        sortUser();
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
                String name = usersTable.getValueAt(usersTable.getSelectedRow(),1).toString().trim();
                String userName = usersTable.getValueAt(usersTable.getSelectedRow(),2).toString().trim();
                String password = usersTable.getValueAt(usersTable.getSelectedRow(),3).toString();
                String type = usersTable.getValueAt(usersTable.getSelectedRow(),4).toString().trim();

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
                if(addUser()){
                    Helper.showMsg("succed");
                    sortUser();
                    comboSortEducator();
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
                if (Helper.confirm("sure")) {
                    if(deleteUserByıd()){
                        Helper.showMsg("succed");
                        sortUser();
                        comboSortEducator();
                        sortCourse();
                        txtDeleteId.setText("");
                        return;
                    }
                    else{
                        System.out.println("Üzgünüz. Bir aksilik oldu!");
                        return;
                    }
                }
            }
        });
        btnSrc.addActionListener(e -> {
            String name = txtNameSrc.getText();
            String userName = txtUserNameSrc.getText();
            String sqlQuery = User.searchQuery(name, userName);
            sortUser(User.userArrayList(sqlQuery));
        });

        btnListele.addActionListener(e -> {
            sortUser();
        });
        exitButton.addActionListener(e -> {
            dispose();
        });


        mdl_course_list = new DefaultTableModel();
        mdl_course_list.setColumnIdentifiers(col_course_list);
        tableCourse.setModel(mdl_course_list);
        tableCourse.getTableHeader().setReorderingAllowed(false);
        tableCourse.getColumnModel().getColumn(0).setMaxWidth(100);
        sortCourse();
        comboSortEducator();
        comboSortPatika();

        tableCourse.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selectedCourseId = tableCourse.getValueAt(tableCourse.getSelectedRow(), 0).toString();
                txtDeletedCourseId.setText(selectedCourseId);
            }
            catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        });
        btnAddCourse.addActionListener(e -> {
            if (Helper.isFieldEmpty(txtCourseName)||
                    Helper.isFieldEmpty(txtCourseLanguage)){
                Helper.showMsg("fill");
            }
            else{
                if(addCourser()){
                    Helper.showMsg("succed");
                    sortUser();
                    txtCourseName.setText("");
                    txtCourseLanguage.setText("");
                    sortCourse();
                    return;
                }
                else{
                    System.out.println("Üzgünüz. Bir aksilik oldu!");
                    return;
                }
            }
        });
        btnDeleteCourse.addActionListener(e -> {
            if(Helper.isFieldEmpty(txtDeletedCourseId)){
                Helper.showMsg("fill");
            }
            else{
                if (Helper.confirm("sure")) {
                    if(deletedCourseById()){
                        Helper.showMsg("succed");
                        sortCourse();
                        txtDeletedCourseId.setText("");
                        return;
                    }
                    else{
                        System.out.println("Üzgünüz. Bir aksilik oldu!");
                        return;
                    }
                }
            }
        });
    }

    private boolean deletedCourseById() {
        try {
            int idValue = Integer.parseInt(txtDeletedCourseId.getText());
            if (Course.deleteById(idValue)) {
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

    private boolean addCourser() {
        String cName = txtCourseName.getText();
        String cLanguage = txtCourseLanguage.getText();
        String patika = cmbPatika.getSelectedItem().toString();
        String educator = cmbEducator.getSelectedItem().toString();
        boolean result = Course.add(cName,cLanguage,patika,educator);
        if (result){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addPatika() {
        String name = Helper.controlFirstLetter(txtAddPatikaName.getText());
        boolean result = Patika.add(name);
        if (result){
            return true;
        }
        else{
            return false;
        }
    }
    private void sortPatika() {
        DefaultTableModel tableModel = (DefaultTableModel) patikasTable.getModel();
        tableModel.setRowCount(0);
        for (Patika patika: Patika.getList()){
            row_patika_list[0] = patika.getId();
            row_patika_list[1] = patika.getName();
            mdl_patika_list.addRow(row_patika_list);
        }
    }

    public void sortCourse(){
        DefaultTableModel tableModel = (DefaultTableModel) tableCourse.getModel();
        tableModel.setRowCount(0);
        for (Course course : Course.getlist()){
            row_course_list[0] = course.getId();
            row_course_list[1] = course.getName();
            row_course_list[2] = course.getLanguage();
            row_course_list[3] = course.getPatika_id();
            row_course_list[4] = course.getUser_id();
            mdl_course_list.addRow(row_course_list);
        }
    }
    public void comboSortPatika(){
        cmbPatika.removeAllItems();
        for(Patika patika : Patika.getList()){
            cmbPatika.addItem(new Item(patika.getId(), patika.getName()).getValue());
        }
    }

    public void comboSortEducator(){
        cmbEducator.removeAllItems();
        for(User user : User.getList()) {
            if (user.getType_id() == 2) {
                cmbEducator.addItem(new Item(user.getId(), user.getName()).getValue());
            }
        }
    }
    public void sortUser(){
        DefaultTableModel clearModel = (DefaultTableModel) usersTable.getModel();
        clearModel.setRowCount(0);
        for(User user: User.getList()){
            row_user_list[0] = user.getId();
            row_user_list[1] = user.getName();
            row_user_list[2] = user.getUserName();
            row_user_list[3] = user.getPassword();
            row_user_list[4] = user.getType_id();
            mdl_user_list.addRow(row_user_list);
        }
        User.countCurrent();
    }
    public void sortUser(ArrayList<User> users){
        DefaultTableModel clearModel = (DefaultTableModel) usersTable.getModel();
        clearModel.setRowCount(0);
        for(User user: users){
        row_user_list[0] = user.getId();
        row_user_list[1] = user.getName();
        row_user_list[2] = user.getUserName();
        row_user_list[3] = user.getPassword();
        row_user_list[4] = user.getType_id();
        mdl_user_list.addRow(row_user_list);
    }
        User.countCurrent();
}
    public boolean addUser(){
        String name = User.controlFirstLetter(txtName.getText());
        String userName = User.controlFirstLetter(txtUserName.getText());
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
