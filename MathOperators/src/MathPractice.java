
public class MathPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathPractice m1 = new MathPractice(9,4);
	}
	
	public MathPractice(double n1, double n2)
	{
		System.out.println(n1+" mod "+ n2+" = "+ n1%n2);
		
		int wN = (int)(n1/n2);
		System.out.println(wN);
		System.out.println(n1/n2);
		double regDiv = n1/n2;
		double remain = (regDiv-wN)*n2;
		System.out.println(n1+" mod "+ n2+" = "+ remain);
	}

}
