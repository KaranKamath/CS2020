//This class defines the requisite tower properties
public class Tower implements Comparable<Tower> {

	int min;
	int range;
	int location;
	Tower (int l,int r) {
		location = l;
		range = r;
		min = l-r;
		if(min < 0)
			min = 0;
	}
	@Override
	public int compareTo(Tower other) {
		if (this.min > other.min)
			return 1;
		else if (this.min < other.min)
			return -1;
		else
			return 0;
	}
	
}
