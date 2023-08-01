import java.util.Scanner;

public class Game {
    private Scanner sc=new Scanner(System.in);
    private Player player;
    Obstacle obstacle;
    public void Start(){
        System.out.println("Welcome to Our Adventure!");
        System.out.println("Please enter your name: ");
        String PlayerName= sc.next();
        player=new Player(PlayerName);
        System.out.println(player.getName()+" bu karanlık ve sisli adaya hoşgeldiniz !! Burada yaşananların hepsi gerçek");
        System.out.println("Lütfen Karakterinizi Seçiniz: ");
        System.out.println("---------------------------------------");
        player.SelectChar();
        player.selectLoc();
        player.printInfo();
        Location location=null;

        while (true){
            System.out.println("Bölgeler");
            System.out.println("1-Güvenli ev");
            System.out.println("2- Mağaza");
            System.out.println("3- Mağara --> Ödülün Yemek, dikkatli ol!");
            System.out.println("4- Orman --> Ödülün Odun, dikkatli ol!");
            System.out.println("5- Nehir --> Ödülün su, dikkatli ol!");
            System.out.println("6- Maden --> Ödülün rastgele, dikkatli ol !");
            System.out.println("0- Çıkış Yap");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz:");
            int selectLoc=sc.nextInt();
            switch (selectLoc){
                case 0:
                    location=null;
                    break;
                case 1: location=new SafeHouse(player);
                    break;
                case 2: location=new Toolstore(player);
                break;
                case 3:
                   if (!this.player.getInventory().isFood()){
                       location=new Cave(player);
                       location.onLocation();
                   }else {
                       System.out.println("Ödülü kazandığınız için buraya tekrardan gidemezsiniz!");

                   }
                    break;
                case 4:
                   if (!this.player.getInventory().isFirewood()){
                       location=new Forest(player);
                       location.onLocation();
                   }else {
                       System.out.println("Ödülü kazandığınız için buraya tekrardan gidemezsiniz!");
                   }
                break;
                case 5:
                    if (!this.player.getInventory().isWater()) {
                        location = new River(player);
                        location.onLocation();
                    } else {
                        System.out.println("Ödülü kazandığınız için buraya tekrardan gidemezsiniz!");
                    }

                break;
                case 6:
                    location=new Mine(player);

                    break;
                default:
                    location=new SafeHouse(player);
            }
            if (location==null){
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin :)");
                break;
            }
            if (!location.onLocation())
            {
                System.out.println("Game Over!");
                break;
            }

        }


    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
}
