
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter{
    private int minMin;
    private int maxMin;
	
	public MinutesFilter(int minM, int maxM) {
		minMin = minM;
		maxMin = maxM;
	}
	
	@Override
	public boolean satisfies(String id) {
		return ((MovieDatabase.getMinutes(id) >= minMin) && (MovieDatabase.getMinutes(id) <= maxMin));
	}
}
