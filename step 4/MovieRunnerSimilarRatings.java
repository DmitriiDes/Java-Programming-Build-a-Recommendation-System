
/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class MovieRunnerSimilarRatings {
    public void printAverageRatings(){
        // to load raters
        FourthRatings MoviesRated = new FourthRatings("ratings.csv");
        //FourthRatings MoviesRated = new FourthRatings("data/ratings_short.csv");
        
        // to oad movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        
        // to check equality of the size of the HashMap and files readed
        //System.out.println("Movie size : " + MovieDatabase.size());
        //System.out.println("Rater size: "+ MoviesRated.getRaterSize());
        
        // to get avg ratings for the movies rated by "n" tarets: MoviesRated.getAverageRatings(n);
        ArrayList<Rating> avgMovieRatings = MoviesRated.getAverageRatings(35);
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with avg rating: "+avgMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(avgMovieRatings);
        
        // to print rating and title of each movie in the list
        for (Rating movie:avgMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));}        
        }
        
    }
    
    public void printAverageRatingsbyYearAfterAndGenre(){
        // to load raters
        FourthRatings MoviesRated = new FourthRatings("ratings.csv");
        //FourthRatings MoviesRated = new FourthRatings("data/ratings_short.csv");
        
        // to oad movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        
        // to check equality of the size of the HashMap and files readed
        //System.out.println("Movie size : " + MovieDatabase.size());
        //System.out.println("Rater size: "+ MoviesRated.getRaterSize());
        
        // to get avg ratings for the movies
        AllFilters YearAfterAndGenre = new AllFilters();
        YearAfterAndGenre.addFilter(new YearAfterFilter(1990));
        YearAfterAndGenre.addFilter(new GenreFilter("Drama"));
        ArrayList<Rating> avgMovieRatings = MoviesRated.getAverageRatingsByFilter(8,YearAfterAndGenre);
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with avg rating: "+avgMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(avgMovieRatings);
        
        // to print rating and title of each movie in the list
        for (Rating movie:avgMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));
                System.out.println("Year: "+ MovieDatabase.getYear(movie.getItem()));
                System.out.println("Genres: "+ MovieDatabase.getGenres(movie.getItem()));
            }        
        }
        
    }
    
    public void printSimilarRatingsByGenre(){
        // to load raters
        FourthRatings MoviesRated = new FourthRatings("ratings.csv");
        //FourthRatings MoviesRated = new FourthRatings("data/ratings_short.csv");
        
        // to load movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
               
        // to get Similar Ratings for a particular rater ID
        String id = "65"; 
        int numSimilarRaters = 20; 
        int minimalraters = 5;
        
        // to get avg ratings for the movies
        AllFilters Filters = new AllFilters();
        //Filters.addFilter(new YearAfterFilter(1990));
        Filters.addFilter(new GenreFilter("Action"));
        ArrayList<Rating> SimilarMovieRatings = MoviesRated.getSimilarRatingsByFilter(id,numSimilarRaters,minimalraters, Filters);
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with similar rating: "+ SimilarMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(SimilarMovieRatings, Collections.reverseOrder());
        
        // to print rating and title of each movie in the list
        for (Rating movie : SimilarMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));}        
        }
        
    }
    
    public void printSimilarRatings(){
        // to load raters
        FourthRatings MoviesRated = new FourthRatings("ratings.csv");
        //FourthRatings MoviesRated = new FourthRatings("data/ratings_short.csv");
        
        // to load movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
               
        // to get Similar Ratings for a particular rater ID
        String id = "65"; 
        int numSimilarRaters = 20; 
        int minimalraters = 5;
        ArrayList<Rating> SimilarMovieRatings = MoviesRated.getSimilarRatings(id,numSimilarRaters,minimalraters);
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with similar rating: "+ SimilarMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(SimilarMovieRatings, Collections.reverseOrder());
        
        // to print rating and title of each movie in the list
        for (Rating movie : SimilarMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));}        
        }
        
    }
    
    public void printSimilarRatingsByDirector(){
        // to load raters
        FourthRatings MoviesRated = new FourthRatings("ratings.csv");
        //FourthRatings MoviesRated = new FourthRatings("data/ratings_short.csv");
        
        // to load movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
               
        // to get Similar Ratings for a particular rater ID
        String id = "1034"; 
        int numSimilarRaters = 10; 
        int minimalraters = 3;
        
        // to get avg ratings for the movies
        AllFilters Filters = new AllFilters();
        //Filters.addFilter(new YearAfterFilter(1990));
        //Filters.addFilter(new GenreFilter("Action"));
        Filters.addFilter(new DirectorsFilter("Clint Eastwood,Sydney Pollack,David Cronenberg,Oliver Stone"));
        ArrayList<Rating> SimilarMovieRatings = MoviesRated.getSimilarRatingsByFilter(id,numSimilarRaters,minimalraters, Filters);
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with similar rating: "+ SimilarMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(SimilarMovieRatings, Collections.reverseOrder());
        
        // to print rating and title of each movie in the list
        for (Rating movie : SimilarMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));}        
        }
        
    }
    
    public void printSimilarRatingsByGenreAndMinutes(){
        // to load raters
        FourthRatings MoviesRated = new FourthRatings("ratings.csv");
        //FourthRatings MoviesRated = new FourthRatings("data/ratings_short.csv");
        
        // to load movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
               
        // to get Similar Ratings for a particular rater ID
        String id = "65"; 
        int numSimilarRaters = 10; 
        int minimalraters = 5;
        
        // to get avg ratings for the movies
        AllFilters Filters = new AllFilters();
        //Filters.addFilter(new YearAfterFilter(1990));
        Filters.addFilter(new GenreFilter("Adventure"));
        Filters.addFilter(new MinutesFilter(100,200));
        ArrayList<Rating> SimilarMovieRatings = MoviesRated.getSimilarRatingsByFilter(id,numSimilarRaters,minimalraters, Filters);
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with similar rating: "+ SimilarMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(SimilarMovieRatings, Collections.reverseOrder());
        
        // to print rating and title of each movie in the list
        for (Rating movie : SimilarMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));}        
        }
        
    }
    
    public void printSimilarRatingsByYearAfterAndMinutes (){
        // to load raters
        FourthRatings MoviesRated = new FourthRatings("ratings.csv");
        //FourthRatings MoviesRated = new FourthRatings("data/ratings_short.csv");
        
        // to load movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
               
        // to get Similar Ratings for a particular rater ID
        String id = "65"; 
        int numSimilarRaters = 10; 
        int minimalraters = 5;
        
        // to get avg ratings for the movies
        AllFilters Filters = new AllFilters();
        Filters.addFilter(new YearAfterFilter(2000));
        //Filters.addFilter(new GenreFilter("Adventure"));
        Filters.addFilter(new MinutesFilter(80,100));
        ArrayList<Rating> SimilarMovieRatings = MoviesRated.getSimilarRatingsByFilter(id,numSimilarRaters,minimalraters, Filters);
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with similar rating: "+ SimilarMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(SimilarMovieRatings, Collections.reverseOrder());
        
        // to print rating and title of each movie in the list
        for (Rating movie : SimilarMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));}        
        }
        
    }
}
