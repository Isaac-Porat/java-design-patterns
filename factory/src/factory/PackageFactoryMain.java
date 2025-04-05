package factory;

// Logistics and Delivery Systems

// Product Interface
interface DeliveryRequest {
  void createPackage();
}

// Concrete Products
class StandardDelivery implements DeliveryRequest {
  @Override
  public void createPackage() {
    System.out.println("Create package using standard delivery...");
  }
}

class ExpressDelivery implements DeliveryRequest {
  @Override
  public void createPackage() {
    System.out.println("Create package using express delivery...");
  }
}

// Creator Abstract Class
abstract class PackageFactory {
  abstract DeliveryRequest createPackageRequest();
}

// Concrete Creators
class StandardDeliveryFactory extends PackageFactory {
  @Override
  DeliveryRequest createPackageRequest() {
    return new StandardDelivery();
  }
}

class ExpressDeliveryFactory extends PackageFactory {
  @Override
  DeliveryRequest createPackageRequest() {
    return new ExpressDelivery();
  }
}

public class PackageFactoryMain {
  public static void main(String[] args) {
    StandardDeliveryFactory standardDeliveryFactory = new StandardDeliveryFactory();
    DeliveryRequest standardDelivery = standardDeliveryFactory.createPackageRequest();
    standardDelivery.createPackage();

    ExpressDeliveryFactory expressDeliveryFactory = new ExpressDeliveryFactory();
    DeliveryRequest expressDelivery = expressDeliveryFactory.createPackageRequest();
    expressDelivery.createPackage();
  }
}
