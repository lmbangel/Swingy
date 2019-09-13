package view;

import controller.hero.Hero;
import controller.hero.Hunter;
import controller.hero.MMA;
import controller.hero.Marine;

import java.util.Scanner;


/* __________________________________________ LMBANGEL ________________________________________ */
public class PlayGame {

    public Hero hero;
    public Play play;
    public int[][] map;
    public MapField mapField;
    Scanner input = new Scanner(System.in);

        PlayGame(Play play){
            this.play = play;
        }

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

        mapField = new MapField(this);
        hero = newHero;
        this.hero = newHero;

        this.map = mapField.createMap(this.hero.getHeroLevel());

    }

    public Hero getHero(){
        return this.hero;
    }

    public void updateValues(Hero hero){
        hero.xpUp(hero.getHeroLevel());
        int val = (hero.getHeroExperience() / 6) / 6;
        hero.getArtifact().getHeroArmor().updatePoints(val);
        hero.getArtifact().getHeroWeapon().updatePoints(val);
        hero.getArtifact().getHeroHelm().updatePoints(val);
        hero.setPower(val);
        hero.fullStrength();
        hero.lvlUP(hero.getHeroLevel());

    }

    public void fight(){

        System.out.println(hero.getPower().getAttack());

        if (mapField.damage < 0 ){
            System.out.println("You lost");
        }
        else if (mapField.damage == 0){
            System.out.println("It's a draw");
        }
        else {
            System.out.println("You won");
        }


    }


    public void endOfMap(Hero heRo) {
        updateValues(heRo);
        play.beginGame(heRo.getHeroLevel());
        System.out.println("Lovin me");

    }
    public void endGame(){
            System.out.println("Congratulations...You have clocked (Haaaa, I miss home) the game");
    }

}