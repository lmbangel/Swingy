package model.artifacts.armor;

import model.artifacts.helm.Limit;

/* __________________________________________ LMBANGEL ________________________________________ */
public class Armor{

//   @NotNull
   private int points;
   @Limit(min=1, max=5)
//   @NotNull
   private int level;
    private String armor;

    public Armor(int points, int level, String armor){
        this.points = points;
        this.level = level;
        this.armor = armor;

    }


    public int getPoints(){
        return this.points;
    }
    public void setPoints(int points){
        this.points = points;
    }
    public void updatePoints(int points){
        setPoints(points + this.points);
    }

    public String getArmor(){
        return this.armor;
    }
}
