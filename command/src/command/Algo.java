package command;

// Command Interface
interface Command {
  void execute();
}

// Concrete Command
class AddCommand implements Command {
  private final BetterAddAlgo algo;
  private final int x;
  private final int y;

  public AddCommand(BetterAddAlgo algo, int x, int y) {
    this.algo = algo;
    this.x = x;
    this.y = y;
  }

  @Override
  public void execute() {
    algo.add(x, y);
  }
}

// Receiver
class BetterAddAlgo {
  public void add(int x, int y) {
    System.out.printf("Answer: %s", x + y);
  }
}

// Invoker
class AlgoController {
  private final Command command;

  public AlgoController(Command command) {
    this.command = command;
  }

  public void executeAlgo() {
    command.execute();
  }
}

public class Algo {
  public static void main(String[] args) {
    BetterAddAlgo betterAddAlgo = new BetterAddAlgo();
    AddCommand command = new AddCommand(betterAddAlgo, 2, 2);
    AlgoController controller = new AlgoController(command);
    controller.executeAlgo();
  }
}
