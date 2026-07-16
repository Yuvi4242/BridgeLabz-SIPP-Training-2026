public class ATMWithdrawalScenario {
    static class InsufficientBalanceException extends Exception {
        private double deficit;
        public InsufficientBalanceException(String msg, double deficit) {
            super(msg);
            this.deficit = deficit;
        }
        public double getDeficit() { return deficit; }
    }

    public static void main(String[] args) {
        double balance = 5000;
        double request = 8000;
        try {
            if (request > balance) throw new InsufficientBalanceException("Withdrawal exceeds balance", request - balance);
        } catch (InsufficientBalanceException e) {
            System.out.println("InsufficientBalanceException handled: " + e.getMessage() + ". Short by: " + e.getDeficit());
        }
    }
}
