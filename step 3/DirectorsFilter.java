
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter{
    private String myDirector;
    
    public DirectorsFilter(String Director) {
        myDirector = Director;
    }
    
    @Override
    public boolean satisfies(String id) {
        return myDirector.contains(MovieDatabase.getDirector(id));
    }
}
