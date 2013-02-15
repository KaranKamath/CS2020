//This class calculates cellular coverage in O(nlogn) time
public class CoverageCalculator {
	int m_countTowers;
	Tower[] m_highwayTowers;
	int m_highwayLength;
	CoverageCalculator (int length) {
		m_countTowers = 0;
		m_highwayLength = length;
		if (length < 0)
			System.out.print("Error : Invalid Highway Length");
		else {
			m_highwayTowers = new Tower[length + 1];
			for (int i = 0; i < length+1; i++)
				m_highwayTowers[i] = new Tower (i,0);
		}
	}
	//Adds a tower object
	public void addTower(int location, int range) {
		if (location < 0 || location > m_highwayLength)
			System.out.println ("Error: invalid location");
		else {
			m_highwayTowers[m_countTowers] = new Tower (location,range);
			m_countTowers++;
		}
	}
	//Sorts towers acc to their min coverage location
	Tower[] MergeSort (Tower[] tow, int n) {
		if (n == 1)
			return tow;
		else {
			Tower[] X = new Tower[n/2];
			Tower[] Y = new Tower[n - (n/2)];
			for(int i = 0; i < n/2; i++)
				X[i] = tow[i];
			for(int j = n/2; j < n; j++)
				Y[j - n/2] = tow[j];
			X = MergeSort(X,n/2);
			Y = MergeSort(Y,n - (n/2));
			int i = 0; int j = 0;int k = 0;
			Tower[] Z = new Tower[n];
			while (X.length != i && Y.length != j) {
				if(X[i].compareTo(Y[j]) == -1) {
					Z[k] = X[i];
					k++;
					i++;
				}
				else {
					Z[k] = Y[j];
					j++;
					k++;
				}
			}
			while (i != X.length)
				Z[k++] = X[i++];
			while (j != Y.length)
				Z[k++] = Y[j++];
			return Z;
		}
	}
	public int getCoverage() {
		if (m_countTowers == 0)
			return 0;
		int coverage = 0;
		m_highwayTowers = MergeSort (m_highwayTowers,m_countTowers);
		int pos = 0;
		int curr_min = m_highwayTowers[0].min;
		coverage += m_highwayTowers[0].location - curr_min;
		if ((m_highwayTowers[0].location + m_highwayTowers[0].range) > m_highwayLength) {
			coverage += (m_highwayLength - m_highwayTowers[0].location);
			return coverage;
		}
		coverage += (m_highwayTowers[0].range);
		pos = m_highwayTowers[0].location + m_highwayTowers[0].range;
		for(int i = 1; i < m_countTowers; i++) {
			curr_min = m_highwayTowers[i].min;
			if(curr_min < pos) {
				if((curr_min + ((m_highwayTowers[i].range)*2)) > pos) {
					if (curr_min + ((m_highwayTowers[i].range)*2) > m_highwayLength)
						return coverage += m_highwayLength - pos;
					coverage += curr_min + ((m_highwayTowers[i].range)*2) - pos;
					pos = curr_min + ((m_highwayTowers[i].range)*2);
				}
			}
			else {
				pos = curr_min;
				coverage += m_highwayTowers[i].location - curr_min;
				if ((m_highwayTowers[i].location + m_highwayTowers[i].range) > m_highwayLength)  
					return coverage += (m_highwayLength - m_highwayTowers[i].location);
				coverage += (m_highwayTowers[i].range);
				pos = m_highwayTowers[i].location + m_highwayTowers[i].range;
			}
		}
		return coverage;
	}
	public static void main (String[] args) {
		CoverageCalculator calc = new CoverageCalculator(100);
		calc.addTower(110, 30);
		System.out.println(calc.getCoverage());
		
	}
}
