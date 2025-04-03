package decorator;

public class ManagementFee extends AbstractDecorator {
  public double managementFee;

  public ManagementFee(InvestmentTransactionFee investmentTransaction, double managementFee) {
    super(investmentTransaction);
    this.managementFee = managementFee;
  }

  @Override
  public double getPrice() {
    return transactionFee.getPrice() * (1 + managementFee/100);
  }

  @Override
  public String getDescription() {
    return transactionFee.getDescription() + " + " + managementFee + "% management fee";
  }

}
