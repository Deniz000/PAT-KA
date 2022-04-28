package com.company;

import java.nio.file.LinkPermission;
import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private String charName;
    private int damage;
    private int health;
    private int money;
    private Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
    }

    public void selectChar(){
        Character[] characters = {new Samurai(), new Archer(),new Knight()};
        for (Character character:characters) {
            System.out.println("ID: " + character.getId()
                    + "\t Karakter: " + character.getName()
                    + "\t Hasar: " + character.getDamage()
                    + "\t Sağlık: " + character.getHealth()
                    + "\t Para: " + character.getMoney());
        }

        System.out.print("Hangi karakter ile oynamak istersin: ");
        int selectedChar = input.nextInt();
        switch (selectedChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        System.out.println("Karakter: " + this.getCharName() + " Hasar: " + this.getDamage()
                + " Sağlık: " + this.getHealth() + " Para: " + this.getMoney());
    }

    private void initPlayer(Character character) {
        this.setCharName(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setMoney(character.getMoney());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int gender) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
