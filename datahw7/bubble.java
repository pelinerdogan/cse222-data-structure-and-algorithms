package datahw7;

import java.util.Map;

public class bubble {
	mymap originalmap;
	mymap sortedmap;
	private String[] aux;

	/**
	 * constructor with parameter initilazes originalmap and sortedmap then copies
	 * the tosort map to them .
	 * 
	 * @param tosort
	 */
	public bubble(mymap tosort) {
		originalmap = new mymap();
		sortedmap = new mymap();
		tosort.putAll(originalmap);
		aux = new String[tosort.size()];
		int count = 0;

		for (Map.Entry<String, info> entry : tosort.map.entrySet()) {
			String key = entry.getKey();
			aux[count] = key;
			count++;
		}

	}

	/**
	 * The sort method of class has nested for loops.
	 * Method compares the counts of info objects belong to the key I store in aux
	 * element.
	 * If next elements count value is smaller I swap them. After loops are over
	 * method initializes
	 * sortedmap with mymap constructor that takes string array and original map to
	 * create my map object.
	 * 
	 * 
	 */
	protected void sort() {
		for (int i = 0; i < aux.length; i++) {
			boolean swaphappened = false;
			for (int k = 0; k < aux.length - i - 1; k++) {

				if (originalmap.get(aux[k + 1]).count < originalmap.get(aux[k]).count) {

					String temp = aux[k];
					aux[k] = aux[k + 1];
					aux[k + 1] = temp;
					swaphappened = true;
				}

			}
			if (swaphappened == false)
				break;

		}
		sortedmap = new mymap(aux, originalmap);
	}

}
