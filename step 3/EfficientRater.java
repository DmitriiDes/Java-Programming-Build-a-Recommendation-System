
/**
 * Write a description of EfficientRater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class EfficientRater implements Rater{
    private String myID;
    private HashMap<String, Rating> myRatings;

    public EfficientRater(String id) {
        myID = id;
        myRatings = new HashMap<String, Rating>();
    }

    @Override
    public void addRating(String item, double rating) {
        if (!myRatings.containsKey(item)){
            myRatings.put(item, new Rating(item,rating));}
        //myRatings.add(new Rating(item,rating));
    }
    
    //public void addRatings(HashMap<String, Rating> ratings) {
    //    myRatings = ratings;
    //}
    

    @Override
    public boolean hasRating(String item) {
        return myRatings.containsKey(item);
    }

    @Override
    public String getID() {
        return myID;
    }

    @Override
    public double getRating(String item) {
        //Rating mr = myRatings.get(item);
        //if (mr != null){mr.getValue();};
        if (myRatings.containsKey(item)){return myRatings.get(item).getValue();};
        //return myRatings.containsKey(item);
        //for(int k=0; k < myRatings.size(); k++){
        //    if (myRatings.get(k).getItem().equals(item)){
        //        return myRatings.get(k).getValue();
        //    }
        //}
        //for(String k : myRatings.keySet()){
        //    if (k.equals(item)){
        //        return myRatings.get(k).getValue();
        //    }
        //}
        
        
        return -1;
    }

    @Override
    public int numRatings() {
        return myRatings.size();
    }

    @Override
    public ArrayList<String> getItemsRated() {
        ArrayList<String> list = new ArrayList<String>();
        for(String k : myRatings.keySet()){
            list.add(k);
        }
        
        return list;
        //return myRatings.keySet();
    }
    
    //implement later
    public Set<String> getItemsRatedSet() {
        return myRatings.keySet();
    }
}
