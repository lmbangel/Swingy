package view;

import controller.enemy.Enemy;
import controller.hero.Hero;
import model.Power;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Random;
import java.util.Scanner;

import static javafx.application.Platform.exit;

/* __________________________________________ LMBANGEL ________________________________________ */
public class MapField {

    Hero hero;
    Enemy enemy;
    int difference;
    public int mapSize;
    public Random random = new Random();
    public int[][] map;
    Scanner input = new Scanner(System.in);
    int x, y;
    public int mapCenterY = getMapSize()/2;
    public int mapCenterX = getMapSize()/2;

    MapField(){}

    public int getMapSize(){ return this.mapSize; }
    public void setMapSize(int mapSize){ this.mapSize = mapSize; }

    public int[][] createMap(int heroLevel){

        this.mapSize = (heroLevel - 1) * 5 + 10 - (heroLevel % 2);
        map = new int[this.mapSize][this.mapSize];
        setMapSize(this.mapSize);
        return map;
    }


    public void map() {
        for (x = 0; x < this.mapSize; x++) {
            for (y = 0; y < this.mapSize; y++) {
                int num = random.nextInt(51);
                if (num % 2 == 0 && (x != (getMapSize()/2) && y != getMapSize()/2)) {
                    map[x][y] = 1;
                    System.out.print("\033[31;1m" + map[x][y] + " \033[31;0m");
                } else if (x == (getMapSize()/2) && y == (getMapSize()/2)) {
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


    public void moveInMap(int i, int j){
        for (int x = 0; x < this.mapSize; x++) {
            for (int y = 0; y < this.mapSize; y++) {
                if (map[i][j] == 0 || map[i][j] == 7 ){
                    try {
                        move(i, j);
                    }catch (Exception err){
                        System.out.println(err);
                        System.out.println("END OF MAP....YOU HAVE PASSED THIS LEVEL, NOW ON TO THE NEXT ONE");
                        //NEXT LEVEL ......
                        break;
                    }


                } else if(map[i][j] == 1) {
                    System.out.println("YOU HAVE MET AN ENEMY, DO YOU WISH TO FIGHT OR RUN"+
                            "\n1.RUN"+
                            "\n2.FIGHT");
                    int choice = 0;
                    while (choice == 0)
                    {
                        try {
                            int play = Integer.parseInt(input.nextLine());
                            if (play == 1 || play == 2)
                                choice = play;
                            else
                                System.out.println("PLEASE ENTER NUMBERS 1 OR 2 TO CHOOSE BETWEEN RUN AND FIGHT!!!");
                        } catch (Exception err) {
                            System.out.println("ERROR CODE FOR YOUR ASS!: " + err + "\n" + "PLEASE ENTER NUMBERS 1 OR 2 TO CHOOSE BETWEEN RUN AND FIGHT!!!");
                        }
                    }
                    if (choice == 2) {
                        fight();
                    }else{
                        move(i, j);
                    }
                }
                else
                    System.out.println("END OF MAP");
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
        }
        moveInMap(mapCenterX, mapCenterY);
    }


    public void fight(){
        difference = (hero.getFullStrength().getAttack() + hero.getFullStrength().getDefence() + hero.getFullStrength().getHitPoints()) -
                (enemy.getFullStrength().getAttack() + enemy.getFullStrength().getDefence() + enemy.getFullStrength().getHitPoints());
        if (difference > 0){
            System.out.println("WIN");
        }
        else if(difference < 0){
            System.out.println("LOSE."
                    );
        }
        else if (difference == 0){}
        System.out.println("DRAW");

    }




}
