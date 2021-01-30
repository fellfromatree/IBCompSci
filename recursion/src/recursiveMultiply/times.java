package recursiveMultiply;

public class times {

	public static void main(String[] args) {
		int n1 = 6;
		int n2 = 3;
		System.out.println(multiply2(n1,n2));
	}

	public static int multiply2(int num1, int num2) {
	    if (num1 == 0 || num2 == 0) {
	        return 0;
	    }

	    else {
	        return num1 + multiply2(num1, num2 - 1);
	    }

	}
}
