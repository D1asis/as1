public class SingletonClient {
    public static void main(String[] args) {
        // Get the Singleton instance
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

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
