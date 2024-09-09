import java.util.*;
class BankAccount{
    double balance;

    BankAccount(double balance){
        if(balance>0)
        this.balance=balance;
        else{
            this.balance=0;
            System.out.println("Invalid Balance Entered. Setting balance to 0.");
        }
    }
    public double getBalance(){
        return balance;
    }
    void deposit(double amount){
        if (amount>0){
            balance=balance+amount;
        }
    }

    void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance=balance-amount;
        }  
    }
}

class ATM{
    BankAccount ob;
    ATM(BankAccount ob){
        this.ob=ob;
    }
    void choose()
    {
        System.out.println("Welcome to ATM Machine");
        System.out.println("Press 1 to Check your balance");
        System.out.println("Press 2 to Deposit Money");
        System.out.println("Press 3 to Withdraw Money");
        System.out.println("Press 4 to Exit");
    }

    void balance(){
        double bal=ob.getBalance();
        System.out.println("Your balance is: "+bal);
        System.out.println();
    }

    void deposit(double amount){
        if(amount>0){
            ob.deposit(amount);
            System.out.println("Amount "+amount+"Deposited Successfully");
            System.out.println();
        }
        else{
            System.out.println("Invalid Amount Entered");
            System.out.println();
        }
    }

    void withdraw(double amount){
        double bal=ob.getBalance();
        if(amount>0 && amount<=bal){
            ob.withdraw(amount);
            System.out.println("Amount "+amount+"Withdrawn Successfully");
            System.out.println();
        }
        else if(amount<0){
            System.out.println("Invalid Amount Entered");
            System.out.println();
        }
        else{
            System.out.println("Insufficient Balance");
            System.out.println();
        }
    }
}

class task3{
    public static void main(String[] args) {
        BankAccount ob=new BankAccount(100000);
        ATM ob2=new ATM(ob);
        Scanner sc=new Scanner(System.in);
        while(true){
            ob2.choose();
            System.out.println("Enter your choice: ");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    ob2.balance();
                    break;
                case 2:
                    double amt;
                    System.out.println("Enter the amount to deposit: ");
                    amt=sc.nextDouble();
                    ob2.deposit(amt);
                    break;
                case 3:
                    double withdrawamt;
                    System.out.println("Enter the amount to withdraw: ");
                    withdrawamt=sc.nextDouble();
                    ob2.withdraw(withdrawamt);
                    break;
                case 4:
                    System.out.println("Thank you for using ATM Machine");
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}