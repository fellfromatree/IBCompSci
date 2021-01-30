package winterhw;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class walkingClub {
	String[] names;
	double[] distance;
	int namesRead; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		walkingClub w1 = new walkingClub();


	}

	public walkingClub()
	{
		names = new String[20];
		distance = new double[20];
		namesRead = 0;


		//System.out.println("The person who walked the furthest distance is "+names);
		//System.out.println("Members who have walked more than 70% of the furthest distance are "+distance);
		//System.out.println("Writing");
		readFile();
		int i = findLongestDistance(); 

		writeFile(i);
		//createFile(); 

	}

	//FILE READ 

	//hardcoded path to the text file (members) --> can be replaced with a file chooser
	public  void readFile()  {
		try {


			String pathToFile = "/Users/paulcasey/Desktop/members.txt"; 

			FileReader f1 = new FileReader(pathToFile);
			Scanner txtReader = new Scanner(f1); 


			//local variable to hold the full line (including commas) 
			String row; 

			//while there's more data in file = read a line in 
			//read file (nextLine)
			while((row = txtReader.next())!= null) {
				//split file around the 'delimiter' (a comma in this case) 
				String[] data = row.split(",");
				//add data from line into array 
				//can be done with while loop to deal with varying lengths of line 
				names[namesRead] = data[0]+" "+data[1]; 
				distance[namesRead] = Double.parseDouble(data[2]);  //changed int to double

				//after a line has been read successfully = increment counter 
				//with a try/catch = this will only run if line read is successful 
				namesRead++; 

			}

			//close file after it's been read to prevent  possible corruption 
			txtReader.close();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}

	//findMax code 
	public int findLongestDistance() {
		int longestDistance = 0; 
		// removed x as it wasn't needed
		
		for(int i=1; i<namesRead;i++) {
			
			// changed x to i in this section
			
			if(distance[i] > distance[longestDistance]) {
				longestDistance = i;
			}
		}
		System.out.println("longest pos = "+longestDistance);
		return longestDistance;  
	}

	//FILE WRITE 

	//method will output the members who walked the farthest distance 
	//will also output members who have walked more than 70% 
	public void writeFile(int i) {

		//local variable to hold 
		double d = distance[i]; 
		double d70 = d*0.7; 

		//try catch used to deal with file read errors 
		try {

			//create new file 
			FileWriter txtWriter = new FileWriter("/Users/paulcasey/Desktop/namesOUT.txt"); 

			//add farthest distance walked to the file (+ New line character \n)
			txtWriter.append("The member who have walked the furthest distance is "+names[i]+"\n"); 
			txtWriter.append("The following people who have walked more than 70% of the furthest distance"+"\n");

			for(int x=0;x<namesRead;x++) {
				if(distance[x]>d70) {  // changed the logical operator
					txtWriter.append(names[x]+"\n"); 
				}
			}

			//cleanup output + close file 
			txtWriter.flush();
			txtWriter.close(); 

		}
		catch (IOException e) {
			e.printStackTrace(); 
			System.out.println("Whoops");
		}
	}
	//creating the file towards the end to put everything in 
	public void createFile() {
		String awards; 
		try {
			File awards1 = new File("awards.txt"); 
			if(awards1.createNewFile()) {
				System.out.println("File created: "+awards1.getName()); 
			}
			else {
				System.out.println("Filed already exists"); 
			}
		}
		catch(IOException e) {
			System.out.println("An error occured."); 
			e.printStackTrace(); 
		}
	}
}
