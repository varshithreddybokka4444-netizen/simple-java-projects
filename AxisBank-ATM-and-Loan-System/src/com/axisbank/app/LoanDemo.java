package com.axisbank.app;

import java.util.Scanner;
import com.axisbank.loan.LoanSystem;

public class LoanDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoanSystem ob = new LoanSystem();
        boolean exit = false; 
        while(!exit){
            System.out.println("--Loans--");
            System.out.println("1.Personal Loan");
              System.out.println("2.Custom Personal Loan"); 
               System.out.println("3.Home Loan");
                 System.out.println("4.Car Loan"); 
                   System.out.println("5.Education Loan"); 
                   System.out.println("6.Exit");
               System.out.println("Enter an option");
               int x = sc.nextInt();
                   switch(x){
                    case 1 : 
                          System.out.println("Enter loan amount");
                         double a= sc.nextDouble();
                         System.out.println("Enter Repayment period");
                         int y = sc.nextInt();
                                 ob.applyloan(a,y);     
                                 break; 
                    case 2 : 
                     System.out.println("Enter loan amount");
                         double am= sc.nextDouble();
                         System.out.println("Enter Repayment period");
                         int ye = sc.nextInt();
                          System.out.println("Enter Custom Intrest rate");
                          float i = sc.nextFloat();
                                 ob.applyloan(am,ye,i);    
                                 break;  
                    case 3:
                     System.out.println("Enter loan amount");
                         double amt1= sc.nextDouble();
                         System.out.println("Enter Repayment period");
                         int years1 = sc.nextInt();
                          System.out.println("Enter Custom Intrest rate");
                          ob.applyloan("Home Loan",amt1,years1);
                          break;  
                           case 4:
                     System.out.println("Enter loan amount");
                         double amt2= sc.nextDouble();
                         System.out.println("Enter Repayment period");
                         int years2 = sc.nextInt();
                          System.out.println("Enter Custom Intrest rate");
                          ob.applyloan("Car Loan",amt2,years2);
                          break;  
                           case 5 :
                     System.out.println("Enter loan amount");
                         double amt3= sc.nextDouble();
                         System.out.println("Enter Repayment period");
                         int years3 = sc.nextInt();
                          System.out.println("Enter Custom Intrest rate");
                          ob.applyloan("Education Loan",amt3,years3);
                          break;  
                    case 6:
                    exit = true;
                    default :
                    System.out.println("Please enter a valid option");


                   }
                }
            }
        }
             
          

