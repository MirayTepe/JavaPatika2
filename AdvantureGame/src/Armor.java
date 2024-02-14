public abstract class Armor {
    private String name;
    private int id;
    private int block;
    private int money;

    public Armor(String name, int id, int block, int money) {
        this.name = name;
        this.id = id;
        this.block = block;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
