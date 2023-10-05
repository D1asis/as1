import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем сканнер для ввода данных с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Создаем ленту товаров
        List<Product> productCatalog = new ArrayList<>();
        productCatalog.add(new Product("Ноутбук", 999.99));
        productCatalog.add(new Product("Смартфон", 499.99));
        productCatalog.add(new Product("Наушники", 149.99));

        // Создаем корзину
        ShoppingCart cart = new ShoppingCart();

        // Покупатель выбирает товары из ленты
        System.out.println("Доступные товары:");
        for (int i = 0; i < productCatalog.size(); i++) {
            Product product = productCatalog.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
        }

        while (true) {
            System.out.print("Выберите номер товара (или '0' для завершения покупок): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > productCatalog.size()) {
                System.out.println("Неверный номер товара.");
                continue;
            }

            Product selectedProduct = productCatalog.get(choice - 1);
            cart.addProduct(selectedProduct);
            System.out.println("Добавлен товар: " + selectedProduct.getName());
        }

        // Выбираем стратегию оплаты
        System.out.print("Выберите способ оплаты (1 - Кредитная карта, 2 - PayPal): ");
        int paymentMethod = scanner.nextInt();
        scanner.nextLine();

        PaymentStrategy paymentStrategy = null;
        if (paymentMethod == 1) {
            System.out.print("Введите номер кредитной карты: ");
            String cardNumber = scanner.nextLine();
            System.out.print("Введите имя владельца карты: ");
            String cardOwnerName = scanner.nextLine();
            paymentStrategy = new CreditCardPaymentStrategy(cardNumber, cardOwnerName);
        } else if (paymentMethod == 2) {
            System.out.print("Введите адрес электронной почты PayPal: ");
            String paypalEmail = scanner.nextLine();
            paymentStrategy = new PayPalPaymentStrategy(paypalEmail);
        } else {
            System.out.println("Неверный способ оплаты.");
            scanner.close();
            return;
        }

        // Выполняем оплату
        double totalAmount = cart.calculateTotal();
        cart.checkout(paymentStrategy);

        // Закрываем сканнер
        scanner.close();
    }
}
