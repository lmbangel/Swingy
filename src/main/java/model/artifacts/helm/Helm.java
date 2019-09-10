package model.artifacts.helm;

import model.artifacts.Artifact;

/* __________________________________________ LMBANGEL ________________________________________ */
public class Helm {

    private int points;
    private int level;
    private String helm;

    public Helm(int points, int level, String helm){
        this.points = points;
        this.level = level;
        this.helm = helm;

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
    public String getHelm(){ return  this.helm; }
}
