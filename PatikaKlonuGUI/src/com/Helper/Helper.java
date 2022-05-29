package com.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static boolean isFieldEmpty(JTextField jTextField){
        return jTextField.getText().trim().isEmpty();
    }

    public static void showMsg(String msg){
        Helper.optionPageTR();
        String mesaj;
        String title;
        switch (msg){
            case "fill":
                mesaj = "Lütfen tüm alanları doldurun!";
                title = "Hata!";
                break;
            case "succed":
                mesaj = "İşlem Başarılı!";
                title = "Result";
                break;
            case "error":
                mesaj = "İşlem Başarısız!";
                title = "Error";
                break;
            default:
                mesaj = msg;
                title = "Mesaj";

        }
        JOptionPane.showMessageDialog(null,mesaj,title,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void optionPageTR(){
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
    }
    public static int screenCenterLoc(String axis, Dimension size){
        //Dimension kısmı bizim oluşturduğumuz ekranın boyutu

        int point;
        switch (axis){
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default:
                point = 0;
                break;
        }
        return point;
    }
    public static String controlFirstLetter(String value){
        String deger = (value.substring(0,1).toUpperCase() + value.substring(1).toLowerCase()).trim();
        return deger;
    }
    public static void setLayout(){
        for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }

    public static boolean confirm(String str) {
        String msg;
        switch (str){
            case "sure":
                msg = "Bu işlemi gerçekleştirmek istediğine emin misiniz?";
                break;
            default:
                msg = str;
                break;
        }

        return JOptionPane.showConfirmDialog(null,msg,"!",JOptionPane.YES_NO_OPTION) == 0;
    }
}
