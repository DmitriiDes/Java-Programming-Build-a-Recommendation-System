
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class MovieRunnerWithFilters {
    public void printAverageRatingsByYear(){
        //SecondRatings MoviesRated = new SecondRatings("data/ratedmoviesfull.csv","data/ratings.csv");
        //SecondRatings MoviesRated = new SecondRatings("data/ratedmovies_short.csv","data/ratings_short.csv");
        
        // to load raters
        ThirdRatings MoviesRated = new ThirdRatings("data/ratings.csv");
        //ThirdRatings MoviesRated = new ThirdRatings("data/ratings_short.csv");
        
        // to oad movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        
        // to check equality of the size of the HashMap and files readed
        System.out.println("Movie size : " + MovieDatabase.size());
        System.out.println("Rater size: "+ MoviesRated.getRaterSize());
        
        //System.out.println("title: "+ MoviesRated.getTitle("68646"));
        //System.out.println("avg by ID: "+ MoviesRated.getAverageByID("68646",10));
        
        // to get avg ratings for the movies rated by "n" tarets: MoviesRated.getAverageRatings(n);
        ArrayList<Rating> avgMovieRatings = MoviesRated.getAverageRatingsByFilter(20,new YearAfterFilter(2000));
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with avg rating: "+avgMovieRatings.size());
        
        //HashMap<String, Double> avgMovieRatings = MoviesRated.getAverageRatings(12);
        
        // to sort movies by ratings ascending
        Collections.sort(avgMovieRatings);
        
        // to print rating and title of each movie in the list
        for (Rating movie:avgMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));}        
        }
        
        //for (String movie:avgMovieRatings.keySet()){
        //    if (avgMovieRatings.get(Movie)>0){
        //        System.out.println(avgMovieRatings.get(Movie)+": "+ MoviesRated.getTitle(movie.getItem()));}        
        //}
        
        
    }
    
    public void printAverageRatings(){
        // to load raters
        ThirdRatings MoviesRated = new ThirdRatings("data/ratings.csv");
        //ThirdRatings MoviesRated = new ThirdRatings("data/ratings_short.csv");
        
        // to oad movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        
        // to check equality of the size of the HashMap and files readed
        System.out.println("Movie size : " + MovieDatabase.size());
        System.out.println("Rater size: "+ MoviesRated.getRaterSize());
        
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
    
    public void printAverageRatingsbyGenre(){
        // to load raters
        ThirdRatings MoviesRated = new ThirdRatings("data/ratings.csv");
        //ThirdRatings MoviesRated = new ThirdRatings("data/ratings_short.csv");
        
        // to oad movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        
        // to check equality of the size of the HashMap and files readed
        System.out.println("Movie size : " + MovieDatabase.size());
        System.out.println("Rater size: "+ MoviesRated.getRaterSize());
        
        // to get avg ratings for the movies rated by "n" tarets: MoviesRated.getAverageRatings(n);
        ArrayList<Rating> avgMovieRatings = MoviesRated.getAverageRatingsByFilter(20,new GenreFilter("Comedy"));
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with avg rating: "+avgMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(avgMovieRatings);
        
        // to print rating and title of each movie in the list
        for (Rating movie:avgMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));
                System.out.println("Genres: "+ MovieDatabase.getGenres(movie.getItem()));
            }        
        }
        
    }
    
    public void printAverageRatingsbyMin(){
        // to load raters
        ThirdRatings MoviesRated = new ThirdRatings("data/ratings.csv");
        //ThirdRatings MoviesRated = new ThirdRatings("data/ratings_short.csv");
        
        // to oad movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        
        // to check equality of the size of the HashMap and files readed
        System.out.println("Movie size : " + MovieDatabase.size());
        System.out.println("Rater size: "+ MoviesRated.getRaterSize());
        
        // to get avg ratings for the movies rated by "n" tarets: MoviesRated.getAverageRatings(n);
        ArrayList<Rating> avgMovieRatings = MoviesRated.getAverageRatingsByFilter(5,new MinutesFilter(105,135));
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with avg rating: "+avgMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(avgMovieRatings);
        
        // to print rating and title of each movie in the list
        for (Rating movie:avgMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));
                System.out.println("Time: "+ MovieDatabase.getMinutes(movie.getItem()));
            }        
        }
        
    }
    
    public void printAverageRatingsbyDirector(){
        // to load raters
        ThirdRatings MoviesRated = new ThirdRatings("data/ratings.csv");
        //ThirdRatings MoviesRated = new ThirdRatings("data/ratings_short.csv");
        
        // to oad movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        
        // to check equality of the size of the HashMap and files readed
        System.out.println("Movie size : " + MovieDatabase.size());
        System.out.println("Rater size: "+ MoviesRated.getRaterSize());
        
        // to get avg ratings for the movies rated by "n" tarets: MoviesRated.getAverageRatings(n);
        ArrayList<Rating> avgMovieRatings = MoviesRated.getAverageRatingsByFilter(4,new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with avg rating: "+avgMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(avgMovieRatings);
        
        // to print rating and title of each movie in the list
        for (Rating movie:avgMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));
                System.out.println("Director: "+ MovieDatabase.getDirector(movie.getItem()));
            }        
        }
        
    }
    
    public void printAverageRatingsbyYearAfterAndGenre(){
        // to load raters
        ThirdRatings MoviesRated = new ThirdRatings("data/ratings.csv");
        //ThirdRatings MoviesRated = new ThirdRatings("data/ratings_short.csv");
        
        // to oad movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        
        // to check equality of the size of the HashMap and files readed
        System.out.println("Movie size : " + MovieDatabase.size());
        System.out.println("Rater size: "+ MoviesRated.getRaterSize());
        
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
    
    public void printAverageRatingsbyDirectorsAndMinutes (){
        // to load raters
        ThirdRatings MoviesRated = new ThirdRatings("data/ratings.csv");
        //ThirdRatings MoviesRated = new ThirdRatings("data/ratings_short.csv");
        
        // to oad movies
        MovieDatabase.initialize("ratedmoviesfull.csv");
        //MovieDatabase.initialize("ratedmovies_short.csv");
        
        // to check equality of the size of the HashMap and files readed
        System.out.println("Movie size : " + MovieDatabase.size());
        System.out.println("Rater size: "+ MoviesRated.getRaterSize());
        
        // to get avg ratings for the movies
        AllFilters YearAfterAndGenre = new AllFilters();
        YearAfterAndGenre.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        YearAfterAndGenre.addFilter(new MinutesFilter(90,180));
        ArrayList<Rating> avgMovieRatings = MoviesRated.getAverageRatingsByFilter(3,YearAfterAndGenre);
        
        // to print how many movies are get avg rating
        System.out.println("The # of movies with avg rating: "+avgMovieRatings.size());
        
        // to sort movies by ratings ascending
        Collections.sort(avgMovieRatings);
        
        // to print rating and title of each movie in the list
        for (Rating movie:avgMovieRatings){
            if (movie.getValue()>0){
                System.out.println(movie.getValue()+": "+ MovieDatabase.getTitle(movie.getItem()));
                System.out.println("Time: "+ MovieDatabase.getMinutes(movie.getItem()));
                System.out.println("Director: "+ MovieDatabase.getDirector(movie.getItem()));
            }        
        }
        
    }
}
