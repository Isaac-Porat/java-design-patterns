package builder;

class Game {
  private final int playerCount;
  private final int timeLength;
  private final int healthPoints;
  private final int xpPoints;

  private Game(GameBuilder builder) {
    this.playerCount = builder.playerCount;
    this.timeLength = builder.timeLength;
    this.healthPoints = builder.healthPoints;
    this.xpPoints = builder.xpPoints;
  }

  public static class GameBuilder {
    private final int playerCount;
    private final int timeLength;
    private int healthPoints = 0;
    private int xpPoints = 0;

    public GameBuilder(int playerCount, int timeLength) {
      this.playerCount = playerCount;
      this.timeLength = timeLength;
    }

    public GameBuilder healthPoints(int healthPoints) {
      this.healthPoints = healthPoints;
      return this;
    }

    public GameBuilder xpPoints(int xpPoints) {
      this.xpPoints = xpPoints;
      return this;
    }

    public Game build() {
      return new Game(this);
    }
  }
}

public class GamePlay {
  public static void main(String[] args) {
    Game game = new Game.GameBuilder(2, 10).build();
  }
}

