package banking_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

class Customer {

    
    static int lastCustomerId =54540 ; // Starting customer ID

    int cust_id;

    public Customer() {
        // Increment the last customer ID and assign it to cust_id
        this.cust_id = ++lastCustomerId;
    }

    public int getCustId() {
        return cust_id;
    }

    public void setCustId(int cust_id) {
        this.cust_id = cust_id;
    }
}



class Account extends Customer {
    static int lastAccountNumber = 12349;
    int acc_no;
    String name;
    String acc_type;
    long balance;
    Scanner sc = new Scanner(System.in);

    String getAccType() {
        return "Savings";
    }


    public void open_Account() {
        acc_no = generateAccountNumber();
        System.out.println("Enter your full name:");
        name = sc.nextLine();
        System.out.println("Enter the balance:");
        balance = sc.nextLong();

    }
    private int generateAccountNumber() {
        // Increment the last account number and return it as a String
        lastAccountNumber++;
        return lastAccountNumber;
    }

    public void Acc_Details() {
        System.out.println("ACCOUNT DETAILS");
        System.out.println("Name of the Account holder:" + name);
        System.out.println("Customer id:"+getCustId());
        System.out.println("Account number:"+acc_no);
        System.out.println("Account type:" + getAccType());
        System.out.println("Balance:" + balance);
    }

    public int getAcc_no() {
        return acc_no;
    }

}

class Savings extends Account {

    long amount;

    public void deposit() {
        System.out.println("DEPOSIT");
        System.out.println("Enter the amount you want to deposit:");
        amount = sc.nextLong();
        System.out.println("Successfully deposited");
        balance += amount;
        System.out.println("Balance after deposit:" + balance);
        try {
            FileWriter depositFile = new FileWriter("deposit_details.txt", true);
            depositFile.write("Account number: " + acc_no + "\n");
            depositFile.write("Deposit amount: " + amount + "\n");
            depositFile.write("New balance: " + balance + "\n\n");
            depositFile.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing deposit details to file.");
            e.printStackTrace();
        
    }

}

    public void withdrawal() {
        System.out.println("WITHDRAWAL");
        System.out.println("Enter the amount you want to withdraw:");
        amount = sc.nextLong();
        if (balance >= amount) {
            balance -= amount;
            System.out.println("withdraw Successfull");
            System.out.println("Balance after withdrawal:" + balance);
            try {
                FileWriter withdrawalFile = new FileWriter("withdrawal_details.txt", true);
                withdrawalFile.write("Account number: " + acc_no + "\n");
                withdrawalFile.write("Withdrawal amount: " + amount + "\n");
                withdrawalFile.write("New balance: " + balance + "\n\n");
                withdrawalFile.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing withdrawal details to file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Your balance is less than" + amount);
            System.out.println("Transaction failed!!");
        }
    }
}

class Fixed_deposit extends Account {

    double principle_amt;
    double annual_interestrate;
    double time_period;
    double total_interest;
    double maturity_amt;

    String getAccType() {
        return "Fixed Deposit";
    }

    public void Acc_Details() {
        System.out.println("ACCOUNT DETAILS");
        System.out.println("Account type:" + getAccType());

    }

    public void fd_details() {
        System.out.println("FIXED DEPOSIT");
        System.out.println("Enter the principle amount:");
        principle_amt = sc.nextDouble();
        annual_interestrate = 6.70;
        System.out.println("Enter the time period in years:");
        time_period = sc.nextDouble();
        total_interest = (principle_amt * annual_interestrate * time_period) / 100;
        maturity_amt = principle_amt + total_interest;
    }

    public void fd_display() {
        System.out.println("Principle Amount:$" + principle_amt);
        System.out.println("Annual interest rate:" + annual_interestrate + "%");
        System.out.println("Time period:" + time_period + "years");
        System.out.println("Total interest:$" + total_interest);
        System.out.println("Maturity Amount:$" + maturity_amt);
    }
}


public class Banking_Project {

