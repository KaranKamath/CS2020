//Class whose objects enable sorting integer arrays with unique keys for each element
public class sortItems implements Comparable<sortItems> {
	int value;
	static long id = 0;
	long item_id;
	sortItems(int v) {
		value = v;
		item_id = id++;
	}
	@Override
	public int compareTo(sortItems other) {
		if (this.value < other.value)
			return -1;
		else if (this.value > other.value)
			return 1;
		return 0;
	}
}
