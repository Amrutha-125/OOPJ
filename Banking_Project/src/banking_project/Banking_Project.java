/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_project;

/**
 *
 * @author amrut
 */
import java.util.Scanner;
class Customer{
    String cust_id;
    
}
class Account extends Customer{
    String acc_no;
    String name;
    String acc_type;
    long balance;
    Scanner sc=new Scanner(System.in);
    String getAccType(){
        return "Savings";
    }
    public void open_Account(){
              
       System.out.println("Enter the Account number:");
       acc_no=sc.next();
       sc.nextLine();
       System.out.println("Enter your full name:");
       name=sc.nextLine();
       System.out.println("Enter the balance:");
       balance=sc.nextLong();
     
    }
    public void Acc_Details(){
        System.out.println("~ACCOUNT DETAILS~");
        System.out.println("Name of the Account holder:"+name);
        System.out.println("Account number:"+acc_no);
        System.out.println("Account type:"+getAccType());
        System.out.println("Balance:"+balance);
    }    
    public boolean search(String account_no){
        if(acc_no.equals(account_no)){
            return true;
        }
        return false;
    }
}
class Savings extends Account{
    long amount;
    public void deposit(){
        System.out.println("~DEPOSIT~");
        System.out.println("Enter the amount you want to deposit:");
        amount=sc.nextLong();
        System.out.println("Successfully deposited");
        balance+=amount;
        System.out.println("Balance after deposit:"+balance);
    }
    public void withdrawal(){
        System.out.println("~WITHDRAWAL~");
        System.out.println("Enter the amount you want to withdraw:");
        amount=sc.nextLong();
        if (balance>=amount){
            balance-=amount;
            System.out.println("withdraw Successfull");
            System.out.println("Balance after withdrawal:"+balance);
        }      
        else{
            System.out.println("Your balance is less than"+amount);
            System.out.println("Transaction failed!!");
        }
    }
}
class Fixed_deposit extends Account{
    double principle_amt;
    double annual_interestrate;
    double time_period;
    double total_interest;
    double maturity_amt;
    String getAccType(){
        return "Fixed Deposit";
    }
    public void Acc_Details(){
        System.out.println("~ACCOUNT DETAILS~");
        System.out.println("Account type:"+getAccType());
    
    }  
    public void fd_details(){
        System.out.println("~FIXED DEPOSIT~");
    System.out.println("Enter the principle amount:");
    principle_amt=sc.nextDouble();
    annual_interestrate=6.70;
    System.out.println("Enter the time period in years:");
    time_period=sc.nextDouble();
    total_interest=(principle_amt *annual_interestrate *time_period)/100;
    maturity_amt=principle_amt+total_interest;
    } 
    public void fd_display(){
        System.out.println("Principle Amount:$"+principle_amt);
        System.out.println("Annual interest rate:"+annual_interestrate+"%");
        System.out.println("Time period:"+time_period+"years");
        System.out.println("Total interest:$"+total_interest);
        System.out.println("Maturity Amount:$"+maturity_amt); 
    }   
}
public class Banking_Project {

    public static void main(String[] args) {
        int n;
        String account_no;
        Boolean found;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of customer:");
        n=sc.nextInt();
        Account c[]=new Account[n];
        Fixed_deposit f[]=new Fixed_deposit[n];
        Personal p=new Personal();
        Car car=new Car();
        Home home=new Home();
        Education edu=new Education();
        int choice;
        do{
            System.out.println("\n**BANKING APPLICATION\n");
            System.out.println("1.Create an Account\n2.Deposit the amount\n3.Withdraw the amount\n4.Loan operation \n5.Exit");
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            
            switch(choice){
                case 1:System.out.println("There are two Account types:Savings and Fixed deposit");
                       System.out.println("Press 1 to open savings account \nPress 2 to open fixed deposit account. ");
                       System.out.println("Enter your choice:");
                       int ch=sc.nextInt();
                       
                       switch(ch){
                           case 1:for(int i=0;i<c.length;i++){
                                  c[i]=new Savings();
                                  c[i].open_Account();
                                  c[i].Acc_Details();
                                  }
                            break;
                           case 2:
                               for(int i=0;i<f.length;i++){
                                  f[i]=new Fixed_deposit();
                                  f[i].fd_details();
                                  f[i].Acc_Details();
                                  f[i].fd_display();
                                  }
                               break;

                }
                    
                break;
                case 2:
                    System.out.println("Enter the account number:");
                    account_no=sc.next();
                    found=false;
                    for(Account i:c){
                        if (i.search(account_no)){
                            ((Savings)i).deposit();
                            found=true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Account doesn't exit!\ndeposit is not possible!\nCreate an account to deposit the amount.");
                    }
                    break;
                case 3: 
                    System.out.println("Enter the account number:");
                    account_no=sc.next();
                    found=false;
                    for(Account i:c){
                        if (i.search(account_no)){
                            ((Savings)i).withdrawal();
                            found=true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Account doesn't exit!\nwithdrawal is not possible!\nCreate an account to withdraw the amount.");
                    }
                 break;
                case 4: System.out.println("LOAN OPERATION");
                    System.out.println("1.Personal Loan\n2.Car Loan\n3.Home Loan\n4.EducationLoan");
                    System.out.println("Which type of loan do you want\nEnter your choice:");
                    choice=sc.nextInt();
                    switch(choice){
                        case 1:p.personal_loan();
                               p.monthly_payment();
                               p.display();      
                               break;
                        case 2:car.car_loan();
                               car.monthly_payment();
                               car.display(); 
                               break;
                        case 3:home.home_loan();
                               home.monthly_payment();
                               home.display();  
                               break;
                        case 4:edu.education_loan();
                               edu.monthly_payment();
                               edu.display();  
                               break;
                        default:System.out.println("Invalid choice!!");
                    }
                    break;
                case 5:break;
                default : System.out.println("Invalid choice!!");
                break;
                    }
            }
        while(choice!=5);        
    }
}
