package model.artifacts.helm;

/* __________________________________________ LMBANGEL ________________________________________ */
public class Helm {

//    @NotNull
    private int points;
    @Limit(min = 1, max = 5)
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
