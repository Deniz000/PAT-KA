package com.company;

import java.util.Scanner;

public class ScreenOfChoose {
    private Scanner scanner = new Scanner(System.in);
    private CommonClass commonClass = null;
    public void start() {

        while (true) {
            System.out.println("PatikaStore Ürün Yönetim Paneli !");

            System.out.println("1 - Notebook İşlemleri\n" +
                    "2 - Cep Telefonu İşlemleri\n" +
                    "3 - Marka Listele\n" +
                    "4 - Ürün Listele\n" +
                    "0 - Çıkış Yap");

            System.out.print("Tercihiniz: ");
            ListOf list;
            int prefer = scanner.nextInt();
            switch (prefer) {
                case 0:
                    commonClass = null;
                    break;
                case 1:
                case 2:
                    System.out.println("İşlemler yğklenecek...");
                    break;
                case 3:
                    commonClass = new Brand();
                    break;
                case 4:
                    commonClass = new Product();
                    break;
                default:
                    System.out.print("Geçerliseçim değil. Tekrar seçim yapınız: ");
                    prefer = scanner.nextInt();
            }
            if(commonClass == null){
                System.out.println("Ekran kapatılıyor...");

            }
        }
    }
}
