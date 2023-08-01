public class NormalLoc extends Location{
    @Override
    boolean onLocation(){
        return true;
    }
    public NormalLoc(Player player,String name){
        super(player,name);

    }
}
