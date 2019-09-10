package view;

import java.util.Scanner;



public class Choose {


    Scanner input = new Scanner(System.in);
    public Choose(){}

    public int choice(){
        System.out.println("___________________ SELECT A DESIRED HERO TYPE/CLASS _____________________"+
                            "\n                 ENTER NUMBERS 1, 2 OR 3 TO CHOOSE"+
                            "\n                ___________________________________"+
                            "\nHero Type                                Hero Stats"+
                            "\n_________                                __________"+
                            "\n1.Marine                                 att: "+ "20"+
                            "\n                                         def: "+ "17"+
                            "\n                                         hp:  "+ "70"+
                            "\n2.MMA (Mixed Martial Artist)             att: "+ "20"+
                            "\n                                         def: "+ "20"+
                            "\n                                         hp:  "+ "70"+
                            "\n3.Hunter                                 att: "+ "20"+
                            "\n                                         def: "+ "10"+
                            "\n                                         hp:  "+ "70"
        );

        int choice = 0;
        while (choice == 0)
        {
            try {
                int heroClass = Integer.parseInt(input.nextLine());
                if ( heroClass == 1 || heroClass == 2 || heroClass == 3 )
                    choice = heroClass;
                else
                    System.out.println("PLEASE ENTER NUMBERS 1, 2 OR 3 TO CHOOSE HERO TYPE/CLASS!!!");
            } catch (Exception err) {
                System.out.println("ERROR CODE FOR YOUR ASS!: " + err + "\n" + "PLEASE ENTER NUMBERS 1, 2 OR 3 TO CHOOSE HERO TYPE/CLASS!!!");
            }
        }
        return choice;

    }

    public int armorChoice(){
        System.out.println("___________________ SELECT A DESIRED ARMOR _____________________"+
                "\n                 ENTER NUMBERS 1 OR 2 TO CHOOSE"+
                "\n                ___________________________________"+
                "\nArmor                                Points"+
                "\n_________                            _______"+
                "\n1.Breast Plate                     "+"25"+
                "\n2.Shield                           "+"30"+
                "\n"
        );

        int choice = 0;
        while (choice == 0)
        {
            try {
                int heroArmor = Integer.parseInt(input.nextLine());
                if ( heroArmor == 1 || heroArmor == 2 )
                    choice = heroArmor;
                else
                    System.out.println("PLEASE ENTER NUMBERS 1 OR 2 TO CHOOSE ARMOR!!!");
            } catch (Exception err) {
                System.out.println("ERROR CODE FOR YOUR ASS!: " + err + "\n" + "PLEASE ENTER NUMBERS 1 OR 2 TO CHOOSE ARMOR!!!");
            }
        }
        return choice;
    }

    public int weaponChoice(){
        System.out.println("___________________ SELECT A DESIRED WEAPON _____________________"+
                "\n                 ENTER NUMBERS 1, 2 OR 3 TO CHOOSE"+
                "\n                ___________________________________"+
                "\nWeapon                                 Points"+
                "\n_________                              _______"+
                "\n1.Gun                                 "+"30"+
                "\n2.Knife                               "+"25"+
                "\n3.Staff                               "+"23"+
                "\n"
        );

        int choice = 0;
        while (choice == 0)
        {
            try {
                int heroWeapon = Integer.parseInt(input.nextLine());
                if ( heroWeapon == 1 || heroWeapon == 2 || heroWeapon == 3 )
                    choice = heroWeapon;
                else
                    System.out.println("PLEASE ENTER NUMBERS 1, 2 OR 3 TO CHOOSE WEAPON!!!");
            } catch (Exception err) {
                System.out.println("ERROR CODE FOR YOUR ASS!: " + err + "\n" + "PLEASE ENTER NUMBERS 1, 2 OR 3 TO CHOOSE WEAPON!!!");
            }
        }
        return choice;
    }

    public int helmChoice(){
        System.out.println("___________________ SELECT A DESIRED HELM _____________________"+
                "\n                 ENTER NUMBERS 1 OR 2 TO CHOOSE"+
                "\n                ___________________________________"+
                "\nHelm                                 Points"+
                "\n_________                            _______"+
                "\n1.Hardhat                            "+"25"+
                "\n2.Iron head                          "+"30"+
                "\n"
        );

        int choice = 0;
        while (choice == 0)
        {
            try {
                int heroHelm = Integer.parseInt(input.nextLine());
                if ( heroHelm == 1 || heroHelm == 2 )
                    choice = heroHelm;
                else
                    System.out.println("PLEASE ENTER NUMBERS 1 OR 2 TO CHOOSE HELM!!!");
            } catch (Exception err) {
                System.out.println("ERROR CODE FOR YOUR ASS!: " + err + "\n" + "PLEASE ENTER NUMBERS 1 OR 2 TO CHOOSE HELM!!!");
            }
        }
        return choice;
    }



}
