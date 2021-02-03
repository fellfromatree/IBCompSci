package bubble;

public class bSort {

	public static void main(String[] args) {
		bSort s1 = new bSort();

	}
	
	
	public bSort()
	{
		int[] arrayNums = {66, 13, 7, 67, 24, 113, 6, 89, 27, 38};
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
	}
	
	public int[] sortThis(int[] array)
	{
        int n = array.length;
        int temp = 0;
        
        for (int x = 0; x<n; x++)
        {
        	for(int y = 0; y<(n-x)-1;y++)
        	{
        		if(array[y]>array[y+1])
        		{
        			// SWAP
        			temp = array[y];
        			array[y]=array[y+1];
        			array[y+1]=temp;
        		}
        	}
        }
		
		return array;
	}

}
