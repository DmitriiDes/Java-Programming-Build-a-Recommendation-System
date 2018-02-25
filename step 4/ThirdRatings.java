
/**
 * Write a description of ThirdRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class ThirdRatings {
    //private HashMap<String, Movie> myMovies;
    private HashMap<String, EfficientRater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("data/" + "ratings.csv");
    }
    
    public ThirdRatings(String ratingsfile) {
       FirstRatings MoviesRated = new FirstRatings();
       //myMovies = MoviesRated.LoadMovies(moviefile);
       myRaters = MoviesRated.LoadRaters(ratingsfile);
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }    
    
    // average rating by movie ID with min raters
    public double getAverageByID(String id, int minimalRaters){
        double aveg = 0.0;
        int k = 0;
        for (EfficientRater rater : myRaters.values()){
            if (rater.getRating(id) >= 0){k++; aveg += rater.getRating(id);} 
        }
        if (k >= minimalRaters){aveg = aveg/k; return aveg;}
        return 0.0;
    }
    
    // average by min raters
    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<Rating> avgMovieRatings = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for (String movieID: movies){
            Rating movieRating = new Rating(movieID,getAverageByID(movieID,minimalRaters));
            if(getAverageByID(movieID,minimalRaters)> 0){avgMovieRatings.add(movieRating);};
        }
        
        return avgMovieRatings;
    }
    
    // avg with filter
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria){
        ArrayList<Rating> avgMovieRatings = new ArrayList<Rating>();
        ArrayList<String> moviesFiltered = MovieDatabase.filterBy(filterCriteria);
        for (String movieID: moviesFiltered){
            //Rating movieRating = new Rating(movieID,getAverageByID(movieID,minimalRaters));
            if(getAverageByID(movieID,minimalRaters)> 0){avgMovieRatings.add(new Rating(movieID,getAverageByID(movieID,minimalRaters)));};
        }
        
        return avgMovieRatings;
    }
    
}

