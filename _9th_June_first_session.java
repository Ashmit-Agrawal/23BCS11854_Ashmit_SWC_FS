abstract class Payment {
    public abstract void processPayment(double amount);
}

class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    private boolean validateCard() {
        return cardNumber != null && cardNumber.length() == 16;
    }

    @Override
    public void processPayment(double amount) {
        if (!validateCard()) {
            System.out.println("Payment Failed: Invalid Credit Card Number.");
            return;
        }

        System.out.println("Credit Card Payment of ₹" + amount +
                           " processed successfully.");
    }
}

class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    private boolean validateUPI() {
        return upiId != null && upiId.matches("^[a-zA-Z0-9._-]+@[a-zA-Z]+$");
    }

    @Override
    public void processPayment(double amount) {
        if (!validateUPI()) {
            System.out.println("Payment Failed: Invalid UPI ID.");
            return;
        }

        System.out.println("UPI Payment of ₹" + amount +
                           " processed successfully.");
    }
}


public class _9th_June_first_session {
    public static void main(String[] args) {

        // Runtime Polymorphism
        Payment p1 = new CreditCardPayment("1234567890123456");
        Payment p2 = new UPIPayment("user@paytm");

        p1.processPayment(5000);
        p2.processPayment(1200);

        // Invalid Payment Scenarios
        Payment p3 = new CreditCardPayment("12345");
        Payment p4 = new UPIPayment("invalidupi");

        p3.processPayment(3000);
        p4.processPayment(800);
    }
}