package ejercicio1;

import java.util.Comparator;

public class ComparatorInteger implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
		
//		return o2.intValue() - o1.intValue();
	}

}
