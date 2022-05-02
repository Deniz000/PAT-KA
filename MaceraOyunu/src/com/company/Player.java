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
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
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

    public void selectLocation(){
        Location location = null;
        while(true) {
            System.out.println();
            System.out.println("----------------------------------------------------------");
            System.out.println("Şimdi de bir bölge seç! ");
            System.out.println("Bölgeler: ");
            Location[] locations = {new SafeHouse(this), new ToolsStore(this), new Exit(this)};
            for (Location locationn : locations) {
                System.out.println("ID: " + locationn.getId() + " bölge: " + locationn.getName()
                        + " Karakter: " + locationn.getPlayer());
            }
            System.out.print("Lütfen seçimi yapınız: ");
            int noLoc = input.nextInt();
            switch (noLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new ToolsStore(this);
                    break;
                default:
                    location = new SafeHouse(this);
                    break;
            }
            if(location == null){
                System.out.println("Oyundan çıkılıyor ...");
                break;
            }
            else if(!location.onLocation()){
                System.out.println("GAME OVER");
                break;
            }
        }
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setMoney(int money) {
        this.money = money;

    }
}
