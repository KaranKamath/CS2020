public class DocumentDistanceMain 
{

	public static void main(String[] args) 
	{
		VectorTextFile3 A = new VectorTextFile3("lear.txt");
		VectorTextFile3 B = new VectorTextFile3("hamlet.txt");

		double theta = VectorTextFile3.Angle(A,B);

		System.out.println("The angle between A and B is: " + theta + "\n");
	}
}
