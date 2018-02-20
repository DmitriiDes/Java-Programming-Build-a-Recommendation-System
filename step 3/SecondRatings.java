
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class SecondRatings {
    private HashMap<String, Movie> myMovies;
    private HashMap<String, EfficientRater> myRaters;
    
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
    
    // average rating by movie ID
    public double getAverageByID(String id, int minimalRaters){
        double aveg = 0.0;
        int k = 0;
        for (EfficientRater rater : myRaters.values()){
            if (rater.getRating(id) >= 0){k++; aveg += rater.getRating(id);} 
        }
        if (k >= minimalRaters){aveg = aveg/k; return aveg;}
        return 0.0;
    }
    
    // get average ratings for all movies rated by minimalRaters people
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> avgMovieRatings = new ArrayList<Rating>();
        for (Movie movie: myMovies.values()){
            Rating movieRating = new Rating(movie.getID(),getAverageByID(movie.getID(),minimalRaters));
            if(getAverageByID(movie.getID(),minimalRaters)> 0){avgMovieRatings.add(movieRating);};
        }
        
        return avgMovieRatings;
    }
    
    //public HashMap<String, Double> getAverageRatings(int minimalRaters){
    //    HashMap<String, Double> avgMovieRatings = new HashMap<String, Double>();
    //    for (Movie movie : myMovies.values()){
    //        avgMovieRatings.put(movie.getID(),getAverageByID(movie.getID(),minimalRaters));
    //    }
        
    //    return avgMovieRatings;
    //}
    
    
    public String getTitle(String id){
        //for (Movie movie: myMovies){if(movie.getID().equals(id)){return movie.getTitle();};}
        //Movie movie = myMovies.get(id);
        //return movie.getTitle();
        if(myMovies.containsKey(id)){return myMovies.get(id).getTitle();};
        return "No Such ID";
    }
    
    public String getID(String title){
        //for (Movie movie: myMovies){if(movie.getTitle().equals(title)){return movie.getID();};}
        for (Movie movie: myMovies.values()){if(movie.getTitle().equals(title)){return movie.getID();};}
        
        return "No Such Title";
    }
    
}
