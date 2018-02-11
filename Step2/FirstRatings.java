
/**
 * Write a description of FirstRatings here.
 * 
 * @author Dmitrii D 
 * @version 3 Feb 2018
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {
    
    public FirstRatings(){
    }

    public ArrayList<Movie> LoadMovies(String Filename){
        String id;
        String title;
        String year;
        String genres;
        String director;
        String country;
        String poster;
        int minutes;
        Movie MyMovie;
        FileResource fr = new FileResource(Filename);
        ArrayList<Movie> MyMovies = new ArrayList<Movie>();
        CSVParser records = fr.getCSVParser();
                
        for (CSVRecord record : records) {
            id = record.get("id");
            title = record.get("title");
            year = record.get("year");
            genres = record.get("genre");
            director = record.get("director");
            country = record.get("country");
            poster = record.get("poster");
            minutes = Integer.parseInt(record.get("minutes").trim());
            MyMovie = new Movie(id, title, year, genres, director, country, poster, minutes);
            if (!MyMovies.contains(MyMovie)){MyMovies.add(MyMovie);};
        }
        
        return MyMovies;
        }
    
     public ArrayList<Rater> LoadRaters(String Filename){
        Rater MyRater;
        ArrayList<Rating> MyRatings;
        String id;
        FileResource fr = new FileResource(Filename);
        HashMap<String, ArrayList<Rating>> MapRaters = new HashMap<String, ArrayList<Rating>>();
        ArrayList<Rater> MyRaters = new ArrayList<Rater>();
        CSVParser records = fr.getCSVParser();
        for (CSVRecord record : records) {
            id = record.get("rater_id");
            if (!MapRaters.containsKey(id)){
                MapRaters.put(id, new ArrayList<Rating>());
                MyRatings = MapRaters.get(id);
                MyRatings.add(new Rating(record.get("movie_id"),Double.parseDouble(record.get("rating").trim()))); 
                MapRaters.put(id, MyRatings);
            }
            else {
                MyRatings = MapRaters.get(id);
                MyRatings.add(new Rating(record.get("movie_id"),Double.parseDouble(record.get("rating").trim()))); 
                MapRaters.put(id, MyRatings);
            }
        }
        
        for (String s : MapRaters.keySet()){
            MyRater = new Rater(s);
            MyRatings = MapRaters.get(s);
            MyRater.addRatings(MyRatings);
            MyRaters.add(MyRater);
        }
        
        return MyRaters;
        }    
        
        
    public void TestLoadMovies(){
    	String Maname = "";
        ArrayList<Movie> MyMovies = new ArrayList<Movie>();
        //MyMovies = LoadMovies("data/ratedmovies_short.csv");
		MyMovies = LoadMovies("data/ratedmoviesfull.csv");
        System.out.println("# of Movies: " + MyMovies.size());
        int k =0;
        HashMap<String, Integer> MapDirectors = new HashMap<String, Integer>();
        for(Movie movie : MyMovies){
            //    System.out.println(movie.toString());
            //if (movie.getGenres().contains("Comedy")){k++;};
            if (movie.getMinutes() > 150){k++;};
            String[] directors = movie.getDirector().split(",");
            for(int i = 0; i < directors.length; i++){
                if (!MapDirectors.containsKey(directors[i])){MapDirectors.put(directors[i],1);}
                else {MapDirectors.put(directors[i],MapDirectors.get(directors[i])+1);}
            }
        }
        
        System.out.println("# of whatever: " + k);
        k = 0;
		
        for (String s : MapDirectors.keySet()){
			if(MapDirectors.get(s)>k){k = MapDirectors.get(s); Maname = s;}
			//System.out.println(s +" = " + MapDirectors.get(s));
		}
        
		System.out.println("# of max: " + k);
		System.out.println("max name: " + Maname);
    }    
     
	public void TestLoadRaters(){
        ArrayList<Rater> MyRaters = new ArrayList<Rater>();
        //MyRaters = LoadRaters("data/ratings_short.csv");
		MyRaters = LoadRaters("data/ratings.csv");
        System.out.println("# of Raters: " + MyRaters.size());
        String MyId = "193";
		HashMap<String, Integer> MapRatingRater = new HashMap<String , Integer>();
		HashMap<String, Integer> MapRatingMovie = new HashMap<String , Integer>();
		for(Rater rater : MyRaters){
			if (!MapRatingRater.containsKey(rater.getID())){MapRatingRater.put(rater.getID(), rater.numRatings());};
			ArrayList<String> ItemsRated = rater.getItemsRated();
			for(String item : ItemsRated){
				if (!MapRatingMovie.containsKey(item)){MapRatingMovie.put(item,1);}
				else{MapRatingMovie.put(item, MapRatingMovie.get(item)+1);}
			}
		//int k =0;
        //HashMap<String, Integer> MapDirectors = new HashMap<String, Integer>();
		//for(Rater rater : MyRaters){
		//	if (MyId.equals(rater.getID())){
		//		System.out.println("ID: "+ rater.getID() + " # of Ratings: " + rater.numRatings());
		//	}
		//	ArrayList<String> list = rater.getItemsRated();
		//	for(String itemRated : list){
		//		System.out.println("Movie: "+ itemRated + " Rating: "+rater.getRating(itemRated));
		//	}
		}
		System.out.println("# of ratings for 1 movie: " + MapRatingMovie.get("1798709"));
		System.out.println("# of Movies: " + MapRatingMovie.size());
		System.out.println("# of Movies rated by " + MyId + "  " + MapRatingRater.get(MyId));
		int k = 0;
		String Maname = "";
        for (String s : MapRatingRater.keySet()){
			if(MapRatingRater.get(s)>k){k = MapRatingRater.get(s); Maname = s;}
			//System.out.println(s +" = " + MapDirectors.get(s));
		}
        
		System.out.println("# of max: " + k);
		System.out.println("max name: " + Maname);
    }
}
