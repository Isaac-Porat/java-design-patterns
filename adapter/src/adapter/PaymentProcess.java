package adapter;

// Target Interface
interface PaymentProcessor {
  void processPayment(double amount);
}

// Target Implementation (not necessary for the adapter pattern, but included for completeness)
class BasicPaymentProcessor implements PaymentProcessor {
  @Override
  public void processPayment(double amount) {
    System.out.println("Processing payment of $" + amount + " using Basic Payment Processor.");
  }
}

// Adapter
class PayPalAdapter implements PaymentProcessor {
  PayPalService paypalService;

  public PayPalAdapter(PayPalService payPalService) {
    this.paypalService = payPalService;
  }

  @Override
  public void processPayment(double amount) {
    paypalService.sendPayment(amount);
  }
}

class StripeAdapter implements PaymentProcessor {
  StripeService stripeService;

  public StripeAdapter(StripeService stripeService) {
    this.stripeService = stripeService;
  }

  @Override
  public void processPayment(double amount) {
    String amountString = Double.toString(amount);
    stripeService.makePayment(amountString);
  }
}

// Adaptee (incompatible interface)
class PayPalService {
  public void sendPayment(double paymentAmount) {
    System.out.println("Processing $" + paymentAmount + " via PayPal");
  }
}

// Another Adaptee with a different interface
class StripeService {
  public void makePayment(String amountInDollars) {
    System.out.println("Sending payment of $" + amountInDollars + " through Stripe");
  }
}

// Client code
public class PaymentProcess {
  public static void main(String[] args) {
    // Create the adaptee objects
    PayPalService paypalService = new PayPalService();
    StripeService stripeService = new StripeService();

    // TODO: Create your adapters here
    PaymentProcessor paypalProcessor = new PayPalAdapter(paypalService);
    PaymentProcessor stripeProcessor = new StripeAdapter(stripeService);

    // Process payments through the common interface
    processPayment(paypalProcessor, 100.00);
    processPayment(stripeProcessor, 200.00);
  }

  private static void processPayment(PaymentProcessor processor, double amount) {
    // Client code works with the common PaymentProcessor interface
    processor.processPayment(amount);
  }
}
