import java.util.Random;
import java.util.Scanner;

public class Player {
    Scanner scanning = new Scanner(System.in);
    private int block;
    private int damage;
    private int health;
    private int money;
    private String weapon;
    private String charName;
    private String playerName;
    private int originalHealth;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    Inventory inventory = new Inventory(false,false,false, this.getWeapon(),"",3,5);
    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Karakterler:");
        for (GameChar gameChar : charList) {
            System.out.println("ID 🆔 : " + gameChar.getId() + " Karakter 🪪 : " + gameChar.getName() + ", Hasar 🗡️ : " + gameChar.getDamage() + ", Sağlık 💖 : " + gameChar.getHealth() + ", Para 💵 : " + gameChar.getMoney() + " Silah 🗡 : " + gameChar.getWeapon());
        }
        System.out.print("Lütfen bir karakter seçiniz: ");
        int input = scanning.nextInt();
        switch (input) {
            case 1:
                System.out.println("Samuray seçildi!");
                gameChar(new Samurai());
                break;
            case 2:
                System.out.println("Okçu seçildi!");
                gameChar(new Archer());
                break;
            case 3:
                System.out.println("Şövalye seçildi!");
                gameChar(new Knight());
                break;
            default:
                System.out.println("Rastgele bir karakter seçildi!");
                Random random = new Random();
                int rand = random.nextInt(3);
                switch (rand) {
                    case 1:
                        System.out.println("Samuray seçildi!");
                        gameChar(new Samurai());
                        break;
                    case 2:
                        System.out.println("Okçu seçildi!");
                        gameChar(new Archer());
                        break;
                    case 3:
                        System.out.println("Şövalye seçildi!");
                        gameChar(new Knight());
                        break;
                }
        }
    }

    public void gameChar(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
        this.setBlock(gameChar.getBlock());
        this.setWeapon(gameChar.getWeapon());
    }

    public boolean weaponChoose(Weapons weapons) {
        this.setDamage(getDamage() + weapons.getDamage());
        this.setMoney(getMoney() - weapons.getMoney());
        this.setWeapon(weapons.getWeaponName());
        return false;
    }
    public boolean Weapons(Weapons weapons) {
        this.setDamage(getDamage() + weapons.getDamage());
        this.setWeapon(weapons.getWeaponName());
        return false;
    }
    public void Armors(Armor armor) {
        this.setBlock(armor.getBlock());
    }

    public void printPlayerInfo() {
        System.out.println("Oyuncu bilgileri: ");
        System.out.println("Para 💵 : " + getMoney() + " Hasar 🗡️ : " + getDamage() + " Bloklama 🛡️ : " + getBlock() + " Sağlık 💖 : " + getHealth() + " Silah ⚔ : " + getWeapon());
    }

    public void armorChoose(Armor armor) {
        this.setMoney(getMoney() - armor.getMoney());
        this.setBlock(armor.getBlock());
        System.out.println("Para miktarınız 💵 : " + this.getMoney());
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
