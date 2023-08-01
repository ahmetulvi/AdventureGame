import java.util.Random;

public class Snake extends Obstacle{
    private int award;
    public Snake(Player player){
        super(4,3,12,"Yılan",0);
        Random r=new Random();
        this.setDamage(r.nextInt(3,6));


    }





}
