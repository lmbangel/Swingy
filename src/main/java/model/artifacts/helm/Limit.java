package model.artifacts.helm;

public @interface Limit {
     int min() default 1;
     int max() default 5;
     String message() default "Your level does not exist in this game";
}
