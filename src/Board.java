import java.util.HashMap;


public class Board {
	
	private HashMap<Integer, Integer> borderPosition = new HashMap<Integer,Integer>();
	
	public Board() {
		borderPosition.put(39, 5);
	}

	public int next(PlaceHolder placeHolder, int passes) {
		if (borderPosition.containsKey(placeHolder.position()))
			return (Integer) borderPosition.get(placeHolder.position());
		return placeHolder.position() + passes;
	}

}
