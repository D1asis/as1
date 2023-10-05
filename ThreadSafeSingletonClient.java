public class ThreadSafeSingletonClient {
    public static void main(String[] args) {
        Runnable task = () -> {
            Singleton1 singleton = Singleton1.getInstance();
            singleton.showMessage();
        };

        // Create multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
