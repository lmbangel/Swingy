package controller;

        /* __________________________________________ LMBANGEL ________________________________________ */

import controller.hero.Hero;
import view.Play;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main{
    public  PrintWriter writer;
    public static Play play = new Play();

    public static void main(String[] args)
    {
        try{
            play.beginGame(0);

        }catch (Exception err){
            System.out.println(err);
        }
    }

    public void saveHero(Hero hero){
        String store;
        String dateStore;
        try {
            writer = new PrintWriter(new FileWriter("HeroStorageFile.txt", true));
        }catch (Exception e){
            System.out.println(e);
            System.out.println("File NOT FOUND");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd:ss");
        dateStore  = dateFormat.format(new Date());
        store =  hero.getHeroName() + "§" + hero.getHeroClass() + "§" + hero.getHeroExperience() + "§" +
                hero.getHeroLevel() + "§" + hero.getPower().getAttack() + "§" + hero.getPower().getDefence()
        + "§" + hero.getPower().getHitPoints() + "§" + dateStore;
        writer.println(store);
        writer.close();
    }

}
