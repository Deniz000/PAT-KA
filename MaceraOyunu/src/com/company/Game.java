package com.company;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.print("Lütfen bir isim giriniz: ");
        //String name = input.nextLine();
        Player player = new Player("Gül");
        System.out.println("Hoşgeldin " + player.getName() + " hadi başlayalım");
        System.out.println("Oyun karakterleri: ");
        player.selectChar();
    }

}
