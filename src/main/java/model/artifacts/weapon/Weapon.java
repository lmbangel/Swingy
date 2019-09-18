package model.artifacts.weapon;

import model.artifacts.helm.Limit;

/* __________________________________________ LMBANGEL ________________________________________ */
public class Weapon{

//    @NotNull
    private int points;
    @Limit
//    @NotNull
    private int level;
    private String weapon;

    public Weapon(int points, int level, String weapon){
        this.points = points;
        this.level = level;
        this.weapon = weapon;

    }

    public int getPoints(){
        return this.points;
    }

    public void setPoints(int points){
        this.points = points;
    }
    public void  updatePoints(int points){
        setPoints(points + this.points);
    }
    public  String getWeapon(){ return  this.weapon; }
}
