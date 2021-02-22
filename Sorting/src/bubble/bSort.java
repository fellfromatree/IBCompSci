package bubble;

public class bSort {

	public static void main(String[] args) {
		bSort s1 = new bSort();

	}
	
	
	public bSort()
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
	}
	
	public int[] sortThis(int[] array)
	{
        int n = array.length;
        int temp = 0;
        int compare=0;
        int swaps=0;
        int x=0;
        boolean ordered = false;
        
        while(x<n && !ordered)
        {
        	ordered=true;
        	for(int y = 0; y<(n-x)-1;y++)
        	{
        		compare++;
        		if(array[y]>array[y+1])
        		{
        			// SWAP
        			temp = array[y];
        			array[y]=array[y+1];
        			array[y+1]=temp;
        			swaps++;
        			ordered=false;
        		}
        	}
        	x++;
        }
        
        System.out.println("Comparisons made "+compare);
        System.out.println("Swaps made "+swaps);
		
		return array;
	}

}
