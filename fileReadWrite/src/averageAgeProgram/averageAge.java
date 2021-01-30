package averageAgeProgram;

// Import Java IO which allows for file read & write
import java.io.*;

public class averageAge {

	//Declare parallel arrays for data from the file, along with a counter to track 
	// how many successful rows have been read
	public String[] names;
	public int[] ages;
	public int namesRead;
	
	public static void main(String[] args) {
		// 
		averageAge a = new averageAge();
	}
	
	public averageAge()
	{
		// Initialise arrays with 10 positions (I know the file size in advance, could be done with an arraylist)
		names = new String[10];
		ages = new int[10];
		namesRead = 0;
		
		// Call the method to read the file in from disk
		readIn();
		
		// Call the calcAverage method to display the average age of the file
		System.out.println("Average age of the class is "+calcAverage());
		
		System.out.println("Full list of names:");
		for(int x=0; x<names.length;x++)
		{
			System.out.println("Person "+(x+1)+"  "+ names[x]);
		}
		System.out.println("Finished");
		// Call the writeAverages method, which creates a new file with the average age
		// and the names of those older than average.
		writeAverages();
		
	}
	
	public void readIn()
	{
		// Hard-coded path to the CSV file we're working with
		// This can be replaced with a file chooser later on.
		String pathToFile = "/Users/paulcasey/Desktop/names.csv";

		
		// Try Catch used to deal with file read errors
		try 
		{
			
			// Create a buffered reader, which allows us to read the file line by line
			BufferedReader csvReader = new BufferedReader(new FileReader(pathToFile));
			
			// Local variable to hold the full line (including commas)
			String row;
			
			// While there's more data in the file, read a line in
			while ((row = csvReader.readLine()) != null) {
				
				// Split the file around the 'delimiter' in this case a comma
			    String[] data = row.split(",");
			    
			    // Add the data from the line into the array
			    // This can be done with a while loop to deal with varying lengths of line
			    names[namesRead] = data[0];
			    ages[namesRead] = Integer.parseInt(data[1]);
			    
			    // After a line has been successfully read, increment the counter.
			    // With a try/catch, this will only run if the line read is successful
			    namesRead++;
			}
			
			// Close the file after it's been read to prevent possible corruption
			csvReader.close();
			
		} 
		
		// Catch errors in the file open/read process.
		catch (IOException e) 
		{
			// Display the error in the console.
			e.printStackTrace();
		}
		
	}
	
	// Method to output the average age of the names to a file.
	// Will also output the names of those older than average
	public void writeAverages()
	{
		// Local variable to hold the average of the names
		double avg = calcAverage();
		
		// Try Catch used to deal with file read errors
		try {
			// Create the new file
			FileWriter csvWriter = new FileWriter("/Users/paulcasey/Desktop/namesOUT.csv");
			
			// Add the average age to the file (along with the New Line character \n
			csvWriter.append("The average age is "+avg+"\n");
			csvWriter.append("The following people are older than average"+"\n");
			
			// Loop through ages array and compare it to the average age
			for(int x=0;x<namesRead;x++)
			{
				// If it's larger (but not inclusive)
				if(ages[x]>avg)
				{
					// Add the users names to the file
					csvWriter.append(names[x]+"\n");
				}
			}
			
			
			// Cleanup the output and close the file (technically works without flush, but more efficient)
			csvWriter.flush();
			csvWriter.close();
			
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}
	
	}
	
	// Method to loop through the ages array and calculate the average of all numbers.
	// The average will be returned to the calling method rather than displayed here.
	public double calcAverage()
	{
		double average = 0;
		for(int x=0;x<namesRead;x++)
		{
			average = average + ages[x];
		}
		average = average/namesRead;

		return average;
	}
	

}
