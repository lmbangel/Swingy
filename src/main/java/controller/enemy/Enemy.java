package controller.enemy;


import model.Power;

import java.util.Random;

public class Enemy  {
    Random random;
    String name;
    Power power;
    int xp;
    Power fullStrength;
    Enemy(){}

    public Enemy enemy(int lvl) {
        if(lvl == 1) {
            this.name = "Transpose01";
            this.power = new Power(50,50,50);
            this.xp = 1000;
            this.fullStrength = new Power(this.power.getAttack(), this.power.getDefence(), this.power.getHitPoints());
        } else if (lvl == 2) {
            this.name = "Transpose02";
            this.power = new Power(50,50,50);
            this.xp = 1000;
            this.fullStrength = new Power(this.power.getAttack(), this.power.getDefence(), this.power.getHitPoints());
        } else if (lvl == 3) {
            this.name = "Transpose03";
            this.power = new Power(50,50,50);
            this.xp = 1000;
            this.fullStrength = new Power(this.power.getAttack(), this.power.getDefence(), this.power.getHitPoints());
        } else if (lvl == 4) {
            this.name = "Transpose04";
            this.power = new Power(50,50,50);
            this.xp = 1000;
            this.fullStrength = new Power(this.power.getAttack(), this.power.getDefence(), this.power.getHitPoints());
        } else {
            this.name = "Transpose05";
            this.power = new Power(50,50,50);
            this.xp = 1000;
            this.fullStrength = new Power(this.power.getAttack(), this.power.getDefence(), this.power.getHitPoints());
        }
        return this;
    }

    public void setFullStrength(){}
    public void setPower(){}
    public void setAttack(){}
    public void setDefense(){}
    public void setXp(){}

    public Power getFullStrength(){ return  this.fullStrength; }
    public Power getPower(){ return this.power;}
//    public int getAttack(){ return this.attack; }
//    public int getDefense(){ return this.defense; }
    public int getXp(){ return  this.xp; }


    


}



