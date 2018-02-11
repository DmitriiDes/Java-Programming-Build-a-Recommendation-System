
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("data/ratedmoviesfull.csv", "data/ratings.csv");
    }
    
    public SecondRatings(String moviefile, String ratingsfile) {
       FirstRatings MoviesRated = new FirstRatings();
       myMovies = MoviesRated.LoadMovies(moviefile);
       myRaters = MoviesRated.LoadRaters(ratingsfile);
    }
    
    public int getMovieSize(){
        return myMovies.size();
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }    
    
    private double getAverageByID(String id, int minimalRaters){
        double aveg = 0.0;
        int k = 0;
        for (Rater rater: myRaters){
            if (rater.getRating(id) >= 0){k++; aveg += rater.getRating(id);} 
        }
        if (k >= minimalRaters){aveg = aveg/k; return aveg;}
        return 0.0;
    }
    
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> avgMovieRatings = new ArrayList<Rating>();
        for (Movie movie: myMovies){
            Rating movieRating = new Rating(movie.getID(),getAverageByID(movie.getID(),minimalRaters));
            avgMovieRatings.add(movieRating);
        }
        
        return avgMovieRatings;
    }
    
    public String getTitle(String id){
        for (Movie movie: myMovies){if(movie.getID().equals(id)){return movie.getTitle();};}
        return "No Such ID";
    }
    
    public String getID(String title){
        for (Movie movie: myMovies){if(movie.getTitle().equals(title)){return movie.getID();};}
        return "No Such Title";
    }
    
}
