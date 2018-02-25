
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
        //SecondRatings MoviesRated = new SecondRatings("data/ratedmovies_short.csv","data/ratings_short.csv");
        System.out.println("Movie size : " + MoviesRated.getMovieSize());
        System.out.println("Rater size: "+ MoviesRated.getRaterSize());
        
        System.out.println("title: "+ MoviesRated.getTitle("68646"));
        System.out.println("avg by ID: "+ MoviesRated.getAverageByID("68646",10));
        
        ArrayList<Rating> avgMovieRatings = MoviesRated.getAverageRatings(50);
        //HashMap<String, Double> avgMovieRatings = MoviesRated.getAverageRatings(12);
        System.out.println("Avg movie sezi: "+ avgMovieRatings.size());
        Collections.sort(avgMovieRatings);
        for (Rating movie:avgMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MoviesRated.getTitle(movie.getItem()));}        
        }
        
        //for (String movie:avgMovieRatings.keySet()){
        //    if (avgMovieRatings.get(Movie)>0){
        //        System.out.println(avgMovieRatings.get(Movie)+": "+ MoviesRated.getTitle(movie.getItem()));}        
        //}
        
        
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
