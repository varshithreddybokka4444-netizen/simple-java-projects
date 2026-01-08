package com.axisbank.account;
public class BankAccount{
   private String name ;
    private  long accountnumber;
    private double balance;
   private int pin;


      public BankAccount(String AccountHolder,long accountnumber,double balance,int pin){
        name = AccountHolder;
        this.accountnumber = accountnumber;
        this.balance = balance;
        this.pin = pin;

    }

    public void deposit(int enteredpin,double amount){
       if(enteredpin==pin){
balance += amount;
System.out.println("Deposit successfull! Current balance : Rupees "+balance);
       }
       else{
System.out.println("Incorrect pin. Deposit failed.");
       }
       
    }
    public void withdraw(int enteredpin,double amount){
      if(enteredpin==pin&&balance-amount>=500){
balance -= amount;
System.out.println(amount+" withdrawn");
       }
    }
    public void printbalance(int enteredpin){
       if(enteredpin==pin){
        System.out.println("Your current balance is : Rupees " + balance);
       }
      }
       public long getAccountnumber()
       {
         return accountnumber;
       }
         public double getBalance(){
         return balance;
       }

    }
