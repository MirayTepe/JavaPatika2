import java.util.Random;
import java.util.Scanner;

public class Obstacle {
    Scanner scanner = new Scanner(System.in);
    Player player;
    GameChar gameChar;
    private int ID;
    private int damage;
    private int health;
    private int killValue;
    private int obstacleNumber;
    private String name;
    Random random = new Random();

    public Obstacle(Player player, String name, int ID, int damage, int health, int killValue, int obstacleNumber) {
        this.name=name;
        this.ID = ID;
        this.damage = damage;
        this.health = health;
        this.killValue = killValue;
        this.obstacleNumber = obstacleNumber;
        this.player=player;
    }

    public GameChar getCharacter() {
        return gameChar;
    }

    public void setCharacter(GameChar gameChar) {
        this.gameChar = gameChar;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    private BattleLoc battleLoc;

    public BattleLoc getBattleLoc() {
        return battleLoc;
    }

    public void setBattleLoc(BattleLoc battleLoc) {
        this.battleLoc = battleLoc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getKillValue() {
        return killValue;
    }

    public void setKillValue(int killValue) {
        this.killValue = killValue;
    }

    public int getObstacleNumber() {
        return obstacleNumber;
    }

    public int setObstacleNumber(int obstacleNumber) {
        this.obstacleNumber = obstacleNumber;
        return obstacleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void obstacleStats(){
        System.out.println("Canavarın adı 🦇 :" + this.getName());
        System.out.println("Canavarın hasarı 👊 :" + this.getDamage());
        System.out.println("Canavarın sağlığı 🖤 :" + this.getHealth() );
        if (!getName().equals("Yılan 🐍")){
            System.out.println("Eğer öldürürseniz " + this.getKillValue() + " 💵 kazanırsınız!");
        } else {
            System.out.println("Eğer şanslıysanız 🍀 , bazı eşyalar kazanabilirsiniz!");
        }
    }

    public void award(){
        int winsomething = random.nextInt(1,100);
        int winitem = random.nextInt(1,100);
        if(winsomething >= 1 && winsomething <= 45){
            System.out.println("Ödül kazanamadınız!");
        }else if( winsomething > 45 && winsomething <= 60 ){
            if(winitem >= 1 && winitem <= 50){
                System.out.println("Tabanca kazandınız, almak ister misiniz? Evet için: 'E' , Hayır için: 'H' ");
                String yesorno = scanner.nextLine();
                yesorno = yesorno.toUpperCase();
                if(yesorno.equals("E")){
                    getPlayer().Weapons(new Gun());
                    System.out.println("Tabancayı aldınız! " + this.getPlayer().getWeapon());
                } else System.out.println("Eşyayı düşürdünüz!");
            } else if (winitem > 50 && winitem <=80){
                System.out.println("Kılıç kazandınız, almak ister misiniz? Evet için: 'E' , Hayır için: 'H' ");
                String yesOrNo = scanner.nextLine();
                yesOrNo.toUpperCase();
                if(yesOrNo.equals("E")){
                    getPlayer().Weapons(new Sword());
                    System.out.println("Kılıcı aldınız! " + this.getPlayer().getWeapon());
                } else System.out.println("Eşyayı düşürdünüz!");
            } else if (winitem > 80 && winitem <= 100){
                System.out.println("Tüfek kazandınız, almak ister misiniz? Evet için: 'E' , Hayır için: 'H' ");
                String yesOrNo = scanner.nextLine();
                yesOrNo.toUpperCase();
                if(yesOrNo.equals("E")){
                    getPlayer().Weapons(new Rifle());
                    System.out.println("Tüfeği aldınız! " + this.getPlayer().getWeapon());
                } else System.out.println("Eşyayı düşürdünüz!");
            }
        } else if(winsomething > 60 && winsomething <= 75){
            if(winitem >= 1 && winitem <= 50){
                System.out.println("Hafif zırh kazandınız, almak ister misiniz? Evet için: 'E' , Hayır için: 'H' Zırh bloğu: 1 🛡 ");
                String yesOrNo = scanner.nextLine();
                yesOrNo = yesOrNo.toUpperCase();
                if(yesOrNo.equals("E")){
                    getPlayer().Armors(new LightArmor());
                    System.out.println("Hafif zırhı aldınız! " + this.getPlayer().getBlock());
                } else System.out.println("Eşyayı düşürdünüz!");
            } else if(winitem > 50 && winitem <= 80){
                System.out.println("Orta zırh kazandınız, almak ister misiniz? Evet için: 'E' , Hayır için: 'H' Zırh bloğu: 3 🛡 ");
                String yesOrNo = scanner.nextLine();
                yesOrNo = yesOrNo.toUpperCase();
                if(yesOrNo.equals("E")){
                    getPlayer().Armors(new MediumArmor());
                    System.out.println("Orta zırhı aldınız! " + this.getPlayer().getBlock());
                } else System.out.println("Eşyayı düşürdünüz!");
            } else if(winitem > 80 && winitem <= 100){
                System.out.println("Ağır zırh kazandınız, almak ister misiniz? Evet için: 'E' , Hayır için: 'H' Zırh bloğu: 5 🛡 " );
                String yesOrNo = scanner.nextLine();
                yesOrNo = yesOrNo.toUpperCase();
                if(yesOrNo.equals("E")){
                    getPlayer().Armors(new HeavyArmor());
                    System.out.println("Ağır zırhı aldınız! " + this.getPlayer().getBlock());
                } else System.out.println("Eşyayı düşürdünüz!");
            }
        } else if(winsomething > 75 && winsomething <= 100){
            if(winitem >=1 && winitem <= 50){
                System.out.println("1 💵 Kazandınız!");
                getPlayer().setMoney(getPlayer().getMoney() + 1);
            } else if(winitem > 50 && winitem <= 80){
                System.out.println("5 💵 Kazandınız!");
                getPlayer().setMoney(getPlayer().getMoney() + 5);
            } else if(winitem > 80 && winitem <= 100){
                System.out.println("10 💵 Kazandınız!");
                getPlayer().setMoney(getPlayer().getMoney() + 10);
            }
        }
    }
}
