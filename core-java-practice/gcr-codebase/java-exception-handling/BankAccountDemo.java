public class BankAccountDemo {
    static class BankAccount {
        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public void withdraw(double amount) throws InsufficientBalanceException {
            if (amount < 0) throw new IllegalArgumentException("Invalid amount");
            if (amount > balance) throw new InsufficientBalanceException("Insufficient balance!");
            balance -= amount;
        }

        public double getBalance() { return balance; }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount(5000);
        try {
            acc.withdraw(8000);
            System.out.println("Withdrawal successful, new balance: " + acc.getBalance());
        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid amount!");
        }
    }
}
