package colections.exercises;

import java.util.Iterator;
import java.util.List;

/**
 * Lets make our own iterable collection. We want to be able to write a
 * "foreach" on our collection. Solution?
 * 
 * @author George Trandafir
 * 
 */
public class Ex3 {



	public static void main(String[] args) {
		Town<String> myTown = new Town<String>();

		for (Town town : myTown) {

		}
	}
}


class Town<T> implements Iterable<Town>{
	private T type;

    @Override
    public Iterator<Town> iterator() {
        return null;
    }
}