    public static void main(String[] args) throws FileNotFoundException,IOException {
        
        int n;
int account_no;
int customer_id = 54543;
Boolean found;
Scanner sc = new Scanner(System.in);
System.out.println("Enter the number of customer:");
n = sc.nextInt();
Customer cust[] = new Customer[n];
Account c[] = new Account[n];  // Initialize c array
Fixed_deposit f[] = new Fixed_deposit[n];  // Initialize f array
Personal_Loan p = new Personal_Loan();
Car_Loan car = new Car_Loan();
Home_Loan home = new Home_Loan();
Education_Loan edu = new Education_Loan();
int choice;
FileWriter fw = null;

        try {
            fw = new FileWriter("customer_details.txt");
            for (int i = 0; i < n; i++) {
                cust[i] = new Customer();
                fw.write("Customer ID: " + cust[i].getCustId() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing customer details to file.");
            e.printStackTrace();
        }


        do {
            System.out.println("\n**BANKING APPLICATION\n");
            System.out.println("1.Create an Account\n2.Deposit the amount\n3.Withdraw the amount\n4.Loan operation \n5.Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("There are two Account types:Savings and Fixed deposit");
                    System.out.println("Press 1 to open savings account \nPress 2 to open fixed deposit account. ");
                    System.out.println("Enter your choice:");
                    int ch = sc.nextInt();

                    switch (ch) {
                       case 1:
    for (int i = 0; i < c.length; i++) {
        c[i] = new Savings();
        // Setting customer ID
        c[i].setCustId(cust[i].getCustId());
        c[i].open_Account();
        c[i].Acc_Details();
        try {
                                    fw = new FileWriter("account_details.txt", true);
                                    fw.write("Account holder: " + c[i].name + "\n");
                                    fw.write("Account type: " + c[i].getAccType() + "\n");
                                    fw.write("Account number: " + c[i].acc_no + "\n");
                                    fw.write("Balance: " + c[i].balance + "\n\n");
                                    fw.close();
                                } catch (IOException e) {
                                    System.out.println("An error occurred while writing account details to file.");
                                    e.printStackTrace();
                                }
                            }
    break;
case 2:
    for (int i = 0; i < f.length; i++) {
        f[i] = new Fixed_deposit();
        f[i].setCustId(cust[i].getCustId());
        f[i].fd_details();
        f[i].Acc_Details();
        f[i].fd_display();
       try {
                                    fw = new FileWriter("account_details.txt", true);
                                    fw.write("Account holder: " + f[i].name + "\n");
                                    fw.write("Account type: " + f[i].getAccType() + "\n");
                                    fw.write("Account number: " + f[i].acc_no + "\n");
                                    fw.write("Balance: " + f[i].balance + "\n\n");
                                    fw.close();
                                } catch (IOException e) {
                                    System.out.println("An error occurred while writing account details to file.");
                                    e.printStackTrace();
                                }
                            }

    break;


                    }

                    break;
                case 2:
                    System.out.println("Enter the account number:");
                    account_no = sc.nextInt();
                    System.out.println("Enter the customer id:");
                    customer_id=sc.nextInt();
                    found = false;
                    
                    for (Account i : c) {
                          if(( i.getAcc_no()==account_no)&&(i.getCustId()==customer_id)){
                            ((Savings) i).deposit();
                            found=true;
                             break;
                        }

                    }
                    if (!found) {
                        System.out.println("Account doesn't exit!\ndeposit is not possible!\nCreate an account to deposit the amount.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the account number:");
                    account_no = sc.nextInt();
                    System.out.println("Enter the customer id:");
                    customer_id=sc.nextInt();
                    found = false;
                   
                    for (Account i : c) {
                        if(( i.getAcc_no()==account_no)&&(i.getCustId()==customer_id)){
                            ((Savings) i).withdrawal();
                            found=true;
                            
                            break;
                        }

                    }
                    if (!found) {
                        System.out.println("Account doesn't exit!\nwithdrawal is not possible!\nCreate an account to withdraw the amount.");
                    }
                    break;
                case 4:
                    System.out.println("LOAN OPERATION");
                    System.out.println("1.Personal Loan\n2.Car Loan\n3.Home Loan\n4.EducationLoan");
                    System.out.println("Which type of loan do you want\nEnter your choice:");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            p.apply_personalLoan();
                            p.calc_monthlyPayment();
                            p.display();
                            break;
                        case 2:
                            car.apply_carLoan();
                            car.calc_monthlyPayment();
                            car.display();
                            break;
                        case 3:
                            home.apply_homeLoan();
                            home.calc_monthlyPayment();
                            home.display();
                            break;
                        case 4:
                            edu.apply_educationLoan();
                            edu.calc_monthlyPayment();
                            edu.display();
                            break;
                        default:
                            System.out.println("Invalid choice!!");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice!!");
                    break;
            }
        } while (choice != 5);
    }
}

