package decorator;

public class PerformanceFee extends AbstractDecorator {
  private double performanceFee;

  public PerformanceFee(InvestmentTransactionFee investmentTransaction, double feePercentage) {
    super(investmentTransaction);
    this.performanceFee = feePercentage;
  }

  @Override
  public double getPrice() {
    return transactionFee.getPrice() * (1 + performanceFee / 100);
  }

  @Override
  public String getDescription() {
    return transactionFee.getDescription() + " + " + performanceFee + "% performance fee";
  }
}
