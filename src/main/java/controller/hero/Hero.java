package controller.hero;

import model.Power;
import model.artifacts.Artifact;
import view.PlayGame;

/* __________________________________________ LMBANGEL ________________________________________ */
public class Hero {

    public String heroName;
    public String heroClass;
    public int heroLevel;
    public int heroExperience;
    public Power power;        /* ___________ Attack, Defence, Hit points ____________ */
    public Power fullStrength;  /* ___ Attack + Weapon (attack) - Defence + Armor (defence) - HP + Helm (hitpoints) __ */
    public Artifact artifact;  /* _______________ Armor, Weapon, Helm ________________ */
    public static int heroId;
    public  PlayGame playGame;
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

        this.fullStrength = new Power(( this.power.getAttack() + this.artifact.getHeroWeapon().getPoints() ),
                ( this.power.getDefence() + this.artifact.getHeroArmor().getPoints() ),
                ( this.power.getHitPoints() + this.artifact.getHeroHelm().getPoints() )
        );
    }
/* ____________________________________________________________________________________________ */

    public String getHeroName(){ return this.heroName; }
    public void setHeroName(String heroName){ this.heroName = heroName; }
    public String getHeroClass(){ return  this.heroClass; }
    public void setHeroClass(String heroClass){ this.heroClass = heroClass; }
    public int getHeroLevel(){ return this.heroLevel; }
    public void setHeroLevel(int heroLevel){ this.heroLevel = heroLevel;}
    public int getHeroExperience(){ return this.heroExperience; }
    public void setHeroExperience(int heroExperience){ this.heroExperience = heroExperience; }
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
        if(this.heroLevel > 5){
            playGame.endGame();
        }
        return this.heroLevel;
    }

    public void xpUp(int heroLevel){
        heroLevel++;
        if(heroLevel == 2)
            this.heroExperience = 2450;
        else if(heroLevel == 3)
            this.heroExperience = 4800;
        else if(heroLevel == 4)
            this.heroExperience = 8050;
        else if (heroLevel == 5)
            this.heroExperience = 12200;
        else
             this.heroExperience = getHeroExperience();
//        return this.heroExperience;
    }
}
