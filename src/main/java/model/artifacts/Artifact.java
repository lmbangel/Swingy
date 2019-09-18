package model.artifacts;

import model.artifacts.armor.Armor;
import model.artifacts.armor.BreastPlate;
import model.artifacts.armor.Shield;
import model.artifacts.helm.HardHat;
import model.artifacts.helm.Helm;
import model.artifacts.helm.IronHead;
import model.artifacts.weapon.Gun;
import model.artifacts.weapon.Knife;
import model.artifacts.weapon.Staff;
import model.artifacts.weapon.Weapon;

/* __________________________________________ LMBANGEL ________________________________________ */
public class Artifact {

//    @NotNull
    private Armor heroArmor;
//    @NotNull
    private Weapon heroWeapon;
//    @NotNull
    private Helm heroHelm;

    public Artifact(String hero){

    }


    public void setHeroArmor(Armor heroArmor){
        this.heroArmor = heroArmor;
    }
    public Armor getHeroArmor(){
        return this.heroArmor;
    }

    public void setHeroWeapon(Weapon heroWeapon){
        this.heroWeapon = heroWeapon;
    }
    public Weapon getHeroWeapon(){
        return  this.heroWeapon;
    }

    public  void  setHeroHelm(Helm heroHelm){
        this.heroHelm = heroHelm;
    }
    public Helm getHeroHelm(){
        return  this.heroHelm;
    }


/* ____________________________________________________ */

    public static Armor selectArmor(int armor){
        if (armor == 2)
            return new Shield(30, 1);
        else if (armor == 1)
            return new BreastPlate(25, 1);
        else
            return null;
    }
/* ____________________________________________________ */

    public static Weapon selectWeapon(int weapon){
        if (weapon == 1)
            return new Gun(30, 1);
        else if (weapon == 2)
            return new Knife(25, 1);
        else if (weapon == 3)
            return new Staff(23, 1);
        else
            return null;
    }
/* ____________________________________________________ */

    public static Helm selectHelm(int helm){
        if (helm == 1)
            return new HardHat(25, 1);
        else if (helm == 2)
            return new IronHead(30, 1);
        else
            return null;
    }
/* ____________________________________________________ */


}
