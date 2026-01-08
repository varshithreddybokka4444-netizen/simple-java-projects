package src.com.axisbank.app;
import java.util.Scanner;

import src.com.axisbank.account.*;
class ATMSystem {
    public static void main(String[] args) {
        
   
BankAccount acc1 = new BankAccount("Varshith", 1234567, 10000, 501301);
BankAccount acc2 = new BankAccount("Nageshwari", 2345678, 20000, 111111);
BankAccount acc3 = new BankAccount("Sai Charan", 3456789, 30000, 321212);
BankAccount acc4 = new BankAccount("Ananya", 4567890, 100000,222222);
BankAccount[] accountbook = {acc1,acc2,acc3,acc4};
boolean exit = false;
Scanner ob = new Scanner(System.in);
while(!exit){
    System.out.println("--Bank Menu--");
    System.out.println("1.Deposit:");
    System.out.println("2.Withdraw:");
    System.out.println("3.Print Balance:");
    System.out.println("4.Exit:");
     System.out.println("Enter your choice");
     int x = ob.nextInt();
     switch (x)
{
      case 1 :
      System.out.println("Please enter account number : ")  ;
      long accnum = ob.nextLong() ;
        System.out.println("Enter the security pin");
        int pin = ob.nextInt();
      System.out.println("Enter amount to be deposted");
        double amount = ob.nextDouble();
      boolean founddep = false;
           
            for(BankAccount n : accountbook){
                
                if(n.getAccountnumber()==accnum){
                    n.deposit(pin,amount);
                   founddep = true;
                }
            }
               if(!founddep){
                System.out.println("Please enter valid details");
                
            }
            break;
            case 2:
             System.out.println("Please enter account number : ")  ;
      long accnumw = ob.nextLong() ;
        System.out.println("Enter the security pin");
        int pinw = ob.nextInt();
      System.out.println("Enter amount to be Withdrawn");
        double amountw = ob.nextDouble();
      boolean foundwit = false;
            //Iterable<BankAccount> accounts;
            for(BankAccount n : accountbook){
                if(n.getAccountnumber()==accnumw){
                    n.withdraw(pinw,amountw);
                    foundwit = true;
                    break;
                }
            }
                if(!foundwit){
                System.out.println("Please enter valid details");
               }  
                   
            break;
             case 3:
             System.out.println("Please enter account number : ")  ;
      long accnump = ob.nextLong() ;
        System.out.println("Enter the security pin");
        int pinp = ob.nextInt();
        boolean found = false;
            for(BankAccount n : accountbook){
                if(n.getAccountnumber()==accnump){
                    n.printbalance(pinp);
                    found = true;
                    break;
                }
            }
                if(!found){
                System.out.println("Please enter valid details");
                
            }
               break;
               case 4:
               exit = true;
               break;
               default : 
               System.out.println("Print enter valid choice....");
            }
}

}
    
}




































































