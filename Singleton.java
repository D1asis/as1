import java.util.ArrayList;
import java.util.List;

// Интерфейс стратегии оплаты
interface PaymentStrategy {
    void processPayment(double amount);
}

// Конкретная стратегия оплаты: Оплата кредитной картой
class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPaymentStrategy(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment of $" + amount + " processed using credit card " + cardNumber);
    }
}

class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment of $" + amount + " processed using PayPal account " + email);
    }
}

// Класс товара
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }

}

// Класс корзины для онлайн-покупок
class ShoppingCart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void checkout(PaymentStrategy paymentStrategy) {
        double totalAmount = calculateTotal();
        paymentStrategy.processPayment(totalAmount);
    }
}

