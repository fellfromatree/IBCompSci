package fileReadWrite;
import java.io.*;

public class fileRead {

	private String[] names;
	private double[] distances;
	private int namesRead;
	
	public fileRead()
	{
		names = new String[20];
		distances = new double[20];
		namesRead = 0;
		
		readIn("/Users/paulcasey/Desktop/members.txt");
		int maxPos = findMax();
		outputs(maxPos);
		write(maxPos);
	}
	
	public void readIn(String path)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String row;
			
			while((row = br.readLine()) !=null)
			{
				String[] data = row.split(",");
				names[namesRead] = data[0]+" "+data[1];
				distances[namesRead] = Double.parseDouble(data[2]);
				namesRead++;
			}
			br.close();
		}
		
		catch (Exception e)
		{
			System.out.println("Oops, something went wrong reading row "+namesRead);
		}
	}
	
	public int findMax()
	{
		int maxPos = 0;
		for(int x=0;x<namesRead;x++)
		{
			if(distances[x]>distances[maxPos])
			{
				maxPos = x;
			}
		}
		return maxPos;
	}
	
	public void outputs(int maxPos)
	{
		double highest = distances[maxPos];
		System.out.println(names[maxPos]+" walked the furthest at "+highest+"km");
		double seventyPercent = highest*.7;
		
		System.out.println("Users who walked more than 70% of this distance include:");
		for(int x=0;x<namesRead;x++)
		{
			if(distances[x]>seventyPercent && x!=maxPos)
			{
				System.out.println(names[x]+" walked "+distances[x]+"km");
			}
		}
		
	}
	
	public void write(int maxPos)
	{
		System.out.println("Writing names to file...");
		try
		{
			FileWriter w = new FileWriter("/Users/paulcasey/Desktop/topWalkers.txt");
			double highest = distances[maxPos];
			
			double seventyPercent = highest*.7;
			
			for(int x=0;x<namesRead;x++)
			{
				if(distances[x]>seventyPercent)
				{
					w.append(names[x]+"\n");
				}
			}
			w.flush();
			w.close();
		}
		catch (Exception e)
		{
			System.out.println("Oops, something went wrong");
		}
		
		System.out.println("Names written.");
	}
	
	public static void main(String[] args)
	{
		fileRead r = new fileRead();
	}
}
