
/**
 * Write a description of FourthRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
public class FourthRatings {
    //private HashMap<String, Movie> myMovies;
    //private HashMap<String, EfficientRater> myRaters;
    
    public FourthRatings() {
        // default constructor
        this("data/" + "ratings.csv");
    }
    
    public FourthRatings(String ratingsfile) {
       FirstRatings MoviesRated = new FirstRatings();
       //myMovies = MoviesRated.LoadMovies(moviefile);
       //myRaters = MoviesRated.LoadRaters(ratingsfile);
       RaterDatabase.initialize(ratingsfile);
    }
    
    //public int getRaterSize(){
    //    return myRaters.size();
    //}    
    
    // average rating by movie ID with min raters
    public double getAverageByID(String id, int minimalRaters){
        double aveg = 0.0;
        int k = 0;
        //for (EfficientRater rater : RaterDatabase.getRaters()){
        for (Rater rater : RaterDatabase.getRaters()){   
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
    
    private double dotProduct(Rater me, Rater r){
        double avg = 0;
        for (String i : me.getItemsRated()){
            if (r.hasRating(i)){avg += (me.getRating(i)-5)*(r.getRating(i)-5);}
        }
        return avg;
        //ArrayList<String> MyMovies = me.getItemsRated();
    }
    
    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> list = new ArrayList<Rating>();
        Rater me = RaterDatabase.getRater(id);
        for(Rater r : RaterDatabase.getRaters()){
            if (r != me){
                if (dotProduct(me, r) > 0){
                list.add(new Rating(r.getID(),dotProduct(me, r)));};
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        return list;
    }
    
    private HashMap<Rater, Double> FullSimilarRatersSelection(ArrayList<Rating> FullSimilarRaters, int numSimilarRaters){
        HashMap<Rater, Double> SimilarRaters = new HashMap<Rater, Double>();
        for (int i = 0; i < numSimilarRaters; i++){
            SimilarRaters.put(RaterDatabase.getRater(FullSimilarRaters.get(i).getItem()),FullSimilarRaters.get(i).getValue());
        }
        return SimilarRaters;
    }
    
     // average rating by movie ID with min raters from similar raters
    private double getAverageByIDFromSimilar(String id, ArrayList<Rating> FullSimilarRaters,int numSimilarRaters, int minimalRaters){
        double aveg = 0.0;
        int k = 0;
        HashMap<Rater, Double> SimilarRaters = FullSimilarRatersSelection(FullSimilarRaters, numSimilarRaters);
        
        for (Rater rater : SimilarRaters.keySet()){
            if (rater.getRating(id) >= 0){k++; aveg += rater.getRating(id)*SimilarRaters.get(rater);}
        }
        if (k >= minimalRaters){aveg = aveg/k; return aveg;}
        return 0.0;
    }
    
    public ArrayList<Rating> getSimilarRatings(String id, int numSimilarRaters, int minimalraters){
        ArrayList<Rating> avgMovieRatings = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        // get the list of numSimilarRaters similar raters with positive vallues
        ArrayList<Rating> FullSimilarRaters = getSimilarities(id);
                
        for (String movieID: movies){
            Rating movieRating = new Rating(movieID,getAverageByIDFromSimilar(movieID, FullSimilarRaters,numSimilarRaters, minimalraters));
            if(getAverageByIDFromSimilar(movieID, FullSimilarRaters,numSimilarRaters, minimalraters)> 0){avgMovieRatings.add(movieRating);};
        }
        
        return avgMovieRatings;
    }
    
    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters, int minimalraters, Filter filterCriteria){
        ArrayList<Rating> avgMovieRatings = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        // get the list of numSimilarRaters similar raters with positive vallues
        ArrayList<Rating> FullSimilarRaters = getSimilarities(id);
                
        for (String movieID: movies){
            Rating movieRating = new Rating(movieID,getAverageByIDFromSimilar(movieID, FullSimilarRaters,numSimilarRaters, minimalraters));
            if(getAverageByIDFromSimilar(movieID, FullSimilarRaters,numSimilarRaters, minimalraters)> 0){avgMovieRatings.add(movieRating);};
        }
        
        return avgMovieRatings;
    }
    
}
