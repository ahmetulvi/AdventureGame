public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player){
        super(player,"Güvenli Ev");
    }
    @Override
   public boolean onLocation(){
        System.out.println("Güvenli Evdesiniz!");
        System.out.println("Canınız Yenilendi");
        this.getPlayer().setHealth(getPlayer().getOriginalHealth());
        System.out.println("Canınız: "+this.getPlayer().getHealth());
        return true;
    }
}
