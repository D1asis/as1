public class SingletonClient {
    public static void main(String[] args) {
        // Get the Singleton instance
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();

        // Check if both instances are the same
        if (singleton1 == singleton2) {
            System.out.println("Both instances are the same. Singleton works.");
        } else {
            System.out.println("Singleton pattern failed.");
        }

        // Demonstrate Singleton functionality
        singleton1.showMessage();
    }
}
