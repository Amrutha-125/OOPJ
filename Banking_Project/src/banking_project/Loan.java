/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking_project;

import java.util.Scanner;

/**
 *
 * @author amrut
 */
    public class Loan extends Customer{
    long loan_amount;
    double annual_interestrate;
    double monthly_interestrate;
    double monthlyPayments;
    double duration;
    Scanner sc=new Scanner(System.in);
    }
class Personal extends Loan{
    String emp_status;
    String loan_purpose;
    public void personal_loan(){
        System.out.println("PERSONAL LOAN");
        System.out.println("Enter the loan amount:");
        loan_amount=sc.nextLong();
        sc.nextLine();
        System.out.println("Enter the purpose of loan:");
        loan_purpose=sc.nextLine();
        System.out.println("Enter the loan period in years:");
        duration=sc.nextInt();
        annual_interestrate=12.0;
    }
    public void monthly_payment(){
        double numberOfPayments;
        monthly_interestrate=(annual_interestrate)/12/100;
        numberOfPayments=duration*12;
        monthlyPayments=(loan_amount*monthly_interestrate)/(1-Math.pow(1+monthly_interestrate,-numberOfPayments));
    }
    public void display(){
        System.out.println("PERSONAL LOAN DETAILS");
        System.out.println("purpose of loan:"+loan_purpose);
        System.out.println("Loan Amount:"+loan_amount);
        System.out.println("Loan Duration:"+duration);
        System.out.println("Annual Interest rate:"+(annual_interestrate)+"%");
        System.out.println("Monthly interest rate:"+(monthly_interestrate*100)+"%");
        System.out.println("Monthly payment:$"+monthlyPayments);
    }
}
    class Car extends Loan{
    double reg_no;
    double engine_no;
    double duration;
    public void car_loan(){
        System.out.println("CAR LOAN");
        System.out.println("Enter the loan amount:");
        loan_amount=sc.nextLong();
        sc.nextLine();
        System.out.println("Enter the loan period in years:");
        duration=sc.nextInt();
        annual_interestrate=9.10;
        System.out.println("Enter the car registration number:");
        reg_no=sc.nextDouble();
        System.out.println("Enter the engine number:");
        engine_no=sc.nextDouble();
    }
    public void monthly_payment(){
        double numberOfPayments;
        monthly_interestrate=annual_interestrate/12/100;
        numberOfPayments=duration*12;
        monthlyPayments=(loan_amount*monthly_interestrate)/(1-Math.pow(1+monthly_interestrate,-numberOfPayments));
}
    public void display(){
        System.out.println("CAR LOAN DETAILS");
        System.out.println("Loan Amount:"+loan_amount);
        System.out.println("Loan Duration:"+duration);
        System.out.println("Annual interest rate:"+annual_interestrate+"%");
        System.out.println("Monthly interest rate:"+(monthly_interestrate*100)+"%");
        System.out.println("Monthly payment:$"+monthlyPayments);
    }
}

class Home extends Loan{
    String property_address;
    String home_no;
    public void home_loan(){
        System.out.println("HOME LOAN");
        System.out.println("Enter the loan amount:");
        loan_amount=sc.nextLong();
        sc.nextLine();
        System.out.println("Enter the loan period in years:");
        duration=sc.nextInt();
        annual_interestrate=8.75;
        sc.nextLine();
        System.out.println("Enter the property address:");
        property_address=sc.nextLine();
        System.out.println("Enter the home number:");
        home_no=sc.next();
    }
    public void monthly_payment(){
        double numberOfPayments;
        monthly_interestrate=annual_interestrate/12/100;
        numberOfPayments=duration*12;
        monthlyPayments=(loan_amount*monthly_interestrate)/(1-Math.pow(1+monthly_interestrate,-numberOfPayments));
    }
    public void display(){
        System.out.println("HOME LOAN DETAILS");
        System.out.println("Loan Amount:"+loan_amount);
        System.out.println("Loan Duration:"+duration);
        System.out.println("Annual interest rate:"+annual_interestrate+"%");
        System.out.println("Monthly interest rate:"+(monthly_interestrate*100)+"%");
        System.out.println("Monthly payment:$"+monthlyPayments);
    }
}
class Education extends Loan{
    String institute_name;
    String course_name;
    public void education_loan(){
        System.out.println("EDUCATION LOAN");
        System.out.println("Enter the loan amount:");
        loan_amount=sc.nextLong();
        sc.nextLine();
        System.out.println("Enter the loan period in years:");
        duration=sc.nextInt();
        annual_interestrate=9.50;
        sc.nextLine();
        System.out.println("Enter the institute name:");
        institute_name=sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the course name:");
        course_name=sc.next();
    }
    public void monthly_payment(){
        double numberOfPayments;
        monthly_interestrate=annual_interestrate/12/100;
        numberOfPayments=duration*12;
        monthlyPayments=(loan_amount*monthly_interestrate)/(1-Math.pow(1+monthly_interestrate,-numberOfPayments));
    }
    public void display(){
        System.out.println("EDUCATION LOAN DETAILS");
        System.out.println("Loan Amount:"+loan_amount);
        System.out.println("Loan Duration:"+duration);
        System.out.println("annual interest rate:"+annual_interestrate+"%");
        System.out.println("Monthly interest rate:"+(monthly_interestrate*100)+"%");
        System.out.println("Monthly payment:$"+monthlyPayments);
    }
}
