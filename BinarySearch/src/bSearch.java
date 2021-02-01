import java.util.Scanner;

public class bSearch 
{
	
	public bSearch(int target)
	{
		// Initialize data structures & Variables
		int[] arrayNums = {1, 212, 16, 67, 42, 53, 23, 14, 93, 537};
		
		// Set high and low pointers and found position
		int low = 0;
		int high = arrayNums.length-1;
		int foundAt = -1; // pointer to the location of the found item
		
		// While the item hasn't been found and low is <= high
		while(foundAt==-1 && low<=high)
		{
		// Calculate the midpoint
			int mid = (low+high)/2;
		
			// If midpoint is the search item
			if(arrayNums[mid]==target)
			{
				// Update found position
				foundAt = mid;
			}
			// If search item > midpoint
			else if(target>arrayNums[mid])
			{
				// Update low
				low = mid+1;
			}
			// Otherwise
			else
			{
				// Update high	
				high = mid-1;
			}
		}
		
		
		// If foundAt is >=0
		if( foundAt>=0)
		{
		// Print found position
			System.out.println("Found item at position "+foundAt);
		// Otherwise
		}
		else
		{
		// Print error message
			System.out.println("Item doesn't exist in the list");
		}
	}
	
	public static void main(String[] args)
	{
		// Input target number
		int t = 0;
		Scanner kb = new Scanner(System.in);
		t = kb.nextInt();
		// Create new instance of bSearch
		bSearch b1 = new bSearch(t);
		
		
	}

}
