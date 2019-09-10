package controller.hero;

import com.sun.istack.internal.NotNull;
import model.Power;
import model.artifacts.Artifact;

/* __________________________________________ LMBANGEL ________________________________________ */
public class Hero {

    @NotNull private String heroName;
    @NotNull private String heroClass;
    private int heroLevel;
    private int heroExperience;
    private Power power;        /* ___________ Attack, Defence, Hit points ____________ */
    private Power fullStrength;  /* ___ Attack + Weapon (attack) - Defence + Armor (defence) - HP + Helm (hitpoints) __ */
    private Artifact artifact;  /* _______________ Armor, Weapon, Helm ________________ */
    private static int heroId;
/* ____________________________________________________________________________________________ */

    public Hero(String heroName, String heroClass, int heroArmor, int heroWeapon, int heroHelm){
        this.heroName = heroName;
        this.heroLevel = 1;
        this.heroClass = heroClass;
        this.heroExperience = 0;
        this.heroId = heroId();
        if (heroClass.equalsIgnoreCase("marine"))
            this.power = new Power(20, 17, 70);
        else if (heroClass.equalsIgnoreCase("hunter"))
            this.power = new Power(20, 10, 70);
        else if (heroClass.equalsIgnoreCase("MMA"))
            this.power = new Power(20, 20, 70);

            this.artifact = new Artifact("hero");
            this.artifact.setHeroArmor(Artifact.selectArmor(heroArmor));
            this.artifact.setHeroWeapon(Artifact.selectWeapon(heroWeapon));
            this.artifact.setHeroHelm(Artifact.selectHelm(heroHelm));
            fullStrength();
    }
/* ____________________________________________________________________________________________ */

    public void fullStrength(){
//        int attack;
//        int defence;
//        int hitpoints;
//
//        attack = ( this.power.getAttack() + this.artifact.getHeroWeapon().getPoints() );
//        defence = ( this.power.getDefence() + this.artifact.getHeroArmor().getPoints() );
//        hitpoints = ( this.power.getHitPoints() + this.artifact.getHeroHelm().getPoints() );
        this.fullStrength = new Power(( this.power.getAttack() + this.artifact.getHeroWeapon().getPoints() ),
                ( this.power.getDefence() + this.artifact.getHeroArmor().getPoints() ),
                ( this.power.getHitPoints() + this.artifact.getHeroHelm().getPoints() )
        );
    }
/* ____________________________________________________________________________________________ */

    public String getHeroName(){ return this.heroName; }
    public String getHeroClass(){ return  this.heroClass; }
    public int getHeroLevel(){ return this.heroLevel; }
    public int getHeroExperience(){ return this.heroExperience; }
    public Power getPower(){ return this.power; }

    public void setPower(int points){
        this.power.setAttack(this.power.getAttack() + points);
        this.power.setDefence(this.power.getDefence() + points);
        this.power.setHitPoints(this.power.getHitPoints() + points);
    }
    public Power getFullStrength(){ return this.fullStrength; }
    public Artifact getArtifact(){ return this.artifact; }
/* ____________________________________________________________________________________________ */

    public int heroId(){
        return ++heroId;
    }
    public int getHeroId(){
       return this.heroId;
    }

    public int lvlUP(int heroLevel){
        this.heroLevel++;
        return this.heroLevel;
    }

    public int xpUp(int heroLevel){
        if(heroLevel == 2)
            this.heroExperience = 1000;
        else if(heroLevel == 3)
            this.heroExperience = 1000;
        else if(heroLevel == 4)
            this.heroExperience = 1000;
        else if (heroLevel == 5)
            this.heroExperience = 1000;
        else
             this.heroExperience = getHeroExperience();
        return this.heroExperience;
    }

}
