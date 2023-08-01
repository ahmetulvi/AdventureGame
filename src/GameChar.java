public class GameChar {
    private int damage;
    private int healthy;
    private int money;
    private String name;
    private String ID;

    public  GameChar(String ID,String name,int damage,int healthy,int money){
        this.damage=damage;
        this.healthy=healthy;
        this.money=money;
        this.name=name;
        this.ID=ID;


    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
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
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID=ID;
    }
}
