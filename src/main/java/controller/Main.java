package controller;

        /* __________________________________________ LMBANGEL ________________________________________ */
        import view.Play;

        import java.io.PrintWriter;

public class Main{

    public static PrintWriter heroStore;
    private static Play play = new Play();
    public static void main(String[] args)
    {

        try{
            play.beginGame(0);

        }catch (Exception err){
            System.out.println(err);
        }

    }

    public static void continueWithExistingHero(){

    }
}
