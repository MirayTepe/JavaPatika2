import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start() {
        Scanner scanning = new Scanner(System.in);
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getPlayerName() + " bu karanlık ve sisli adaya hoşgeldiniz! Burada yaşananların hepsi gerçek!");
        System.out.println("Lütfen bir karakter seçiniz!");
        System.out.println("----------------------------------");
        player.selectChar();
        Location location = null;
        boolean gameOver = false;

        while(true) {
            player.printPlayerInfo();
            System.out.println("----------------------------------");
            System.out.println("########## Bölgeler ##########");
            System.out.println();
            System.out.println("1: Güvenli Ev 💒 --> Burası sizin için güvenli bir ev, burada düşman yoktur!\n"
                             + "2: Eşya Dükkanı 🏹🔨 --> Silah veya zırh satın alabilirsiniz!\n"
                             + "3: Mağara 🪨 --> Ödül <Yemek> , dikkatli ol karşına zombi çıkabilir!\n"
                             + "4: Orman 🌳 --> Ödül <Odun> , dikkatli ol karşına vampir çıkabilir!\n"
                             + "5: River 🤽 --> Ödül <Su> , dikkatli ol karşına ayı çıkabilir!\n"
                             + "6: Maden ⛏ --> Ödül <Silah/Zırh/Para> , dikkatli ol karşına yılan çıkabilir!\n"
                             + "7: Ödül Bölgesi 🏆 Tüm ödülleri toplar ve bu bölgeye giderseniz oyunu bitirebilirsiniz! 🔚");

            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int input = scanning.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Güvenli eve girdiniz! 🏠 Sağlığınız dolduruldu! 💞");
                    location = new SafeHouse(player);
                    break;
                case 2:
                    System.out.println("Eşya dükkanına girdiniz! 🛠");
                    location = new ToolStore(player);
                    break;
                case 3:if(!player.getInventory().isFood()){
                    System.out.println("Mağaraya girdiniz! 🪨");
                    location = new Cave(player);
                } else {
                    System.out.println("Ödülleri zaten topladın, içeri giremezsiniz!");
                    location = new SafeHouse(player);
                } break;

                case 4:
                    if(!player.getInventory().isFirewood()){
                        System.out.println("Ormana girdiniz! 🌳");
                        location = new Forest(player);
                    } else {
                        System.out.println("Ödülleri zaten topladın, içeri giremezsiniz!");
                        location = new SafeHouse(player);
                    } break;
                case 5:
                    System.out.println("Nehire girdiniz! 🤽");
                    location = new River(player);
                    break;
                case 6:
                    System.out.println("Madene girdiniz! ⛏");
                    location = new Mine(player);
                    break;
                case 7:
                    System.out.println("Ödül bölgesi 🏆");
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(player.getInventory().isWater() && player.getInventory().isWater() && player.getInventory().isFirewood()){
                System.out.println("Tebrikler, tüm ödülleri topladınız!\n" + "Oyun Bitti!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Oyun Bitti!");
                break;
            } else location.onLocation();
        }
    }
}
