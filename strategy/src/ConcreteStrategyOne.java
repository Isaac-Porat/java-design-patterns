public class ConcreteStrategyOne implements StrategyInterface {
  private int number;

  public ConcreteStrategyOne(int number) {
    this.number = number;
  }

  @Override
  public int executeAlgorithm() {
    return number + 1;
  }
}
