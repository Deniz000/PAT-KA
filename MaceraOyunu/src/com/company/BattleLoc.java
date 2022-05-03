package com.company;

public class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLoc(int id, Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(id, player, name);
        this.award = award;
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;
    }

    @Override
    boolean onLocation() {
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol! Burada "+ this.getMaxObstacle() + " tane "
                + this.getObstacle().getName() + " yaşıyor");
        boolean continueEx = true;
        while(continueEx) {
            System.out.println("<S>avaş  veya <K>aç");
            String selectCase = Location.scanner.nextLine();
            selectCase = selectCase.toUpperCase();
            if (selectCase.equals("S")) {
                if (combat(getMaxObstacle())) {
                } else {
                    System.out.println("Öldünüz!");
                    return false;
                }
            } else if (selectCase.equals("K")) {
                continueEx = false;
            }
        }
        return true;
    }
    public boolean combat(int obsNumber){
        for(int i = 1; i<=obsNumber; i++){
            this.getObstacle().setHealth(this.getObstacle().getOrijinalHealth());

            obstacleStatus(i);
            playerStats();

            while (this.getPlayer().getHealth() > 0
            && this.getObstacle().getHealth() > 0){
                System.out.println("<V>ur veya <K>aç");
                String selectCombat = scanner.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    System.out.println("Vurdunuz!");
                    this.getObstacle().setHealth(this.getObstacle().getHealth()
                    - this.getPlayer().getTotalDamage());
                    afterHit(i);
                    if (this.getObstacle().getHealth() > 0){
                        System.out.println(this.getObstacle().getName() + " size vurdu");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getArmor().getBlock();
                        if(obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - this.getObstacle().getDamage());
                        afterHit(i);
                    }
                }
                else if(selectCombat.equals("K")){
                    afterHit(i);
                    return true;
                }
            }

        }

        if( this.getPlayer().getHealth() > this.getObstacle().getHealth()){
            System.out.println("Düşmanı yendiniz!");
            int totalGain = this.getObstacle().getAward() * getMaxObstacle();
            System.out.println(totalGain + " altın ödülünü kazandınız");
            System.out.println("Önceki paranız: " + this.getPlayer().getMoney());
            this.getPlayer().setMoney(this.getPlayer().getMoney() + totalGain);
            System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
            System.out.println(this.getName() + " bölgesinde tüm düşmanları yendiniz !");
            return true;
        }else{
        return false;}
    }

    private void afterHit(int i) {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(i + ". " +this.obstacle.getName() + " canı: "
        + this.obstacle.getHealth());
        System.out.println();
    }

    private void obstacleStatus(int i) {
        System.out.println("--------------------");
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri: ");
        System.out.println("Sağlık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getAward());
    }

    private void playerStats() {
        System.out.println("--> Oyuncu değerleri: ");

        System.out.println("Sağlık: "+ this.getPlayer().getHealth());
        System.out.println("Hasar: "+ this.getPlayer().getTotalDamage());
        System.out.println("Para: "+ this.getPlayer().getMoney());
        System.out.println("Silah: " + this.getPlayer().getWeapon().getName());
        System.out.println("Zırh: " + this.getPlayer().getArmor().getName());
        System.out.println("----------------");

    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
