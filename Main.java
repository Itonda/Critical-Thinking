public class Main {
    public static void main(String[] args) {
        // Create a CheckingAccount object
        CheckingAccount checkingAccount = new CheckingAccount("John", "Doe", 12345, 1000.0, 1.7, 30.0);
        
        // Display account summary
        System.out.println(checkingAccount.accountSummary());
        
        // Test deposit
        checkingAccount.deposit(200.0);
        System.out.println("Balance after $200 deposit: $" + checkingAccount.getBalance());
        
        // Test withdrawal within balance
        checkingAccount.processWithdrawal(300.0);
        System.out.println("Balance after $300 withdrawal: $" + checkingAccount.getBalance());
        
        // Test withdrawal exceeding balance (with overdraft)
        System.out.println("Attempting to withdraw $910 (overdraft):");
        checkingAccount.processWithdrawal(910.0);
        System.out.println("Balance after overdraft withdrawal: $" + checkingAccount.getBalance());
        
        // Test withdrawal exceeding overdraft limit
        System.out.println("Another withdrawal of $5:");
        checkingAccount.processWithdrawal(5.0);
        System.out.println("Balance after overdraft withdrawal: $" + checkingAccount.getBalance());

        checkingAccount.deposit(500);
        System.out.println("Balance after $500 deposit: $" + checkingAccount.getBalance());
    }
}
