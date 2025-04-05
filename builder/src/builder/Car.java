package builder;

import builder.CarModel.CarBuilder;

class CarModel {
  private final String model;
  private final int year;

  private CarModel(CarBuilder builder) {
    this.model = builder.model;
    this.year = builder.year;
  }

  public static class CarBuilder {
    private final String model;
    private final int year;

    public CarBuilder(String model, int year) {
      this.model = model;
      this.year = year;
    }

    public CarModel build() {
      return new CarModel(this);
    }
  }
}

public class Car {
  public static void main(String[] args) {
    CarModel carModel = new CarBuilder("BMW", 2000).build();
  }
}
