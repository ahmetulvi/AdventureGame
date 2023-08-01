import java.util.Random;

public class Mine extends BattleLocation{
    public Mine(Player player){
        super(player,"Maden Bölgesi",new Snake(player),"0",12);
        Random r=new Random();
        this.setMaxObstacle(r.nextInt(1,5)+1);
    }
}
