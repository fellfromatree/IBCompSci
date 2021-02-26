package selection;

public class sSort {

	public static void main(String[] args)
	{
		sSort s1 = new sSort();
	
	}
	
	public sSort()
	{
		int[] arrayNums = {66, 13, 7, 67, 24, 113, 6, 89, 27, 38};
		//int[] arrayNums = {6,7,13,24,27,38,66,67,89,113};
		printArray(arrayNums);
		arrayNums = sortThis(arrayNums);
		
		printArray(arrayNums);
	}
	
	
	public void printArray(int[] array)
	{
		System.out.println("Current array state:");
		for(int x = 0; x< array.length; x++)
		{
			System.out.print(array[x] + ", ");
		}
		System.out.print("\n");
		//sdfgsdfg
		
	}
	
	
	
	public int[] sortThis(int[] array)
	{
        int n = array.length;
        int temp = 0;
        int minPos = 0;
        
        // Loop from 0 to n-2
        
        // Set minPos = first item
        
        // Loop from x + 1 to n-1
        
        // If current item < min item
        
        // minPos = current position
        
        // End if
        
        // End loop
        
        // Swap
        
        // End loop
        

		
		return array;
	}
	
}
