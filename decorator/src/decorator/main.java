package decorator;

public class main {
  public static void main(String[] args) {
    InvestmentTransactionFee transactionFee = new ConcreteInvestmentTransactionFee(2);

    System.out.println(transactionFee.getPrice());
    System.out.println(transactionFee.getDescription());

    // Decorator that adds performance fee
    InvestmentTransactionFee performanceFee = new PerformanceFee(transactionFee, 2);

    System.out.println(performanceFee.getPrice());
    System.out.println(performanceFee.getDescription());

    // Decorator that adds management fee
    InvestmentTransactionFee managementFee = new ManagementFee(performanceFee, 3);

    System.out.println(managementFee.getPrice());
    System.out.println(managementFee.getDescription());
  }
}
