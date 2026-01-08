package src.com.axisbank.loan;

public class LoanSystem {
       public void applyloan(double amount,int years){

        double rate = 10;
double emi = (amount+(amount*rate*(years/100.0)))/(years*12);
System.out.println("Loan type : Personal Loan");
System.out.println("Loan Amount : " + amount);
System.out.println("Duration of loan repayment : "+years+" Years");
System.out.println("Intrest Rate Applied : "+rate+"%");
System.out.println("EMI : "+emi);
    } 
      public void  applyloan(double amount,int years,double interestRate){
       double emi = (amount+(amount*interestRate*(years/100.0)))/(years*12); 
System.out.println("Loan type : Custom Personal Loan");
System.out.println("Loan Amount : " + amount);
System.out.println("Duration of loan repayment : "+years+" Years");
System.out.println("Intrest Rate Applied : "+interestRate+"%");
System.out.println("EMI : "+emi);
    }
       public void applyloan(String type,double amount,int years){
String[] types = {"Home","Car","Education"};
double interestRate=0;
    if(type.equals("Home")){
interestRate = 9;
    }
    else if(type.equals("Car")){
        interestRate = 15;
    }
    else if(type.equals("Education")){
        interestRate = 7;
    }
    else{
        System.out.println("Please type a Valid option");
    }
    double emi = (amount+(amount*interestRate*(years/100.0)))/(years*12); 
System.out.println("Loan type :"+type+" Custom Loan");
System.out.println("Loan Amount : " + amount);
System.out.println("Duration of loan repayment : "+years+" Years");
System.out.println("Intrest Rate Applied : "+interestRate+"%");
System.out.println("EMI : "+emi);
}  

}
