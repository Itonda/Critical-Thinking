public class Main {
    public static void main(String[] args) {
        // Create a CheckingAccount object
        CheckingAccount checkingAccount = new CheckingAccount("John", "Doe", 
                                                    12345, 1000.0, 1.7, 30.0, 100.0);
        
        // Display account summary
        System.out.println(checkingAccount.accountSummary());
        
        // Test deposit
        double depositAmount = 200.0;
        checkingAccount.deposit(depositAmount);
        System.out.printf("Balance after $200 deposit: $%.2f%n", checkingAccount.getBalance());
        
        // Test withdrawal within balance
        double withdrawalAmount = 300.0;
        checkingAccount.processWithdrawal(withdrawalAmount);
        System.out.printf("Balance after $300 withdrawal: $%.2f%n", checkingAccount.getBalance());
        
        // Test withdrawal exceeding balance (with overdraft)
        System.out.println("Attempting to withdraw $910 (overdraft):");
        double overdraftWithdrawalAmount = 910.0;
        checkingAccount.processWithdrawal(overdraftWithdrawalAmount);
        System.out.printf("Balance after overdraft withdrawal: $%.2f%n", checkingAccount.getBalance());
        
        // Test withdrawal exceeding overdraft limit
        System.out.println("Another withdrawal of $35:");
        double overdraftWithdrawalAmount2 = 35.0;
        checkingAccount.processWithdrawal(overdraftWithdrawalAmount2);
        System.out.printf("Balance after withdrawal exceeding overdraft limit (declined, balance would be -$105): $%.2f%n", checkingAccount.getBalance());

        // Test deposit after overdraft
        double depositAmount2 = 500.0;
        checkingAccount.deposit(depositAmount2);

        System.out.printf("Balance after $500 deposit: $%.2f%n", checkingAccount.getBalance());
    }
}