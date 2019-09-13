package view;

import controller.enemy.Enemy;

import java.util.Random;
import java.util.Scanner;

/* __________________________________________ LMBANGEL ________________________________________ */
public class MapField {
    public Enemy enemy;
    public Play gamePlay = new Play();
    private PlayGame playGame;
    int damage;
    public int mapSize;
    public Random random = new Random();
    public int[][] map;
    Scanner input = new Scanner(System.in);
    int x, y;
    public int mapCenterY = getMapSize()/2;
    public int mapCenterX = getMapSize()/2;


    MapField(PlayGame playGame){
        this.playGame = playGame;
    }

    public int getMapSize(){ return this.mapSize; }
    public void setMapSize(int mapSize){ this.mapSize = mapSize; }

    public int[][] createMap(int heroLevel)
    {

        this.mapSize = (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
        map = new int[this.mapSize][this.mapSize];
        setMapSize(this.mapSize);
        return map;
    }


    public void map()
    {
        for (x = 0; x < this.mapSize; x++)
        {
            for (y = 0; y < this.mapSize; y++)
            {
                int num = random.nextInt(51);
                if (num % 2 == 0 && (x != (getMapSize()/2) && y != getMapSize()/2))
                {
                    map[x][y] = 1;
                    System.out.print("\033[31;1m" + map[x][y] + " \033[31;0m");
                } else if (x == (getMapSize()/2) && y == (getMapSize()/2))
                {
                    map[x][y] = 7;
                    System.out.print("\033[34;1m" + map[x][y] + " \033[34;0m");
                }
                else {
                    map[x][y] = 0;
                    System.out.print("\033[33;1m" + map[x][y] + " \033[33;0m");
                }
            }
            System.out.println();
        }
    }


    public void moveInMap(int i, int j)
    {
        for (int x = 0; x < this.mapSize; x++)
        {
            for (int y = 0; y < this.mapSize; y++)
            {
                if (map[i][j] == 0 || map[i][j] == 7 )
                {
                    move(i, j);
                }
                else if(map[i][j] == 1)
                {
                    System.out.println("YOU HAVE MET AN ENEMY, DO YOU WISH TO FIGHT OR RUN\n");
                    System.out.println("The enemy you have met has the following Stats:\n ");
//                    System.out.println(hero.getHeroLevel());

//                    gamePlay.displayEnemyStats(enemy.enemy(playGame.getHero().getHeroLevel()));
                    System.out.println("1.RUN"+ "\n2.FIGHT");

                    int choice = 0;
                    while (choice == 0)
                    {
                        try {
                            int play = Integer.parseInt(input.nextLine());
                            if (play == 1 || play == 2)
                                choice = play;
                            else
                                System.out.println("PLEASE ENTER NUMBERS 1 OR 2 TO CHOOSE BETWEEN RUN AND FIGHT!!!");
                        } catch (Exception err)
                        {
                            System.out.println("ERROR CODE FOR YOUR ASS!: " + err + "\n" + "PLEASE ENTER NUMBERS 1 OR 2 TO CHOOSE BETWEEN RUN AND FIGHT!!!");
                        }
                    }
                    if (choice == 2)
                    {
                        System.out.println("11111111111111111");
                        playGame.fight();
                    }
                    else
                        {
                        move(i, j);
                        }
                }
            }
            System.out.println();
        }
    }


    public void move(int mapCenterX, int mapCenterY)
    {
        System.out.println(mapCenterX + " + " + mapCenterY);
        System.out.println("\nHOW TO MOVE IN THE MAP WHILE IN GAME PLAY: "+
                            "\nSELECT"+ "\033[31;1m 1 \033[31;0m"+  "TO MOVE"+ "\033[31;1m UP \033[31;0m"+
                            "\nSELECT"+ "\033[31;1m 2 \033[31;0m"+ "TO MOVE"+ "\033[31;1m DOWN \033[31;0m"+
                            "\nSELECT"+ "\033[31;1m 3 \033[31;0m"+ "TO MOVE"+ "\033[31;1m LEFT \033[31;0m"+
                            "\nSELECT"+ "\033[31;1m 4 \033[31;0m"+ "TO MOVE"+ "\033[31;1m RIGHT \033[31;0m"+
                            "\n");
        int choice = 0;
        while (choice == 0)
        {
            try {
                int play = Integer.parseInt(input.nextLine());
                if (play == 1 || play == 2 || play == 3 || play == 4)
                {
                    choice = play;
                    if(choice == 1)
                        mapCenterY--;
                    else if (choice == 2)
                        mapCenterY++;
                    else if (choice == 3)
                        mapCenterX--;
                    else
                        mapCenterX++;
                }
                else
                    System.out.println("PLEASE ENTER NUMBERS 1 | 2 | 3 | 4 TO CHOOSE DIRECTION!!!");
            } catch (Exception err) {
                System.out.println("ERROR CODE FOR YOUR ASS!: " + err + "\n" + "PLEASE ENTER NUMBERS 1 | 2 | 3 | 4 TO CHOOSE DIRECTION!!!");
            }
        }/* __________________________________________ END OF MAP ___________________________________________________________ */
        if ((mapCenterX == -1 || mapCenterX == this.mapSize + 1) || (mapCenterY == -1 || mapCenterY == this.mapSize + 1))
        {
            System.out.println("END OF MAP....YOU HAVE PASSED THIS LEVEL, NOW ON TO THE NEXT ONE\n");
            System.out.println("Do you wish to continue playing? (y/n)");
            String yn = input.nextLine();
            try {
                if(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("n")) {
                    if (yn.equalsIgnoreCase("y")) {
                        playGame.endOfMap(playGame.getHero());
                    } else {
                        System.out.println("ksdjglkgasdlkjhsd");
                        System.exit(0);
                    }
                }
            }catch (Exception e){

                System.out.println("Catch");
            }
        }/* __________________________________________ END OF MAP _____________________________________________________________ */
        else
            moveInMap(mapCenterX, mapCenterY);
    }

}
