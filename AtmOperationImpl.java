package machine;

public class AtmOperationImpl implements AtmOperationInterf {
    ATM atm = new ATM();


    private String lastTransaction1 = "";
    private String lastTransaction2 = "";
    private String lastTransaction3 = "";

    public void viewBalance() {
        System.out.println("Available Balance is: " + atm.getBalance());
    }

    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                updateMiniStatement("Withdrawn: ₹" + withdrawAmount);
                System.out.println("Collect the Cash: ₹" + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("❌ Insufficient Balance!");
            }
        } else {
            System.out.println("⚠️ Please enter the amount in multiples of ₹500.");
        }
    }

    public void depositAmount(double depositAmount) {
        updateMiniStatement("Deposited: ₹" + depositAmount);
        System.out.println("₹" + depositAmount + " Deposited Successfully!");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    public void viewMiniStatement() {
        System.out.println("\n📜 Mini Statement:");
        if (lastTransaction1.isEmpty() && lastTransaction2.isEmpty() && lastTransaction3.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            if (!lastTransaction1.isEmpty()) System.out.println("💰 " + lastTransaction1);
            if (!lastTransaction2.isEmpty()) System.out.println("💰 " + lastTransaction2);
            if (!lastTransaction3.isEmpty()) System.out.println("💰 " + lastTransaction3);
        }
    }

    // Helper method to store only the last 3 transactions
    private void updateMiniStatement(String transaction) {
        lastTransaction3 = lastTransaction2;
        lastTransaction2 = lastTransaction1;
        lastTransaction1 = transaction;
    }
}
