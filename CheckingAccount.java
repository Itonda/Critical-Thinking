// Subclass of BankAccount representing a checking account with overdraft capabilities
class CheckingAccount extends BankAccount {
    private final Double interestRate;
    private final Double overdraftFee;
    private final Double overdraftLimit; // Overdraft limit

    // Default constructor
    public CheckingAccount() {
        super();
        this.interestRate = 1.7;
        this.overdraftFee = 30.0;
        this.overdraftLimit = 100.0; 
    }

    // Parameterized constructor
    public CheckingAccount(String firstName, String lastName, int accountID, double balance, 
                           double interestRate, double overdraftFee, double overdraftLimit) {
        super(firstName, lastName, accountID, balance);
        this.interestRate = interestRate;
        this.overdraftFee = overdraftFee;
        this.overdraftLimit = overdraftLimit;
    }

    // Method for withdrawing money with overdraft capabilities
    public Double processWithdrawal(Double amount) {
        try {
            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount.");
                return null;
            }

            if (amount > getBalance()) {
                // Apply overdraft fee if the withdrawal exceeds the balance
                double totalAmount = amount + overdraftFee;
                double potentialBalance = balance - totalAmount;

                System.out.println("Overdraft fee applied: $" + overdraftFee);
                if (potentialBalance < -overdraftLimit) {
                    throw new Exception("Overdraft limit exceeded. Transaction denied.");
                } else {
                    balance -= totalAmount;  
                }
            } else {
                balance -= amount;  
            }

        } catch (Exception e) {  
            System.out.println(e.getMessage());
            
        }
        
        return balance;
    } 

    @Override
    public String accountSummary() {
        return "Account Type: Checking Account\n" +
               "First Name: " + getFirstName() + "\n" +
               "Last Name: " + getLastName() + "\n" +
               "Account ID: " + getAccountID() + "\n" +
               "Balance: $" + String.format("%.2f", getBalance()) + "\n" +
               "Interest Rate: " + interestRate + "%\n" +
               "Overdraft Fee: $" + overdraftFee + "\n" +
                "Overdraft Limit: $" + overdraftLimit;
    }
}