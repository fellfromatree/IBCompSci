package towers;

public class towersOfHanoi {

	public static void main(String[] args) {
		int n = 200; 
        hanoi(n, 'A', 'C', 'B'); 

	}

	
	public static void hanoi(int n, char from_rod, char to_rod, char spare_rod) 
    { 
        if (n == 1) 
        { 
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod); 
            return; 
        } 
        
        hanoi(n-1, from_rod, spare_rod, to_rod); 
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod); 
        hanoi(n-1, spare_rod, to_rod, from_rod); 
    } 
}
