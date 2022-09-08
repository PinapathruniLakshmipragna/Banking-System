package Bankingsystem;

import java.util.*;
public class BankApplication {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        System.out.print("Dear Customer, Please enter your name...");
        String sname=s.nextLine();
        System.out.print("Enter you Account Number: ");
        String sid=s.nextLine();
        BankAccount obj1=new BankAccount(sname,sid);
        obj1.showMenu();
    }
}
class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname,String cid){
        customerName=cname;
        customerId=cid;
    }
    void deposit(int amount){
        if(amount!=0){
            balance=balance+amount;
            previousTransaction=amount;
        }
    }
    void withdraw(int amount){
        if(amount!=0){
            balance=balance-amount;
            previousTransaction=-amount;
        }
    }
    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: "+previousTransaction);
        }
        else if(previousTransaction <0){
            System.out.println("Withdraw: "+Math.abs(previousTransaction));
        }
        else {
            System.out.println("No Transaction occured");
        }
    }

    void showMenu(){
        char option='\0';
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome "+customerName);
        System.out.println("Your ID is "+customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. PreviousTransaction");
        System.out.println("E. Exit");

        do{
            System.out.println("==============================================================================================");
            System.out.print("Enter an option: ");
            option=sc.next().charAt(0);
            System.out.println("==============================================================================================");
            System.out.println("\n");
            switch(option){
                case 'A':
                    System.out.println("----------------------------------");
                    System.out.println("Your current Balance is: "+balance);
                    System.out.println("----------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("----------------------------------");
                    System.out.print("Enter an amount to deposit: ");
                    int amount=sc.nextInt();
                    deposit(amount);
                    System.out.println("Amount successfully credited in you account...");
//                    System.out.println("\n");                    //Only use if you want extra space of one row
                    System.out.println("----------------------------------");
                    break;
                case 'C':
                    System.out.println("----------------------------------");
                    System.out.print("Enter an amount to withdraw: ");
                    int amount2=sc.nextInt();
                    withdraw(amount2);
                    System.out.println("Amount successfully debited from your account...");
//                    System.out.println("\n");
                    System.out.println("----------------------------------");
                    break;
                case 'D':
                    System.out.println("----------------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------------");
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("***********************************");
                    break;
                default:
                    System.out.println("Invalid option!! Please enter again... ");
                    break;
            }
        }
        while(option !='E');
        System.out.println("ThankYou for using CodeSpeedy services.");
    }
}




