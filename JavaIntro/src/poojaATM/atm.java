package poojaATM;

import java.util.Scanner;
import java.text.DecimalFormat;

public class atm
{
    private int x; // amount to withdraw
    private double y; // current balance
    private double fee; // atm withdrawal fee

    
    public static void main(String[] args)
    {
    	atm a1 = new atm();
    
    }
    
    
    public atm()
    {
       fee = 0.5;
       x = withdrawAmount();
       boolean valid = false;
       valid = isValidAmount(x);
       y = currentBalance();
       
       if(!valid)
       {
           System.out.println(y);
       }
       else
       {
           System.out.println(newBalance(x,y,fee));
       }
    }

    private double newBalance(int withdraw, double balance, double fee)
    {
        double temp = withdraw+fee;
        
        if(balance>temp)
        {
            return balance-temp;
        }
        else
        {
            return balance;
        }
    }
    
    private int withdrawAmount()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter the amount you wish to withdraw");
        String t = kb.nextLine();
        int n=0;
        try
        {
            Integer.parseInt(t);
            n = Integer.parseInt(t);
        }
        catch (NumberFormatException e)
        {
            System.out.println("You have not entered a whole number");
        }
        
        while(n<=0 || n>2000)
        {
            System.out.println("You must enter a number between 0 and 2000");
            System.out.println("Please enter the amount you wish to withdraw");
            t = kb.nextLine();
        
            try
            {
                Integer.parseInt(t);
                n = Integer.parseInt(t);
            }
            catch (NumberFormatException e)
            {
                System.out.println("You have not entered a whole number");
            }
        }
        
        return n;
    }
    
    
    
    private boolean isValidAmount(int n)
    {
        if(n%5 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    private double currentBalance()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter your current balance");
        String t = kb.nextLine();
        double n=0;
        try
        {
            Double.parseDouble(t);
            n = Double.parseDouble(t);
        }
        catch (NumberFormatException e)
        {
            System.out.println("You have not entered a decimal number");
        }
        
        while(n<=0 || n>2000)
        {
            System.out.println("You must enter a number between 0 and 2000");
            System.out.println("Please enter the amount you wish to withdraw");
            t = kb.nextLine();
        
            try
            {
                Double.parseDouble(t);
                n = Double.parseDouble(t);
            }
            catch (NumberFormatException e)
            {
                System.out.println("You have not entered a decimal number");
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");      
        n = Double.valueOf(df.format(n));
        return n;
    }
    
    
    
    private double currentBalancev2()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter your current balance");
        String t = kb.nextLine();
        double n=0;
        try
        {
            Double.parseDouble(t);
            n = Double.parseDouble(t);
        }
        catch (NumberFormatException e)
        {
            System.out.println("You have not entered a decimal number");
        }
        
        while(n<=0 || n>2000)
        {
            System.out.println("You must enter a number between 0 and 2000");
            System.out.println("Please enter the amount you wish to withdraw");
            t = kb.nextLine();
        
            try
            {
                Double.parseDouble(t);
                n = Double.parseDouble(t);
            }
            catch (NumberFormatException e)
            {
                System.out.println("You have not entered a decimal number");
            }
        }
        n = Math.round(n*100);
        n = n/100;
        return n;
    }
}

