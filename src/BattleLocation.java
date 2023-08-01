import java.util.Random;

public class BattleLocation extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private Player player;

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public BattleLocation(Player player, String name, Obstacle obstacle, String award,int maxObstacle) {
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
        this.player=player;
    }
    @Override
    public boolean onLocation(){
        int obsNumber=this.randomObstacleNumber();
        System.out.println("Şu anda burdasınız: "+this.getName());
        System.out.println("Dikkatli ol! Burada "+obsNumber+" tane " +this.getObstacle().getName()+" yaşıyor!");
        System.out.println("<S>avaş veya <K>aç: ");
        String selectCase= sc.nextLine();
        selectCase=selectCase.toUpperCase();


        if (selectCase.equals("S")&&combat(obsNumber)){
            System.out.println(this.getName()+" tüm düşmanları yendiniz !");
            return true;
        }
        if (this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz!!");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNumber){
        for (int i=1;i<=obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            playerStats();
            obstacleStats(i);
            Random z=new Random();
            int selectFirst=z.nextInt(2);
            if (selectFirst==0){

                while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                    System.out.println("Şanslısın, canavardan önce davrandın! :)");
                    System.out.println("<V>ur veya <K>aç");
                    String selectCombat=sc.nextLine().toUpperCase();
                    if (selectCombat.equals("V")){
                        System.out.println("Siz vurdunuz!");
                        this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getHealth()>0){
                            System.out.println();
                            System.out.println("Canavar size vurdu!");
                            int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage<0){
                                obstacleDamage=0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                }
                if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                    System.out.println("Düşmanı yendiniz !");
                    System.out.println(this.getObstacle().getAward()+ " kazandınız!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                    getInventoryPrize();
                    System.out.println("Güncel paranız: "+this.getPlayer().getMoney());
                    System.out.println("Canınız :"+this.getPlayer().getHealth());
                }
                if (this.getObstacle().getHealth()<this.getPlayer().getHealth() && this.getObstacle().getId(i)==4) {
                    //Yılan
                    System.out.println("Yılanı yendiniz !");
                    int zz=Items();
                    int yy=randomItem();
                    if (yy >= 0 && yy <= 14){
                        if (zz >= 0 && zz <= 19){
                            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(3));
                            System.out.println("Kazanılan silah: " + this.getPlayer().getInventory().getWeapon().getName());
                        } else if (zz >= 20 && zz <= 49) {
                            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(2));
                            System.out.println("Kazanılan silah: " + this.getPlayer().getInventory().getWeapon().getName());
                        }else if (zz >= 50 && zz <= 100) {
                            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(1));
                            System.out.println("Kazanılan silah: " + this.getPlayer().getInventory().getWeapon().getName());
                        }
                    }
                    else if (yy >=15 && yy <=29){
                        int b = Items();
                        if(zz >= 0 && zz <= 19){

                            int selectArmorID = 3;
                            Armor selectedArmor = Armor.getArmorById(selectArmorID);
                            this.getPlayer().getInventory().setArmor(selectedArmor);
                            System.out.println("Kazanılan zırh: " + this.getPlayer().getInventory().getArmor().getName());
                        }
                        else if(b >=20 && b <=49){

                            int selectArmorID = 2;
                            Armor selectedArmor = Armor.getArmorById(selectArmorID);
                            this.getPlayer().getInventory().setArmor(selectedArmor);
                            System.out.println("Kazanılan zırh: " + this.getPlayer().getInventory().getArmor().getName());
                        }
                        else{

                            int selectArmorID = 1;
                            Armor selectedArmor = Armor.getArmorById(selectArmorID);
                            this.getPlayer().getInventory().setArmor(selectedArmor);
                            System.out.println("Kazanılan zırh: " + this.getPlayer().getInventory().getArmor().getName());
                        }
                    }
                    else if(yy >= 30 && yy <= 54){
                        System.out.println("Tebrikler bu yılandan para düştü.");
                        int a = Items();
                        if(a >= 0 && a <= 19){
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                            System.out.println("Kazanılan para: 10");
                        }
                        else if(a >=20 && a <=49){
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                            System.out.println("Kazanılan para: 5");
                        }
                        else{
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                            System.out.println("Kazanılan para: 1");
                        }
                    }
                    else{
                        System.out.println("Bu yılandan hiçbir eşya veya para düşmedi :(");
                    }




                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                    getInventoryPrize();
                    System.out.println("Güncel paranız: "+this.getPlayer().getMoney());
                    System.out.println("Canınız :"+this.getPlayer().getHealth());
                }
            }else {
                System.out.println("Canavar sana saldırdı !");
                while (this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                    System.out.println();
                    System.out.println("Canavar size vurdu!");
                    int obstacleDamage=this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                    if (obstacleDamage<0){
                        obstacleDamage=0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                    afterHit();
                    System.out.println("<V>ur veya <K>aç");
                    String selectCombat=sc.nextLine().toUpperCase();
                    if (selectCombat.equals("V")){
                        System.out.println("Siz vurdunuz!");
                        this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getHealth()>0){
                            System.out.println();
                            System.out.println("Canavar size vurdu!");
                            if (obstacleDamage<0){
                                obstacleDamage=0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                }
                if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                    System.out.println("Düşmanı yendiniz !");
                    System.out.println(this.getObstacle().getAward()+ " kazandınız!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
                    getInventoryPrize();
                    System.out.println("Güncel paranız: "+this.getPlayer().getMoney());
                    System.out.println("Canınız :"+this.getPlayer().getHealth());
                }
            }


        }

        return false;
    }
    public void getInventoryPrize() {
        String obstacleName = this.obstacle.getName();

        switch (obstacleName) {
            case "Ayı" -> {
                this.player.getInventory().setWater(true);
                System.out.println("Su kazandınız, öldürdüğünüz için " + this.obstacle.getName());
            }
            case "Vampir" -> {
                this.player.getInventory().setFirewood(true);
                System.out.println("Odun kazandınız, öldürdüğünüz için " + this.obstacle.getName());
            }
            case "Zombi" -> {
                this.player.getInventory().setFood(true);
                System.out.println("Yemek kazandınız, öldürdüğünüz için " + this.obstacle.getName());
            }

        }
    }


    public void afterHit(){
        System.out.println("Canınız: "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+ " Canı "+this.getObstacle().getHealth());
        System.out.println("-------------------------");
    }
    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("-------------------");
        System.out.println("Sağlık: "+this.getPlayer().getHealth());
        System.out.println("Silah: "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: "+this.getPlayer().getTotalDamage());
        System.out.println("Zırh: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: "+this.getPlayer().getMoney());
    }
    public void obstacleStats(int i){
        System.out.println(i+ "."+this.getObstacle().getName()+" Değerleri");
        System.out.println("----------------");
        System.out.println("Sağlık: "+this.getObstacle().getHealth());
        System.out.println("Hasar: "+this.getObstacle().getDamage());
        System.out.println("Ödül: "+this.getObstacle().getAward());
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber(){
        Random r=new Random(maxObstacle);
        return r.nextInt(this.getMaxObstacle()+1);
    }
    public int randomItem(){
        Random r=new Random();
        int y= r.nextInt(100);
        return y;
    }
    public int Items(){
        Random rand=new Random();
        int z=rand.nextInt(100);
        return z;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }
}
