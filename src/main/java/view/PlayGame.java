package view;

import controller.Main;
import controller.hero.Hero;
import controller.hero.Hunter;
import controller.hero.MMA;
import controller.hero.Marine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


/* __________________________________________ LMBANGEL ________________________________________ */
public class PlayGame {

    public Hero hero;
    public Main main = new Main();
    public Play play ;
    public int[][] map;
    public MapField mapField;
    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    public PlayGame(Play play){
        this.play = play;
    }

    public void createNewHero(String heroName, int heroClass, int heroArmor, int heroWeapon, int heroHelm)
    {
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


    public void  setHero(Hero newHero)
    {
        mapField = new MapField(this);
        hero = newHero;
        this.hero = newHero;
        this.map = mapField.createMap(this.hero.getHeroLevel());
    }

    public Hero getHero(){
        return this.hero;
    }

    public void updateValues(Hero hero)
    {
        hero.xpUp(hero.getHeroLevel());
        int val = (hero.getHeroExperience() / 6) / 6;
        hero.getArtifact().getHeroArmor().updatePoints(val);
        hero.getArtifact().getHeroWeapon().updatePoints(val);
        hero.getArtifact().getHeroHelm().updatePoints(val);
        hero.setPower(val);
        hero.fullStrength();
        hero.lvlUP(hero.getHeroLevel());
    }

    public void fight(Hero hero)
    {
        int i = 0;
        while (i < 100000000){ i++; }
        int fight = rand.nextInt(4);
        int heroPower = hero.getFullStrength().getAttack() + hero.getFullStrength().getDefence() + hero.getFullStrength().getHitPoints();
        int enemyPower = ((heroPower / hero.getHeroLevel() * fight) - (heroPower / 2));
        if (heroPower >= enemyPower){
            System.out.println("You have killed the enemy!");
        }else{
            System.out.println("The enemy has killed you!\n\n\n\n\n");
            System.out.println("GAME OVER!");
            System.exit(0);
        }
    }

    public void endOfMap(Hero heRo) {
        updateValues(heRo);
        play.beginGame(heRo.getHeroLevel());
    }

    public void endGame(){
        System.out.println("Congratulations...You have clocked (Haahaa, I miss home) the game");
        System.exit(0);
    }



    public void terminateGame(Hero hEro)
    {
        System.out.println("Would you like to store your progress? (y/n)");
        String yn = null;
        while(!(yn == "y") || !(yn=="n") )
        {
            yn = input.nextLine();
            if (yn.equalsIgnoreCase("y")){
                main.saveHero(hEro);
                System.out.println("PROGRESS SAVED! GAME OVER!");
                System.exit(0);
            } else if (yn.equalsIgnoreCase("n")) {
                System.out.println("GAME OVER!");
                System.exit(0);
            }else {
                System.out.println("Please write y or n");
            }
        }
    }

    public void continueWithHero(Hero player, Play contPlay)throws IOException{
        System.out.println();
        String line;
        BufferedReader buff = new BufferedReader(new FileReader("HeroStorageFile.txt"));
        System.out.println("        Load your game          "+
                "\n_________________________________");
        int i =0;
        while (((line = buff.readLine()) != null)) {
            String [] hero = line.split("§");
            if ((hero.length == 8))
                System.out.println(i+1 + "."+" "+hero[0]+" "+hero[3]+" "+hero[7]);
            i++;
        }
        int choice = 0;
        while (choice == 0)
        {
            try {
                int play = Integer.parseInt(input.nextLine());
                if (!(play > i))
                    choice = play;
                else if (play > i) {
                    System.out.println("NO SUCH HERO SAVED");
                }
            } catch (Exception err) {
                System.out.println("ERROR CODE FOR YOUR ASS!!!: " + err+"(i.e Choose a number from the ones listed Nigga!!)");
            }
        }
        loadHero(choice, player, contPlay);
    }


    public void loadHero(int loadhero, Hero player, Play contPlay) throws IOException {
        String line;
        BufferedReader buff = new BufferedReader(new FileReader("HeroStorageFile.txt"));
        for (int i =0; ((line = buff.readLine()) != null); i++) {
            String [] heero = line.split("§");
            if ((heero.length == 8) && (i == loadhero - 1))
            {
                player.setHeroName(heero[0]);
                player.setHeroClass(heero[1]);
                player.setHeroExperience(Integer.parseInt(heero[2]));
                player.setHeroLevel(Integer.parseInt(heero[3]));
                player.getPower().setAttack(Integer.parseInt(heero[4]));
                player.getPower().setDefence(Integer.parseInt(heero[5]));
                player.getPower().setHitPoints(Integer.parseInt(heero[6]));
                setHero(player);
                contPlay.beginContinue(player);
            }
        }
    }

}