package decorator;

abstract class AbstractDecorator implements InvestmentTransactionFee {
  InvestmentTransactionFee transactionFee;

  public AbstractDecorator(InvestmentTransactionFee transactionFee) {
    this.transactionFee = transactionFee;
  }

  public double getPrice() {
    return transactionFee.getPrice();
  }

  public String getDescription() {
    return transactionFee.getDescription();
  }
}
