// Subclass of BankAccount representing a checking account with overdraft capabilities
class CheckingAccount extends BankAccount {
    private Double interestRate;
    private Double overdraftFee;

    // Default constructor
    public CheckingAccount() {
        super();
        this.interestRate = 1.7;
        this.overdraftFee = 30.0;
    }

    // Parameterized constructor
    public CheckingAccount(String firstName, String lastName, int accountID, double balance, double interestRate, double overdraftFee) {
        super(firstName, lastName, accountID, balance);
        this.interestRate = interestRate;
        this.overdraftFee = overdraftFee;
    }

    // Method for withdrawing money with overdraft capabilities
    public Double processWithdrawal(Double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return null;
        }

        if (amount > getBalance()) {
            // Apply overdraft fee if the withdrawal exceeds the balance
            double totalAmount = amount + overdraftFee;
            setBalance(getBalance() - totalAmount);
            System.out.println("Overdraft fee applied: $" + overdraftFee);
        } else {
            setBalance(getBalance() - amount);
        }

        return getBalance();
    }

    @Override
    public String accountSummary() {
        return "Account Type: Checking Account\n" +
               "First Name: " + getFirstName() + "\n" +
               "Last Name: " + getLastName() + "\n" +
               "Account ID: " + getAccountID() + "\n" +
               "Balance: $" + String.format("%.2f", getBalance()) + "\n" +
               "Interest Rate: " + interestRate + "%\n" +
               "Overdraft Fee: $" + overdraftFee;
    }
}




