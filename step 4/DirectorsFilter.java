
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class DirectorsFilter implements Filter{
    private String myDirector;
    
    public DirectorsFilter(String Director) {
        myDirector = Director;
    }
    
    @Override
    public boolean satisfies(String id) {
        List<String> DirectorsList = Arrays.asList(myDirector.split(","));
        boolean k = false;
        for (String DirectorFromTheList : DirectorsList){
            //System.out.println(DirectorFromTheList);
            k = k || MovieDatabase.getDirector(id).contains(DirectorFromTheList);
        }
        return k;
    }
}
