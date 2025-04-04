package adapter;

import java.util.Objects;

// Target Interface
interface TemperatureSensor {
  double getTemperature(); // Returns Celsius
}

// Adaptee 1 (Legacy Fahrenheit sensor)
class FahrenheitSensor {
  public double getFahrenheitTemp() {
    return 68.0; // Example value
  }
}

// Adaptee 2 (Modern Celsius sensor)
class CelsiusSensor {
  public double getCelsiusTemp() {
    return 20.0; // Example value
  }
}

// TODO: Create FahrenheitAdapter class here
class FahrenheitAdapter implements TemperatureSensor {
  private final FahrenheitSensor temp;

  public FahrenheitAdapter(FahrenheitSensor temp) {
    this.temp = Objects.requireNonNull(temp);
  }

  @Override
  public double getTemperature() {
    return Math.round(((temp.getFahrenheitTemp() - 32.0) * 5.0 / 9.0) * 10) / 10.0;
  }
}

// TODO: Create CelsiusAdapter class here
class CelsiusAdapter implements TemperatureSensor {
  private final CelsiusSensor temp;

  public CelsiusAdapter(CelsiusSensor temp) {
    this.temp = Objects.requireNonNull(temp);
  }

  @Override
  public double getTemperature() {
    return temp.getCelsiusTemp();
  }
}

// Client Code
public class TempSensor {
  public static void main(String[] args) {
    FahrenheitSensor fSensor = new FahrenheitSensor();
    CelsiusSensor cSensor = new CelsiusSensor();

    // TODO: Create adapters
    TemperatureSensor fAdapter = new FahrenheitAdapter(fSensor);
    TemperatureSensor cAdapter = new CelsiusAdapter(cSensor);

    displayTemp(fAdapter);
    displayTemp(cAdapter);
  }

  private static void displayTemp(TemperatureSensor sensor) {
    System.out.printf("Temperature: %.1f°C%n", sensor.getTemperature());
  }
}

