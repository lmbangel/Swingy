package view;

import controller.hero.Hero;
import controller.hero.Hunter;
import controller.hero.MMA;
import controller.hero.Marine;


/* __________________________________________ LMBANGEL ________________________________________ */
public class PlayGame {

    private Hero hero;
    private int[][] map;
    private MapField mapField;



    public void createNewHero(String heroName, int heroClass, int heroArmor, int heroWeapon, int heroHelm){
        Hero newHero;

        if (heroClass == 1)
            newHero = new Marine(heroName, heroArmor, heroWeapon, heroHelm);
        else if(heroClass == 2)
            newHero = new Hunter(heroName, heroArmor, heroWeapon, heroHelm);
        else if (heroClass == 3)
            newHero = new MMA(heroName, heroArmor, heroWeapon, heroHelm);
        else return;
        setHero(newHero);
    }


    public void  setHero(Hero newHero){

        mapField = new MapField();

        this.hero = newHero;
        this.map = mapField.createMap(this.hero.getHeroLevel());

    }

    public Hero getHero(){
        return this.hero;
    }

    public void updateValues(int heroExperience){
        int val = (heroExperience / 6) / 6;
        hero.getArtifact().getHeroArmor().updatePoints(val);
        hero.getArtifact().getHeroWeapon().updatePoints(val);
        hero.getArtifact().getHeroHelm().updatePoints(val);
        hero.setPower(val);
        hero.fullStrength();
        hero.lvlUP(hero.getHeroLevel());
    }

    public void fight(){

    }

}