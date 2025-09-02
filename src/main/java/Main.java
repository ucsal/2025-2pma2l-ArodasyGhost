import br.com.mariojp.solid.lspaccounts.BankService;
import br.com.mariojp.solid.lspaccounts.CheckingAccount;
import br.com.mariojp.solid.lspaccounts.SavingsAccount;
import br.com.mariojp.solid.lspaccounts.Withdrawable;

public class Main {
	public static void main(String[] args) {
		CheckingAccount checking = new CheckingAccount();
		checking.deposit(100);
		new BankService().processWithdrawal(checking, 30);
		System.out.println("Checking balance: " + checking.getBalance()); // 70.0

		SavingsAccount savings = new SavingsAccount();
		savings.deposit(100);
		
		
		if (savings instanceof Withdrawable) {
			new BankService().processWithdrawal((Withdrawable) savings, 30);
		} else {
			System.out.println("Saque não permitido em poupança");
		}
		System.out.println("Savings balance: " + savings.getBalance());
	}
}