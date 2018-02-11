
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class MovieRunnerAverage {
    
    public void printAverageRatings(){
        SecondRatings MoviesRated = new SecondRatings("data/ratedmoviesfull.csv","data/ratings.csv");
        System.out.println(MoviesRated.getMovieSize());
        System.out.println(MoviesRated.getRaterSize());
        ArrayList<Rating> avgMovieRatings = MoviesRated.getAverageRatings(12);
        System.out.println(avgMovieRatings.size());
        Collections.sort(avgMovieRatings);
        for (Rating movie:avgMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MoviesRated.getTitle(movie.getItem()));}        
        }
        
    }
    
    public void getAverageOneMovie(){
        SecondRatings MoviesRated = new SecondRatings("data/ratedmoviesfull.csv","data/ratings.csv");
        String title = "Vacation";
        int minRaters = 3;
        int k = 0;
        String myId = MoviesRated.getID(title);
        ArrayList<Rating> avgMovieRatings = MoviesRated.getAverageRatings(minRaters);
        for (Rating movie:avgMovieRatings){
            if (movie.getItem().equals(myId)){
                System.out.println(movie.getValue()+": "+ MoviesRated.getTitle(movie.getItem())); 
                k = -1;
                break;}
        }
        if (k!=-1){System.out.println(myId);}
    }
    
}
