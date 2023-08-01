import java.util.Scanner;

public class Player {
   private int damage;
   private int health;
   private int originalHealth;
   private int money;
   private String name;
   private String CharName;
   Scanner sc=new Scanner(System.in);
   private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Player(String name){
        this.name=name;
        this.inventory=new Inventory();
    }

    public void SelectChar(){
        GameChar[] charList={new Samurai(),new Archer(),new Knight()};
        for (GameChar gameChar:charList){
            System.out.println("ID: "+gameChar.getID()+
                    "\t\tKarakter: " +gameChar.getName() +
                    "\t\tSağlık: "+ gameChar.getHealthy()+
                    "\t\t Para: "+gameChar.getMoney());
            System.out.println("--------------");

        }
        int selectChar=sc.nextInt();
        switch (selectChar){
            case 1:initPlayer(new Samurai());
            break;
            case 2:initPlayer(new Archer());
            break;
            case 3:initPlayer(new Knight());
            break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter: "+this.getCharName()+" Hasar: "+this.getDamage()+" Sağlık: "+this.getHealth()+" Para:"+this.getMoney());
    }
    public void printInfo(){
        System.out.println("" +
                "Silahınız: "+ this.getInventory().getWeapon().getName()+
                " Zırh: "+this.getInventory().getArmor().getName()+
                " Bloklama "+this.getInventory().getArmor().getBlock()+
                " Hasar: "+this.getTotalDamage()+
                " Sağlık: "+this.getHealth()+
                " Para:"+this.getMoney());

    }
    public void selectLoc(){

    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealthy());
        this.setOriginalHealth(gameChar.getHealthy());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0){
            health=0;
        }
        this.health = health;
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

    public String getCharName() {
        return CharName;
    }

    public void setCharName(String charName) {
        CharName = charName;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
