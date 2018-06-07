import java.math.BigDecimal;
public class BankAccount {
	private long accountNo;
	private BigDecimal checkingBalance;
	private BigDecimal savingBalance;
	private static BigDecimal bankFunds=new BigDecimal(0);
	private static int numAccounts=0;
	public BankAccount(){
		numAccounts++;
		this.accountNo = accountNoGenerator();
		this.savingBalance = new BigDecimal(0);
		this.checkingBalance = new BigDecimal(0);
	}
	private long accountNoGenerator() {
		long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		return number;
	}
	public BigDecimal getChecking() {
		System.out.print("Your checking balance is: ");
		System.out.println(this.checkingBalance);
		return this.checkingBalance;
	}
	public BigDecimal getSavings() {
		System.out.print("Your savings balance is: ");
		System.out.println(this.savingBalance);
		return this.savingBalance;
	}
	public long getAccountNo() {
		return this.accountNo;
	}
	public void deposit(double deposit_amt, boolean isChecking) {
		if (isChecking == true) {
			System.out.println(this.checkingBalance);
			this.checkingBalance.add(new BigDecimal(deposit_amt));
			System.out.println(this.checkingBalance);
			bankFunds.add(new BigDecimal(deposit_amt));
		}
		else {
			System.out.println(this.savingBalance);
			this.savingBalance.add(new BigDecimal(deposit_amt));
			System.out.println(this.savingBalance);
			bankFunds.add(new BigDecimal(deposit_amt));
		}
	}
	public void withdraw(double withdraw_amt, boolean isChecking) {
		BigDecimal curFunds;
		if (isChecking == true) {
			curFunds = this.getChecking();
		}
		else {
			curFunds = this.getSavings();
		}
		if (new BigDecimal(withdraw_amt).compareTo(curFunds) == 1) { //withdraw_amt > curFunds
			System.out.println("You do not have the funds available to transfer");
		}
		else { //can withdraw
			bankFunds.subtract(new BigDecimal(withdraw_amt));
			if (isChecking == true) {
				this.checkingBalance.subtract(new BigDecimal(withdraw_amt));
				System.out.print("The bank clerk produces $");
				System.out.print(withdraw_amt);
				System.out.print(" in cash for you from your checking account ");
				System.out.println(this.accountNo);
				this.getChecking();
			}
			else {
				this.savingBalance.subtract(new BigDecimal(withdraw_amt));
				System.out.print("The bank clerk produces $");
				System.out.print(new BigDecimal(withdraw_amt));
				System.out.print(" in cash for you from your savings account ");
				System.out.println(this.accountNo);
				this.getSavings();
			}
		}
	}
	public BigDecimal totalFunds() {
		System.out.print("You currently have $");
		System.out.print(bankFunds);
		System.out.print(" available from ");
		System.out.print(numAccounts);
		System.out.println(" different accounts.");
		return bankFunds;
	}
	
}
