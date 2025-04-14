// Superclass for a bank account
class BankAccount {
    private final String firstName;
    private final String lastName;
    private final int accountID;
    protected double balance;
    
    // Default constructor
    public BankAccount() {
        this.firstName = "";
        this.lastName = "";
        this.accountID = 0;
        this.balance = 0.0;
    }

    // Parameterized constructor
    public BankAccount(String firstName, String lastName, int accountID, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = balance;
    }
    
    // Getters
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public Double getBalance() {
        return this.balance;
    }

    // Method for depositing money
    public Double deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
        return this.balance;
    }

    // Method for withdrawing money
    public Double withdrawal(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
        return this.balance;
    }

    // Method to get account summary
    public String accountSummary() {
        return "Account Summary: \n" +
               "Name: " + this.firstName + " " + this.lastName + "\n" +
               "Account ID: " + this.accountID + "\n" +
               "Balance: $" + String.format("%.2f", this.balance);
    }   
}