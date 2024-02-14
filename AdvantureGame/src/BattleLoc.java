import java.util.Random;

public abstract class BattleLoc extends Location {
    Random random = new Random();
    Obstacle obstacle;
    private String item;
    Inventory inventory;


    public BattleLoc(Player player, String locName, Obstacle obstacle, String item) {
        super(player, locName);
        this.obstacle = obstacle;
        this.item = item;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int obstacleNumber = randomObstacleNumber();

    @Override
    public boolean onLocation() {
        System.out.println("Şu anda buradasınız: " + this.getLocName());
        if (obstacleNumber > 0) {
            System.out.println("Dikkatli Ol! Burada  " + obstacleNumber + " tane " + this.getObstacle().getName() + " yaşıyor!");
        } else {
            System.out.println("Hiçbir canavar kalmadı! " + "\n" + "Buradan ayrıl! 🏃‍♀️💨");
            return true;
        }
        System.out.println("Savaşmak için: 'S' 🏹" + "\n" + "Kaçmak için: 'K' 🏃‍💨‍️");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("K")) {
            System.out.println("Bu yerden kaç! 🏃‍️💨");
            return true;
        }
        if (selectCase.equals("S") && combat()) {
            return true;
        }
        if(this.getPlayer().getHealth()<= 0){
            System.out.println("Öldünüz! 💀");
            return false;
        }

        return true;
    }

    public int randomObstacleNumber() {
        return random.nextInt(3) + 1;
    }

    public void AfterHit() {
        System.out.println("Canınız ❤ : " + getPlayer().getHealth() + "💖");
        if (obstacle.getHealth() > 0) {
            System.out.println(this.getObstacle().getName() + " Canı: " + obstacle.getHealth() + "🖤");

            System.out.println("----------------------------------");
        }


    }

    public boolean combat() {
        int originalHealth = obstacle.getHealth();
        for (int obs = 0; obs < obstacleNumber; obs++) {
            getPlayer().printPlayerInfo();
            System.out.println("🔱🔱🔱🔱🔱🔱🔱🔱🔱🔱🔱🔱🔱🔱🔱🔱");
            getObstacle().obstacleStats();
            while (getPlayer().getHealth() > 0 && getObstacle().getHealth() > 0 && obs != obstacleNumber ) {
                int whoWillShoot = random.nextInt(2);
                switch (whoWillShoot) {
                    case 0:
                        System.out.println("Vurmak için: 'V' 🏹" + "\t" +  "Kaçmak için: 'K' 🏃‍♂️💨");
                        String selectCase = input.nextLine();
                        selectCase = selectCase.toUpperCase();
                        if (selectCase.equals("K")) {
                            System.out.println("Kaçtınız! 🏃‍♀️💨");
                            return true;

                        } else if (selectCase.equals("V")) {
                            System.out.println("Siz " + getPlayer().getWeapon() + " ile vurdunuz!");
                            obstacle.setHealth(obstacle.getHealth() - getPlayer().getDamage());
                            if (obstacle.getHealth() <= 0) {
                                System.out.println(obstacle.getName() + " Öldü! ☠⚰ " + obstacle.getKillValue() + " 💵 kazandınız!");
                                getPlayer().setMoney(getPlayer().getMoney() + obstacle.getKillValue());
                                obstacleNumber--;
                                if(getLocName().equals("Maden ⛏")){
                                    getObstacle().award();
                                    getObstacle().setHealth(originalHealth);
                                    break;
                                }
                                getObstacle().setHealth(originalHealth);
                            }
                            AfterHit();
                        }
                        break;
                    case 1:
                        System.out.println(obstacle.getName() + " size vurdu! 👊");
                        if (getPlayer().getHealth() > 0) {
                            if (getPlayer().getBlock() < obstacle.getDamage()) {
                                getPlayer().setHealth(getPlayer().getHealth() - (obstacle.getDamage() - getPlayer().getBlock()));
                                if(getPlayer().getHealth() <= 0){
                                    return false;
                                }
                                AfterHit();
                            } else if (getPlayer().getBlock() >= obstacle.getDamage()) {
                                getPlayer().setHealth(getPlayer().getHealth());
                                AfterHit();

                            }
                        } else
                            return false;
                        break;
                }
            }

        }
        if (this.item.equals("Su")){
            getPlayer().getInventory().setWater(true);
        } else if (this.item.equals("Odun")){
            getPlayer().getInventory().setFirewood(true);
        } else if (this.item.equals("Yemek")) {
            getPlayer().getInventory().setFood(true);
        }
        return true;
    }
}
