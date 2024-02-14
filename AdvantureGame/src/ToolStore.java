public class ToolStore extends NormalLoc {
    public void weapons(Weapons weapons) {

    }

    public ToolStore(Player player) {
        super(player, "Eşya Dükkanı");
    }

    public void menu() {
        System.out.println("Menü: ");
        Weapons[] weapList = {new Gun(), new Sword(), new Rifle()};
        Armor[] armorList = {new LightArmor(), new MediumArmor(), new HeavyArmor()};
        System.out.println("⚔⚔⚔⚔⚔⚔⚔ Silahlar ⚔⚔⚔⚔⚔⚔⚔");
        for (Weapons weapons : weapList) {
            System.out.println("Silah adı ⚔ : " + weapons.getWeaponName() + "\n" + "ID 🆔 : " + weapons.getId() + "\n" + "Hasar 💔 : " + weapons.getDamage() + "\n" + "Para 💵 :" + weapons.getMoney());
        }
        System.out.println("🛡️🛡️🛡️🛡️🛡️🛡️🛡️ Zırhlar 🛡️🛡️🛡️🛡️🛡️🛡️🛡️");
        for (Armor armor : armorList) {
            System.out.println("Zırh adı 🛡️ : " + armor.getName() + "\n" + "ID 🆔 : " + armor.getId() + "\n" + "Zırh Bloklaması 🛡️ : " + armor.getBlock() + "\n" + "Para 💵 : " + armor.getMoney());
        }
    }

    @Override
    public boolean onLocation() {
        Weapons[] weapList = {new Gun(), new Sword(), new Rifle()};
        Armor[] armorList = {new LightArmor(), new MediumArmor(), new HeavyArmor()};
        System.out.println("Ne satın almak istiyorsunuz? \n"
                + "1- Silahlar ⚔\n" + "2- Armors🛡️\n" + "0- Çıkış Yap");
        int input1 = input.nextInt();
        int balance = 0;
        switch (input1) {
            case 1:
                for (Weapons weapons : weapList) {
                    System.out.println("Silah adı ⚔ : " + weapons.getWeaponName() + "\n" + "ID 🆔 : " + weapons.getId() + "\n" + "Hasar 💔 : " + weapons.getDamage() + "\n" + "Para 💵 : " + weapons.getMoney());
                }
                int input2 = input.nextInt();
                switch (input2) {
                    case 0:
                        return  true;

                    case 1:
                        if (getPlayer().getMoney() >= weapList[0].getMoney()) {
                            System.out.println("Silah aldınız!");
                            getPlayer().weaponChoose(new Gun());
                        } else System.out.println("Yeterli miktarda paraya sahip değilsiniz! 😭");
                        break;
                    case 2:
                        if (getPlayer().getMoney() >= weapList[1].getMoney()) {
                            System.out.println("Kılıç aldınız!");
                            getPlayer().weaponChoose(new Sword());
                        } else System.out.println("Yeterli miktarda paraya sahip değilsiniz! 😭");
                        break;
                    case 3:
                        if (getPlayer().getMoney() >= weapList[2].getMoney()) {
                            getPlayer().weaponChoose(new Rifle());
                        } else System.out.println("Yeterli miktarda paraya sahip değilsiniz! 😭");
                        break;

                }
                System.out.println("Para miktarınız: " + getPlayer().getMoney());
                break;
            case 2:
                for (Armor armor : armorList) {
                    System.out.println("Zırh adı 🛡️ : " + armor.getName() + "\n" + "ID 🆔 : " + armor.getId() + "\n" + "Zırh bloklaması 🛡️ : " + armor.getBlock() + "\n" + "Para 💵 : " + armor.getMoney());
                }
                int input3 = input.nextInt();
                switch (input3) {
                    case 0:
                        return true;
                    case 1:
                        if (getPlayer().getMoney() >= 15) {
                            getPlayer().armorChoose(new LightArmor());

                        } else System.out.println("Yeterli miktarda paraya sahip değilsiniz! 😭");
                        break;
                    case 2:
                        if (getPlayer().getMoney() >= 25) {
                            getPlayer().armorChoose(new MediumArmor());
                        } else System.out.println("Yeterli miktarda paraya sahip değilsiniz! 😭");
                        break;
                    case 3:
                        if (getPlayer().getMoney() >= 40) {
                            getPlayer().armorChoose(new HeavyArmor());
                        } else System.out.println("Yeterli miktarda paraya sahip değilsiniz! 😭");
                        break;
                }
                break;
            case 0:
                System.out.println("Yine bekleriz..!");
                return true;
        }
        return true;
    }
}
