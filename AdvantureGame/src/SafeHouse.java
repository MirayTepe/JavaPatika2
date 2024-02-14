public class SafeHouse extends NormalLoc {
    public SafeHouse(Player player){
        super(player, "Güvenli Ev");
        if(getPlayer().getCharName().equals("Samuray")){
            getPlayer().setHealth(21);
        }
        else if(getPlayer().getCharName().equals("Okçu")){
            getPlayer().setHealth(18);
        }
        else if(getPlayer().getCharName().equals("Şövalye")){
            getPlayer().setHealth(24);
        }
    }

    @Override
    public boolean onLocation() {

        return true;
    }
}
