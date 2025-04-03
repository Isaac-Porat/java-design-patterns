package decorator;

public class ConcreteInvestmentTransactionFee implements InvestmentTransactionFee {
  private double price;

  public ConcreteInvestmentTransactionFee(double price) {
    this.price = price;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public String getDescription() {
    return "The investment transaction fee is $" + this.price;
  }
}
