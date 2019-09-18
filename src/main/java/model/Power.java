package model;

/* __________________________________________ LMBANGEL ________________________________________ */
public class Power {

//    @NotNull
    private int attack;
//    @NotNull
    private int defence;
//    @NotNull
    private int hitPoints;

    public Power(int attack, int defence, int hitPoints){
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;

    }

    public int getAttack(){
        return this.attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public int getDefence(){
        return this.defence;
    }
    public void setDefence(int deff){
        this.defence = deff;
    }
    public int getHitPoints(){
        return this.hitPoints;
    }
    public void setHitPoints(int hp){
        this.hitPoints = hp;
    }
}
