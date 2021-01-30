package javaIOPractice;

import java.util.Random;
import java.util.Scanner;

public class sweets {
	public static void main(String[] args)
	{
		int questions = 6;
		int max=21;
		int correct = 0;
		int current = 0;
		int newRandom = 0;
		boolean keepPlaying = true;
		
		System.out.println("Welcome to Casey's got the cake");
		System.out.println("The aim of the game is simple, guess Higher or Lower");
		System.out.println("Get it right "+questions+" times to win!\n\n");

		Random r = new Random();
		current = r.nextInt(max)+1;
		
		
		while(keepPlaying && correct<questions)
		{
			newRandom = r.nextInt(max)+1;
			System.out.println("The current number is "+current);
			System.out.println("Higher or Lower");
			Scanner s = new Scanner(System.in);
			String guess = s.nextLine().toLowerCase();
			
			
			if(guess.equals("higher") && newRandom>current)
			{
				keepPlaying= true;
			}
			else if(guess.equals("lower") && newRandom<current)
			{
				keepPlaying= true;
			}
			else
			{
				keepPlaying= false;
			}

			
			if (keepPlaying) 
			{ 
				correct++;
				System.out.println("Well done, only "+(questions-correct)+" to go!\n");
				current=newRandom;
			}
		}
		
		if(correct==questions)
		{
			System.out.println("Congrats, you get Casey's sweets");
		}
		else
		{
			System.out.println("Better Luck Next Time");
			System.out.println("The correct next number was "+newRandom);
		}
	}
}
