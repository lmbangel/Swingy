package model;

import java.util.Random;

public class FightSim {

    public static void fighting(int heroPower, int enemyPower, String enemyClass){

        Random luckDraw = new Random();
        int n = luckDraw.nextInt(57);

        System.out.println("Enemy Power = " + enemyPower + "Hero Power = " + heroPower);
        if (enemyPower > heroPower && (n % 2 == 0))
            System.out.println("You are very lucky, the " + enemyClass + " tripped and fell just when it was about to kill you...Haahaha dumb blob!!");
        else if (enemyPower > heroPower)
            System.out.println("The " + enemyClass + " beat the heck out of you...you dead Nigga!!");
        else if(heroPower > enemyPower)
            System.out.println("You beat the heck out of that " + enemyClass + "...Hahaha right on bro!!!");
    }



}
