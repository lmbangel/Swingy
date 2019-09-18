package view;

import controller.Main;
import controller.hero.Hero;

import java.util.Scanner;

/* __________________________________________ LMBANGEL ________________________________________ */
public class Play {

    Scanner input = new Scanner(System.in);
    public Choose chooseClass;
    public PlayGame playGame;
    public MapField mapField;
    int heroClass;
    int heroArmor;
    int heroWeapon;
    int heroHelm;
    public Hero hero;
    public Hero player;
    public Main main = new Main();

    public Play(){ }

    public void beginGame(int lvl)
    {
        if (lvl == 0)
        {
            System.out.println("____________________________ WELCOME ____________________________\n" +
                    "\n             Enter 1. to START | Enter 2. to CONTINUE" +
                    "\n             _________________________________________\n" +
                    "\n1.START GAME - New character" +
                    "\n2.CONTINUE   - Use saved character" +
                    "\n"
            );/* ___________________________________________________________________________________________________*/
            int choice = 0;
            while (choice == 0)
            {
                try {

                    int play = Integer.parseInt(input.nextLine());
                    if (play == 1 || play == 2)
                        choice = play;
                    else
                        System.out.println("PLEASE ENTER NUMBERS 1 OR 2 TO CHOOSE BETWEEN START AND CONTINUE!!!");
                } catch (Exception err) {
                    System.out.println("ERROR CODE FOR YOUR ASS!: " + err + "\n" +
                            "PLEASE ENTER NUMBERS 1 OR 2 TO CHOOSE BETWEEN START AND CONTINUE!!!");
                }
            }
            selectHero(choice);
        }
        displayStats(playGame.getHero());
        hero = playGame.getHero();
        System.out.println("\n");
        mapField = new MapField(playGame);
        mapField.createMap(playGame.getHero().getHeroLevel());
        mapField.map();
        mapField.moveInMap(mapField.getMapSize()/2, mapField.getMapSize()/2);
    }

    public void beginContinue(Hero heroCont){

        displayStats(heroCont);
        hero = heroCont;
        System.out.println("\n");
        mapField = new MapField(playGame);
        mapField.createMap(heroCont.getHeroLevel());
        mapField.map();
        mapField.moveInMap(mapField.getMapSize()/2, mapField.getMapSize()/2);
    }


    public void selectHero(int choice) {
        if (choice == 1)
            makeNewHero();
        else {
            try {
                playGame = new PlayGame(this);
                player = new Hero("dummy", "Hunter", 1, 1, 1);
                System.out.println("SSSSSSSSSS");
                playGame.continueWithHero(player, this);
                System.out.println("afgafdg");
            } catch (Exception err) {
                System.out.println(err);
            }
        }
    }

    public void makeNewHero()
    {
        System.out.println(
                "                ENTER THE NAME OF YOUR HERO" +
                "\n             ______________________________\n");
        String name = input.nextLine();
        chooseClass = new Choose();
        heroClass = chooseClass.choice();
        heroArmor = chooseClass.armorChoice();
        heroWeapon = chooseClass.weaponChoice();
        heroHelm = chooseClass.helmChoice();
        playGame = new PlayGame(this);
        playGame.createNewHero(name, heroClass, heroArmor, heroWeapon, heroHelm );
    }

    public void displayStats(Hero hero)
    {
        System.out.println("            HERO STATS\n_____________________________________"+
                "\nName:        "+hero.getHeroName()+
                "\nClass:       "+hero.getHeroClass()+
                "\nLevel:       "+hero.getHeroLevel()+
                "\nXP:          "+hero.getHeroExperience()+
                "\nAttack:      "+hero.getPower().getAttack()+
                "\nDef:         "+hero.getPower().getDefence()+
                "\nHP:          "+hero.getPower().getHitPoints()+
                "\nArmor:       "+hero.getArtifact().getHeroArmor().getArmor()+     "   - "+hero.getArtifact().getHeroArmor().getPoints()+    " Points"+
                "\nWeapon:      "+hero.getArtifact().getHeroWeapon().getWeapon()+       "           - "+hero.getArtifact().getHeroWeapon().getPoints()+   " Points"+
                "\nHelm:        "+hero.getArtifact().getHeroHelm().getHelm()+       "       - "+hero.getArtifact().getHeroHelm().getPoints()+     " Points"+
                "\nID:          "+hero.getHeroId() + "\n"+
                "____________________________________\n"+
                "Total Strength: \n"+
                "att:       "+hero.getFullStrength().getAttack()+
                "\ndef:       "+hero.getFullStrength().getDefence()+
                "\nhp:        "+hero.getFullStrength().getHitPoints()
        );
    }

}
