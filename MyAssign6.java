//Ammanuel Gebreegziabher

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class MyAssign6{
   public static void main(String[] args)throws IOException{
      // Setting up the scanner for getting user data
      Scanner keyboard = new Scanner(System.in);
      
      // Setting up variables
      final double INCOME_RATE = .09, SS_RATE = .0875;
      String [] fName = new String[20];
      String [] lName = new String[20];
      double [] grossPay = new double[20];
      double [] payRate = new double[20];
      double [] hoursWorked = new double[20];
      double incomeTax, ssTax, netPay;
      int numEmp = 0;
      String fileName;

      // Get the file name from the user      
      System.out.println("Please enter the name of the input file?");
      fileName = keyboard.next();
      
     
     try{
       // Set up the file to be read from
      File input = new File(fileName);
      Scanner employeeInfo = new Scanner(input);

       // Get the number of employees from the user
      System.out.println("How many employees do you have to enter?");
      numEmp = keyboard.nextInt();
      // Reading in all the data from the file
      for(int i = 0; i < numEmp; i++){
         fName[i] = employeeInfo.next();
         lName[i] = employeeInfo.next();
         payRate[i] = employeeInfo.nextDouble();
         hoursWorked[i] = employeeInfo.nextDouble();

        // Calling the getGrossPay method to get all the gross pay calculated at once
      getGrossPay(payRate, hoursWorked, grossPay);
      }     
       
      //  Scanner in = new Scanner(new File(fileName)); 
     } 
       // FileNotFound Exception!
     catch(FileNotFoundException e){
       System.out.println("The file name you entered does not exist.\nRestart the program and enter the correct file name.");
     }
       
       //Wrong input type
     catch(InputMismatchException e){
       numEmp = 0;
       System.out.println("The input is not the correct type.\nRestart the program and enter a number.");
       
       //Array Out of bounds exception
    } catch(ArrayIndexOutOfBoundsException e){
       System.out.println("The array is out of bounds.\nRestart the program and endter a number between 1 - 19.");
       while(true){
         return;
       }
    }
        
      
      // Do some last calculations and then output
      for(int n = 0; n < numEmp; n++){
      
         incomeTax = calcTax(grossPay[n], INCOME_RATE);
         ssTax = calcTax(grossPay[n], SS_RATE);
                  
         netPay = grossPay[n] - incomeTax - ssTax;
         
         System.out.println("Employee " + (n+1) + ": " + lName[n] + ", " + 
fName[n]);
         System.out.println("*******************************");
         System.out.printf("Gross Pay: $%.2f\n", grossPay[n]);
         System.out.println("Taxes: ");
         System.out.printf("       Income Tax: $%.2f\n", incomeTax);
         System.out.printf("       SS Tax: $%.2f\n", ssTax);
         System.out.println("*******************************");
         System.out.printf("Net Pay: $%.2f\n\n\n", netPay);
      }
   }
   
   //Method that calculates the gross pay for a single employee
   public static void getGrossPay(double [] rate, double [] hours, double [] 
theGrossPay){
      
      int n = 0;
      
      while(rate[n] != 0){
         theGrossPay[n] = rate[n] * hours[n];
         
         n++;
      }
   }//end getGrossPay method
   
   //Method that will calculate any given tax
   public static double calcTax(double amount, double rate){
      double answer;
      
      answer = amount * rate;
      
   return answer;   
   }//end calcTax method
   
}//end of class
