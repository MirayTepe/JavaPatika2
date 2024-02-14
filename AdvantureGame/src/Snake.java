import java.util.Random;

public class Snake extends Obstacle {
    Random random = new Random();

    public Snake(Player player) {
        super(player,"Yılan 🐍", 4, 4, 12, 0, 1);
        Random random = new Random();
        this.setDamage(random.nextInt(3,6));
    }
}
