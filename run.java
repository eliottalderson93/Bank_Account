import java.math.BigDecimal;
public class run {
	public static void main(String[] args) {
		BankAccount WellsFargo = new BankAccount();
		BankAccount RobinHood = new BankAccount();
//		BigDecimal myCash = new BigDecimal(200.0);
//		BigDecimal myCash2 = new BigDecimal(351.24);
//		BigDecimal myCash3 = new BigDecimal(99.99);
		double myCash = 200;
		double myCash2 = 351.24;
		double myCash3 = 99.99;
		System.out.println(myCash);
		System.out.println(myCash2);
		System.out.println(myCash3);
		WellsFargo.deposit(myCash, true);
		WellsFargo.deposit(myCash3, false);
		RobinHood.deposit(myCash2, false);
		System.out.println("Your Wells Fargo Account:");
		WellsFargo.getChecking();
		WellsFargo.getSavings();
		WellsFargo.totalFunds();
		System.out.println("Your Robinhood account:");
		RobinHood.getChecking();
		RobinHood.getSavings();
		RobinHood.totalFunds();
		System.out.println("--------------");
		WellsFargo.withdraw(myCash,false);
		RobinHood.withdraw(myCash,false);
		RobinHood.withdraw(myCash3, false);
		WellsFargo.totalFunds();
		RobinHood.totalFunds();
		
	}

}
