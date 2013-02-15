//Class to Test The Sorters Given to Us
import java.util.Random;

public class Test {

	//Uses an object of type sortItems to ensure each item in the integer array has a unique key. 
	//It then creates at least one duplicate and checks the sorted array for stability
	static boolean isStable(ISort sorter, int size) {
		sortItems[] testArray = new sortItems [size];
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			testArray[i] = new sortItems(r.nextInt (size));
			if(r.nextInt(size) % 2 == 0)
				testArray[i].value *= -1;
		}
		int loc = r.nextInt(size);
		int randVal = testArray[loc].value;
		testArray[0].value = randVal;
		testArray[size-1].value = randVal;

		System.out.println();
		sorter.sort(testArray);
		for (int i = 0; i < size-1; i++)
			if (testArray[i].value == testArray[i+1].value && testArray[i].item_id > testArray[i+1].item_id)
				return false;
		return true;
	}
	//Checks whether the sorted array is actually sorted
	static boolean isSorted (ISort sorter, int size) {
		sortItems[] testArray = new sortItems [size];
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			testArray[i] = new sortItems(r.nextInt (size));
			if(r.nextInt(size) % 2 == 0)
				testArray[i].value *= -1;
		}
		System.out.println();
		for(int j = 0; j < 5; j++) {
			sorter.sort(testArray);

			System.out.println();

			for(int i = 1; i < size; i++)
				if(testArray[i].value < testArray[i-1].value)
					return false;
		}
		return true;
	}
	public static void main(String[] args) {
		StopWatch watch = new StopWatch();
		ISort sorterA = new SorterE();
		int size = 100;

		watch.start();

		System.out.println("Stable: " + isStable(sorterA,size));
		watch.stop();
		System.out.println("Time: " + watch.getTime());
		watch.start();
		System.out.println("Sorted: " + isSorted(sorterA,size));
		System.out.println("Time: " + watch.getTime() + "\nSize: " + size);
	}
}
