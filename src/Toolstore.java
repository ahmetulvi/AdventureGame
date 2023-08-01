public class Toolstore extends NormalLoc{
    public Toolstore(Player player){
        super(player,"Mağaza");
    }
    @Override
    public boolean onLocation(){
        boolean showMenu=true;
        System.out.println("Mağazaya Hoşgeldiniz!");
        while (showMenu){
            System.out.println("1- Silahlar");
            System.out.println("2-Zırhlar");
            System.out.println("3- Çıkış Yap");
            System.out.println("Seçiminiz:");
            int selectCase= sc.nextInt();
            while (selectCase<1 || selectCase>3){
                System.out.println("Geçersiz değer, lütfen tekrardan giriniz:");
                selectCase=sc.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz.");
                    showMenu=false;
                    break;
            }

        }
        return true;
    }
    public void printWeapon(){
        System.out.println("Silahlar");
        System.out.println();
        for (Weapon w:Weapon.weapons()){
            System.out.println(w.getId()+"- " +w.getName()+" <<Fiyat>> "+w.getPrice()+" <<Hasar>> "+w.getDamage());
        }
        System.out.println("0- Çıkış Yap");

    }
    public void buyWeapon(){
        System.out.println("Silah seçiniz.");
        int selectWeaponId= sc.nextInt();
        while (selectWeaponId<0 || selectWeaponId>Weapon.weapons().length){
            System.out.println("Geçersiz değer, lütfen tekrardan giriniz:");
            selectWeaponId=sc.nextInt();
        }
        if (selectWeaponId!=0){
            Weapon selectedWeapon=Weapon.getWeaponById(selectWeaponId);
            if (selectedWeapon!=null){
                if (selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Bakiye yetersiz!");
                    return;
                }else
                    System.out.println(selectedWeapon.getName()+" silahını aldınız");
                int balance=this.getPlayer().getMoney()-selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız: "+this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println(this.getPlayer().getInventory().getWeapon().getName());
            }
        }

    }
    public void printArmor(){
        System.out.println("--------Zırhlar--------");
        for (Armor a:Armor.armors()){
            System.out.println(a.getId()+" - "+a.getName()+ " <Block> "+a.getBlock()+" Engelleme "+a.getPrice());
        }
        System.out.println("0- Çıkış Yap");
    }
    public void buyArmor(){
        System.out.println("Armor seçiniz.");
        int selectArmorId= sc.nextInt();
        while (selectArmorId<0 || selectArmorId>Armor.armors().length){
            System.out.println("Geçersiz değer, lütfen tekrardan giriniz:");
            selectArmorId=sc.nextInt();
        }
        if (selectArmorId!=0){
            Armor selectedArmor=Armor.getArmorById(selectArmorId);
            if (selectedArmor!=null){
                if (selectedArmor.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Bakiye yetersiz!");
                    return;
                }else
                    System.out.println(selectedArmor.getName()+" zırhını aldınız");
                int balance=this.getPlayer().getMoney()-selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız: "+this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println(this.getPlayer().getInventory().getArmor().getName());
            }
        }
    }
}
